package com.example.minavegacionuiux.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.minavegacionuiux.R;
import com.example.minavegacionuiux.databinding.FragmentGalleryBinding;
import com.squareup.picasso.Picasso;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        final ImageView img = binding.imgRandom;
        final Button btn = binding.btnChangeImg;
        final ImageView img2 = binding.imgRandom2;

        btn.setOnClickListener(view -> galleryViewModel.setRandomImage());

        Picasso.with(getContext()).load(galleryViewModel.urlImage().getValue()).into(img);

        galleryViewModel.urlImage().observe(getViewLifecycleOwner(), s -> {

        });

        galleryViewModel.urlImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Picasso.with(getContext()).load(s).into(img2);
            }
        });

        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}