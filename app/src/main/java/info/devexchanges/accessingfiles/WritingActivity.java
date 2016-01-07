package info.devexchanges.accessingfiles;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class WritingActivity extends AppCompatActivity {

    private EditText editText;
    private View button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        editText = (EditText) findViewById(R.id.edit_text);
        button = findViewById(R.id.btn);
        button2 = findViewById(R.id.btn_go);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeTextToFile();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WritingActivity.this, ImageActivity.class);
                startActivity(intent);
            }
        });
    }

    public void writeTextToFile() {
        if (editText.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please input some texts", Toast.LENGTH_SHORT).show();
        } else {
            try {
                File sdcard = Environment.getExternalStorageDirectory();

                //Get the text file based on folder
                File file = new File(sdcard, "Test/output.txt");
                file.createNewFile();

                FileOutputStream fOut = new FileOutputStream(file);
                OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);

                //get EditText content to OutputStreamWriter
                myOutWriter.append(editText.getText().toString().trim());

                myOutWriter.close();
                fOut.close();
                Toast.makeText(this, "Done writing File to SD card!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
