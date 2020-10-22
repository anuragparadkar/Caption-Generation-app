package com.example.cg3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.transform.sax.TemplatesHandler;

public class Activity6 extends AppCompatActivity {

    String currentImagePath = null;
    private static final int IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
    }


    public void captureimage(View view) {

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (cameraIntent.resolveActivity(getPackageManager()) != null)
        {
            File imageFile = null;

            try {
                imageFile = getimageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (imageFile!= null)
            {
                Uri imageUri = FileProvider.getUriForFile(this,"android.example.android.fileprovider",imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(cameraIntent,IMAGE_REQUEST);
            }

        }
    }

        public void displayimage (View view)
        {
            Intent intent12 = new Intent(this,DisplayImage.class);
            intent12.putExtra("image_path",currentImagePath);
            startActivity(intent12);

        }

        private File getimageFile ()throws IOException
        {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHss").format(new Date());
            String imageName = "jpg_" + timeStamp + "_";
            File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

            File imageFile = File.createTempFile(imageName, ".jpg", storageDir);
            currentImagePath = imageFile.getAbsolutePath();
            return imageFile;
        }

}


