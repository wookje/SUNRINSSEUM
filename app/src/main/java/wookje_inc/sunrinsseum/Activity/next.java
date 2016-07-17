package wookje_inc.sunrinsseum.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import wookje_inc.sunrinsseum.R;

// 메인 엑티비티 리스트 클릭 시 보여지는 엑티비티
public class next extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);

        TextView tvTitle = (TextView)findViewById(R.id.textView1);
        //ImageView ivTitle = (ImageView)findViewById(R.id.imageView1);
        
        Intent intent = new Intent(this.getIntent());
        tvTitle.setText(intent.getStringExtra("title"));
    }
}