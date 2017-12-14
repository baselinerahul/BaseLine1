package com.example.android.baseline;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.baseline.security.SecuredSessionActivity;

public class Blog extends SecuredSessionActivity {
    TextView textView1, textView2, textView3, textView4, textView5, textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        onNavigation();
        textView1 = findViewById(R.id.tetblok1);
        textView2 = findViewById(R.id.tetblok2);
        textView3 = findViewById(R.id.tetblok3);
        textView4 = findViewById(R.id.tetblok4);
        textView5 = findViewById(R.id.tetblok5);
        textView6 = findViewById(R.id.tetblok6);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Font/JosefinSans-Regular.ttf");
        textView1.setTypeface(custom_font);
        textView2.setTypeface(custom_font);
        textView3.setTypeface(custom_font);
        textView4.setTypeface(custom_font);
        textView5.setTypeface(custom_font);

        textView6.setTypeface(custom_font);
    }
}
