package com.othershe.behaviortest.extend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.othershe.behaviortest.R;
import com.othershe.behaviortest.mainpage.TypeAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test5);

        RecyclerView recyclerView = findViewById(R.id.my_list);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(i + 1 + "");
        }
        TypeAdapter adapter = new TypeAdapter(this, list, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

//        TextView title = findViewById(R.id.title);
//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) title.getLayoutParams();
//        params.setBehavior(new SampleTitleBehavior());
    }
}
