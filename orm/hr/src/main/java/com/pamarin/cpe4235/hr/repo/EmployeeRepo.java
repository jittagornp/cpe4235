/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.hr.repo;

import com.pamarin.cpe4235.hr.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author anonymous
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e ORDER BY e.firstName, e.lastName")
    List<Employee> findAllEmployees();

    @Query("SELECT e FROM Employee e WHERE LOWER(e.firstName) LIKE ?1 OR LOWER(e.lastName) LIKE ?1 ORDER BY e.firstName, e.lastName")
    List<Employee> searchByName(String keyword);

}
