/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.android.baseline.POJO;

import java.io.Serializable;
import java.util.HashMap;


/**
 *
 * @author Administrator
 */
public class MessagePOJO  implements Serializable {

    private int response = 200;
    private String message;
    private String status;
    private long userId;
    private HashMap<String,String> imageList;
    private byte[] imageBytes;


    /**
     * @return the response

     */
    public int getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(int response) {
        this.response = response;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the imageList
     */
    public HashMap<String,String> getImageList() {
        return imageList;
    }

    /**
     * @param imageList the imageList to set
     */
    public void setImageList(HashMap<String,String> imageList) {
        this.imageList = imageList;
    }

    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

}
