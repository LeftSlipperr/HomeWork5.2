package com.example.myapplication2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
//    public String name = "";
    public MutableLiveData<String> name = new MutableLiveData<>("");
}
