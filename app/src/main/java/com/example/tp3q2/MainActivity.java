package com.example.tp3q2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intFragment(savedInstanceState);

    }
    private void intFragment(Bundle savedInstanceState){
        fragmentManager = getSupportFragmentManager();
        if(findViewById(R.id.FragmentLayout) != null) {
            if(savedInstanceState != null) {
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            LoginFragment loginFragment = new LoginFragment();
            fragmentTransaction.add(R.id.FragmentLayout, loginFragment, null);
            fragmentTransaction.commit();
        }
    }

}