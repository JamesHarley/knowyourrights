package com.example.sundr.know_your_rights;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.text.Html;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

    final Button Decl = findViewById(R.id.decl);
    Decl.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            setContentView(R.layout.activity_main);
            TextView maintext = (TextView)findViewById(R.id.alltext);
            maintext.setText(Html.fromHtml(getString(R.string.declaration)));
        }
    });
    final Button Preamble = findViewById(R.id.preamble);
    Preamble.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
                TextView maintext = (TextView)findViewById(R.id.alltext);
                maintext.setText(Html.fromHtml(getString(R.string.preamble)));
            }
     });
    final Button Art1 = findViewById(R.id.art1);
    Art1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
            TextView maintext = (TextView)findViewById(R.id.alltext);
            maintext.setText(Html.fromHtml(getString(R.string.cons_art1)));
        }
    });
    final Button Art2 = findViewById(R.id.art2);
    Art2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
            TextView maintext = (TextView)findViewById(R.id.alltext);
            maintext.setText(Html.fromHtml(getString(R.string.cons_art2)));
        }
    });
    final Button Art3 = findViewById(R.id.art3);
    Art3.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
            TextView maintext = (TextView)findViewById(R.id.alltext);
            maintext.setText(Html.fromHtml(getString(R.string.cons_art3)));
        }
    });
    final Button Art4 = findViewById(R.id.art4);
    Art4.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
            TextView maintext = (TextView)findViewById(R.id.alltext);
            maintext.setText(Html.fromHtml(getString(R.string.cons_art4)));
        }
    });
    final Button Art5 = findViewById(R.id.art5);
    Art5.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
            TextView maintext = (TextView)findViewById(R.id.alltext);
            maintext.setText(Html.fromHtml(getString(R.string.cons_art5)));
        }
    });
    final Button Art6 = findViewById(R.id.art6);
    Art6.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
            TextView maintext = (TextView)findViewById(R.id.alltext);
            maintext.setText(Html.fromHtml(getString(R.string.cons_art1)));
        }
    });

    final Button Art7 = findViewById(R.id.art7);
    Art7.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
            TextView maintext = (TextView)findViewById(R.id.alltext);
            maintext.setText(Html.fromHtml(getString(R.string.cons_art7)));
        }
    });
    final Button Amd1 = findViewById(R.id.amd1);
    Amd1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
            TextView maintext = (TextView)findViewById(R.id.alltext);
            maintext.setText(Html.fromHtml(getString(R.string.cons_amend_1_10)));
        }
    });
    final Button Amd2 = findViewById(R.id.amd2);
    Amd2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
            TextView maintext = (TextView)findViewById(R.id.alltext);
            maintext.setText(Html.fromHtml(getString(R.string.cons_amend_11_20)));
        }
    });
    final Button Amd3 = findViewById(R.id.amd3);
    Amd3.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
            TextView maintext = (TextView)findViewById(R.id.alltext);
            maintext.setText(Html.fromHtml(getString(R.string.cons_amend_21_27)));
        }
    });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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

}
