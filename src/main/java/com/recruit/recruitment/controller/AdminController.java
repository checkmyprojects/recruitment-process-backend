package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.models.ERole;
import com.recruit.recruitment.models.Role;
import com.recruit.recruitment.payload.request.RoleRequest;
import com.recruit.recruitment.service.AppUserServiceImpl;
import com.recruit.recruitment.service.RoleServiceImpl;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<List<AppUser>> all()
    {
        return ResponseEntity.ok().body(service.all());
    }

    @PostMapping("role")
    //@PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Boolean> changeRole(@RequestBody RoleRequest r)
    {
        AppUser user = service.findById(r.id);
        if(user != null)
        {
            List<Role> roles = new ArrayList<>();
            r.roles.forEach(role ->
            {
                switch(role)
                {
                    case "admin":
                        roles.add(rservice.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
                        break;
                    case "business":
                        roles.add(rservice.findByName(ERole.ROLE_BUSINESS).orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
                        break;
                    case "interview":
                        roles.add(rservice.findByName(ERole.ROLE_INTERVIEWER).orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
                        break;
                    case "people":
                        roles.add(rservice.findByName(ERole.ROLE_PEOPLE).orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
                        break;
                    default:
                        roles.add(rservice.findByName(ERole.ROLE_PEOPLE).orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
                }
            });
            user.setRoles(new HashSet<>(roles));
            service.saveUser(user);
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteSelectionById(@PathVariable Long id) {
        System.out.println("Deleting Selection Process with ID: " + id);
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id/{id}")
    ResponseEntity<AppUser> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    
}