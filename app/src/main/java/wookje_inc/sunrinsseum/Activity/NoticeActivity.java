package wookje_inc.sunrinsseum.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import wookje_inc.sunrinsseum.Adapter.NoticeListviewAdapter;
import wookje_inc.sunrinsseum.Item.NoticeListviewitem;
import wookje_inc.sunrinsseum.R;

public class NoticeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        Intent intent = new Intent(this.getIntent());

        /*
            액션바/네비게이션 드로워 시작
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_notice);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(null);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        /*
            액션바/네비게이션 드로워 끝
         */

        /*
            리스트뷰 시작
         */
        final ArrayList<NoticeListviewitem> noticeListData = new ArrayList<>();
        ListView noticeListView = (ListView) findViewById(R.id.notice_listview);
        NoticeListviewitem[] nlItem = new NoticeListviewitem[10];
        /*for (int i = 0; i < 10; i++) {
            nlItem[i] = new NoticeListviewitem((R.drawable.test), "권욱제", "05:05 pm", "반갑습니다");
            noticeListData.add(nlItem[i]);
        }*/
        nlItem[0] = new NoticeListviewitem((R.drawable.test), "임준오", "05:05 pm", "하이요!");
        noticeListData.add(nlItem[0]);
        nlItem[1] = new NoticeListviewitem((R.drawable.test), "Alex Kim", "05:05 pm", "Cna't wait to see you");
        noticeListData.add(nlItem[1]);

        NoticeListviewAdapter adapter = new NoticeListviewAdapter(this, R.layout.listview_item_notice, noticeListData);
        noticeListView.setAdapter(adapter);
        noticeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NoticeActivity.this, next.class);
                startActivity(intent);
            }
        });

        // 리스트 뷰 높이 재계산
        ListAdapter listAdapter = noticeListView.getAdapter();
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, noticeListView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = noticeListView.getLayoutParams();
        params.height = totalHeight + (noticeListView.getDividerHeight() * (adapter.getCount() - 1));
        noticeListView.setLayoutParams(params);
        noticeListView.requestLayout();

        /*
            리스트뷰 끝
         */
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) {
            Intent intent = new Intent(NoticeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_hotshow) {
            Intent intent = new Intent(NoticeActivity.this, HotTopicActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_search) {
            Intent intent = new Intent(NoticeActivity.this, SearchActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_alert) {
            Intent intent = new Intent(NoticeActivity.this, NoticeActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_mypage) {
            Intent intent = new Intent(NoticeActivity.this, MypageActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(NoticeActivity.this, SettingsActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}