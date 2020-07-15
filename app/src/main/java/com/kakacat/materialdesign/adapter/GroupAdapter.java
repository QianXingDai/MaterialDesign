package com.kakacat.materialdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kakacat.materialdesign.R;
import com.kakacat.materialdesign.model.Group;

import java.util.List;

public class GroupAdapter extends BaseExpandableListAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<Group> groupList;

    public GroupAdapter(Context context, List<Group> groupList) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.groupList = groupList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupList.get(groupPosition).getChildList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder;
        Group group = groupList.get(groupPosition);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.group, parent, false);
            holder = new GroupViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }

        holder.tvHead.setText(String.valueOf(group.getHead()));
        holder.tvTitle.setText(group.getTitle());
        if (isExpanded) {
            holder.bottomLine.setVisibility(View.VISIBLE);
        } else {
            holder.bottomLine.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder;
        Group group = groupList.get(groupPosition);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.child_layout, parent, false);
            holder = new ChildViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ChildViewHolder) convertView.getTag();
        }

        holder.rv.setLayoutManager(new LinearLayoutManager(context));
        holder.rv.setAdapter(group.getChildAdapter());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    static class GroupViewHolder {
        private TextView tvHead;
        private TextView tvTitle;
        private View bottomLine;

        public GroupViewHolder(View contentView) {
            tvHead = contentView.findViewById(R.id.tv_head);
            tvTitle = contentView.findViewById(R.id.btn);
            bottomLine = contentView.findViewById(R.id.bottom_line);
        }
    }

    static class ChildViewHolder {
        private RecyclerView rv;

        public ChildViewHolder(View contentView) {
            rv = contentView.findViewById(R.id.rv);
        }
    }

}
