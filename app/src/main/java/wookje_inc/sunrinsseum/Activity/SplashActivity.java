package wookje_inc.sunrinsseum.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import wookje_inc.sunrinsseum.R;

public class SplashActivity extends Activity {
    private Boolean LOGIN_COOKIE = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences pref = getSharedPreferences("Setting", 0);
        LOGIN_COOKIE = pref.getBoolean("Vibe", false);

        Handler hd = new Handler();
        hd.postDelayed(new splashhandler() , 2000); // 2초 후에 hd Handler 실행
    }

    private class splashhandler implements Runnable {
        public void run() {
            //if (LOGIN_COOKIE) {
                startActivity(new Intent(getApplication(), MainActivity.class));
                SplashActivity.this.finish();
           /*}
            else {
                startActivity(new Intent(getApplication(), LoginActivity.class));
                SplashActivity.this.finish();
            }*/
        }
    }

}