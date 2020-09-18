package com.timhdang.test2.ui.edit;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class EditViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EditViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is a test");
    }

    public LiveData<String> getText() {
        return mText;
    }
}