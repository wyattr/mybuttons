package com.wyattratliff.mybuttons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wyatt on 12/30/15.
 */
public class DisplayMessageActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //this will show the value input in the text box and get it tracked
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        setContentView(textView);

        //track the event and data with AppsFlyer

        Map<String, Object> eventValue = new HashMap<String, Object>();

        eventValue.put(AFInAppEventParameterName.LEVEL,1);
        eventValue.put(AFInAppEventParameterName.PARAM_1,message);

        AppsFlyerLib.trackEvent(getApplicationContext(), AFInAppEventType.LEVEL_ACHIEVED,eventValue);

    }




}
