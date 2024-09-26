package fvtc.edu.galleryapp.ui.character1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Character1ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Character1ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}