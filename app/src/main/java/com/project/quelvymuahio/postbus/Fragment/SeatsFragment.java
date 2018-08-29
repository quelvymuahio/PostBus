package com.project.quelvymuahio.postbus.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.project.quelvymuahio.postbus.R;

import java.util.ArrayList;
import java.util.List;

public class SeatsFragment extends Fragment {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;

    public SeatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seats, container, false);

        btn1 = view.findViewById(R.id.btn_1);
        btn2 = view.findViewById(R.id.btn_2);
        btn3 = view.findViewById(R.id.btn_3);
        btn4 = view.findViewById(R.id.btn_4);
        btn5 = view.findViewById(R.id.btn_5);
        btn6 = view.findViewById(R.id.btn_6);
        btn7 = view.findViewById(R.id.btn_7);
        btn8 = view.findViewById(R.id.btn_8);
        btn9 = view.findViewById(R.id.btn_9);
        btn10 = view.findViewById(R.id.btn_10);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setBackgroundColor(Color.BLACK);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setBackgroundColor(Color.BLACK);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn3.setBackgroundColor(Color.BLACK);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn4.setBackgroundColor(Color.BLACK);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn5.setBackgroundColor(Color.BLACK);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn6.setBackgroundColor(Color.BLACK);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn7.setBackgroundColor(Color.BLACK);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn8.setBackgroundColor(Color.BLACK);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn9.setBackgroundColor(Color.BLACK);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn10.setBackgroundColor(Color.BLACK);
                Log.i("FRAGMENT TAG", "Entrou  no Listener 10");
            }
        });

        return view;
    }

}