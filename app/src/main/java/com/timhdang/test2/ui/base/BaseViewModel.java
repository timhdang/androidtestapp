package com.timhdang.test2.ui.base;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BaseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is a test");
    }

    public LiveData<String> getText() {
        return mText;
    }
}