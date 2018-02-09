package com.akashdubey.runtimepermissioncheck;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity{



    private static final int IMAGE_OK = 100;
    int permission;
    boolean granted;
    Button capturePhoto;
    ImageView photo;






    // this method ensures that request was sucesful to open camera app and
    //user did actually take the picture successfully
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode==IMAGE_OK && resultCode==RESULT_OK){
            Bundle extras= data.getExtras();
            Bitmap bitmap=(Bitmap)extras.get("data");
            photo.setImageBitmap(bitmap);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding object to views
        capturePhoto=(Button)findViewById(R.id.photoBtn);
        photo=(ImageView)findViewById(R.id.photoIV);




        //method handles capture picture actions
        // if app does not have access to camera ,permission is requested explicitly
        capturePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result=isPermissionGranted(Manifest.permission.CAMERA);
                if(!result){
                    requestPermission(Manifest.permission.CAMERA);
                }else{
                    //All good , let's proceed with capturing image
                    Intent imgCapture=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(imgCapture,IMAGE_OK);
                }
            }
        });

    }


    //checking with permission granted and accordingly setting the boolean variable
    boolean  isPermissionGranted (String myPermission){
        permission= ContextCompat.checkSelfPermission(this, myPermission);
        if (permission== PackageManager.PERMISSION_GRANTED){
            granted= true;
        }else{
            granted=false;
        }
        return granted;
    }


    //method handles requesting appropriate permission from user
    void requestPermission(String myPermission){
        ActivityCompat.requestPermissions(this,new String[]{myPermission},IMAGE_OK);
    }



}
