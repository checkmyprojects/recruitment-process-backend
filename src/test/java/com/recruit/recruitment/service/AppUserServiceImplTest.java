package com.recruit.recruitment.service;

import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.repository.AppUserRepo;
import com.recruit.recruitment.repository.RoleRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
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
    void findById() {
        AppUser appUser = new AppUser(
                1L,
                "user",
                "user",
                "user@mail.com",
                "password",
                true
        );
        given(appUserRepo.findById(appUser.getId())).willReturn(Optional.of(appUser));
        underTest.findById(appUser.getId());
        verify(appUserRepo).findById(appUser.getId());

    }

    @Test
    void deleteById() {
        underTest.deleteById(1L);
        verify(appUserRepo).deleteById(1L);
    }

    @Test
    void findAppUserByRoles() {

        underTest.findAppUserByRoles(any());
        verify(appUserRepo).findAppUserByRoles(any());

    }

    @Test
    void all() {
        underTest.all();
        verify(appUserRepo).findAll();
    }

}