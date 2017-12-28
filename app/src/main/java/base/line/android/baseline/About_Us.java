package base.line.android.baseline;

/**
 * Created by Rahul on 06-12-2017.
 */

import android.os.Bundle;
import android.widget.TextView;

import base.line.android.baseline.security.SecuredSessionActivity;

public class About_Us extends SecuredSessionActivity {
    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us);
        onNavigation();
        txt1 = findViewById(R.id.tetabout1);
        txt2 = findViewById(R.id.tetabout2);
        txt3 = findViewById(R.id.tetabout3);
        txt4 = findViewById(R.id.tetabout4);
        txt5 = findViewById(R.id.tetabout5);
        txt6 = findViewById(R.id.tetabout6);
        txt7 = findViewById(R.id.tetabout7);
        txt8 = findViewById(R.id.tetabout8);
        txt9 = findViewById(R.id.tetabout9);
        txt10 = findViewById(R.id.tetabout10);
//        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Font/JosefinSans-Regular.ttf");
//
//        txt1.setTypeface(custom_font);
//        txt2.setTypeface(custom_font);
//        txt3.setTypeface(custom_font);
//        txt4.setTypeface(custom_font);
//        txt5.setTypeface(custom_font);
//        txt6.setTypeface(custom_font);
//        txt7.setTypeface(custom_font);
//        txt8.setTypeface(custom_font);
//        txt9.setTypeface(custom_font);
//        txt10.setTypeface(custom_font);
    }
}
