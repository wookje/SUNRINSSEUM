package wookje_inc.sunrinsseum.Activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import wookje_inc.sunrinsseum.Adapter.DebateListviewAdapter;
import wookje_inc.sunrinsseum.Item.DebateListviewitem;
import wookje_inc.sunrinsseum.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    int temp = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            액션바/네비게이션 드로워 시작
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(null);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView searchButton = (ImageView) findViewById(R.id.search_button);
        searchButton.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intent);
                    }
                }
        );
        /*
            액션바/네비게이션 드로워 끝
         */

        /*
            플로팅 액션 버튼 시작
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /*
            플로팅 액션 버튼 끝
         */

        /*
            핫토픽 시작
         */
        ImageView hotTopic = (ImageView) findViewById(R.id.hot_topic);
        Drawable hotTopicImage = getResources().getDrawable(R.drawable.army);
        hotTopic.setImageDrawable(hotTopicImage);
        hotTopic.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, HotTopicActivity.class);
                        startActivity(intent);
                    }
                }
        );

        /*
            핫토픽 끝
         */

        /*
            리스트 뷰 시작
         */
        //IssuesGetter get = new IssuesGetter();
        //final Issues[] issues_arr = get.Get(1);
        final ArrayList<DebateListviewitem> debateListData = new ArrayList<>();
        ListView debateListView = (ListView) findViewById(R.id.debate_listview);
        DebateListviewitem[] dlItem = new DebateListviewitem[5];

        dlItem[0] = new DebateListviewitem((R.drawable.thad), "사드 배치");
        debateListData.add(dlItem[0]);
        dlItem[1] = new DebateListviewitem((R.drawable.england), "BREXIT");
        debateListData.add(dlItem[1]);
        dlItem[2] = new DebateListviewitem((R.drawable.gangnam), "강남역 묻지마 살인");
        debateListData.add(dlItem[2]);
        dlItem[3] = new DebateListviewitem((R.drawable.history), "교과서 국정화");
        debateListData.add(dlItem[3]);
        dlItem[4] = new DebateListviewitem((R.drawable.toilet), "화장실 몰래 카메라");
        debateListData.add(dlItem[4]);

        /*for (int i = 0; i < issues_arr.length; i++) {
            dlItem[i] = new DebateListviewitem((R.drawable.city), issues_arr[i].topic);
            debateListData.add(dlItem[i]);
        }*/
        DebateListviewAdapter adapter = new DebateListviewAdapter(this, R.layout.listview_item_main, debateListData);
        debateListView.setAdapter(adapter);
        debateListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, next.class);
                intent.putExtra("title", debateListData.get(position).getName());
                intent.putExtra("image", debateListData.get(position).getImage());
//Toast.makeText(getApplicationContext(), "hi", 1000).show();
                startActivity(intent);
            }
        });

        // 리스트 뷰 높이 재계산
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, debateListView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = debateListView.getLayoutParams();
        params.height = totalHeight + (debateListView.getDividerHeight() * (adapter.getCount() - 1));
        debateListView.setLayoutParams(params);
        debateListView.requestLayout();

        debateListView.setFocusable(false);

        /*
        LayoutInflater inflater = (LayoutInflater) getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View header = inflater.inflate(
                R.layout.content_main, null, false);
        debateListView.addHeaderView(header);
        */
        /*
            리스트 뷰 끝
        */
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            return true;
        }
        else if (id == R.id.logo_button) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) {
            // Handle the camera action
        } else if (id == R.id.nav_hotshow) {
            Intent intent = new Intent(MainActivity.this, HotTopicActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_search) {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_alert) {
            Intent intent = new Intent(MainActivity.this, NoticeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_mypage) {
            Intent intent = new Intent(MainActivity.this, MypageActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
