package com.example.tp3q2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private EditText email, password;
    private Button btnlogin;
    private String regexEmail = "[A-Za-z]{2,}@[A-Za-z]{3,}(\\.com|\\.net|\\.org)";
    private String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=()\\-]).{8,40}$";

    public LoginFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        btnlogin = view.findViewById(R.id.btnlogin);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        btnlogin.setOnClickListener(this);
        return view;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnlogin) {
            if (validation(email.getText().toString().trim(), password.getText().toString().trim()) == 0) {
                addFragment();
            } else if (validation(email.getText().toString().trim(), password.getText().toString().trim()) == 1) {
                email.requestFocus();
                email.setError("Veuillez saisir un email valide !");
            } else if (validation(email.getText().toString().trim(), password.getText().toString().trim()) == 2) {
                password.requestFocus();
                password.setError("Veuillez saisir un mot de passe valide !");
            }
        }
    }


    private void addFragment(){
        Bundle bundle = new Bundle();
        BienvenueFragment bienvenueFragment = new BienvenueFragment();
        bundle.putString("name", email.getText().toString().trim());
        bundle.putString("password", password.getText().toString().trim());
        bienvenueFragment.setArguments(bundle);
        MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentLayout, bienvenueFragment, null).addToBackStack(null).commit();
    }
    private int validation(String login, String word){
        Pattern pattern1 = Pattern.compile(regexEmail);
        Pattern pattern2 = Pattern.compile(regexPassword);
        Matcher matcher1 = pattern1.matcher(login);
        Matcher matcher2 = pattern2.matcher(word);
        if ((matcher1.matches()) && (matcher2.matches()))
        {
            return 0;
        }
       else  if (matcher1.matches()==false){
            return 1;
        }
        else {
            return 2;
        }
    }
}