package com.othershe.behaviortest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.othershe.behaviortest.test1.TestActivity1;
import com.othershe.behaviortest.test2.TestActivity2;
import com.othershe.behaviortest.mainpage.TestActivity3;
import com.othershe.behaviortest.xiami.TestActivity4;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test_one(View v) {
        startActivity(new Intent(this, TestActivity1.class));
    }

    public void test_two(View v) {
        startActivity(new Intent(this, TestActivity2.class));
    }

    public void test_three(View v) {
        startActivity(new Intent(this, TestActivity3.class));
    }

    public void test_four(View v) {
        startActivity(new Intent(this, TestActivity4.class));
    }
}
