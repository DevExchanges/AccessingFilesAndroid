package info.devexchanges.accessingfiles;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        View button = findViewById(R.id.btn_get);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File sdcard = Environment.getExternalStorageDirectory();

                //Get PNG file based on folder
                File imgFile = new File(sdcard, "Test/logo.png");

                if(imgFile.exists()){
                    //decode Bitmap by BitmapFactory
                    Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

                    //set Bitmap to ImageView
                    ImageView imageView = (ImageView) findViewById(R.id.image);
                    imageView.setImageBitmap(bitmap);
                }
            }
        });
    }
}
