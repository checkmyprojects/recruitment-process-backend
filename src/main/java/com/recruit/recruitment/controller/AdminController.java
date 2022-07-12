package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.models.Role;
import com.recruit.recruitment.payload.request.RoleRequest;
import com.recruit.recruitment.service.AppUserServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/admin/")
@RestController
public class AdminController
{
    private final AppUserServiceImpl service;

    public AdminController(AppUserServiceImpl service)
    {
        this.service = service;
    }

    @GetMapping("users")
    @PreAuthorize("hasRole('ADMIN')")
    List<AppUser> all()
    {
        return service.all();
    }

    @PostMapping("role")
    @PreAuthorize("hasRole('ADMIN')")
    boolean changeRole(@RequestBody RoleRequest r)
    {
        AppUser user = service.findById(r.id);
        if(user != null)
        {
            List<Role> roles = user.getRoles().stream().toList();
            Role rr = new Role();
            rr.setName(r.role);
            roles.add(rr);
            user.setRoles(new HashSet<>(roles));
            service.saveUser(user);
            return true;
        }
        return false;
    }
}