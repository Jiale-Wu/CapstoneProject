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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Login_CredentialsScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Login_CredentialsScreen extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    FragmentLoginCredentialsScreenBinding binding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Login_CredentialsScreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Login_CredentialsScreen.
     */
    // TODO: Rename and change types and number of parameters
    public static Login_CredentialsScreen newInstance(String param1, String param2) {
        Login_CredentialsScreen fragment = new Login_CredentialsScreen();
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
        binding = FragmentLoginCredentialsScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.passwordText2.getText().toString().isEmpty() || binding.usernameText.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please fill in credentials", Toast.LENGTH_SHORT).show();
                }else{
                    mListener.SignInNext();
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