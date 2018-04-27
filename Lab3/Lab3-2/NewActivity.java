package com.example.yea.lab3_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
    TextView text,gender,accept;
    Button prebtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        text=findViewById(R.id.Textt);
        gender=findViewById(R.id.gender);
        accept=findViewById(R.id.accept);
        prebtn = findViewById(R.id.previous);

        Intent getIntent = getIntent();
        if(getIntent!=null) {
            text.setText(getIntent.getStringExtra("name"));
            gender.setText(getIntent.getStringExtra("gender"));
            accept.setText(getIntent.getStringExtra("accept"));
        }
        prebtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
