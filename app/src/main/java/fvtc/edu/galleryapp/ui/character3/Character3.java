package fvtc.edu.galleryapp.ui.character3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import fvtc.edu.galleryapp.databinding.FragmentCharacter3Binding;

public class Character3 extends Fragment {

    private FragmentCharacter3Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Character3ViewModel notificationsViewModel =
                new ViewModelProvider(this).get(Character3ViewModel.class);

        binding = FragmentCharacter3Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.tvInfo;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}