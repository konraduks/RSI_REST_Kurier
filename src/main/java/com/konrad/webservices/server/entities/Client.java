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
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String APIpassword;
    private String phoneNumber;    
    private String name;
    private String address;
    private String city;
    //private String country;
    @ManyToOne
    private CountryDistrict countryDistrict;   
    
    private String zipCode;
    private String email;

    public Client() {
    }   

    /*public Client(String login, String password, String APIpassword, String phoneNumber, String name, String address, String city, String country, String district, String zipCode, String email) {
        this.login = login;
        this.password = password;
        this.APIpassword = APIpassword;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
        this.city = city;
        //this.country = country;
        this.zipCode = zipCode;
        this.email = email;
    }*/
    
    public Client(String login, String password, String APIpassword, String phoneNumber, String name, String address, String city, CountryDistrict countryDistrict, String zipCode, String email) {
        this.login = login;
        this.password = password;
        this.APIpassword = APIpassword;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
        this.city = city;
        //this.country = country;
        this.countryDistrict = countryDistrict;
        this.zipCode = zipCode;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAPIpassword() {
        return APIpassword;
    }

    public void setAPIpassword(String APIpassword) {
        this.APIpassword = APIpassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CountryDistrict getCountryDistrict() {
        return countryDistrict;
    }

    public void setCountryDistrict(CountryDistrict countryDistrict) {
        this.countryDistrict = countryDistrict;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
        
}
