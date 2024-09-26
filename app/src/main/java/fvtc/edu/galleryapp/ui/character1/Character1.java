package fvtc.edu.galleryapp.ui.character1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import fvtc.edu.galleryapp.databinding.FragmentCharacter1Binding;

public class Character1 extends Fragment {

    private FragmentCharacter1Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Character1ViewModel character1ViewModel =
                new ViewModelProvider(this).get(Character1ViewModel.class);

        binding = FragmentCharacter1Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.tvInfo;
        character1ViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}