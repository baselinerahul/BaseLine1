package base.line.android.baseline.activity;


/**
 * Created by Rahul on 06-12-2017.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;

import base.line.android.baseline.R;
import base.line.android.baseline.app.Config;
import base.line.android.baseline.security.SecuredSessionActivity;
import base.line.android.baseline.utils.NotificationUtils;


public class MainActivity extends SecuredSessionActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    Button degin, devlopment, seo, notibtn;
    SliderLayout sliderLayout;
    HashMap<String, String> Hash_file_maps;
    TextView textView1, textView2, textView3, textView4, textView5, textView6;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private TextView txtRegId, txtMessage;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         onNavigation();
         textView1 = findViewById(R.id.txt1);
         textView2 = findViewById(R.id.txt2);
         textView3 = findViewById(R.id.txt3);
         textView4 = findViewById(R.id.txt4);
         textView5 = findViewById(R.id.txt5);
         textView6 = findViewById(R.id.txt6);
         Typeface custom_font = Typeface.createFromAsset(getAssets(), "Font/JosefinSans-Regular.ttf");
         textView1.setTypeface(custom_font);
         textView2.setTypeface(custom_font);
         textView3.setTypeface(custom_font);
         textView4.setTypeface(custom_font);
         textView5.setTypeface(custom_font);
         textView6.setTypeface(custom_font);


         Hash_file_maps = new HashMap<String, String>();

         sliderLayout = findViewById(R.id.slider);

         Hash_file_maps.put("WEB DEGINE ", "http://baselineitdevelopment.com/wp-content/uploads/2016/02/blx-d-p02-1.jpg");
         Hash_file_maps.put("WEB DEVELOPMENT ", "http://baselineitdevelopment.com/wp-content/uploads/2016/03/blx-d-p06.jpg");
         Hash_file_maps.put("SEO", "http://baselineitdevelopment.com/wp-content/uploads/2016/02/blx-d-p15.jpg");

         for (String name : Hash_file_maps.keySet()) {

             TextSliderView textSliderView = new TextSliderView(MainActivity.this);
             textSliderView.description(name).image(Hash_file_maps.get(name))
                     .setScaleType(BaseSliderView.ScaleType.Fit)
                     .setOnSliderClickListener(this);
             textSliderView.bundle(new Bundle());
             textSliderView.getBundle().putString("extra", name);
             sliderLayout.addSlider(textSliderView);
         }
         sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
         sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
         sliderLayout.setCustomAnimation(new DescriptionAnimation());
         sliderLayout.setDuration(3000);
         sliderLayout.addOnPageChangeListener(this);


         txtRegId = findViewById(R.id.txt_reg_id);
         txtMessage = findViewById(R.id.txt_push_message);

//        mapView = (MapView) findViewById(R.id.mapView);

//        degin = (Button) findViewById(R.id.web_degin);
//        devlopment = (Button) findViewById(R.id.web_Development);
//        seo = (Button) findViewById(R.id.seo);
//        notibtn = (Button) findViewById(R.id.notie);
//        notibtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Send_Notifaction.class);
//                String to = txtRegId.getText().toString();
//                intent.putExtra("to",to);
//                startActivity(intent);
//            }
//        });
//
//        degin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Web_Design.class);
//                startActivity(intent);
//            }
//        });
//
//        devlopment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, WebDevlapment.class);
//                startActivity(intent);
//            }
//        });
//
//        seo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Seo.class);
//                startActivity(intent);
//            }
//        });
         mRegistrationBroadcastReceiver = new BroadcastReceiver() {
             @Override
             public void onReceive(Context context, Intent intent) {

                 // checking for type intent filter
                 if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                     // gcm successfully registered
                     // now subscribe to `global` topic to receive app wide notifications
                     FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);

                     displayFirebaseRegId();

                 } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                     // new push notification is received

                     String message = intent.getStringExtra("message");
                     Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();
                     if (message.isEmpty()) {
                         txtMessage.setText("nulll");
                     }
                     txtMessage.setText(message);
                 }
             }
         };

         displayFirebaseRegId();
     }

    // Fetches reg id from shared preferences
    // and displays on the screen
    private void displayFirebaseRegId() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        String regId = pref.getString("regId", null);

        Log.e(TAG, "Firebase reg id: " + regId);

        if (!TextUtils.isEmpty(regId))
            txtRegId.setText("Firebase Reg Id: " + regId);
        else
            txtRegId.setText("Firebase Reg Id is not received yet!");
    }

    @Override
    protected void onResume() {
        super.onResume();

        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(getApplicationContext());
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }


    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}

