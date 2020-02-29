package com.nuc.defedit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 这里的flag是为了判断当前text的样式
     * 0是普通/默认
     * 1是当前是加粗
     * 2是当前是斜体
     */
    private int flag;
    // edittext文本编辑框
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 下面的是获取相关控件并且设定点击监听器
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

        // 这里初始化flag为默认值
        flag = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.redButton:
                // 这里对文本编辑框的文本进行颜色设定
                // getColor方法是从res中的color.xml中获取相应的颜色
                editText.setTextColor(getColor(R.color.red));
                break;
            case R.id.greenButton:
                editText.setTextColor(getColor(R.color.green));
                break;
            case R.id.blueButton:
                editText.setTextColor(getColor(R.color.blue));
                break;
            case R.id.biggerButton:
                // 这里设定文本相关的文本大小
                // TypedValue.COMPLEX_UNIT_PX 是以像素格式设定文本大小
                // 因为gettext获取到的是sp格式的文本大小
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
                /**
                 * 这里首先判断是否是默认/加粗状态
                 * 如果是则不应该变为斜体+加粗
                 * 如果不是就说明其肯定是在斜体的状态
                 * 再点击加粗肯定变为加粗+斜体
                 * */
                if (flag == 0 || flag == 1) {
                    editText.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
                    flag = 1;
                    break;
                }
                editText.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
                flag = 3;
                break;

            case R.id.italicButton:
                if (flag == 0 || flag == 2) {
                    editText.setTypeface(Typeface.MONOSPACE, Typeface.ITALIC);
                    flag = 2;
                    break;
                }
                editText.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
                flag = 3;
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
