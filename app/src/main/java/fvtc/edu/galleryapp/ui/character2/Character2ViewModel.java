package fvtc.edu.galleryapp.ui.character2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Character2ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Character2ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}