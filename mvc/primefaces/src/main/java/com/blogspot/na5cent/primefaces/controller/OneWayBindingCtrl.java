/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.na5cent.primefaces.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author anonymous
 */
@ManagedBean
@ViewScoped
public class OneWayBindingCtrl implements Serializable{
    
    private String name = "primefacse";
    
    public String getMessage(){
        return "first controller";
    }
    
    public String getApplicationName(){
        return name;
    }
    
    public String getEmail(){
        return "jittagornp@gmail.com";
    }
    
    public String getOccupation(){
        return "programmer.";
    }
}
