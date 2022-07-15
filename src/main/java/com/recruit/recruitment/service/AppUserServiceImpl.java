package com.recruit.recruitment.service;

import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.repository.AppUserRepo;
import com.recruit.recruitment.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService{

    private final AppUserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public Optional<AppUser> findByUsername(String username) {
        return userRepo.findAppUserByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    public AppUser saveUser(AppUser user) {
        return userRepo.save(user);
    }

    @Override
    public AppUser findById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public List<AppUser> all()
    {
        return userRepo.findAll();
    }

    public AppUser findById(long id)
    {
        try
        {
            return userRepo.findById(id).orElseThrow();
        }
        catch(NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}