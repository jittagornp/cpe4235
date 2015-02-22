/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.primefaces.controller;

import com.blogspot.na5cent.primefaces.model.Item;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author anonymous
 */
@ManagedBean
@SessionScoped
public class ItemCtrl implements Serializable {

    private Item item;
    private List<Item> items;

    public Item getItem() {
        if (item == null) {
            item = new Item();
        }

        return item;
    }

    public void setItem(Item item) {
        System.out.println("item = " + item);
        this.item = item;
    }

    public void onAddItem() {
        getItems().add(getItem());
        item = null;
    }

    public List<Item> getItems() {
        if (items == null) {
            items = new LinkedList<>();
        }

        return items;
    }
}
