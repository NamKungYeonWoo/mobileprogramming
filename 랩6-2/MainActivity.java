package com.example.namgoong.yeonwoo;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {
    EditText sn,name;
    String stu_num,stu_name;
    Button btn1,btn2,btn3;
    SharedPreferences sh_pref;
    SharedPreferences.Editor toEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvitiy_main);
        sn = findViewById(R.id.sn);
        name = findViewById(R.id.name);
        btn1=findViewById(R.id.call);
        btn2=findViewById(R.id.save);
        btn3=findViewById(R.id.init);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stu_num=sn.getText().toString();
                stu_name=name.getText().toString();
                sharedPreferences();
                Toast.makeText(getApplicationContext(),"Details are saved", Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sn.setText("");
                name.setText("");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applySharedPreference();
            }
        });
    }

    public void sharedPreferences(){
        sh_pref = getSharedPreferences("Login Credentials",MODE_PRIVATE);
        toEdit=sh_pref.edit();
        toEdit.putString("StudentNumber",stu_num);
        toEdit.putString("StudentName",stu_name);
        toEdit.commit();
    }
    public void applySharedPreference(){
        sh_pref=getSharedPreferences("Login Credentials",MODE_PRIVATE);
        if(sh_pref!=null && sh_pref.contains("StudentNumber")){
            String number = sh_pref.getString("StudentNumber","0");
            sn.setText(number);
            String tempname = sh_pref.getString("StudentName","noname");
            name.setText(tempname);
        }
    }
}
