package com.example.shuiguodian.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shuiguodian.R;

public class jiezhang extends AppCompatActivity {
    private Button b1;
    private TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiezhang);
        //控件初始化
        initview();
        //监听器
        initlistener();
    }



    private void initlistener() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //逻辑处理
            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        t2.setText("请支付"+bundle.getString("id"));
    }

    private void initview() {
        b1 = findViewById(R.id.b1);
        t2 = findViewById(R.id.t2);
    }
}
