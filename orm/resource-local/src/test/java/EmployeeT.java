/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.blogspot.na5cent.resourcelocal.model.Employee;
import com.blogspot.na5cent.resourcelocal.repo.EmployeeRepo;
import java.util.Date;
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

    @Test
    public void insertEmployee(){
        Employee employee = new Employee();
        employee.setId(1000);
        employee.setFirstName("jittagornp");
        employee.setLastName("pitakmetagoon");
        employee.setEmail("pamarin@gmail.com");
        employee.setHireDate(new Date());
        employee.setJobId("IT_PROG");
        
        repo.delete(employee);
    } 
    
    @Test
    public void searchByFirstName(){
        List<Employee> employees = repo.searchByFirstName("%JO%".toLowerCase());
        assertEquals(employees.size(), 6);
        
        Employee employee = new Employee();
        employee.setId(110);
        
        assertTrue(employees.contains(employee));
    }
    
    @Test
    public void findByJobId(){
        List<Employee> employees = repo.findByJobIdOrderByIdDesc("IT_PROG");
        
        assertEquals(employees.size(), 5);
        
        Employee employee = employees.get(0);
        assertEquals(employee.getFirstName(), "Diana");
    }
}
