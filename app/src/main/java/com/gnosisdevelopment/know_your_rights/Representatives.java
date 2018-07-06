package com.gnosisdevelopment.know_your_rights;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Representatives extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_representatives);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        WebView repWebView = (WebView) findViewById(R.id.rep_webView);
        repWebView.setWebViewClient(new Representatives.MyBrowser());

        String url = "https://myreps.participatorybudgeting.org/";

        repWebView.getSettings().setLoadsImagesAutomatically(true);
        repWebView.getSettings().setJavaScriptEnabled(true);
        repWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        repWebView.loadUrl(url);

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
        if (findViewById(R.id.rep_webView) != null) {
            if (findViewById(R.id.rep_webView).getVisibility() == View.VISIBLE) {

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
