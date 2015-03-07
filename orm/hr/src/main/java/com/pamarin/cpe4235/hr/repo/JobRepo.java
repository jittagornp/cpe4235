/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.hr.repo;

import com.pamarin.cpe4235.hr.model.Job;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author anonymous
 */
public interface JobRepo extends JpaRepository<Job, String> {

    @Query("SELECT j FROM Job j ORDER BY j.title")
    List<Job> findAllJobs();
}
