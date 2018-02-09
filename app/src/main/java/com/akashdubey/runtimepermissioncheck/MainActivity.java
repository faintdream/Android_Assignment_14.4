package com.akashdubey.runtimepermissioncheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button capturePhoto,captureVideo;
    ImageView photo;
    VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        capturePhoto=(Button)findViewById(R.id.photoBtn);
        captureVideo=(Button)findViewById(R.id.videoBtn);
        photo=(ImageView)findViewById(R.id.photoIV);
        video=(VideoView)findViewById(R.id.videoView);


    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "view called ...", Toast.LENGTH_SHORT).show();
        switch (view.getId()){
            case R.id.photoBtn:
                Toast.makeText(this, "photoBtn called", Toast.LENGTH_SHORT).show();
                break;

            case R.id.videoBtn:
                Toast.makeText(this, "videoBtn called", Toast.LENGTH_SHORT).show();
                break;

        }


    }
}
