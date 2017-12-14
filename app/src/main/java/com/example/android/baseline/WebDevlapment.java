package com.example.android.baseline;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.baseline.security.SecuredSessionActivity;

public class WebDevlapment extends SecuredSessionActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_devlapment);
        onNavigation();
        textView = findViewById(R.id.tetwe_dev);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Font/JosefinSans-Regular.ttf");
        textView.setTypeface(custom_font);
    }
}
