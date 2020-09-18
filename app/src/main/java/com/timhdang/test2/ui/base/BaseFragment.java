package com.timhdang.test2.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.timhdang.test2.R;

public class BaseFragment extends Fragment {

    private BaseViewModel baseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        baseViewModel =
                ViewModelProviders.of(this).get(BaseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_base, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        baseViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
