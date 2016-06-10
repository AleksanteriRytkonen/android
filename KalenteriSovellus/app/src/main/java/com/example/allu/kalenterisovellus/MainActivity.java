package com.example.allu.kalenterisovellus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView maView = (TextView) findViewById(R.id.textViewMa);


        assert maView != null;
        maView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent testi = new Intent(getApplicationContext(), TestiAct.class);
                startActivity(testi);
            }
        });
    }
}
