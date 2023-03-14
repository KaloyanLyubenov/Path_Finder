package com.example.path_finder.repositories;

import com.example.path_finder.domain.entities.Role;
import com.example.path_finder.domain.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(Roles role);

    List<Role> findAll();
}
