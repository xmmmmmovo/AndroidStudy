package com.nuc.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RegisterCompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_complete);

        Intent intent = getIntent();
        TextView textView = findViewById(R.id.comText);
        textView.setText(intent.getStringExtra("ans"));
    }
}
