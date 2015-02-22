/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.primefaces.model;

import java.io.Serializable;

/**
 *
 * @author anonymous
 */
public class Item implements Serializable{

    private String name;
    private float price;

    public String getName() {
        return name;
    } 

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
