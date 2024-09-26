package fvtc.edu.galleryapp.ui.character3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Character3ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Character3ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}