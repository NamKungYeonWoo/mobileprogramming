package com.example.namgoong.yeonwoo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1,imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvitiy_main);

        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DogThread thread1 = new DogThread(0);
                thread1.start();
                DogThread thread2 = new DogThread(1);
                thread2.start();
            }
        });
    }
    class DogThread extends Thread{
        public int dogIndex;
        public int stateIndex;
        ArrayList<Integer> images = new ArrayList<Integer>();
        public DogThread(int index){
            dogIndex=index;
            images.add(R.drawable.dog_eating);
            images.add(R.drawable.dog_standing);
            images.add(R.drawable.dog_studying);
        }
        public void run() {
            stateIndex = 0;
            for (int i = 0; i < 9; i++) {
                final String msg = "dog #" + dogIndex + "state " + stateIndex;
                handler.post(new Runnable(){
                    public void run () {
                        editText.append(msg + "\n");
                        if (dogIndex == 0)
                            imageView1.setImageResource(images.get(stateIndex));
                        else if (dogIndex == 1)
                            imageView2.setImageResource(images.get(stateIndex));
                    }});

                try {
                    int sleepTime = getRandomTime(500, 3000);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stateIndex++;
                if (stateIndex >= images.size())
                    stateIndex = 0;
            }
        }
    }
    public int getRandomTime(int min,int max){
        return min+(int)(Math.random()*(max-min));
    }
}
