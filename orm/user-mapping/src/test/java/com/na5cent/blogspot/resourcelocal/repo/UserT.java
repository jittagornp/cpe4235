package com.na5cent.blogspot.resourcelocal.repo;

import com.blogspot.na5cent.resourcelocal.model.Employee;
import com.blogspot.na5cent.resourcelocal.model.User;
import com.blogspot.na5cent.resourcelocal.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anonymous
 */
@ContextConfiguration(locations = {
    "/spring/applicationContext.xml",
    "/spring/applicationContext-eclipseLink.xml"
})
public class UserT extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserRepo repo;

    @Test
    public void findByName() {
        User user = repo.findOne(100);
        if (user == null) {
            user = new User();
            user.setId(100);
            user.setUsername("Steve");
            user.setPassword("1234");

            repo.save(user);
            user = repo.findOne(100);
        }

        Employee employee = user.getEmployee();
        assertNotNull(employee);
        assertEquals(employee.getFirstName(), "Steven");
    }
}
