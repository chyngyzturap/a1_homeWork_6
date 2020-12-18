package com.pharos.a1_homework_6;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EditTextButtonFragment extends Fragment {


    private ActionFragment listener;
    private EditText edText;
    private Button btnPush;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (ActionFragment) context;
    }


    public EditTextButtonFragment() {
        // Required empty public constructor
    }

    public static EditTextButtonFragment newInstance(String param1, String param2) {
        EditTextButtonFragment fragment = new EditTextButtonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_text_button, container, false);

        edText = view.findViewById(R.id.edTxt);
        btnPush = view.findViewById(R.id.pushBtn);


        btnPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.sendMessage(edText.getText().toString());

            }
        });


        return view;
    }
}