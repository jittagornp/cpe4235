/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.hr.controller;

import com.pamarin.cpe4235.hr.model.Employee;
import com.pamarin.cpe4235.hr.model.Job;
import com.pamarin.cpe4235.hr.service.EmployeeService;
import com.pamarin.cpe4235.hr.service.JobService;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anonymous
 */
@Component
@Scope("view")
public class EmployeeCtrl {

    @Autowired
    private EmployeeService employeeService;
    private List<Employee> employees;
    //
    private String keyword;
    //
    private Employee employee;
    @Autowired
    private JobService jobService;
    private List<Job> jobs;

    @PostConstruct
    public void postConstruct() {
        onSearch();
        jobs = jobService.findAll();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Employee getEmployee() {
        if (employee == null) {
            employee = new Employee();
        }

        return employee;
    }
    
    public void onCreate(){
        employee = new Employee();
    }

    public List<Job> getJobs() {
        if (jobs == null) {
            jobs = new LinkedList<>();
        }

        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void onSearch() {
        employees = employeeService.searchByName(keyword);
    }

    public void onClear() {
        keyword = null;
        onSearch();
    }

    public List<Employee> getEmployees() {
        if (employees == null) {
            employees = new LinkedList<>();
        }

        return employees;
    }

    private void notify(FacesMessage.Severity severity, String topic, String details) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(
                                severity,
                                topic,
                                details
                        ));
    }

    private void save(String title) {
        try {
            employeeService.save(employee);
            employee = null;
            onSearch();
            notify(
                    FacesMessage.SEVERITY_INFO,
                    title,
                    "สำเร็จ"
            );
        } catch (Exception ex) {
            notify(
                    FacesMessage.SEVERITY_ERROR,
                    title,
                    "ล้มเหลว เนื่องจาก " + ex.getMessage()
            );
        }
    }

    public void onEdit() {
        save("การแก้ไขข้อมูลบุคลากร");
    }

    public void onAdd() {
        save("การเพิ่มข้อมูลบุคลากร");
    }

    private String request(String paramName) {
        return (String) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get(paramName);
    }

    public void onSelect() {
        Integer employeeId = Integer.valueOf(request("employeeId"));
        int index = getEmployees().indexOf(new Employee(employeeId));
        employee = index == -1 ? null : getEmployees().get(index);
    }

    public void onDelete() {
        try {
            employeeService.delete(employee);
            employee = null;
            onSearch();
            notify(
                    FacesMessage.SEVERITY_INFO,
                    "การลบข้อมูลบุคลากร",
                    "สำเร็จ"
            );
        } catch (Exception ex) {
            notify(
                    FacesMessage.SEVERITY_ERROR,
                    "การลบข้อมูลบุคลากร",
                    "ล้มเหลว เนื่องจาก " + ex.getMessage()
            );
        }
    }
}
