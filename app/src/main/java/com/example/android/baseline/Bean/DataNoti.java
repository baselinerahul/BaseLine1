package com.example.android.baseline.Bean;

import java.io.Serializable;

/**
 * Created by Android on 12/8/2017.
 */

public class DataNoti implements Serializable  {
    String to;
    Notification notification;


    public Notification getData() {
        return notification;
    }

    public void setData(Notification notification) {
        this.notification = notification;
    }

     public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }




}
