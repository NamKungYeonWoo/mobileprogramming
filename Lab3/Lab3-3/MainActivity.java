package com.example.yea.lab3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
MainFragment mainFragment;
NewFragment newFragment;
Button button1;
Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         button1 = findViewById(R.id.tab1);
         button2 = findViewById(R.id.tab2);

         mainFragment = new MainFragment();
         newFragment =  new NewFragment();

         button1.setOnClickListener(new View.OnClickListener(){
             public void onClick(View view){
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,mainFragment).commit();
             }
         });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,newFragment).commit();
            }
        });
    }
}
