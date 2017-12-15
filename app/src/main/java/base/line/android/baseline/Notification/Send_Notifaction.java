package base.line.android.baseline.Notification;

/**
 * Created by Rahul on 06-12-2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import base.line.android.baseline.Bean.DataNoti;
import base.line.android.baseline.Bean.Notification;
import base.line.android.baseline.R;
import base.line.android.baseline.comm.URIConstants;
import base.line.android.baseline.comm.message.MessageManager;
import base.line.android.baseline.comm.message.MessageType;

public class Send_Notifaction extends AppCompatActivity {
    EditText message, titel;
    Button send_notifacation;
    String t, m, n;
  String to ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notifaction);
        Intent intent = getIntent();
        to = intent.getStringExtra("to");
        message = (EditText) findViewById(R.id.message_txt2);
        titel = (EditText) findViewById(R.id.tital_txt);


        send_notifacation = (Button) findViewById(R.id.send_notifacation);


        send_notifacation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataNoti dataNoti = new DataNoti();
                Notification Notification = new  Notification();

                m = message.getText().toString();
                t = titel.getText().toString();
                String[] words=to.split("\\s");

                dataNoti.setTo(words[3]);
                Notification.setMessage("gbjh");
                Notification.setTitle("hjnvjhv");
                Notification.setIs_background("hjgjh");
                dataNoti.setData(Notification);
                PushRequ pushRequ = new PushRequ();
                pushRequ.execute(MessageType.POST, URIConstants.PUSHNOTI, dataNoti);

            }
        });

    }

    class PushRequ extends MessageManager {

        @Override
        public void onPostExecute(String result) {
            if (result == null) {
                finish();
            } else {
                System.out.println("LoginMessage.onPostExecute()" + result);
//                UserPOJO userPOJO = ObjectCaster.jSONcast(UserPOJO.class, result);
//                String message = userPOJO.getMessage();
//                Toast.makeText(
//                        Register2User.this, message, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Register2User.this,DashBoard.class);
//                startActivity(intent);
            }
        }

    }





}