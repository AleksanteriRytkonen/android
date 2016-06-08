package com.example.allu.kamerasofta;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    private Uri fileUri;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent kuva = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        final Intent musa = new Intent(MainActivity.this, AudioActivity.class);
        Button otaKuva = (Button) findViewById(R.id.button_capture);
        Button musiikki = (Button) findViewById(R.id.buttonMusic);

        musiikki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(musa);
            }
        });

        otaKuva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(kuva.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(kuva, REQUEST_IMAGE_CAPTURE);
                }
            }
        });


    }
    protected void onActivityResult(int requestCode, int resultCode, Intent kuva) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = kuva.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView naytaKuva = (ImageView) findViewById(R.id.imageView);
            naytaKuva.setImageBitmap(imageBitmap);
        }
    }
}
