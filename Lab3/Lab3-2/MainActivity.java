package com.example.yea.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText name;
    RadioButton male,female;
    CheckBox sms,email;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editText);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        sms=findViewById(R.id.sms);
        email=findViewById(R.id.e_mail);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String passedname = name.getText().toString();
                //성별 radiobutton
                String gender="";
                if(male.isChecked())
                    gender="남";
                else if(female.isChecked())
                    gender="여";

                //수신여부 checkbox
                String acceptance="";
                if(sms.isChecked())
                    acceptance="SMS ";
                if(email.isChecked())
                    acceptance+="e-mail";

                Intent intent = new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtra("name",passedname);
                intent.putExtra("gender",gender);
                intent.putExtra("accept",acceptance);
                startActivity(intent);
                finish();
            }
        });
    }
}
