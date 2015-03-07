/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.hr.service.impl;

import com.pamarin.cpe4235.hr.model.Job;
import com.pamarin.cpe4235.hr.repo.JobRepo;
import com.pamarin.cpe4235.hr.service.JobService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anonymous
 */
@Service
@Transactional
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepo repo;

    @Override
    public List<Job> findAll() {
        return repo.findAllJobs();
    }

}
