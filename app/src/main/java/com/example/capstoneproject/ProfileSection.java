package com.example.capstoneproject;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.capstoneproject.databinding.FragmentEventsPageBinding;
import com.example.capstoneproject.databinding.FragmentProfileSectionBinding;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileSection#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileSection extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    FragmentProfileSectionBinding binding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileSection() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileSection.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileSection newInstance(String param1, String param2) {
        ProfileSection fragment = new ProfileSection();
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
        binding = FragmentProfileSectionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.homeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toHome();
            }
        });
        binding.notificationsButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toNotifications();
            }
        });
        binding.eventsButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toEvents();
            }
        });
        binding.chatButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toChat();
            }
        });
        binding.profileButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toProfile();
            }
        });
        binding.backButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toHome();
            }
        });
        binding.settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toSettings();
            }
        });
        binding.changePfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toChangePFP();
            }
        });
        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                mListener.toSignin();
            }
        });
    }

    ProfileSectionListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (ProfileSectionListener) context;
    }

    interface ProfileSectionListener {
        void toNotifications();
        void toEvents();
        void toChat();
        void toProfile();
        void toHome();
        void toSettings();
        void toChangePFP();
        void toSignin();
    }
}