package com.example.notakuka.ui.tareas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.notakuka.databinding.FragmentTareasBinding;

public class TareasFragment extends Fragment {

    private com.example.notakuka.ui.tareas.tareashowViewModel tareashowViewModel;
    private FragmentTareasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tareashowViewModel =
                new ViewModelProvider(this).get(com.example.notakuka.ui.tareas.tareashowViewModel.class);

        binding = FragmentTareasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTareas;
        tareashowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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