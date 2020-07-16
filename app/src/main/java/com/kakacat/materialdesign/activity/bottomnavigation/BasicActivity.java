package com.kakacat.materialdesign.activity.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kakacat.materialdesign.R;
import com.kakacat.materialdesign.fragment.MyFragment;
import com.kakacat.materialdesign.util.Util;

import java.util.ArrayList;
import java.util.List;

public class BasicActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int[] fileIds = {R.raw.bottom_nav_basic_activity, R.raw.activity_bottom_navigation_basic, R.raw.recycleview_anim, R.raw.item_anim_from_bottom, R.raw.my_fragment, R.raw.fragment_layout};
    private static final String[] fileNames = {"activity", "xml", "recycle_anim", "item_anim", "fragment", "fragment_layout"};

    private List<MyFragment> myFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_basic);

        initView();
    }

    private void initView() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        myFragmentList = new ArrayList<>();
        loadFragment(0);

        BottomNavigationView btmNav = findViewById(R.id.btm_nav);
        btmNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu: {
                    btmNav.setBackgroundColor(getColor(android.R.color.holo_green_light));
                    loadFragment(0);
                    break;
                }
                case R.id.search: {
                    btmNav.setBackgroundColor(getColor(android.R.color.holo_red_dark));
                    loadFragment(1);
                    break;
                }
                case R.id.rotation_3d: {
                    btmNav.setBackgroundColor(getColor(android.R.color.holo_blue_bright));
                    loadFragment(2);
                    break;
                }
                case R.id.more: {
                    btmNav.setBackgroundColor(getColor(android.R.color.holo_purple));
                    loadFragment(3);
                    break;
                }
            }

            return true;
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_show_code) {
            Util.showCode(this, fileIds, fileNames);
        }
    }

    private void loadFragment(int index) {
        if (index > myFragmentList.size() - 1) {
            myFragmentList.add(new MyFragment(index));
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragmentList.get(index)).commit();
    }
}