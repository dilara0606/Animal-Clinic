package com.AnimalClinic.repository;

import com.AnimalClinic.entity.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRoleRepository extends JpaRepository<UsersRoles, Integer> {
}
