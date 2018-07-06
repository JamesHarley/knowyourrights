package com.gnosisdevelopment.know_your_rights;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class RegisterVote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.sundr.know_your_rights.R.layout.activity_register_vote);
        Toolbar toolbar = (Toolbar) findViewById(com.example.sundr.know_your_rights.R.id.toolbar);
        setSupportActionBar(toolbar);


        WebView registerWebView = (WebView) findViewById(com.example.sundr.know_your_rights.R.id.register_vote_WebView);
        registerWebView.setWebViewClient(new MyBrowser());

        String url = "https://register.vote.org/?partner=111111&campaign=free-tools";

        registerWebView.getSettings().setLoadsImagesAutomatically(true);
        registerWebView.getSettings().setJavaScriptEnabled(true);
        registerWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        registerWebView.loadUrl(url);

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        if(findViewById(com.example.sundr.know_your_rights.R.id.register_vote_WebView) != null){
            if(findViewById(com.example.sundr.know_your_rights.R.id.register_vote_WebView).getVisibility() == View.VISIBLE){

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

}
