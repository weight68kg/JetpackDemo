package com.weight68kg.jetpackdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FFActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ff);

        com.example.myapplication.ScaleWidget scale = findViewById(R.id.scale);
        TextView tvOffsetTitle = findViewById(R.id.tv_offset_title);


        tvOffsetTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double v1 = Math.random() * 4 - 2;
                scale.setCurrent((float) v1);
            }
        });
    }
}
