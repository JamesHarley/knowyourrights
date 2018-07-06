package com.gnosisdevelopment.know_your_rights;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class StatusVote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_vote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        WebView statusWebView = (WebView) findViewById(R.id.status_voteWebView);
        statusWebView.setWebViewClient(new StatusVote.MyBrowser());


        String url = "https://verify.vote.org/?partner=111111&campaign=free-tools";

        statusWebView.getSettings().setLoadsImagesAutomatically(true);
        statusWebView.getSettings().setJavaScriptEnabled(true);
        statusWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        statusWebView.loadUrl(url);

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
        if (findViewById(R.id.status_voteWebView) != null) {
            if (findViewById(R.id.status_voteWebView).getVisibility() == View.VISIBLE) {

                startActivity(intent);

                return;
            } else {
                super.onBackPressed();
                return;
            }

        } else {

            super.onBackPressed();
        }

    }
}
