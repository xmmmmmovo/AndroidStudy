package org.nuc.file;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText writeText, readText;
    private Button readButton, writeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sdStatus = Environment.getExternalStorageState();
                if (sdStatus.equals(Environment.MEDIA_MOUNTED)) {
                    String sdRoot = Environment.getExternalStorageDirectory().toString();
                    String path = sdRoot + File.separator + "classten";
                    File file = new File(path);
                    if (!file.exists()) {
                        file.mkdirs();
                    }

                    File newFile = new File(file, "content.txt");
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = new FileOutputStream(newFile, false);
                        fileOutputStream.write(writeText.getText().toString().getBytes());
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = "";
                FileInputStream fileInputStream = null;
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    String sdCardPath = Environment.getExternalStorageDirectory().toString();
                    String tempPath = sdCardPath + File.separator + "classten";
                    try {
                        File newFile = new File(tempPath, "content.txt");
                        fileInputStream = new FileInputStream(newFile);
                        int length = fileInputStream.available();
                        byte[] buffer = new byte[length];
                        fileInputStream.read(buffer);
                        content = new String(buffer);
                        fileInputStream.close();
                        readText.setText(content);
                    } catch (IOException e) {
                        readText.setText(content);
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void initView() {
        readButton = findViewById(R.id.readButton);
        writeButton = findViewById(R.id.writeButton);
        readText = findViewById(R.id.readText);
        writeText = findViewById(R.id.writeText);
    }
}
