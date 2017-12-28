package base.line.android.baseline;

/**
 * Created by Rahul on 06-12-2017.
 */

import android.os.Bundle;
import android.widget.TextView;

import base.line.android.baseline.security.SecuredSessionActivity;

public class services extends SecuredSessionActivity {
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        onNavigation();
//        text1 = findViewById(R.id.tet1);
//        text2 = findViewById(R.id.tet2);
//        text3 = findViewById(R.id.tet3);
//        text4 = findViewById(R.id.tet4);
//        text5 = findViewById(R.id.tet5);
//        text6 = findViewById(R.id.tet6);
//        text7 = findViewById(R.id.tet7);
//        text8 = findViewById(R.id.tet8);
//        text9 = findViewById(R.id.tet9);
//        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Font/JosefinSans-Regular.ttf");
//        text1.setTypeface(custom_font);
//        text2.setTypeface(custom_font);
//        text3.setTypeface(custom_font);
//        text4.setTypeface(custom_font);
//        text5.setTypeface(custom_font);
//        text6.setTypeface(custom_font);
//        text7.setTypeface(custom_font);
//        text8.setTypeface(custom_font);
//        text9.setTypeface(custom_font);

    }
}
