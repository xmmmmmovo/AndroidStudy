package com.nuc.txtedit;

import android.graphics.Typeface;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> content;
    private MutableLiveData<Typeface> style;
    private MutableLiveData<Integer> flag;

    public MutableLiveData<String> getContent() {
        if (content == null) {
            content = new MutableLiveData<>();
            content.setValue("");
        }
        return content;
    }



    public MutableLiveData<Typeface> getStyle() {
        if (style == null) {
            style = new MutableLiveData<>();
            style.setValue(Typeface.DEFAULT);
        }

        return style;
    }
}
