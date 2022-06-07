package com.savin.dto.buying;

import java.util.Date;

public class BuyingIdAndSurnameDTO {
    private long id;
    private String surname;
    private Date date;

    public BuyingIdAndSurnameDTO(long id, String surname, Date date) {
        this.id = id;
        this.surname = surname;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
