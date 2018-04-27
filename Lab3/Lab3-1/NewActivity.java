package com.example.namgoong.yeonwoo;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    TextView textView;
    Button goBtn;
    Button bactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        textView = (TextView) findViewById(R.id.txt);
        goBtn = (Button) findViewById(R.id.go);
        bactBtn = (Button) findViewById(R.id.back);
        final Intent passedIntent = getIntent();
        final String passedUrl = passedIntent.getStringExtra("address");
        textView.setText(passedUrl);
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!passedUrl.isEmpty())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + passedUrl));
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해주세요.", Toast.LENGTH_LONG).show();
                }
            }
        });
        bactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 눌렀습니다.", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
    }
