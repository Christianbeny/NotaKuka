package com.example.notakuka.ui.tareas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class tareashowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public tareashowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Tareas fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}