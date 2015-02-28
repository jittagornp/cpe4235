package com.blogspot.na5cent.resourcelocal.repo;

import com.blogspot.na5cent.resourcelocal.model.Department;
import java.util.List;
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
    public void findByName() {
        Department department = repo.findByName("Administration");
        assertNotNull(department);

        assertEquals(department.getId(), Integer.valueOf(10));
    }

    @Test
    public void findByLocationIds() {
        List<Department> departments = repo.findByLocationId(1700);

        assertEquals(departments.size(), 21);

        Department itSupport = new Department();
        itSupport.setId(200);

        assertTrue(departments.contains(itSupport));
    }
}
