/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.konrad.webservices.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author KonradD
 */
@Entity
public class Parcel {
    @Id
    @GeneratedValue
    private Long id;
    private String trackingNumber;
    
    @OneToOne
    private Client sender;
    //private Client receiver;
    private String phoneNumber;    
    private String name;
    private String address;
    private String city;
    //private String country;
    @ManyToOne
    private CountryDistrict countryDistrict;   
    private String zipCode;
    private String email;
    
    // 0 - nadano;
    // 1 - odbior od adresata
    // 2 - dostarczenie do sortowni
    // 3 - wyjscie z sortowni
    // 4 - wydanie do doreczenia
    // 5 - doreczenie
    private int parcelStatus;    
    
    @Lob @Column(nullable= true, length=4000000)
    private byte[] wayBill;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getWayBill() {
        return wayBill;
    }

    public void setWayBill(byte[] wayBill) {
        this.wayBill = wayBill;
    }

    public Parcel() {
    }

    public Parcel(String trackingNumber, Client sender, String phoneNumber, String name, String address, String city, CountryDistrict countryDistrict, String zipCode, String email, byte[] wayBill) {
        this.trackingNumber = trackingNumber;
        this.sender = sender;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
        this.city = city;
        //this.country = country;
        this.countryDistrict = countryDistrict;
        this.zipCode = zipCode;
        this.email = email;
        this.wayBill = wayBill;
        parcelStatus = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /*public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }*/
    
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
    
    public int getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(int parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    /*@Override
    public String toString() {
        return "Package{" + "id=" + id + ", trackingNumber=" + trackingNumber + ", sender=" + sender + ", phoneNumber=" + phoneNumber + ", name=" + name + ", address=" + address + ", city=" + city + ", country=" + country + ", zipCode=" + zipCode + ", email=" + email + '}';
    } */
    
    @Override
    public String toString() {
        return "Package{" + "id=" + id + ", trackingNumber=" + trackingNumber + ", sender=" + sender + ", phoneNumber=" + phoneNumber + ", name=" + name + ", address=" + address + ", city=" + city + ", country=" + countryDistrict.getCountry().getName() + ", zipCode=" + zipCode + ", email=" + email + '}';
    }    
}
