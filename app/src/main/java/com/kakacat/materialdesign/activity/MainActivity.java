package com.kakacat.materialdesign.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.kakacat.materialdesign.R;
import com.kakacat.materialdesign.adapter.GroupAdapter;
import com.kakacat.materialdesign.base.IPresenter;
import com.kakacat.materialdesign.contract.MainContract;
import com.kakacat.materialdesign.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavView;
    private MainContract.MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    @Override
    protected void onDestroy() {
        mPresenter = null;
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
                mDrawerLayout.closeDrawer(GravityCompat.START);
            else
                mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return true;
    }

    @Override
    public void initView() {
        initToolbar();
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavView = findViewById(R.id.nav_view);
        ExpandableListView mExpandableListView = findViewById(R.id.expand_lv);

        setPresenter(new MainPresenter(this));
        GroupAdapter groupAdapter = new GroupAdapter(this, mPresenter.getGroupList());
        mExpandableListView.setAdapter(groupAdapter);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initToolbar() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_slide);
        }
    }

    @Override
    public void setPresenter(IPresenter presenter) {
        mPresenter = (MainContract.MainPresenter) presenter;
    }
}