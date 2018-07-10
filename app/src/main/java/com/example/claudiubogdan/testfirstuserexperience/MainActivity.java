package com.example.claudiubogdan.testfirstuserexperience;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class starts First User Experience Activity
 */
public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName().toString();
    public static final String PREF_USER_FIRST_TIME = "first";
    private TextView onboardingStatusView;
    private Button startOnboardButton;
    private boolean isUserFirstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, "true"));


        startOnboardButton = findViewById(R.id.startFueId);
        onboardingStatusView = findViewById(R.id.onboardStatusTxt);
        onboardingStatusView.setText("First time: " + isUserFirstTime);

        startOnboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO : Start first user experience activity
                Intent introIntent = new Intent(MainActivity.this, OnboardingActivity.class);
                introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);
                startActivity(introIntent);
            }
        });

    }


}
