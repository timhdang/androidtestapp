package com.timhdang.test2.ui.notification;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.timhdang.test2.R;

public class NotificationFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Dialog dialog = new Dialog(getContext());
        //setting custom layout to dialog
        dialog.setContentView(R.layout.custom_dialog_layout);
        dialog.setTitle("Custom Dialog");

        //adding text dynamically
        TextView txt = (TextView) dialog.findViewById(R.id.notification_content);
        txt.setText("Put your dialog text here.");


        //adding button click event
        Button dismissButton = (Button) dialog.findViewById(R.id.ok_button);
        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }
}
