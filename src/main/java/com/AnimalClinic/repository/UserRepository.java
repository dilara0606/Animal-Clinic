package com.AnimalClinic.repository;

import com.AnimalClinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    Optional<User> findByEmail(String username);

    Boolean existsByEmail(String email);

    User findByemail(String email);

    User findByid (Integer id);

}
