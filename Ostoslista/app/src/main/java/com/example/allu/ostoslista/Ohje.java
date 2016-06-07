package com.example.allu.ostoslista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Ohje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohje);
        WebView helpWebView;
        helpWebView = (WebView) findViewById(R.id.webView);
        helpWebView.loadUrl("file:///android_asset/ohje.html");

        Button btnSulje = (Button) findViewById(R.id.btnSulje);
        assert btnSulje != null;
        btnSulje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
