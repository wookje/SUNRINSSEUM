package wookje_inc.sunrinsseum.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import wookje_inc.sunrinsseum.R;

public class SearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent = new Intent(this.getIntent());

        /*
            액션바/네비게이션 드로워 시작
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_search);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(null);

        ImageView backButton = (ImageView) findViewById(R.id.search_back_btn);
        backButton.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                }
        );

        final EditText editBox = (EditText) findViewById(R.id.search_box);
        ImageView searchButton = (ImageView) findViewById(R.id.search_admit);
        searchButton.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        String inputText = editBox.getText().toString();
                        Toast.makeText(SearchActivity.this, inputText, Toast.LENGTH_SHORT).show();
                        // request search to server
                    }
                }
        );

        /*
            액션바/네비게이션 드로워 끝
         */
    }
}