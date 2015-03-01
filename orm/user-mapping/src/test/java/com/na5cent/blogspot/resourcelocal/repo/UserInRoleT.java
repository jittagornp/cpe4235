/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.na5cent.blogspot.resourcelocal.repo;

import com.blogspot.na5cent.resourcelocal.model.Authority;
import com.blogspot.na5cent.resourcelocal.model.User;
import com.blogspot.na5cent.resourcelocal.repo.UserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author anonymous
 */
@ContextConfiguration(locations = {
    "/spring/applicationContext.xml",
    "/spring/applicationContext-eclipseLink.xml"
})
public class UserInRoleT extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private UserRepo repo;
    
    @Test
    public void findUserInRole(){
        List<User> users = repo.findUserInRole(new Authority("ADMIN"));
        
        
        User steven = new User();
        steven.setId(100);
        
        assertTrue(users.contains(steven));
    }
}
