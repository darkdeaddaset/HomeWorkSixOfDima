package com.savin.dto.buying;

import java.util.Date;

public class BuyingSurnameAndHomeAndDateDTO {
    private String surname;
    private String home;
    private Date date;

    public BuyingSurnameAndHomeAndDateDTO(String surname, String home, Date date) {
        this.surname = surname;
        this.home = home;
        this.date = date;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
