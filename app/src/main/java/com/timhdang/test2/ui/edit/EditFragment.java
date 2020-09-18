package com.timhdang.test2.ui.edit;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.google.gson.Gson;
import com.timhdang.test2.Person;
import com.timhdang.test2.R;

import java.io.Console;

import static com.timhdang.test2.ui.profile.ProfileFragment.PREF_NAME;

public class EditFragment extends Fragment {

    private EditViewModel editViewModel;
    TextView profile_info;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        editViewModel =
                ViewModelProviders.of(this).get(EditViewModel.class);
        View root = inflater.inflate(R.layout.fragment_edit, container, false);
        /*final TextView textView = root.findViewById(R.id.text_home);
        editViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */
        profile_info = root.findViewById(R.id.profile_info);
        SharedPreferences mPrefs = getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("personOfInterest", "");
        Log.e("JSON=",json);
        Person p = gson.fromJson(json, Person.class);

        profile_info.setText("First Name:" + p.getFirstname() +"\n"
                              + "Last Name:" +  p.getLastname() + "\n"
                              + "Email:" +      p.getEmail() +"\n"
                              +  "Phone:" +        p.getPhone() +"\n"      );


        //profile_info.setText("HAHHAA");
        return root;
    }
}
