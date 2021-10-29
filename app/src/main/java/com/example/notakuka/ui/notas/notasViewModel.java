package com.example.notakuka.ui.notas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class notasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public notasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Notas fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}