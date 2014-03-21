package com.dephiros.Campaign_parameters;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import java.net.URI;

public class Hello extends Activity {
    /**
     * Called when the activity is first created.
     */

    private TextView hello = null;
    private static String CAMPAIGN_SOURCE_PARA = "utm_source";
    private static String CAMPAIGN_REF_PARA = "referral";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hello = (TextView) findViewById(R.id.hello);
        Intent intent = this.getIntent();
        String parameter = intent.getStringExtra(CAMPAIGN_REF_PARA);
        if (parameter != null) {
            hello.setText("hello" + parameter);
        }

        setContentView(R.layout.main);
    }
}
