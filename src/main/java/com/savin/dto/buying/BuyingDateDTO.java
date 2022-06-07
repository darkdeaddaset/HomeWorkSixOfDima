package com.savin.dto.buying;

import java.util.Date;

public class BuyingDateDTO {
    private Date date;

    public BuyingDateDTO(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
