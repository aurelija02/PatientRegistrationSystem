package com.example.finalProject.role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {

    Optional<Role> findByRole(RolesEnum role);

}
