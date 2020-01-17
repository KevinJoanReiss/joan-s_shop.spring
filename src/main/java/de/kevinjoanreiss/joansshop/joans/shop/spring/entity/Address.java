package de.kevinjoanreiss.joansshop.joans.shop.spring.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Address {
    private String city;
    private int zipCode;
    private String streetName;

    public Address(String streetName, int zipCode, String city) {
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Address(){}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
