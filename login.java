package com.example.shuiguodian.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shuiguodian.R;
import com.example.shuiguodian.data.USER;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

public class login extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private Button b1;
    private Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bmob.initialize(this,"6ea4388afcacd6095c8b70f40be4c716");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //初始化控件
        initview();
        //初始化监听器
        initlistener();
    }
    private void initlistener() {
        //注册按键监听器
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注册按键逻辑处理
                zhuce();
            }
        });
        //登录按键监听器
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录按键逻辑处理
                denglu();
            }
        });
    }

    private void denglu() {
        String User = user.getText().toString();
        String Password = password.getText().toString();
        //此处替换为你的用户名密码
        BmobUser.loginByAccount(User, Password, new LogInListener<USER>() {
            @Override
            public void done(USER user, BmobException e) {
                if (e == null) {
                    Intent intent = new Intent(login.this, home.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("id",User);
                    intent.putExtras(bundle);
                    setResult(1,intent);
                    finish();
                    startActivity(intent);
                } else {
                    Toast.makeText(login.this, "账号或者密码错误" + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void zhuce() {
        Intent intent = new Intent(login.this, zhuce.class);
        startActivity(intent);
    }

    private void initview() {
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
    }
}
