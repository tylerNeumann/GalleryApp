package fvtc.edu.galleryapp.ui.character2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import fvtc.edu.galleryapp.databinding.FragmentCharacter2Binding;

public class Character2 extends Fragment {

    private FragmentCharacter2Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Character2ViewModel dashboardViewModel =
                new ViewModelProvider(this).get(Character2ViewModel.class);

        binding = FragmentCharacter2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.tvInfo;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}