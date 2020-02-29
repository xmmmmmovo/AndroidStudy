package com.nuc.defedit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int flag;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.redButton).setOnClickListener(this);
        findViewById(R.id.greenButton).setOnClickListener(this);
        findViewById(R.id.blueButton).setOnClickListener(this);
        findViewById(R.id.biggerButton).setOnClickListener(this);
        findViewById(R.id.smallerButtom).setOnClickListener(this);
        findViewById(R.id.defaultSizeButton).setOnClickListener(this);
        findViewById(R.id.boldButton).setOnClickListener(this);
        findViewById(R.id.italicButton).setOnClickListener(this);
        findViewById(R.id.defaultStyleButton).setOnClickListener(this);
        editText = findViewById(R.id.editText);

        flag = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.redButton:
                editText.setTextColor(getColor(R.color.red));
                break;
            case R.id.greenButton:
                editText.setTextColor(getColor(R.color.green));
                break;
            case R.id.blueButton:
                editText.setTextColor(getColor(R.color.blue));
                break;
            case R.id.biggerButton:
                editText.setTextSize(
                        TypedValue.COMPLEX_UNIT_PX,
                        editText.getTextSize() + 10
                );
                break;
            case R.id.smallerButtom:
                editText.setTextSize(
                        TypedValue.COMPLEX_UNIT_PX,
                        editText.getTextSize() - 10
                );
                break;
            case R.id.defaultSizeButton:
                editText.setTextSize(
                        20
                );
                break;

            case R.id.boldButton:
                if (flag == 0 || flag == 1) {
                    editText.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
                    flag = 1;
                    break;
                }
                editText.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
                break;

            case R.id.italicButton:
                if (flag == 0 || flag == 2) {
                    editText.setTypeface(Typeface.MONOSPACE, Typeface.ITALIC);
                    flag = 2;
                    break;
                }
                editText.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
                break;
            case R.id.defaultStyleButton:
                editText.setTypeface(Typeface.MONOSPACE, Typeface.NORMAL);
                flag = 0;
                break;
            default:
                break;
        }
    }
}
