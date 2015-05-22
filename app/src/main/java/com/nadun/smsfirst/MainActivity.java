package com.nadun.smsfirst;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity  {
    Button sendbtn ;
    EditText text,phonenum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendbtn = (Button) findViewById(R.id.sendbtn) ;

        text = (EditText) findViewById(R.id.text) ;
        phonenum = (EditText) findViewById(R.id.phonenum) ;

        sendbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String mySms = text.getText().toString();
                String myNum = phonenum.getText().toString();
                sendMsg(mySms, myNum);
            }
        });

    }

    protected void sendMsg(String mySms, String myNum) {
        SmsManager sms = SmsManager.getDefault();

        sms.sendTextMessage(myNum,null,mySms,null,null);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
