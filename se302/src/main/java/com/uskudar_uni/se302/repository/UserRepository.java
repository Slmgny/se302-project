package com.uskudar_uni.se302.repository;

import com.uskudar_uni.se302.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u JOIN u.skills s WHERE s.skill = :skillName AND u.available = :available")
    List<User> findBySkillNameAndAvailable(@Param("skillName") String skillName, @Param("available") boolean available);

    @Query("SELECT u FROM User u JOIN u.skills s WHERE s.skill = :skillName")
    List<User> findBySkillName(@Param("skillName") String skillName);
}