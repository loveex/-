package com.example.shuiguodian.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shuiguodian.R;
import com.example.shuiguodian.activity.login;
import com.example.shuiguodian.data.USER;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

//我的页面
public class My extends Fragment {
    private TextView gonghao;
    private TextView name;
    private TextView dian;
    private TextView phone;
    private TextView money;
    private View view;
    private String namString;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bmob.initialize(getActivity(), "6ea4388afcacd6095c8b70f40be4c716");
        view = View.inflate(getActivity(), R.layout.fragment_my, null);
        //控件初始化
        initview();

        return view;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent id) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, id);
        Bundle bundle = id.getExtras();
        namString = bundle.getString("id");
    }

    private void equal() {
        startActivityForResult(new Intent(getActivity(), login.class),1);
        BmobQuery<USER> categoryBmobQuery = new BmobQuery<>();
        categoryBmobQuery.addWhereEqualTo("username",namString);
        categoryBmobQuery.findObjects(new FindListener<USER>() {
            @Override
            public void done(List<USER> list, BmobException e) {
                if (e == null) {
                    gonghao.setText(list.get(1).getGonghao());
                    name.setText(list.get(1).getName());
                    dian.setText(list.get(1).getShop());
                    phone.setText(list.get(1).getMobilePhoneNumber());
                    money.setText(list.get(1).getMoney());

                } else {
                    Log.e("BMOB", e.toString());
                    Toast.makeText(getActivity(),"没有此人"+e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initview() {
        gonghao = view.findViewById(R.id.gonghao);
        name = view.findViewById(R.id.name);
        dian = view.findViewById(R.id.dian);
        phone = view.findViewById(R.id.phone);
        money = view.findViewById(R.id.money);
    }

}
