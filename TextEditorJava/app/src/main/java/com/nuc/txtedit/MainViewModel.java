package com.nuc.txtedit;

import android.graphics.Typeface;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> content;
    private MutableLiveData<Typeface> style;
    private MutableLiveData<Boolean> isSingleChoose;

    public MutableLiveData<String> getContent() {
        if (content == null) {
            content = new MutableLiveData<>();
            content.setValue("");
        }
        return content;
    }

    /**
     * bold italic
     */
    public void setContentStyle(Typeface style) {
        this.style.setValue(style);
    }

    public MutableLiveData<Typeface> getStyle() {
        if (style == null) {
            style = new MutableLiveData<>();
            style.setValue(Typeface.DEFAULT);
        }

        return style;
    }
}
