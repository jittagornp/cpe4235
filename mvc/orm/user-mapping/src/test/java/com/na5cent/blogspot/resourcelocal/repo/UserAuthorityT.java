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
public class UserAuthorityT extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private UserRepo repo;
    
    @Test
    public void findAuthorities(){
        Authority authority = new Authority("ADMIN");
        
        User user = repo.findOne(100);
        List<Authority> authorities = user.getAuthorities();
        
        if(authorities.isEmpty()){
            authorities.add(authority);
            repo.save(user);
            
            user = repo.findOne(100);
        }
        
        assertTrue(user.getAuthorities().contains(authority));
    }
}
