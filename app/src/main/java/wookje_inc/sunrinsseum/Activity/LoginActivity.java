package wookje_inc.sunrinsseum.Activity;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import wookje_inc.sunrinsseum.R;

public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = new Intent(this.getIntent());
    }

    @Override
    protected void onPause() {
        SharedPreferences pref = getSharedPreferences("Setting", 0);
        SharedPreferences.Editor edit = pref.edit();
        edit.putBoolean("Vibe", true);
        edit.commit();
    }

    String name;
    public void getData(String name) {
        this.name = name;
    }
}
