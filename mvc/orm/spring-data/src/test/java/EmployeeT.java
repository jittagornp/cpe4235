/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.blogspot.na5cent.resourcelocal.model.Employee;
import com.blogspot.na5cent.resourcelocal.repo.EmployeeRepo;
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
public class EmployeeT extends AbstractTestNGSpringContextTests {

    @Autowired
    private EmployeeRepo repo;
    
    @Test
    public void findByEmail() {
        Employee employee = repo.findByEmail("AFRIPP");
        assertEquals(employee.getId(), Integer.valueOf(121));
    }

    @Test
    public void findByFirstNameLike(){
        List<Employee> employees = repo.findByFirstNameLike("%K%");
        assertEquals(employees.size(), 7);
    }
    
    @Test
    public void findByNameLike(){
        String name = "%st%".toLowerCase();
        List<Employee> employees = repo.findByNameLike(name);
        assertEquals(employees.size(), 10);
    }
}
