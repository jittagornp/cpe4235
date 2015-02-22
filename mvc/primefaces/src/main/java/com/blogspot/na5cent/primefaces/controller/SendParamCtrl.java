/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.primefaces.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author anonymous
 */
@ManagedBean
@ViewScoped
public class SendParamCtrl implements Serializable {

    private Object request(String paramName) {
        return FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get(paramName);
    }

    public void onSendParam() {
        System.out.println("param = " + request("postId"));
    }
}
