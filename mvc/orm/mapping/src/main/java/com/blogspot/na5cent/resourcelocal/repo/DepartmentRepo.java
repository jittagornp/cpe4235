/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.resourcelocal.repo;

import com.blogspot.na5cent.resourcelocal.model.Department;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author anonymous
 */
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    Department findByName(String administration);

    List<Department> findByLocationId(Integer locationId);

}
