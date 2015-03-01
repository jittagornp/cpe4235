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
    public void findOne() {
        Employee employee = repo.findOne(100);
        assertNotNull(employee);
        assertEquals(employee.getFirstName(), "Steven");
        assertEquals(employee.getLastName(), "King");
    }
    
    @Test
    public void findAll(){
        List<Employee> employees = repo.findAll();
        assertEquals(employees.size(), 107);
    }

}
