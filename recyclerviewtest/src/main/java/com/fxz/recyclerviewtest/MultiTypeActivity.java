package com.fxz.recyclerviewtest;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MultiTypeActivity extends AppCompatActivity {
        private RecyclerView mRecyclerView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.multi_view_item);
        //获取多类型RecyclerView
        mRecyclerView = findViewById(R.id.multi_type_list);
    }
}
