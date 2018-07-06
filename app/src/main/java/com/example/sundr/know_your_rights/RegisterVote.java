package com.example.sundr.know_your_rights;

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
        setContentView(R.layout.activity_register_vote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        WebView registerWebView = (WebView) findViewById(R.id.register_vote_WebView);
        registerWebView.setWebViewClient(new MyBrowser());

        String summary = "<html><body>You scored <b>192</b> points.</body></html>";
        registerWebView.loadData(summary, "text/html", null);
//       / registerWebView.loadUrl("https://register.rockthevote.com/registrants/new?partner=1&source=ovrpage");
        String url = "https://register.rockthevote.com/registrants/new?partner=1&source=ovrpage";

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
        if(findViewById(R.id.register_vote_WebView) != null){
            if(findViewById(R.id.register_vote_WebView).getVisibility() == View.VISIBLE){

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
