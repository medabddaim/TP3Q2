package com.example.tp3q2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BienvenueFragment extends Fragment {

    private TextView txtBienvenue;
    private String name;
    private String mot;

    public BienvenueFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bienvenue, container, false);
        txtBienvenue = view.findViewById(R.id.txtBienvenue);
        Bundle bundle= getArguments();
        if(bundle !=null){
             name=bundle.getString("name");
            mot=bundle.getString("password");
             txtBienvenue.setText("Bienvenue \nvotre email valid: "+name+"\nmot de passe valide: "+mot);
        }
        return view;
    }


}