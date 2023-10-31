package com.sksmccorp.consumertwo.models;

import lombok.Data;

import java.util.Date;

@Data
public class order {
    public Date ordertime;
    public Long orderId;
    public String itemId;
    public Double orderUnits;
    public address address;
}