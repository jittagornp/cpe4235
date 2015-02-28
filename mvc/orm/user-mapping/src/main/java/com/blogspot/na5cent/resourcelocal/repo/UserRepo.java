/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.resourcelocal.repo;

import com.blogspot.na5cent.resourcelocal.model.Authority;
import com.blogspot.na5cent.resourcelocal.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author anonymous
 */
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u INNER JOIN u.authorities auth WHERE auth = ?1")
    List<User> findUserInRole(Authority authority);
}
