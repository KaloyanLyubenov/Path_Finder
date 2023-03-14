package com.example.path_finder.services;

import com.example.path_finder.domain.dto.models.RoleModel;
import com.example.path_finder.domain.enums.Roles;
import com.example.path_finder.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    public Set<RoleModel> findAllRoles(){
        return this.roleRepository.findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, RoleModel.class))
                .collect(Collectors.toSet());
    }

    public RoleModel findRoleByName(String name){
        return this.modelMapper.map(this.roleRepository.findByRole(Roles.valueOf(name))
                .orElseThrow(NoSuchElementException::new),
                RoleModel.class);
    }
}
