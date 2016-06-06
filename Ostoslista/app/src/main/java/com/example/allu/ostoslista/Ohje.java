package com.example.allu.ostoslista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Ohje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohje);
        WebView helpWebView;
        helpWebView = (WebView) findViewById(R.id.webView);
        helpWebView.loadUrl("file:///android_asset/index.html");
    }
}
