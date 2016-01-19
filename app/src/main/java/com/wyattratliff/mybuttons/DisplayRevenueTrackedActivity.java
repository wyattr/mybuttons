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
public class DisplayRevenueTrackedActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        String revenue = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = new TextView(this);
        textView.setTextSize(49);

        //track the event in AppsFlyer

        Map<String, Object> eventValue = new HashMap<String, Object>();
        eventValue.put("should_be_first", "1234");
        eventValue.put(AFInAppEventParameterName.REVENUE,Float.parseFloat(revenue));
        eventValue.put(AFInAppEventParameterName.CONTENT_TYPE,"content_type/category");
        eventValue.put(AFInAppEventParameterName.CURRENCY,"USD");
        eventValue.put(AFInAppEventParameterName.CONTENT_ID,"skuHERE");
        eventValue.put("should be middle", "456");
        eventValue.put("should_be_last", "321");

        AppsFlyerLib.trackEvent(getApplicationContext(), AFInAppEventType.PURCHASE, eventValue);

        revenue += ", revenue was tracked";

        textView.setText(revenue);
        setContentView(textView);


    }





}
