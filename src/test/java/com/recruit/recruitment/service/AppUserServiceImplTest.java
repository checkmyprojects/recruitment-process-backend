package com.recruit.recruitment.service;

import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.models.ERole;
import com.recruit.recruitment.models.Role;
import com.recruit.recruitment.repository.AppUserRepo;
import com.recruit.recruitment.repository.RoleRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AppUserServiceImplTest {

    @Mock
    private AppUserRepo appUserRepo;

    @Mock
    private RoleRepo roleRepo;

    private AppUserServiceImpl underTest;

    @BeforeEach
    void setUp() { underTest = new AppUserServiceImpl(appUserRepo, roleRepo);


    }

    @Test
    void findByUsername() {
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

    @Test
    void existsByUsername() {
        given(appUserRepo.existsByUsername("user")).willReturn(true);

        underTest.existsByUsername("user");
        verify(appUserRepo).existsByUsername("user");


    }

    @Test
    void existsByEmail() {
        given(appUserRepo.existsByEmail("email")).willReturn(true);

        underTest.existsByEmail("email");
        verify(appUserRepo).existsByEmail("email");

    }

    @Test
    void saveUser() {
        AppUser appUser = new AppUser(
                1L,
                "user",
                "user",
                "user@mail.com",
                "password",
                true
        );
        underTest.saveUser(appUser);
        verify(appUserRepo).save(appUser);
    }

    @Test
    void saveUserIsSaveRepo() {
        AppUser appUser = new AppUser(
                1L,
                "user",
                "user",
                "user@mail.com",
                "password",
                true
        );

        underTest.saveUser(appUser);

        ArgumentCaptor<AppUser> appUserArgumentCaptor = ArgumentCaptor.forClass(AppUser.class);
        verify(appUserRepo).save(appUserArgumentCaptor.capture());
    }

    @Test
    void findById() {
        AppUser appUser = new AppUser(
                1L,
                "user",
                "user",
                "user@mail.com",
                "password",
                true
        );
        underTest.saveUser(appUser);
        underTest.findById(appUser.getId());
        verify(appUserRepo).findById(appUser.getId());

    }

    @Test
    void all() {
        underTest.all();
        verify(appUserRepo).findAll();
    }

    @Test
    void testFindById() {
        AppUser appUser = new AppUser(
                1L,
                "user",
                "user",
                "user@mail.com",
                "password",
                true
        );
        underTest.saveUser(appUser);
        underTest.findById(1L);
        verify(appUserRepo).findById(1L);
    }
    }
