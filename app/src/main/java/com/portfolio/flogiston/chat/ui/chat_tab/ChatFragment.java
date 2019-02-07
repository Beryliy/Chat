package com.portfolio.flogiston.chat.ui.chat_tab;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.portfolio.flogiston.chat.R;

import butterknife.BindView;

public class ChatFragment extends Fragment {
    @BindView(R.id.messages_list) RecyclerView messagesList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment_layout, container, false);
        messagesList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        messagesList.setLayoutManager(layoutManager);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
