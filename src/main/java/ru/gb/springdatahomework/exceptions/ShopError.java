package ru.gb.springdatahomework.exceptions;


import java.util.Date;

public class ShopError {
    private int status;
    private String message;
    private Date timetamp;

    public ShopError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timetamp = new Date();
    }
        }
