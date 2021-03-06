package com.timhdang.test2.ui.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.Toast;

import com.google.gson.Gson;
import com.timhdang.test2.Person;
import com.timhdang.test2.R;

import static android.content.Context.MODE_PRIVATE;

public class ProfileFragment extends Fragment {

    public static String PREF_NAME = "personOfInterest";
    private Button submit;
    private EditText fnEditText, lnEditText, eEditText,pEditText;
    private String SAVED_FIRST_NAME;
    private String SAVED_LAST_NAME;
    private String SAVED_EMAIL;
    private String SAVED_PHONE;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        submit = root.findViewById(R.id.save);
        fnEditText = root.findViewById(R.id.first_name);
        lnEditText = root.findViewById(R.id.last_name);
        eEditText = root.findViewById(R.id.email);
        pEditText = root.findViewById(R.id.phone);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences  mPrefs = getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
                String fn = fnEditText.getText().toString();
                String ln = lnEditText.getText().toString();
                String e = eEditText.getText().toString();
                String p = pEditText.getText().toString();
                Person myObject = new Person(fn,ln,e,p);
                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(myObject);
                prefsEditor.putString(getString(R.string.person_of_interest), json);
                prefsEditor.commit();
                Toast.makeText(getContext(),R.string.submitted,Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    public void onSaveInstanceState( Bundle savedInstanceState ) {
        // now, save the text if something overlaps this Activity
        savedInstanceState.putString( SAVED_FIRST_NAME, fnEditText.getText().toString() );
        savedInstanceState.putString( SAVED_LAST_NAME, lnEditText.getText().toString() );
        savedInstanceState.putString( SAVED_EMAIL, fnEditText.getText().toString() );
        savedInstanceState.putString( SAVED_PHONE, pEditText.getText().toString() );

    }
}
