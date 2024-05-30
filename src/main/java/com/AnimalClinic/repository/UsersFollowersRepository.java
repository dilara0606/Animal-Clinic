package com.AnimalClinic.repository;

import com.AnimalClinic.entity.User;
import com.AnimalClinic.entity.UsersFollowers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersFollowersRepository extends JpaRepository<UsersFollowers, Integer> {
    UsersFollowers findByFollowingUserAndFollowedUser(User followingUser, User followedUser);

    void deleteByFollowingUserAndFollowedUser(User followingUser, User followedUser);

    @Query("SELECT uf.followedUser FROM UsersFollowers uf WHERE uf.followingUser = :user")
    List<User> findFollowedUserByFollowingUser(@Param("user") User user);
}
