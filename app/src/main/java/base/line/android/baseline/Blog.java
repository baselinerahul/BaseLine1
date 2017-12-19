package base.line.android.baseline;

/**
 * Created by Rahul on 06-12-2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import base.line.android.baseline.security.SecuredSessionActivity;
import base.line.android.baseline.utils.Blogc;

public class Blog extends SecuredSessionActivity {
    TextView textView1, textView2, textView3, textView4, textView5, textView6;
    Button buttonbloga, buttonblogb, buttonblogc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        onNavigation();
        buttonbloga = (Button) findViewById(R.id.btm_blocka);
        buttonblogb = (Button) findViewById(R.id.btm_blockb);
        buttonblogc = (Button) findViewById(R.id.btm_blockc);

        buttonbloga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Blog.this, Block_A.class);
                startActivity(intent);
            }
        });
        buttonblogb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Blog.this, Blog_B.class);
                startActivity(intent);
            }
        });
        buttonblogc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Blog.this, Blogc.class);
                startActivity(intent);
            }
        });
//        textView1 = findViewById(R.id.tetblok1);
//        textView2 = findViewById(R.id.tetblok2);
//        textView3 = findViewById(R.id.tetblok3);
//        textView4 = findViewById(R.id.tetblok4);
//        textView5 = findViewById(R.id.tetblok5);
//        textView6 = findViewById(R.id.tetblok6);
//
//        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Font/JosefinSans-Regular.ttf");
//
//        textView1.setTypeface(custom_font);
//        textView2.setTypeface(custom_font);
//        textView3.setTypeface(custom_font);
//        textView4.setTypeface(custom_font);
//        textView5.setTypeface(custom_font);
//        textView6.setTypeface(custom_font);
    }
}
