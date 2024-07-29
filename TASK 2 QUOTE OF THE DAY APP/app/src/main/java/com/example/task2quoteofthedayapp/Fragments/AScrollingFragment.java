package com.example.task2quoteofthedayapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.task2quoteofthedayapp.R;

public class AScrollingFragment extends Fragment {

   public AScrollingFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        System.out.println("onCreateView");

        return inflater.inflate(R.layout.fragment_a_scrolling, container, false);

    }
}