package com.recruit.recruitment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.models.Candidate;
import com.recruit.recruitment.payload.request.LoginRequest;
import com.recruit.recruitment.payload.request.SignupRequest;
import com.recruit.recruitment.service.AppUserService;
import com.recruit.recruitment.service.AppUserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @MockBean
    private AppUserServiceImpl appUserService;
//
//    @InjectMocks
//    private AuthController authControllerMock;

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private MockMvc mockMvcMocking;

    @BeforeEach
    public void setup(){

//        mockMvcMocking = MockMvcBuilders.standaloneSetup(authControllerMock).build();
    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void itShouldLoginWithTheCorrectUsernameAndPassword() throws Exception {
        LoginRequest loginRequest = new LoginRequest("admin", "admin");

        this.mockMvc.perform(post("/api/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(loginRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accessToken").exists());

    }

    @Test
    void itShouldNotLoginWithTheIncorrectUsernameAndPassword() throws Exception {
        LoginRequest loginRequest = new LoginRequest("abcd", "12345");

        this.mockMvc.perform(post("/api/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(loginRequest)))
                .andDo(print())
                .andExpect(status().isUnauthorized());

    }

//    @Test
//    void itShouldFailToRegisterIfUsernameAlreadyExits() throws Exception {
//        SignupRequest signupRequest = new SignupRequest("admin", "admin", "newEmail@mail.com",null, "admin");
//
//        this.mockMvc.perform(post("/api/auth/signup")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(signupRequest)))
//                .andDo(print())
//                .andExpect(status().isBadRequest());
//
//    }

    @Test
    void itShouldFailToRegisterIfEmailAlreadyExits() throws Exception {
//        SignupRequest signupRequest = new SignupRequest("newUser", "newUser", "admin@mail.com",null, "admin");
//
//        this.mockMvc.perform(post("/api/auth/signup")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(signupRequest)))
//                .andDo(print())
//                .andExpect(status().isBadRequest());
        SignupRequest signupRequest = new SignupRequest("admin", "NonExistingUsername", "existingEmail@mail.com",null, "1234");
        when(appUserService.existsByUsername(any())).thenReturn(false);
        when(appUserService.existsByEmail(any())).thenReturn(true);

        this.mockMvc.perform(post("/api/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(signupRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest());
        verify(appUserService, times(1)).existsByUsername(any());
        verify(appUserService, times(1)).existsByEmail(any());
        verify(appUserService, times(0)).saveUser(any());

    }

    @Test
    void itShouldFailToRegisterIfUsernameAlreadyExits() throws Exception {

        SignupRequest signupRequest = new SignupRequest("admin", "existingUsername", "nonExistingEmail@mail.com",null, "1234");
        when(appUserService.existsByUsername(any())).thenReturn(true);
        when(appUserService.existsByEmail(any())).thenReturn(false);

        this.mockMvc.perform(post("/api/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(signupRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest());
        verify(appUserService, times(1)).existsByUsername(any());
        verify(appUserService, times(0)).existsByEmail(any());
        verify(appUserService, times(0)).saveUser(any());
    }

    @Test
    void itShouldRegisterIfUsernameAndEmailDoesNotExistOnDatabase() throws Exception {
        Set<String> rolesList = new HashSet<>();
        rolesList.add("admin");
        rolesList.add("people");
        rolesList.add("business");
        rolesList.add("interview");

        AppUser userToReturn = new AppUser("name", "username", "password", "email@mail.com");
        SignupRequest signupRequest = new SignupRequest("admin", "admin", "newEmail@mail.com", rolesList, "admin");
        when(appUserService.existsByUsername(any())).thenReturn(false);
        when(appUserService.existsByEmail(any())).thenReturn(false);
        when(appUserService.saveUser(any())).thenReturn(userToReturn);
        this.mockMvc.perform(post("/api/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(signupRequest)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void itShouldRegisterIfUsernameAndEmailDoesNotExistOnDatabaseWithoutSendingRoles() throws Exception {
        AppUser userToReturn = new AppUser("name", "username", "password", "email@mail.com");
        SignupRequest signupRequest = new SignupRequest("admin", "admin", "newEmail@mail.com", null, "admin");
        when(appUserService.existsByUsername(any())).thenReturn(false);
        when(appUserService.existsByEmail(any())).thenReturn(false);
        when(appUserService.saveUser(any())).thenReturn(userToReturn);
        this.mockMvc.perform(post("/api/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(signupRequest)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}