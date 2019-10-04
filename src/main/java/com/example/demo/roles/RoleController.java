package com.example.demo.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("role")
public class RoleController
{
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService)
    {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getRoles()
    {
        return ResponseEntity.ok()
                             .body(roleService.getRoles().stream()
                                              .map(this::convertToDto)
                                              .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Void> addRole(@RequestBody RoleToAddDto role)
    {
        if (!roleService.addRole(role.getName(), role.getLevel()))
        {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


    private RoleDto convertToDto(Role role)
    {
        return new RoleDto(role.getId(), role.getName(), convertToDto(role.getLevel()));
    }

    private String convertToDto(Level level)
    {
        return level.getName();
    }
}
