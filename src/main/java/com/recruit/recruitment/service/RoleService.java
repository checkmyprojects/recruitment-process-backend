package com.recruit.recruitment.service;

import com.recruit.recruitment.models.ERole;
import com.recruit.recruitment.models.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(ERole name);
}
