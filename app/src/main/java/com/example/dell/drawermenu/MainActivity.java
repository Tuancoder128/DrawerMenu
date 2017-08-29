package com.example.dell.drawermenu;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBar actionBar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
//    String[] item = {"android","ios","windowphone"};
//    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//listView =  (ListView) findViewById(R.id.listview);
//        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item);
//        listView.setAdapter(adapter);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(this);

        // tạo 3 gạch trong toolbar
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open, R.string.close);
        drawerToggle.syncState();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int i = item.getItemId();
        switch (i){
            case R.id.Camera:
                 fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment_Camera fragment_camera =  new Fragment_Camera();
                fragmentTransaction.replace(R.id.content_layout,fragment_camera);
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                ;break;
            case R.id.Gallery:
                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transactionGallery = fragmentManager.beginTransaction();

                Fragment_Gallery fragment_gallery = new Fragment_Gallery();
                transactionGallery.replace(R.id.content_layout,fragment_gallery);
                transactionGallery.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                ;break;
            case R.id.SlideShow:

                ;break;
            case R.id.Setting:

                ;break;
            case R.id.Share:

                ;break;
            case R.id.Send:

                ;break;
        }
        return true;
    }
}
