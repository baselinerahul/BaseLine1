package com.example.android.baseline.security;

import android.content.Context;

import com.example.android.baseline.Uitls.Constants;

import java.util.Timer;


/**
 * Created by Palo12 on 05-05-2017.
 */

public class SecuredSession {

    public long milliseconds = Constants.SESSION_MAXIMUM_TIME;
    private Timer timer = null;
    private Context context = null;
//    private UserPOJO userPOJO = null;
//    private CartPOJO cartPOJO = null;

//    public SecuredSession() {
//        this.timer = new Timer();
//        this.timer.start();
//    }


//    public void update() {
//        milliseconds = Constants.SESSION_MAXIMUM_TIME;
//    }
//
//    public void dismiss() {
//        milliseconds = 0;
//        this.userPOJO = null;
//        this.cartPOJO = null;
//        this.context = null;
//    }

//    public UserPOJO getUserPOJO() {
//        return userPOJO;
//    }
//
//    public void setUserPOJO(UserPOJO userPOJO) {
//        this.userPOJO = userPOJO;
//    }
//
//    public CartPOJO getCartPOJO() {
//        if(cartPOJO == null){
//            cartPOJO = new CartPOJO(this.getUserPOJO().getId());
//        }
//        return cartPOJO;
//    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }

//    class Timer extends Thread {
//
//        @Override
//        public void run() {
//            while (milliseconds > 0) {
//                try {
//                    Thread.sleep(1000);
//                    milliseconds -= 1000;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            dismiss();
//        }
//    }
}