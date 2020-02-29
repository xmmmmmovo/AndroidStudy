package com.nuc.txtedit;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<String> content;
    private MutableLiveData<Integer> flag;
    private MutableLiveData<Integer> color;
    private MutableLiveData<Float> size;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getContent() {
        if (content == null) {
            content = new MutableLiveData<>();
            content.setValue("");
        }
        return content;
    }

    public MutableLiveData<Integer> getFlag() {
        if (flag == null) {
            flag = new MutableLiveData<>();
            flag.setValue(0);
        }

        return flag;
    }

    public MutableLiveData<Integer> getColor() {
        if (color == null) {
            color = new MutableLiveData<>();
            color.setValue(R.color.black);
        }

        return color;
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @param context （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public MutableLiveData<Float> getSize() {
        if (size == null) {
            size = new MutableLiveData<>();
            size.setValue((float) sp2px(getApplication(), 20));
        }

        return size;
    }

    public void setSize(float size) {
        this.size.setValue((float) sp2px(getApplication(), size));
    }

    public void addSize(float px) {
        size.setValue(size.getValue() + px);
    }

    public void decreaseSize(float px) {
        size.setValue(size.getValue() - px);
    }

    public void setColor(Integer color) {
        this.color.setValue(color);
    }
}
