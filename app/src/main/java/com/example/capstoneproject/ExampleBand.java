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
import com.example.capstoneproject.databinding.FragmentExampleBandBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExampleBand#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExampleBand extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    FragmentExampleBandBinding binding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExampleBand() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExampleBand.
     */
    // TODO: Rename and change types and number of parameters
    public static ExampleBand newInstance(String param1, String param2) {
        ExampleBand fragment = new ExampleBand();
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
        binding = FragmentExampleBandBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.homeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toHome();
            }
        });
        binding.notificationsButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toNotifications();
            }
        });
        binding.eventsButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toEvents();
            }
        });
        binding.chatButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toChat();
            }
        });
        binding.profileButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toProfile();
            }
        });
        binding.joinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toHome();
            }
        });
    }

    ExampleBandListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (ExampleBandListener) context;
    }

    interface ExampleBandListener {
        void toNotifications();
        void toEvents();
        void toChat();
        void toProfile();
        void toHome();
        void toExampleBand();
    }
}