package com.message.copy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.message.copy.service.ServiceChecker;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ServiceChecker sc = new ServiceChecker(this);
        if (!sc.isAccessibilitySettingsOn()) {
            sc.openAsSettings();
        }
    }
}
