package base.line.android.baseline;

import android.os.Bundle;

import base.line.android.baseline.security.SecuredSessionActivity;

public class Block_A extends SecuredSessionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_);
        onNavigation();
    }
}
