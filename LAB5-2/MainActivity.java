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
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvitiy_main);
        textView = findViewById(R.id.txtView2);
        editText = findViewById(R.id.edittext);
        button=findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Calculate().execute();
            }
        });
    }

    private class Calculate extends AsyncTask<Void, Integer, Void> {
        int result = 1;
        protected void onPreExecute(){
            textView.setText(" ");
        }
        protected Void doInBackground(Void... params) {
            String num = editText.getText().toString();
            for (int i = Integer.parseInt(num); i >= 1; i--) {
                try {
                    Thread.sleep(500);
                    publishProgress(i);
                    result = result * i;
                } catch (Exception e) {
                }
            }
            return null;
        }
        protected void onProgressUpdate(Integer... values){
            textView.append(values[0].intValue()+ " ");
        }
        protected void onPostExecute(Void aVoid){
            textView.append("\n = " + result);
        }
    }
}

