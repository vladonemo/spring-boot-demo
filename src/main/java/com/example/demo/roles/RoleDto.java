package com.example.demo.roles;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleDto
{
    private Long id;
    private String name;
    private String level;
}
