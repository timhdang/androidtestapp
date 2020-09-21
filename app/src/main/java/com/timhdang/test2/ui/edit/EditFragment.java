package com.timhdang.test2.ui.edit;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import com.google.gson.Gson;
import com.timhdang.test2.Person;
import com.timhdang.test2.R;


import static com.timhdang.test2.ui.profile.ProfileFragment.PREF_NAME;

public class EditFragment extends Fragment {

    TextView profile_info;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_edit, container, false);
        profile_info = root.findViewById(R.id.profile_info);
        SharedPreferences mPrefs = getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        try {
            String json = mPrefs.getString(getString(R.string.person_of_interest), "");
            Person p = gson.fromJson(json, Person.class);
            profile_info.setText(getString(R.string.profile_info)+ "\n\n"
                    + p.getFirstname() + " " + p.getLastname() + "\n"
                    + p.getEmail() + "\n"
                    + p.getPhone() + "\n");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            profile_info.setText(getString(R.string.profile_info) + " \n\n");
        }

        return root;
    }
}
