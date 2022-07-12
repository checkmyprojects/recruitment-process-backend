package com.recruit.recruitment.service;

import com.recruit.recruitment.models.ERole;
import com.recruit.recruitment.models.Role;
import com.recruit.recruitment.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService{

    private final RoleRepo roleRepo;

    @Override
    public Optional<Role> findByName(ERole name) {
        return roleRepo.findByName(name);
    }

    public void save(Role r)
    {
        roleRepo.save(r);
    }
}