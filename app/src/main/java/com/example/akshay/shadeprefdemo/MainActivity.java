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

public class  MainActivity extends AppCompatActivity {

    Button save,next;
    EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save= findViewById(R.id.bt1);
        next= findViewById(R.id.bt2);
        user= findViewById(R.id.ed1);
        pass= findViewById(R.id.ed2);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= getSharedPreferences("mydata", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString("name",user.getText().toString());
                editor.putString("password",pass.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this,"Data saved",Toast.LENGTH_SHORT).show();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        int i=2;
        String test= "Test";
        int k=33;
        int x=89;

    }
}
