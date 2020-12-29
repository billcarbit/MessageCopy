package com.message.copy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.message.copy.fragment.EmailFragment;
import com.message.copy.fragment.PersonalFragment;
import com.message.copy.service.MyAccessibilityService;
import com.message.copy.service.ServiceChecker;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    Button btn_check;
    Button btn_start_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();


    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void initView() {
        btn_check = (Button) findViewById(R.id.btn_check);
        btn_start_service = (Button) findViewById(R.id.btn_start_service);
    }

    private void initData() {
        btn_check.setOnClickListener(this);
        btn_start_service.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_check:
                ServiceChecker sc = new ServiceChecker(this);
                if (!sc.isAccessibilitySettingsOn()) {
                    sc.openAsSettings();
                }
                break;
            case R.id.btn_start_service:
                startService(new Intent(this, MyAccessibilityService.class));
                break;
            default:
                break;
        }
    }
}
