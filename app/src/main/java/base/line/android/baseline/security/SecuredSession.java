package base.line.android.baseline.security;

import android.content.Context;

import java.util.Timer;

import base.line.android.baseline.Uitls.Constants;


/**
 * Created by Rahul on 06-12-2017.
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

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
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