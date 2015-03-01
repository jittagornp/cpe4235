package com.na5cent.blogspot.resourcelocal.repo;

import com.blogspot.na5cent.resourcelocal.model.Department;
import com.blogspot.na5cent.resourcelocal.repo.DepartmentRepo;
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
public class DepartmentT extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private DepartmentRepo repo;
    
    @Test
    public void findByName(){
        Department department= repo.findByName("Administration");
        assertNotNull(department);
        
        assertEquals(department.getId(), Integer.valueOf(10));
    }
}
