package com.example.demo.roles;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Role
{
    private Long id;
    private String name;
    private Level level;
}
