package com.example.android.baseline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.baseline.security.SecuredSessionActivity;

public class WebDevlapment extends SecuredSessionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_devlapment);
        onNavigation();
    }
}
