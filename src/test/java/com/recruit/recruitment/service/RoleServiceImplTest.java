package com.recruit.recruitment.service;

import com.recruit.recruitment.models.ERole;
import com.recruit.recruitment.repository.RoleRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @Mock
    private RoleRepo roleRepo;

    private RoleServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new RoleServiceImpl(roleRepo);
    }

    @Test
    void findByName() {
        underTest.findByName(ERole.ROLE_PEOPLE);
        verify(roleRepo).findByName(ERole.ROLE_PEOPLE);
    }
}