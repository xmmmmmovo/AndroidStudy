package com.nuc.register;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView cityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.cityButton).setOnClickListener(this);
        cityTextView = findViewById(R.id.cityTextView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cityButton:
                Intent intent = new Intent(this, CityChooseActivity.class);
                startActivityForResult(intent, 0);
                break;
            default:
                Log.d("test", "onClick: 其他点击事件");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 0:
                Log.d("test", data.getExtras().getString("city"));
                cityTextView.setText(data.getExtras().getString("city"));
        }
    }
}
