package com.kakacat.materialdesign.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.kakacat.materialdesign.R;

import java.util.ArrayList;
import java.util.List;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<String> stringList;

    public TitleAdapter(){
        stringList = new ArrayList<>();
        fillList();
    }

    private void fillList(){
        for(int i = 0; i < 50; i++){
            stringList.add(String.valueOf(i));
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(inflater == null){
            inflater = LayoutInflater.from(parent.getContext());
        }
        View view = inflater.inflate(R.layout.layout_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.btn.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private MaterialButton btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.btn = itemView.findViewById(R.id.btn);
        }
    }
}
