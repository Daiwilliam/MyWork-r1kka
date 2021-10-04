package com.example.mywork_r1kka;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment wechatFragment =new WeChatFragment();
    private Fragment newsFragment =new NewsFragment();
    private Fragment friendFragment =new FriendFragment();
    private Fragment configFragment =new ConfigFragment();

    private FragmentManager fragmentManager;

    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        linearLayout1 = findViewById(R.id.LinearLayout1);
        linearLayout2 = findViewById(R.id.LinearLayout2);
        linearLayout3 = findViewById(R.id.LinearLayout3);
        linearLayout4 = findViewById(R.id.LinearLayout4);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);

        InitFragment();


    }

    private void InitFragment(){
        fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.id_content,wechatFragment);
        transaction.add(R.id.id_content,newsFragment);
        transaction.add(R.id.id_content,friendFragment);
        transaction.add(R.id.id_content,configFragment);
        transaction.commit();
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
                showfragment(0);
                break;
            case R.id.LinearLayout2:
                showfragment(0);
                break;
            case R.id.LinearLayout3:
                showfragment(0);
                break;
            case R.id.LinearLayout4:
                showfragment(0);
                break;
            default:
                break;
        }
    }

    private void showfragment(int i) {
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
    }
}