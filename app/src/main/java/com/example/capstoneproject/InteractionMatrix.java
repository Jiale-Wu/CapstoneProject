package com.example.capstoneproject;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.capstoneproject.databinding.FragmentInteractionMatrixBinding;
import com.example.capstoneproject.databinding.FragmentNotificationsPageBinding;

public class InteractionMatrix extends Fragment {


    public InteractionMatrix() {
        // Required empty public constructor
    }

    FragmentInteractionMatrixBinding binding;

    public static InteractionMatrix newInstance(String param1, String param2) {
        InteractionMatrix fragment = new InteractionMatrix();
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
        binding = FragmentInteractionMatrixBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toHome();
            }
        });

        binding.chatSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toShareLink();
            }
        });
    }

    InteractionMatrixListener mListener;

    public interface InteractionMatrixListener {
        void toShareLink();
        void toHome();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (InteractionMatrixListener) context;
    }
}