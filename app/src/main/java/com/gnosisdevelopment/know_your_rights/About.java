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

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView aboutWebView = (WebView) findViewById(R.id.aboutWebView);
        aboutWebView.setWebViewClient(new About.MyBrowser());

        String summary = "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                ".main{\n" +
                "margin:20px;\n" +
                "\n" +
                "text-align:center;\n" +
                "color:dark-gray\n" +
                "}\n" +
                ".gnos a{\n" +
                "color:purple;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body\n" +
                "\n" +
                "\t<div class=\"main\">\n" +
                "\t\t<h1>Know Your Rights</h1>\n" +
                "\t\t<p>\n" +
                "\t\tThis app was developed as a citizens tool for learning about the Unites States of America's laws, voting information, and voter engagement with representatives.</p>\n" +
                "\t\t<div class=\"gnos\"><a href=\"https://github.com/JamesHarley/knowyourrights\">Github repo</a> - <a href=\"http://gnosisdevelopment.com\"> Developed by James Harley</a> </div> \n" +
                "\t\n" +
                "\t</div>\n" +
                "</body\n" +
                "</html>";

        aboutWebView.getSettings().setLoadsImagesAutomatically(true);
        aboutWebView.getSettings().setJavaScriptEnabled(true);
        aboutWebView.getSettings().setBuiltInZoomControls(true);
        aboutWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        aboutWebView.loadData(summary, "text/html", null);

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
        if(findViewById(R.id.aboutWebView) != null){
            if(findViewById(R.id.aboutWebView).getVisibility() == View.VISIBLE){

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
