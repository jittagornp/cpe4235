/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.hr.service.impl;

import com.pamarin.cpe4235.hr.model.Employee;
import com.pamarin.cpe4235.hr.repo.EmployeeRepo;
import com.pamarin.cpe4235.hr.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author anonymous
 */
@Service
@TransactionConfiguration
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    @Override
    public List<Employee> searchByName(String keyword) {
        if (isEmpty(keyword)) {
            return repo.findAllEmployees();
        }

        return repo.searchByName("%" + keyword + "%");
    }

    @Override
    public void delete(Employee employee) {
        if (employee != null) {
            repo.delete(employee.getId());
        }
    }

    @Override
    public Employee save(Employee employee) {
        return repo.save(employee);
    }

}
