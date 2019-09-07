package com.example.demo.repository;

import com.example.demo.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RegisteredUserRepository  extends JpaRepository<RegisteredUser, Long> {
    RegisteredUser findByUserName(String username);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE RegisteredUser r SET r.userName = :username, r.password = :password," +
            " r.firstName = :firstName, r.email = :email," +
            " r.lastName = :lastName, r.city = :city, r.phoneNumber = :phoneNumber WHERE r.registeredUserId = :id")
    void updateUser(@Param("id") Long id, @Param("username") String username, @Param("password") String password,
                              @Param("email") String email, @Param("firstName") String firstName,
                              @Param("lastName") String lastName, @Param("city") String city,
                              @Param("phoneNumber") String phoneNumber);
}
