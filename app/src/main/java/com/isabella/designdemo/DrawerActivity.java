package com.isabella.designdemo;

import android.content.Intent;
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
import android.widget.Button;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        //点击事件
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar setActionTextColor()更改Action的字体颜色
                Snackbar snackbar = Snackbar.make(view, "弹出了", Snackbar.LENGTH_SHORT)
                        //设置右边按钮
                        .setAction("你点我啊", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //设置点击完右边按钮后出现的字
                                Snackbar.make(v, "啦啦啦啦", Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .setActionTextColor(0xffeb7b1b);
                SnackbarUtil.setSnackbarColor(snackbar, 0xffd68ccc, 0xff9fe1e8);
                //  SnackbarUtil.SnackbarAddView(snackbar, R.layout.add_view, 0);
                snackbar.show();
            }
        });
        //toolbar.setSubtitle("副标题");
        // toolbar.setLogo(R.mipmap.ic_launcher_round);
        //设置返回键的图标
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.option_1:
                        Snackbar.make(fab, "option_1", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.option_2:
                        Snackbar.make(fab, "option_2", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.option_3:
                        Snackbar.make(fab, "option_3", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.menu1:
                        Snackbar.make(fab, "menu1", Snackbar.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button bt2= (Button) findViewById(R.id.button2);
        Button bt3= (Button) findViewById(R.id.button3);
        Button bt4= (Button) findViewById(R.id.button4);
        Button bt5= (Button) findViewById(R.id.button5);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                toActivity(TabActivity.class);
                break;
            case R.id.button3:
                toActivity(CollaspsingActivity.class);
                break;
            case R.id.button4:
                toActivity(LoginActivity.class);
                break;
            case R.id.button5:
                toActivity(BottomSeetActivity.class);
                break;
        }
    }
    private void toActivity( Class classType) {
        Intent intent=new Intent(DrawerActivity.this,classType);
        startActivity(intent);
    }
}
