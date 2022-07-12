package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.models.Role;
import com.recruit.recruitment.payload.request.RoleRequest;
import com.recruit.recruitment.service.AppUserServiceImpl;
import com.recruit.recruitment.service.RoleServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/admin/")
@RestController
public class AdminController
{
    private final AppUserServiceImpl service;

    private final RoleServiceImpl rservice;

    public AdminController(AppUserServiceImpl service, RoleServiceImpl rservice)
    {
        this.service = service;
        this.rservice = rservice;
    }

    @GetMapping("users")
    //@PreAuthorize("hasRole('ADMIN')")
    List<AppUser> all()
    {
        return service.all();
    }

    @PostMapping("role")
    //@PreAuthorize("hasRole('ADMIN')")
    boolean changeRole(@RequestBody RoleRequest r)
    {
        AppUser user = service.findById(r.id);
        if(user != null)
        {
            List<Role> roles = new ArrayList<>(user.getRoles().stream().toList());
            roles.add(rservice.findByName(r.role).orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
            user.setRoles(new HashSet<>(roles));
            service.saveUser(user);
            return true;
        }
        return false;
    }
}