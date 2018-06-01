package com.example.namgoong.yeonwoo;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        ListView list;
        String[] info;
        SQLiteDatabase db;
        MySQLiteOpenHelper helper;
        EditText namee,getsn;
        Button btn1,btn2;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.actvitiy_main);
            helper = new MySQLiteOpenHelper(MainActivity.this,"student.db",null,1);
            list = findViewById(R.id.list);
            namee=findViewById(R.id.name);
            getsn = findViewById(R.id.getsn);
            btn1=findViewById(R.id.btn1);
            btn2=findViewById(R.id.btn2);

            btn1.setOnClickListener(new View.OnClickListener() { // 추가
                @Override
                public void onClick(View view) {
                    String msg1, msg2;
                    msg1 = namee.getText().toString();
                    msg2 = getsn.getText().toString();
                    if (msg1.length() == 0 || msg2.length() == 0)
                        Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요", Toast.LENGTH_SHORT).show();
                    else {
                        insert(msg1, msg2);
                        invalidate();
                        Toast.makeText(getApplicationContext(), "Insert success", Toast.LENGTH_SHORT).show();
                        namee.setText("");
                        getsn.setText("");
                    }
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() { // 삭제
                @Override
                public void onClick(View view) {
                    String msg1 = namee.getText().toString();
                    if(msg1.length()==0)
                        Toast.makeText(getApplicationContext(),"이름을 입력해주세요.",Toast.LENGTH_SHORT).show();
                    else{
                        delete(msg1);
                        Toast.makeText(getApplicationContext(),"Delete success.",Toast.LENGTH_SHORT).show();
                        invalidate();
                        namee.setText("");
                        getsn.setText("");
                    }
                }
            });
        }
        public void insert(String name,String stunum){
            db=helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name",name);
            values.put("studentNo",stunum);
            db.insert("student",null,values);
        }
        public void delete(String name){
            db=helper.getWritableDatabase();
            db.delete("student","name=?",new String[]{name});
        }
        public void select(){
            db = helper.getReadableDatabase();
            Cursor c = db.query("student",null,null,null,null,null,null);
            info = new String[c.getCount()];
            int count=0;
            while(c.moveToNext()){
                info[count] = c.getString(c.getColumnIndex("name")) + " " + c.getString(c.getColumnIndex("studentNo"));
                count++;
            }
            c.close();
        }
        public void invalidate(){
            select();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,info);
            list.setAdapter(adapter);
        }
    }
