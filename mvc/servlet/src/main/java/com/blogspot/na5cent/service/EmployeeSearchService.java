/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.service;

import com.blogspot.na5cent.connectdb.model.EmployeeMap;
import java.util.List;

/**
 *
 * @author anonymous
 */
public interface EmployeeSearchService {

    List<EmployeeMap> search(String keyword);
}
