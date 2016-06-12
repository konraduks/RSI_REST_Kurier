/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.konrad.webservices.server.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author KonradD
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    
    private String location;
    private String employeeAPIpassword;   
    
    @ManyToOne
    private CountryDistrict countryDistrict; 
    
    //dla Basic auth
    private String login;
    private String password;

    public Employee() {
    }

    public Employee(String location, String employeeAPIpassword) {
        this.location = location;
        this.employeeAPIpassword = employeeAPIpassword;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmployeeAPIpassword() {
        return employeeAPIpassword;
    }

    public void setEmployeeAPIpassword(String employeeAPIpassword) {
        this.employeeAPIpassword = employeeAPIpassword;
    }
    
    public CountryDistrict getCountryDistrict() {
        return countryDistrict;
    }

    public void setCountryDistrict(CountryDistrict countryDistrict) {
        this.countryDistrict = countryDistrict;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
