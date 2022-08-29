package com.recruit.recruitment.service;

import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.repository.AppUserRepo;
import com.recruit.recruitment.repository.RoleRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

    @Mock
    private AppUserRepo appUserRepo;

    @Mock
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private RoleRepo roleRepo;

    @Mock
    private PasswordEncoder passwordEncoder;

    private AppUserServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new AppUserServiceImpl(appUserRepo, roleRepo);
    }

    @Test
    void loadUserByUsername() {
        AppUser appUser = new AppUser(

                1L,
                "user",
                "user",
                "user@mail.com",
                "password",
                true
        );
        given(appUserRepo.findAppUserByUsername("user")).willReturn(Optional.of(appUser));

        underTest.findByUsername("user");
        verify(appUserRepo).findAppUserByUsername("user");

    }
}