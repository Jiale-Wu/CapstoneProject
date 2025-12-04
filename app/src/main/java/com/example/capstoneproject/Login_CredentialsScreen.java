package com.example.capstoneproject;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.capstoneproject.databinding.FragmentLoginCredentialsScreenBinding;
import com.example.capstoneproject.databinding.FragmentLoginScreenBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_CredentialsScreen extends Fragment {

    FragmentLoginCredentialsScreenBinding binding;

    public Login_CredentialsScreen() {
        // Required empty public constructor
    }

    public static Login_CredentialsScreen newInstance(String param1, String param2) {
        Login_CredentialsScreen fragment = new Login_CredentialsScreen();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginCredentialsScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = binding.usernameText.getText().toString();
                String password = binding.passwordText2.getText().toString();
                if(password.isEmpty() || userName.isEmpty()){
                    Toast.makeText(getActivity(), "Please fill in credentials", Toast.LENGTH_SHORT).show();
                }else{
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                mListener.SignInNext();
                            } else {
                                Toast.makeText(getActivity(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
        binding.forgotcredentials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.forgotCredentials();
            }
        });
        binding.backbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.back();
            }
        });
    }

    LoginCredentialsListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (LoginCredentialsListener) context;
    }



    interface LoginCredentialsListener {
        void SignInNext();
        void forgotCredentials();
        void back();
    }
}