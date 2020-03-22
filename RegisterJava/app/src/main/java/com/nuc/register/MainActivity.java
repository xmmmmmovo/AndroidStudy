package com.nuc.register;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView cityTextView;
    private TextView unemptyText;
    private TextView pwdLengthText;
    private TextView unEquelText;

    private EditText nameEditText;
    private EditText pwdEditText;
    private EditText confirmPwdEditText;

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.cityButton).setOnClickListener(this);
        findViewById(R.id.registerButton).setOnClickListener(this);

        cityTextView = findViewById(R.id.cityTextView);
        unemptyText = findViewById(R.id.unemptyText);
        pwdLengthText = findViewById(R.id.pwdLengthText);
        unEquelText = findViewById(R.id.unEquelText);

        nameEditText = findViewById(R.id.nameEditText);
        pwdEditText = findViewById(R.id.pwdEditText);
        confirmPwdEditText = findViewById(R.id.confirmEditText);

        radioGroup = findViewById(R.id.radioGroup);
    }

    private boolean validate() {
        boolean ok = true;

        if (nameEditText.getText().length() == 0) {
            ok = false;
            unemptyText.setVisibility(TextView.VISIBLE);
        }

        if (pwdEditText.length() < 6) {
            ok = false;
            pwdLengthText.setVisibility(TextView.VISIBLE);
        }

        if (!confirmPwdEditText.getText().toString().equals(pwdEditText.getText().toString())) {
            ok = false;
            unEquelText.setVisibility(TextView.VISIBLE);
        }

        if (ok) {
            unemptyText.setVisibility(TextView.INVISIBLE);
            pwdLengthText.setVisibility(TextView.INVISIBLE);
            unEquelText.setVisibility(TextView.INVISIBLE);
            return true;
        } else {
            return false;
        }

    }

    private String combineString() {
        RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        return "姓名:" + nameEditText.getText().toString() + "\n" +
                "密码:" + pwdEditText.getText().toString() + "\n" +
                "性别:" + radioButton.getText().toString() + "\n" +
                "所在地:" + cityTextView.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cityButton:
                Intent intent = new Intent(this, CityChooseActivity.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.registerButton:
                if (validate()) {
                    Intent intent1 = new Intent(this, RegisterCompleteActivity.class);
                    intent1.putExtra("ans", combineString());
                    startActivity(intent1);
                }
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
                cityTextView.setText(data.getExtras().getString("city"));
        }
    }
}
