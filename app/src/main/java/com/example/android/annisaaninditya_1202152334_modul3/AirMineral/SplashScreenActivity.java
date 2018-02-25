package com.example.android.annisaaninditya_1202152334_modul3.AirMineral;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.android.annisaaninditya_1202152334_modul3.AirMineral.LoginActivity;
import com.example.android.annisaaninditya_1202152334_modul3.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static int splashInterval = 2000;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        }, 3000L); //3000 L = 3 detik
    }
}
