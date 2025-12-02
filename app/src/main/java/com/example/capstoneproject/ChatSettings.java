package com.example.capstoneproject;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.capstoneproject.databinding.ChatSettingsRecyclerViewBinding;
import com.example.capstoneproject.databinding.FragmentChatSettingsBinding;
import com.example.capstoneproject.databinding.FragmentHomeScreenBinding;

import java.util.ArrayList;

public class ChatSettings extends Fragment {

    public ChatSettings() {
        // Required empty public constructor
    }

    FragmentChatSettingsBinding binding;

    public static ChatSettings newInstance(String param1, String param2) {
        ChatSettings fragment = new ChatSettings();
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
        binding = FragmentChatSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        names.add("Gehari");
        names.add("Justin");
        names.add("Fabi");
        names.add("Caleb");
        names.add("Jiale");
        names.add("Isa");

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ChatAdapter();
        binding.recyclerView.setAdapter(adapter);

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toChat();
            }
        });
    }

    ChatSettingsListener mListener;

    public interface ChatSettingsListener {
        void toChat();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (ChatSettingsListener) context;
    }

    ChatAdapter adapter;
    ArrayList<String> names = new ArrayList<>();

    class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
        @NonNull
        @Override
        public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ChatSettingsRecyclerViewBinding itemBinding = ChatSettingsRecyclerViewBinding.inflate(getLayoutInflater(), parent, false);
            return new ChatViewHolder(itemBinding);
        }

        @Override
        public int getItemCount() {
            return names.size();
        }

        @Override
        public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
            String name = names.get(position);
            holder.setupUI(name);
        }

        class ChatViewHolder extends RecyclerView.ViewHolder {
            ChatSettingsRecyclerViewBinding itemBinding;
            String mName;

            public ChatViewHolder(ChatSettingsRecyclerViewBinding itemBinding) {
                super(itemBinding.getRoot());
                this.itemBinding = itemBinding;
            }

            public void setupUI(String name) {
                mName = name;
                itemBinding.userNameText.setText(name);
            }
        }
    }

}