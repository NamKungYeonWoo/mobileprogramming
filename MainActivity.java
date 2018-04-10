package com.example.namgoong.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Age;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText) findViewById(R.id.editText1);
        Age = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName = Name.getText().toString();
                String UserAge = Age.getText().toString();
                Intent intent = new Intent (getApplicationContext(), ActivityNew.class);
                intent.putExtra("loginName", UserName);
                intent.putExtra("loginAge", UserAge);
                startActivity(intent);
            }
        });
    }
}