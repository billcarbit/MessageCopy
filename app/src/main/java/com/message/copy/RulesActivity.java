package com.message.copy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RulesActivity extends Activity {

    private TextView tv_rules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        tv_rules = findViewById(R.id.tv_rules);
        tv_rules.setText("1.禁止用于窃听他人隐私");
    }

}
