package com.kakacat.materialdesign.model;

import com.kakacat.materialdesign.adapter.ChildAdapter;

import java.util.List;

public class Group {
    private char head;
    private String title;
    private List<Child> childList;
    private ChildAdapter childAdapter;

    public Group(String title, List<Child> childList, ChildAdapter adapter) {
        this.title = title;
        this.head = title.charAt(0);
        this.childList = childList;
        this.childAdapter = adapter;
    }

    public char getHead() {
        return head;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public ChildAdapter getChildAdapter() {
        return childAdapter;
    }

    public void setChildAdapter(ChildAdapter childAdapter) {
        this.childAdapter = childAdapter;
    }

}
