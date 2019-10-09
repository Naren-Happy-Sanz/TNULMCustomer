package com.hst.customer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.hst.customer.R;
import com.hst.customer.bean.database.SQLiteHelper;
import com.hst.customer.utils.PreferenceStorage;
import com.hst.customer.utils.SkilExValidator;


public class SplashScreenActivity extends Activity {

    private static int SPLASH_TIME_OUT = 2000;
    SQLiteHelper database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        database = new SQLiteHelper(getApplicationContext());
        final int getStatus = database.appInfoCheck();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (!PreferenceStorage.isFirstTimeLaunch(getApplicationContext()) && SkilExValidator.checkNullString(PreferenceStorage.getUserId(getApplicationContext()))) {
                    Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(SplashScreenActivity.this, new OnSuccessListener<InstanceIdResult>() {
                        @Override
                        public void onSuccess(InstanceIdResult instanceIdResult) {
                            String newToken = instanceIdResult.getToken();
                            Log.e("newToken", newToken);
                            PreferenceStorage.saveGCM(getApplicationContext(), newToken);
                        }
                    });
                    startActivity(i);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);

    }
}

