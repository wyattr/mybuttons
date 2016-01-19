package com.wyattratliff.mybuttons;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.wyattratliff.mybuttons.MESSAGE";
    public static final String LOG_TAG = "MyButtons AppsFlyer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppsFlyerLib.setAppsFlyerKey("772Ky9mcWkrFy2yZetF5rk");
        AppsFlyerLib.sendTracking(getApplicationContext());

        AppsFlyerLib.registerConversionListener(this, new AppsFlyerConversionListener() {
            @Override
            public void onInstallConversionDataLoaded(Map<String, String> conversionData) {
                for (String attrName : conversionData.keySet()) {
                    Log.d(LOG_TAG, "attribute: " + attrName + " = " + conversionData.get(attrName));
                    //now send this information to the screen that gets displayed


                }
            }

            public void onInstallConversionFailure(String errorMessage) {
                Log.d(LOG_TAG, "error getting conversion data: " + errorMessage);
            }

            public void onAppOpenAttribution(Map<String, String> attributionData) {
                // printMap(attributionData);
            }

            public void onAttributionFailure(String errorMessage) {
                Log.d(LOG_TAG, "error onAttributionFailure : " + errorMessage);

            }
        });

        setContentView(R.layout.activity_main);
    }



    public void sendMessage(View view){
        Log.i("troubleshooting", "within the send message method");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void trackEvent2(View view){
        Intent intent = new Intent(this, DisplayRevenueTrackedActivity.class);
        EditText editText = (EditText) findViewById(R.id.event_two_id);
        String revenueToTrack = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, revenueToTrack);
        startActivity(intent);
    }


/**

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
 **/

}
