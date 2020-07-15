package com.kakacat.materialdesign.presenter;

import android.content.Context;

import com.kakacat.materialdesign.R;
import com.kakacat.materialdesign.adapter.ChildAdapter;
import com.kakacat.materialdesign.base.IView;
import com.kakacat.materialdesign.contract.MainContract;
import com.kakacat.materialdesign.model.Child;
import com.kakacat.materialdesign.model.Group;
import com.kakacat.materialdesign.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements MainContract.MainPresenter {

    private MainContract.MainView mView;
    private Context context;
    private List<Group> groupList;

    public MainPresenter(MainContract.MainView view) {
        this.mView = view;
        context = view.getContext();
        initGroupList();
    }

    @Override
    public List<Group> getGroupList() {
        return groupList;
    }

    @Override
    public void initGroupList() {
        groupList = new ArrayList<>();
        String[] titles = context.getResources().getStringArray(R.array.group_item_titles);
        String[] childTitles = context.getResources().getStringArray(R.array.group_item_child_titles);

        for (int i = 0; i < titles.length; i++) {
            List<Child> childList = new ArrayList<>();
            for (String childTitle : childTitles[i].split(",")) {
                childList.add(new Child(childTitle));
            }
            ChildAdapter adapter = new ChildAdapter(childList);
            Group group = new Group(titles[i], childList, adapter);
            groupList.add(group);
        }
        setChildClickListener();
    }

    public void setChildClickListener() {
        for (int i = 0; i < groupList.size(); i++) {
            ChildAdapter childAdapter = groupList.get(i).getChildAdapter();
            int finalI = i;
            childAdapter.setOnClickListener((view, position) -> Util.startActivity(context, finalI, position));
        }
    }


    @Override
    public IView getView() {
        return mView;
    }
}
