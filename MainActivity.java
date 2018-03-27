package org.androidtown.hello;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
//import org.androidtown.hello.changeimage.R;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;                              // 이미지객체 생성
    int imageIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView)findViewById(R.id.blue);     // 안드로이드 블루 이미지 참조
        imageView2=(ImageView)findViewById(R.id.red);      // 안드로이드 레드 이미지 참조
    }
    public void onButton1Clicked(View v){                   // 버튼클릭시 실행할 함수
        changeImage();			// 버튼클릭시 changeImage method 실행

    }
    private void changeImage(){
        if(imageIndex==0){                                        // imageIndex가 0이면 블루이미지
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex=1;}	// imageIndex 1로 바꿔 다음 버튼       누르면 레드이미지로 바꾸게끔 한다.

        else if(imageIndex==1){ 		// imageIndex가 1이면 레드이미지
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex=0;
        }
    }
}
