package com.example.demo.roles;

import java.util.List;

public interface RoleService
{
    List<Role> getRoles();

    boolean addRole(String name, long level);
}
