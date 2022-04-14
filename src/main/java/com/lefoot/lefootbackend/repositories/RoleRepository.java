package com.lefoot.lefootbackend.repositories;

import com.lefoot.lefootbackend.models.ERole;
import com.lefoot.lefootbackend.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findByName(ERole name);
}
