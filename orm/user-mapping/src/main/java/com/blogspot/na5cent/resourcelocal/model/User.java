/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.resourcelocal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author anonymous
 */
@Entity
@Table(name = "user_acc")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    private Integer id;
    @Column(length = 255, nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    //--------------------------------------------------------------------------
    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {
                @JoinColumn(
                        name = "user_id",
                        referencedColumnName = "user_id",
                        insertable = false,
                        updatable = false
                )
            },
            inverseJoinColumns = {
                @JoinColumn(
                        name = "auth_id",
                        referencedColumnName = "auth_id",
                        insertable = false,
                        updatable = false
                )
            }
    )
    private List<Authority> authorities;
    //--------------------------------------------------------------------------
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "employee_id",
            insertable = false,
            updatable = false
    )
    @OneToOne
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Authority> getAuthorities() {
        if (authorities == null) {
            authorities = new ArrayList<>();
        }

        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
