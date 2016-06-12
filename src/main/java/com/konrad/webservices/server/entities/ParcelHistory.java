/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.konrad.webservices.server.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author KonradD
 */
@Entity
public class ParcelHistory {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Parcel parcel ;
    
    private Date date = new Date();
    private String description;

    public ParcelHistory() {
    }

    public ParcelHistory(Parcel parcel, String description) {
        this.parcel = parcel;
        this.description = description;
    }

    @Override
    public String toString() {
        return "date=" + date + ", description=" + description + '.';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
}
