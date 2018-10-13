package com.example.akshay.shadeprefdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

   public static final String Default = "N/A";
   EditText user,pass;
   Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        user=(EditText) findViewById(R.id.e1);
        pass=(EditText) findViewById(R.id.e2);
        b1=(Button) findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences =getSharedPreferences("mydata", Context.MODE_PRIVATE);
                String username= sharedPreferences.getString("name",Default);
                String password= sharedPreferences.getString("password",Default);

                if(username.equals(Default)|| password.equals(Default))
                {
                    Toast.makeText(SecondActivity.this,"Not found",Toast.LENGTH_SHORT);
                }
                else
                {
                    Toast.makeText(SecondActivity.this,"Load Successful",Toast.LENGTH_SHORT);
                    user.setText(username);
                    pass.setText(password);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new android.content.Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
