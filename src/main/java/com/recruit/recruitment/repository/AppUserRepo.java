package com.recruit.recruitment.repository;

import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findAppUserByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    List<AppUser> findAppUserByRoles(Role role);
}
