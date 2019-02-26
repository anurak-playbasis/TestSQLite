package com.example.testsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.example.testsqlite.model.FriendData;
import com.example.testsqlite.sqlite.DBHelper;

import java.nio.channels.Channels;

public class AddFriendActivity extends AppCompatActivity {
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mTel;
    private EditText mEmail;
    private EditText mDescription;
    private Button mButtonOK;
    private int ID = -1;

    private DBHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        mHelper = new DBHelper(this);

        mFirstName = (EditText) findViewById(R.id.add_first_name);
        mLastName = (EditText) findViewById(R.id.add_last_name);
        mTel = (EditText) findViewById(R.id.add_tel);
        mEmail = (EditText) findViewById(R.id.add_email);
        mDescription = (EditText) findViewById(R.id.add_description);
        mButtonOK = (Button) findViewById(R.id.button_submit);

        mButtonOK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                FriendData friendData = new FriendData();
                friendData.setFirstName(mFirstName.getText().toString());
                friendData.setLastName(mLastName.getText().toString());
                friendData.setPhone(mTel.getText().toString());
                friendData.setEmail(mEmail.getText().toString());
                friendData.setDescription(mDescription.getText().toString());

               //String name =  mFirstName.getText().toString();


                Toast.makeText(getApplicationContext(), "msg msg"+friendData , Toast.LENGTH_LONG).show();
                //mHelper.addFriend(friendData);
                if (ID == -1) {
                    mHelper.addFriend(friendData);
                } else {
                    friendData.setId(ID);
                    //mHelper.updateFriend(friend);
                }
                finish();




            }
        });


    }

}
