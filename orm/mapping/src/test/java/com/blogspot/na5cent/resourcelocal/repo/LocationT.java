package com.blogspot.na5cent.resourcelocal.repo;


import com.blogspot.na5cent.resourcelocal.model.Department;
import com.blogspot.na5cent.resourcelocal.model.Location;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author anonymous
 */
@ContextConfiguration(locations = {
    "/spring/applicationContext.xml",
    "/spring/applicationContext-eclipseLink.xml"
})
public class LocationT extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private LocationRepo repo;
    
    @Test
    public void findById(){
        Location location = repo.findOne(1000);
        Assert.assertEquals(location.getPostalCode(), "00989");
    }
    
    @Test
    public void findDepartments(){
        Location location = repo.findOne(2500);
        List<Department> departments = location.getDepartments();
        Assert.assertEquals(departments.size(), 1);
        
        Department department = departments.get(0);
        Assert.assertEquals(department.getName(), "Sales");
    }
}
