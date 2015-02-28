/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.blogspot.na5cent.resourcelocal.model.Department;
import com.blogspot.na5cent.resourcelocal.model.Employee;
import com.blogspot.na5cent.resourcelocal.repo.EmployeeRepo;
import java.util.Arrays;
import java.util.LinkedList;
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
    public void findDepartment() {
        Employee employee = repo.findOne(100);
        assertNotNull(employee);
        
        Department department = employee.getDepartment();

        assertNotNull(department);
        assertEquals(department.getName(), "Executive");
    }
    
    @Test
    public void findManager(){
        Employee employee = repo.findOne(101);
        assertNotNull(employee);
        
        Employee manager = employee.getManager();
        
        assertEquals(manager.getId(), Integer.valueOf(100));
        assertEquals(manager.getFirstName(), "Steven");
        assertEquals(manager.getLastName(), "King");
    }

    @Test
    public void findSubOrdinates() {
        Employee employee = repo.findOne(101);
        assertNotNull(employee);

        List<Employee> subordinates = employee.getSubordinates();
        
        assertEquals(subordinates.size(), 5);
        
        List<Integer> subIds = findEmployeeIds(subordinates);
        List<Integer> expectIds = Arrays.asList(108, 200, 203, 204, 205);
        
        
        assertEquals(subIds, expectIds);
    }

    private List<Integer> findEmployeeIds(List<Employee> employees) {
        List<Integer> results = new LinkedList<>();
        for (Employee employee : employees) {
            results.add(employee.getId());
        }

        return results;
    }
}
