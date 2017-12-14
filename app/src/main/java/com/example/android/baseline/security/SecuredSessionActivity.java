package com.example.android.baseline.security;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.android.baseline.About_Us;
import com.example.android.baseline.Blog;
import com.example.android.baseline.Career;
import com.example.android.baseline.Contact;
import com.example.android.baseline.R;
import com.example.android.baseline.Seo;
import com.example.android.baseline.Uitls.Constants;
import com.example.android.baseline.WebDevlapment;
import com.example.android.baseline.Web_Design;
import com.example.android.baseline.activity.MainActivity;
import com.example.android.baseline.services;

/**
 * Created by Rahul on 06-12-2017.
 */

public abstract class SecuredSessionActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Constants.PACKAGE_NAME = getApplicationContext().getPackageName();
    }

    protected void onNavigation() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

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
        if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.website_design) {
            Intent intent = new Intent(this, Web_Design.class);
            startActivity(intent);
        } else if (id == R.id.web_development) {
            Intent intent = new Intent(this, WebDevlapment.class);
            startActivity(intent);
        } else if (id == R.id.seo_optimization) {
            Intent intent = new Intent(this, Seo.class);
            startActivity(intent);
        } else if (id == R.id.contact_us) {
            Intent intent = new Intent(this, Contact.class);
            startActivity(intent);
        } else if (id == R.id.about_us) {
            Intent intent = new Intent(this, About_Us.class);
            startActivity(intent);
        } else if (id == R.id.services) {
            Intent intent = new Intent(this, services.class);
            startActivity(intent);
        } else if (id == R.id.blog_nev) {
            Intent intent = new Intent(this, Blog.class);
            startActivity(intent);
        } else if (id == R.id.career) {
            Intent intent = new Intent(this, Career.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}

