package com.pharos.a1_homework_6;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ButtonFragment extends Fragment {


    private Button closeBtn, openBtn;
    private ActionFragment listener;
    TextView txtView;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (ActionFragment) context;
    }

    public ButtonFragment() {
        // Required empty public constructor
    }

    public static ButtonFragment newInstance(String param1, String param2) {
        ButtonFragment fragment = new ButtonFragment();
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
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        closeBtn = view.findViewById(R.id.hideButton);
        openBtn = view.findViewById(R.id.showButton);

        if (mParam1 != null) {
            txtView.setText(mParam1);
        }
        //////////////////////hideButton//////////////////////////
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFirstFragment();

            }
        });
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
        //////////////////////showButton//////////////////////////////
        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSecondFragment();
            }
        });
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//

        return view;
    }
}   