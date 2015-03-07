/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.hr.service;

import com.pamarin.cpe4235.hr.model.Job;
import java.util.List;

/**
 *
 * @author anonymous
 */
public interface JobService {

    List<Job> findAll();
}
