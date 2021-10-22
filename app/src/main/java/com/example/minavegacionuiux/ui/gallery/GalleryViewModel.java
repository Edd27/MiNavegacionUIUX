package com.example.minavegacionuiux.ui.gallery;

import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.minavegacionuiux.R;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    private MutableLiveData<String> urlImage;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        urlImage = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> urlImage() {
        if (urlImage == null) {
            urlImage.setValue(urlImageRandom());
        }
        return urlImage;
    }

    public String urlImageRandom() {
        return "https://picsum.photos/" + (int) (Math.random() * 5 + 3) + "00/" + (int) (Math.random() * 5 + 3) + "00";
    }
}