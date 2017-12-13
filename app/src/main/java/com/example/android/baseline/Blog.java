package com.example.android.baseline;

import android.os.Bundle;

import com.example.android.baseline.security.SecuredSessionActivity;

public class Blog extends SecuredSessionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        onNavigation();
    }
}