package base.line.android.baseline;

/**
 * Created by Rahul on 06-12-2017.
 */

import android.os.Bundle;
import android.widget.TextView;

import base.line.android.baseline.security.SecuredSessionActivity;

public class Seo extends SecuredSessionActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seo);
        onNavigation();
        textView = findViewById(R.id.txt_seo);
//        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Font/JosefinSans-Regular.ttf");
//        textView.setTypeface(custom_font);
    }
}
