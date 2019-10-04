package com.example.demo.roles;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<RoleEntity, Long>
{
}
