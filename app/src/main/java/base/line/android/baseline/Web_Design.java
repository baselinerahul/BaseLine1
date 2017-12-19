package base.line.android.baseline;

/**
 * Created by Rahul on 06-12-2017.
 */

import android.os.Bundle;
import android.widget.TextView;

import base.line.android.baseline.security.SecuredSessionActivity;

public class Web_Design extends SecuredSessionActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web__design);
        onNavigation();
//        textView = findViewById(R.id.tetwe_deg);
//        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Font/JosefinSans-Regular.ttf");
//        textView.setTypeface(custom_font);

    }
}
