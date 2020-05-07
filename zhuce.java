package com.example.shuiguodian.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shuiguodian.R;
import com.example.shuiguodian.data.USER;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class zhuce extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private EditText phone;
    private EditText gonghao;
    private Button b1;
    private Button b2;
    private Object Snackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bmob.initialize(this, "6ea4388afcacd6095c8b70f40be4c716");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuce);

        //初始化控件
        initview();
        //初始化监听器
        initlistener();

    }

    private void initlistener() {
        //注册按钮监听器
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注册逻辑事件处理
                zhuce();
            }
        });
        //重置按钮监听器
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重置逻辑事件处理
                chongzhi();
            }
        });

    }

    private void chongzhi() {

        user.setText("");
        password.setText("");
        phone.setText("");
        gonghao.setText("");

    }

    private void zhuce(){
        String User = user.getText().toString();
        String Password = password.getText().toString();
        String Gonghao = gonghao.getText().toString();
        String Phone = phone.getText().toString();
        final USER user = new USER();
        user.setUsername(User);
        user.setPassword(Password);
        user.setMobilePhoneNumber(Phone);
        user.setGonghao(Gonghao);
        user.signUp(new SaveListener<USER>() {
            @Override
            public void done(USER user, BmobException e) {
                if (e == null) {
                    Toast.makeText(zhuce.this,"注册成功",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(zhuce.this,"注册失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void initview() {
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        phone = (EditText) findViewById(R.id.phone);
        gonghao = (EditText) findViewById(R.id.gonghao);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
    }
}
