package com.example.android.baseline.Bean;

import java.io.Serializable;

/**
 * Created by Android on 12/8/2017.
 */
public   class Notification implements Serializable {

    String  message;
    String title;
    String  is_background;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIs_background() {
        return is_background;
    }

    public void setIs_background(String is_background) {
        this.is_background = is_background;
    }

}