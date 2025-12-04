package com.example.capstoneproject;

import static android.view.View.VISIBLE;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.capstoneproject.databinding.FragmentChatBinding;
import com.example.capstoneproject.databinding.FragmentShareLinkBinding;

public class ShareLink extends Fragment {



    public ShareLink() {
        // Required empty public constructor
    }

    public static ShareLink newInstance(String param1, String param2) {
        ShareLink fragment = new ShareLink();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    FragmentShareLinkBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentShareLinkBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.CopyLinkImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.copyConfirmation.setVisibility(VISIBLE);
            }
        });
        binding.homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toHome();
            }
        });
        binding.notificationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toNotifications();
            }
        });
        binding.eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toEvents();
            }
        });
        binding.ChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toChat();
            }
        });
        binding.profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toProfile();
            }
        });
    }

    ShareLinkListener mListener;

    public interface ShareLinkListener {
        void toHome();
        void toNotifications();
        void toEvents();
        void toChat();
        void toProfile();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (ShareLinkListener) context;
    }
}