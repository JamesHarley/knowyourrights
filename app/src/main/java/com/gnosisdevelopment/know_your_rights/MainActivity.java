package com.gnosisdevelopment.know_your_rights;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.text.Html;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    int once = 0;
    private TextView mTextMessage;
    private Intent registerIntent;
    private Intent statusIntent;
    private Intent pollingIntent;
    private Intent aboutIntent;
    private Intent repIntent;


    private WebView maintext;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //TODO Change this to a method
                    setContentView(R.layout.index);

                    return true;
                case R.id.navigation_dashboard:
                    setContentView(R.layout.index);
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerIntent = new Intent(this, RegisterVote.class);
        statusIntent = new Intent(this, StatusVote.class);
        pollingIntent = new Intent(this, PollingVote.class);
        aboutIntent = new Intent(this, About.class);
        repIntent = new Intent(this, Representatives.class);
        maintext = (WebView) findViewById(R.id.alltext);

        setContentView(R.layout.index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //TODO Create a onclickeneventlistenter method for all buttons and load from xml
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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
            changelayout(findViewById(id));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void changelayout(View view){
        setContentView(R.layout.activity_main);
        startActivity(aboutIntent);
    }
    //TODO FIX Back with new activity
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        if(findViewById(R.id.activity_main) != null){
            if(findViewById(R.id.activity_main).getVisibility() == View.VISIBLE){

                startActivity(intent);

                return;
            }else{
                super.onBackPressed();
                return;
            }

        }
        else{

            super.onBackPressed();
        }

    }
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        setContentView(R.layout.activity_main);
        maintext = (WebView) findViewById(R.id.alltext);
        maintext.setBackgroundColor(000);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String summary = "";

        int id = item.getItemId();

        if (id == R.id.register_vote) {
            startActivity(registerIntent);
            return true;
        }if
         (id == R.id.status_vote) {
            startActivity(statusIntent);
            return true;
        }if (id == R.id.poll_vote) {
            startActivity(pollingIntent);
            return true;
        }
        if (id == R.id.rep) {
            startActivity(repIntent);
            return true;
        }
        //Documents
        if (id == R.id.decl) {
            getSupportActionBar().setTitle(getString(R.string.dec_title));
            summary  = getString(R.string.declaration);
            maintext.loadData(summary, "text/html", null);
            return true;
        }else if (id == R.id.alltext) {
            
          summary  = getString(R.string.all_text);
        } else if (id == R.id.preamble) {
          summary  = getString(R.string.preamble);
        } else if (id == R.id.art1) {
          summary  = getString(R.string.cons_art1);
        } else if (id == R.id.art2) {
          summary  = getString(R.string.cons_art2);
        } else if (id == R.id.art3) {
          summary  = getString(R.string.cons_art3);
        } else if (id == R.id.art4) {
          summary  = getString(R.string.cons_art4);
        }else if (id == R.id.art5) {
          summary  = getString(R.string.cons_art5);
        }else if (id == R.id.art6) {
          summary  = getString(R.string.cons_art6);
        }else if (id == R.id.art7) {
          summary  = getString(R.string.cons_art7);
        }else if (id == R.id.amd1) {
          summary  = getString(R.string.cons_amend_1_10);
        }else if (id == R.id.amd2) {
          summary  = getString(R.string.cons_amend_11_20);
        }else if (id == R.id.amd3) {
          summary  = getString(R.string.cons_amend_21_27);
        }
        getSupportActionBar().setTitle(getString(R.string.cons_title));
        maintext.loadData(summary, "text/html", null);
        return true;
    }
}
