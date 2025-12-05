package com.example.capstoneproject;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.capstoneproject.databinding.FragmentChooseImageBinding;
import com.example.capstoneproject.databinding.FragmentPermissionsScreenBinding;


public class PermissionsFragment extends Fragment {

    public PermissionsFragment() {
        // Required empty public constructor
    }

    FragmentPermissionsScreenBinding binding;

    public static PermissionsFragment newInstance(String param1, String param2) {
        PermissionsFragment fragment = new PermissionsFragment();
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
        binding = FragmentPermissionsScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnAllowPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toHome();
            }
        });
        binding.btnAllowContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toHome();
            }
        });
        binding.btnDenyContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toHome();
            }
        });
        binding.btnDenyPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toHome();
            }
        });
    }

    PermissionsListener mListener;

    public interface PermissionsListener {
        void toHome();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (PermissionsListener) context;
    }
}