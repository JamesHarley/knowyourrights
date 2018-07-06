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

public class PollingVote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling_vote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        WebView pollingWebView = (WebView) findViewById(R.id.polling_voteWebView);
        pollingWebView.setWebViewClient(new MyBrowser());

        String summary = "<html><body>" +
                "<script type=\"text/javascript\" src=\"https://tool.votinginfoproject.org/app.js\"></script>\n" +
                "<div id=\"_vit\"></div>\n" +
                "<script type=\"text/javascript\">vit.load({\n" +
                "    modal: true,\n" +
                "    theme: 'https://tool.votinginfoproject.org/images/theme2.png',\n" +
                "    officialOnly: false,\n" +
                "    title: 'Find Voting Location',\n" +
                "\n" +
                "    colors: {\n" +
                "      'header': '#000',\n" +
                "      'landscapeBackgroundHeader': '#555'\n" +
                "    },\n" +
                "    language: 'en',\n" +
                "});</script>" +
                "</body></html>";

        pollingWebView.getSettings().setLoadsImagesAutomatically(true);
        pollingWebView.getSettings().setJavaScriptEnabled(true);
        pollingWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        pollingWebView.loadData(summary, "text/html", null);

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
        if(findViewById(R.id.polling_voteWebView) != null){
            if(findViewById(R.id.polling_voteWebView).getVisibility() == View.VISIBLE){

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
