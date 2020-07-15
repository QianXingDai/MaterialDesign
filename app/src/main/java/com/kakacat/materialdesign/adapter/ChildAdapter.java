package com.kakacat.materialdesign.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kakacat.materialdesign.R;
import com.kakacat.materialdesign.model.Child;
import com.kakacat.materialdesign.util.RecycleViewItemOnClickListener;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Child> stringList;
    private RecycleViewItemOnClickListener clickListener;

    public ChildAdapter(List<Child> stringList) {
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }

        View view = inflater.inflate(R.layout.child_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tv.setText(stringList.get(position).getTitle());
        if (clickListener != null) {
            holder.itemView.setOnClickListener(v -> clickListener.onClick(holder.itemView, position));
        }
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public void setOnClickListener(RecycleViewItemOnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
