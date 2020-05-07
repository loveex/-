package com.example.shuiguodian.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shuiguodian.R;
import com.example.shuiguodian.activity.jiezhang;

import org.w3c.dom.Text;

public class Sale extends Fragment {

    private Button b_huoqu;
    private Button b_qingling;
    private Button b_jiezhang;
    private TextView jiage;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = View.inflate(getActivity(), R.layout.fragment_sale, null);
        //控件初始化
        initgridview(view);
        //创建监听器
        initlistener();
        return view;
    }

    private void initlistener() {
        b_huoqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取按键逻辑处理
            }
        });

        b_qingling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //清零按键逻辑处理
                jiage.setText("0");
            }
        });
        b_jiezhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //结账按键逻辑处理
                Intent intent = new Intent(getActivity(), jiezhang.class);
                intent.putExtra("id",jiage.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void initgridview(View view) {
        b_huoqu = (Button) view.findViewById(R.id.b_huoqu);
        b_qingling = (Button) view.findViewById(R.id.b_qingling);
        b_jiezhang = (Button) view.findViewById(R.id.b_jiezhang);
        jiage = (TextView) view.findViewById(R.id.jiage);
    }

}
