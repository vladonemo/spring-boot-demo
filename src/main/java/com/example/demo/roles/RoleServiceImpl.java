package com.example.demo.roles;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoleServiceImpl implements RoleService
{
    private final RolesRepository rolesRepository;
    private LevelRepository levelRepository;

    public RoleServiceImpl(RolesRepository rolesRepository,
                           LevelRepository levelRepository)
    {
        this.rolesRepository = rolesRepository;
        this.levelRepository = levelRepository;
    }

    @Override
    public List<Role> getRoles()
    {
        return StreamSupport.stream(rolesRepository.findAll().spliterator(), false)
                            .map(r -> new Role(r.getId(), r.getName(),
                                               new Level(r.getLevel().getName(),
                                                         r.getLevel().getDescription()))).collect(
                        Collectors.toList());
    }

    @Override
    public boolean addRole(String name, long levelId)
    {
        Optional<LevelEntity> level = levelRepository.findById(levelId);
        if(!level.isPresent())
        {
            return false;
        }
        RoleEntity role = new RoleEntity();
        role.setName(name);
        role.setLevel(level.get());
        rolesRepository.save(role);
        return true;
    }
}
