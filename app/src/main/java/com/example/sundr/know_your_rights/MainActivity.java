package com.example.sundr.know_your_rights;

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

import android.widget.RelativeLayout;
import android.widget.TextView;
import android.text.Html;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    int once = 0;
    private TextView mTextMessage;
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
        setContentView(R.layout.index);
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
        TextView maintext = (TextView)findViewById(R.id.alltext);

        maintext.setText(Html.fromHtml(getString(R.string.all_text)));
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
        TextView maintext = (TextView)findViewById(R.id.alltext);
        int id = item.getItemId();

        if (id == R.id.decl) {
            maintext.setText(Html.fromHtml(getString(R.string.declaration)));


        }else if (id == R.id.alltext) {
            maintext.setText(Html.fromHtml(getString(R.string.all_text)));
        } else if (id == R.id.preamble) {
            maintext.setText(Html.fromHtml(getString(R.string.preamble)));
        } else if (id == R.id.art1) {
            maintext.setText(Html.fromHtml(getString(R.string.cons_art1)));
        } else if (id == R.id.art2) {
            maintext.setText(Html.fromHtml(getString(R.string.cons_art2)));
        } else if (id == R.id.art3) {
            maintext.setText(Html.fromHtml(getString(R.string.cons_art3)));
        } else if (id == R.id.art4) {
            maintext.setText(Html.fromHtml(getString(R.string.cons_art4)));
        }else if (id == R.id.art5) {
            maintext.setText(Html.fromHtml(getString(R.string.cons_art5)));
        }else if (id == R.id.art6) {
            maintext.setText(Html.fromHtml(getString(R.string.cons_art6)));
        }else if (id == R.id.art7) {
            maintext.setText(Html.fromHtml(getString(R.string.cons_art7)));
        }else if (id == R.id.amd1) {
            maintext.setText(Html.fromHtml(getString(R.string.cons_amend_1_10)));
        }else if (id == R.id.amd2) {
            maintext.setText(Html.fromHtml(getString(R.string.cons_amend_11_20)));
        }else if (id == R.id.amd3) {
            maintext.setText(Html.fromHtml(getString(R.string.cons_amend_21_27)));
        }

        return true;
    }
}
