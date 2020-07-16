package com.kakacat.materialdesign.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.kakacat.materialdesign.R;
import com.kakacat.materialdesign.adapter.TitleAdapter;

public class MyFragment extends Fragment {

    private int flag;

    public MyFragment(int flag){
        this.flag = flag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout,container,false);
        RecyclerView rv = view.findViewById(R.id.rv);

        if(flag == 0 || flag == 3){
            rv.setLayoutManager(new LinearLayoutManager(getContext()));
        }else if(flag == 1){
            rv.setLayoutManager(new GridLayoutManager(getContext(),4));
        }else if(flag == 2){
            rv.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        }
        rv.setAdapter(new TitleAdapter());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);
    }
}
