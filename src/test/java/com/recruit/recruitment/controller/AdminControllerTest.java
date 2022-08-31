package com.recruit.recruitment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.models.ERole;
import com.recruit.recruitment.models.Role;
import com.recruit.recruitment.payload.request.RoleRequest;
import com.recruit.recruitment.service.AppUserServiceImpl;
import com.recruit.recruitment.service.RoleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppUserServiceImpl appUserService;

    @MockBean
    private RoleServiceImpl roleService;
    @Mock
    private AdminController adminController;

    @Test
    void all() throws Exception {
        List<AppUser> appUserList = new ArrayList<>();

        when(appUserService.all()).thenReturn(appUserList);
        mockMvc.perform((MockMvcRequestBuilders.get("/api/admin/users")
                        .contentType(MediaType.APPLICATION_JSON)))
                .andDo(MockMvcResultHandlers.print());
        verify(appUserService).all();
        verify(appUserService, times(1)).all();
    }

    @Test
    void findAllInterviewers() throws Exception {
        List<AppUser> appUserList = new ArrayList<>();
        Role role = new Role();
        role.setId(1);
        role.setName(ERole.ROLE_INTERVIEWER);
        when(roleService.findByName(any())).thenReturn(Optional.of(role));
        when(appUserService.findAppUserByRoles(any())).thenReturn(appUserList);
        when(appUserService.all()).thenReturn(appUserList);
        mockMvc.perform((MockMvcRequestBuilders.get("/api/admin/usersInterview")
                        .contentType(MediaType.APPLICATION_JSON)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
        verify(appUserService).findAppUserByRoles(any());
        verify(appUserService, times(1)).findAppUserByRoles(any());
    }

    @Test
    void changeRole() throws Exception {
        RoleRequest roleRequest = new RoleRequest();
        roleRequest.id = 1;
        roleRequest.roles = Collections.singleton("admin");
        Role role = new Role();
        role.setId(1);
        role.setName(ERole.ROLE_ADMIN);
        AppUser appUser = new AppUser("name", "admin", "admin@mail.com", "admin");
        when(roleService.findByName(any())).thenReturn(Optional.of(role));
        when(appUserService.findById(any())).thenReturn(appUser);

        mockMvc.perform((MockMvcRequestBuilders.post("/api/admin/role")
                        .contentType(MediaType.APPLICATION_JSON))
                        .content(asJsonString(roleRequest)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
        //verify(appUserService).findById(any());
        //verify(appUserService, times(1)).findById(any());
    }

    @Test
    void deleteSelectionById() throws Exception {
        AppUser appUser = new AppUser("name", "admin", "admin@mail.com", "admin");


        mockMvc.perform((MockMvcRequestBuilders.delete("/api/admin/delete/1")
                        .contentType(MediaType.APPLICATION_JSON)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
        verify(appUserService).deleteById(any());
        verify(appUserService, times(1)).deleteById(any());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform((MockMvcRequestBuilders.get("/api/admin/id/1")
                        .contentType(MediaType.APPLICATION_JSON)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
        verify(appUserService).findById(any());
        verify(appUserService, times(1)).findById(any());
    }

//    @Test
//    void editUser() throws Exception {
//        Role role = new Role();
//        role.setId(1);
//        role.setName(ERole.ROLE_INTERVIEWER);
//
//        Set<Role> roleSet = new HashSet<>();
//        roleSet.add(role);
//        AppUser appUser = new AppUser("name", "admin", "admin@mail.com", "admin");
//        appUser.setId(1L);
//        //appUser.setRoles(roleSet);
//        appUser.setActive(true);
//
//        when(roleService.findByName(any())).thenReturn(Optional.of(role));
//        when(appUserService.findById(any())).thenReturn(appUser);
//        when(appUserService.saveUser(any())).thenReturn(appUser);
//        mockMvc.perform((MockMvcRequestBuilders.put("/api/admin/edit")
//                        .contentType(MediaType.APPLICATION_JSON))
//                        .content(asJsonString(appUser)))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isOk());
//        verify(appUserService).findById(any());
//        verify(appUserService, times(1)).findById(any());
//    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}