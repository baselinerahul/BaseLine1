package com.example.android.baseline;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.baseline.security.SecuredSessionActivity;

public class Career extends SecuredSessionActivity {
    private static final int PICK_FROM_GALLERY = 101;
    EditText name1, email1, subject1, message1;
    String email;
    String subject;
    String message;
    String attachmentFile;
    Button send, attach;
    Uri URI = null;
    int columnIndex;
    TextView txt1, txt2, txt3, txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career);
        onNavigation();
        name1 = findViewById(R.id.name);
        email1 = findViewById(R.id.email);
        subject1 = findViewById(R.id.subject);
        message1 = findViewById(R.id.message);
        send = findViewById(R.id.send);
        attach = findViewById(R.id.attach);
        txt1 = findViewById(R.id.tecarrer1);
        txt2 = findViewById(R.id.tecarrer2);
        txt3 = findViewById(R.id.tecarrer3);
        txt4 = findViewById(R.id.tecarrer4);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Font/JosefinSans-Regular.ttf");
        txt1.setTypeface(custom_font);
        txt2.setTypeface(custom_font);
        txt3.setTypeface(custom_font);
        txt4.setTypeface(custom_font);
        attach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFolder();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            attachmentFile = cursor.getString(columnIndex);
            URI = Uri.parse("file://" + attachmentFile);
            cursor.close();
        }
    }
    public void sendEmail() {
        try {
            email = email1.getText().toString();
            subject = subject1.getText().toString();
            message = message1.getText().toString();
            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"baselinerahul@gmail.com"});
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
            if (URI != null) {
                emailIntent.putExtra(Intent.EXTRA_STREAM, URI);
            }
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
            this.startActivity(Intent.createChooser(emailIntent, "Sending email..."));
        } catch (Throwable t) {
            Toast.makeText(this, "Request failed try again: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }
    public void openFolder() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data", true);
        //intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" +attachmentFile));
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_GALLERY);

        //  startActivityForResult(Intent.createChooser(intent, "ChooseFile"), 100);
    }
}
