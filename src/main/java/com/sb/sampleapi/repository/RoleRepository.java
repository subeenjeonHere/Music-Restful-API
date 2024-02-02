package com.sb.sampleapi.repository;


import com.sb.sampleapi.domain.Role;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Object> findByName(String user);
}
