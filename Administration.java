package com.example.shuiguodian.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shuiguodian.R;
import com.example.shuiguodian.activity.home;
import com.example.shuiguodian.activity.shangpingguanli;

public class Administration extends Fragment {

    private Button b_1;
    private Button b_2;
    private View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)  {
       view = View.inflate(getActivity(), R.layout.fragment_administration,null);

        //控件初始化
        initview();

        //设置监听器
        initlistener();

        return view;

    }

    private void initlistener() {
        //商品管理监听器
        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //逻辑处理
                Intent intent = new Intent(getActivity(), shangpingguanli.class);
                startActivity(intent);
            }
        });
        //个人信息监听器
        b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //逻辑处理
                Intent intent = new Intent(getActivity(), shangpingguanli.class);
                startActivity(intent);
            }
        });
    }

    private void initview() {
        b_1 = (Button) view.findViewById(R.id.b_1);
        b_2 = (Button) view.findViewById(R.id.b_2);
    }
}
