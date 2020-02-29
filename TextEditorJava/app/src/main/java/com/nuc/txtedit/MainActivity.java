package com.nuc.txtedit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Typeface;
import android.os.Bundle;

import com.nuc.txtedit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        activityMainBinding.setData(mainViewModel);
        activityMainBinding.setLifecycleOwner(this);

        // 这里设定对于flag数据的响应式监听器
        // 将程序架构设定为响应式框架
        mainViewModel.getFlag().observe(
                this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        switch (integer) {
                            case 0:
                                activityMainBinding.editText.setTypeface(
                                        Typeface.MONOSPACE,
                                        Typeface.NORMAL
                                );
                                break;
                            case 1:
                                activityMainBinding.editText.setTypeface(
                                        Typeface.MONOSPACE,
                                        Typeface.BOLD
                                );
                                break;
                            case 2:
                                activityMainBinding.editText.setTypeface(
                                        Typeface.MONOSPACE,
                                        Typeface.ITALIC
                                );
                                break;
                            case 3:
                                activityMainBinding.editText.setTypeface(
                                        Typeface.MONOSPACE,
                                        Typeface.BOLD_ITALIC
                                );
                                break;
                        }
                    }
                }
        );
    }
}
