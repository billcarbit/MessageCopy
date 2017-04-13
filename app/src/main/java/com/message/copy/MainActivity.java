package com.message.copy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.message.copy.fragment.EmailFragment;
import com.message.copy.fragment.PersonalFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    TextView mTvEmail;
    TextView mTvSetting;
    ViewPager mVp;

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
  /*      ServiceChecker sc = new ServiceChecker(this);
        if (!sc.isAccessibilitySettingsOn()) {
            sc.openAsSettings();
        }*/


    }

    private void initView() {
        mTvEmail = (TextView) findViewById(R.id.tv_email);
        mTvSetting = (TextView) findViewById(R.id.tv_setting);
        mVp = (ViewPager) findViewById(R.id.vp);

        mTvEmail.setOnClickListener(this);
        mTvSetting.setOnClickListener(this);
    }

    private void initData(){
        EmailFragment emailFragment = new EmailFragment();
        PersonalFragment personalFragment = new PersonalFragment();
        final List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(emailFragment);
        fragmentList.add(personalFragment);

        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("onPageScrolled", "position=" + position + ",positionOffset=" + positionOffset + ",positionOffsetPixels=" + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("onPageSelected", "position=" + position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("onPageScrollStateChange", "state=" + state);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_email:
                mVp.setCurrentItem(0);
                break;
            case R.id.tv_setting:
                mVp.setCurrentItem(1);
                break;
            default:
                break;
        }
    }
}
