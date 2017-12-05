package com.othershe.behaviortest.xiami;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.othershe.behaviortest.mainpage.TypeAdapter;
import com.othershe.behaviortest.R;

import java.util.ArrayList;
import java.util.List;

public class TestActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);

        RecyclerView commentList = findViewById(R.id.comment_list);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + 1 + "");
        }
        TypeAdapter adapter = new TypeAdapter(this, list, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        commentList.setLayoutManager(layoutManager);
        commentList.setAdapter(adapter);
    }
}
