package com.example.capstoneproject;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.capstoneproject.databinding.FragmentChatBinding;
import com.example.capstoneproject.databinding.FragmentEventsPageBinding;

public class ChatFragment extends Fragment {

    FragmentChatBinding binding;

    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(inflater, container, false);
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

        binding.buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = binding.editTextText2.getText().toString().trim();
                if (!msg.isEmpty()) {
                    addMessage(msg);
                    binding.editTextText2.setText("");
                }
            }
        });
    }
    ChatListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (ChatListener) context;
    }

    interface ChatListener {
        void toShareLink();
        void toHome();
    }

    private void addMessage(String text) {


        LinearLayout parentLayout = new LinearLayout(getContext());
        parentLayout.setOrientation(LinearLayout.HORIZONTAL);
        parentLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        parentLayout.setGravity(Gravity.END);


        TextView messageView = new TextView(getContext());
        messageView.setText(text);
        messageView.setTextSize(16);
        messageView.setPadding(24, 16, 24, 16);
        messageView.setBackground(requireContext().getDrawable(R.drawable.your_message));



        LinearLayout.LayoutParams msgParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        msgParams.setMargins(0, 12, 0, 12);
        messageView.setLayoutParams(msgParams);


        parentLayout.addView(messageView);


        binding.messageContainer.addView(parentLayout);


        binding.messageScroll.post(() ->
                binding.messageScroll.fullScroll(View.FOCUS_DOWN)
        );
    }

}