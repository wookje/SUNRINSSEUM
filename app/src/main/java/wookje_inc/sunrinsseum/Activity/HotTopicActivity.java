package wookje_inc.sunrinsseum.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import wookje_inc.sunrinsseum.R;

public class HotTopicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hottopic);

        Intent intent = new Intent(this.getIntent());

        /*
            액션바/네비게이션 드로워 시작
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_hottopic);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(null);

        ImageView backButton = (ImageView) findViewById(R.id.hottopic_back_btn);
        backButton.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                }
        );
        /*
            액션바/네비게이션 드로워 끝
         */
    }
}