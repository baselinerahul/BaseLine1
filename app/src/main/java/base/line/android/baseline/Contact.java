package base.line.android.baseline;

/**
 * Created by Rahul on 06-12-2017.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import base.line.android.baseline.activity.MainActivity;
import base.line.android.baseline.security.SecuredSessionActivity;

public class Contact extends SecuredSessionActivity {

    EditText editTextTo, editTextSubject, editTextMessage;
    TextView view1, view2, view3;
    Button send;
    String subject;
    String message;
    String from = "magusinfotec@gmail.com";
    String password = "baseline77";
    String to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        onNavigation();
        view1 = findViewById(R.id.address);
        view2 = findViewById(R.id.address2);
        view3 = findViewById(R.id.address3);
//        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Font/JosefinSans-Regular.ttf");
//        view1.setTypeface(custom_font);
//        view2.setTypeface(custom_font);
//        view3.setTypeface(custom_font);
        editTextTo = findViewById(R.id.editText1);
        editTextSubject = findViewById(R.id.editText2);
        editTextMessage = findViewById(R.id.editText3);
        send = findViewById(R.id.button1);
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                to = editTextTo.getText().toString();
                subject = editTextSubject.getText().toString();
                message = editTextMessage.getText().toString();
                new SendMail().execute("");
//                Intent email = new Intent(Intent.ACTION_SEND);
//                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"hr@baselineitdevelopment.com"});
//                email.putExtra(Intent.EXTRA_SUBJECT, subject);
//                email.putExtra(Intent.EXTRA_TEXT, message);
//                //need this to prompts email client only
//                email.setType("message/rfc822");
//                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }

        });
    }

    class SendMail extends AsyncTask<String, Integer, Void> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(Contact.this, "Please wait", "Sending mail", true, false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
        }

        protected Void doInBackground(String... params) {
            Mail m = new Mail("magusinfotec@gmail.com", "baseline77");
            String[] toArr = {to};
            m.setTo(toArr);
            m.setFrom("magusinfotec@gmail.com");
            m.setSubject(subject);
            m.setBody(message);
            try {
                if (m.send()) {
                    Toast.makeText(Contact.this, "Email was sent successfully.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Contact.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Contact.this, "Email was not sent.", Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Log.e("MailApp", "Could not send email", e);
            }
            return null;
        }
    }
}
