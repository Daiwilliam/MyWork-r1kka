package com.example.mywork_r1kka;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment wechatFragment =new WeChatFragment();
    private Fragment newsFragment =new NewsFragment();
    private Fragment friendFragment =new FriendFragment();
    private Fragment configFragment =new ConfigFragment();

    private FragmentManager fragmentManager;

    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;
    private ImageView imageView1,imageView2,imageView3,imageView4;
    private TextView textView1,textView2,textView3,textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        linearLayout1 = findViewById(R.id.LinearLayout1);
        linearLayout2 = findViewById(R.id.LinearLayout2);
        linearLayout3 = findViewById(R.id.LinearLayout3);
        linearLayout4 = findViewById(R.id.LinearLayout4);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
        
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        InitFragment();
        showFragment(0);

    }
    
    
    //fragment的标准化
    private void InitFragment(){
        fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.id_content,wechatFragment);
        transaction.add(R.id.id_content,newsFragment);
        transaction.add(R.id.id_content,friendFragment);
        transaction.add(R.id.id_content,configFragment);
        transaction.commit();
        HideFragment(transaction);      //隐藏四个tag
        

    }
    private void initView(){
        linearLayout1 = findViewById(R.id.LinearLayout1);
        linearLayout2 = findViewById(R.id.LinearLayout2);
        linearLayout3 = findViewById(R.id.LinearLayout3);
        linearLayout4 = findViewById(R.id.LinearLayout4);

        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
    }

    private void HideFragment(FragmentTransaction transaction){
        transaction.hide(wechatFragment);
        transaction.hide(newsFragment);
        transaction.hide(friendFragment);
        transaction.hide(configFragment);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.LinearLayout1:
                changeColor(0);
                showFragment(0);
                break;
            case R.id.LinearLayout2:
                changeColor(1);
                showFragment(1);
                break;
            case R.id.LinearLayout3:
                changeColor(2);
                showFragment(2);
                break;
            case R.id.LinearLayout4:
                changeColor(3);
                showFragment(3);
                break;
            default:
                break;
        }
    }

    private void showFragment(int i) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        HideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(wechatFragment);
                break;
            case 1:
                transaction.show(newsFragment);
                break;
            case 2:
                transaction.show(friendFragment);
                break;
            case 3:
                transaction.show(configFragment);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void changeColor(int i) {
        textView1.setTextColor(Color.rgb(255,255,255));
        textView2.setTextColor(Color.rgb(255,255,255));
        textView3.setTextColor(Color.rgb(255,255,255));
        textView4.setTextColor(Color.rgb(255,255,255));
        switch (i) {
            case 0:
                textView1.setTextColor(Color.rgb(0, 255, 0));
                break;
            case 1:
                textView2.setTextColor(Color.rgb(0, 255, 0));
                break;
            case 2:
                textView3.setTextColor(Color.rgb(0, 255, 0));
                break;
            case 3:
                textView4.setTextColor(Color.rgb(0, 255, 0));
                break;
            default:
                break;

        }
    }
}