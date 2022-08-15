package com.recruit.recruitment.service;

import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.models.Role;

import java.util.List;
import java.util.Optional;

public interface AppUserService {

    Optional<AppUser> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    AppUser saveUser(AppUser user);
    AppUser findById(Long id);
    void deleteById(Long id);
    List<AppUser> findAppUserByRoles(Role role);
}