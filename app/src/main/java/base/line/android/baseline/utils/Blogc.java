package base.line.android.baseline.utils;

import android.os.Bundle;

import base.line.android.baseline.R;
import base.line.android.baseline.security.SecuredSessionActivity;

public class Blogc extends SecuredSessionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogc);
        onNavigation();
    }
}
