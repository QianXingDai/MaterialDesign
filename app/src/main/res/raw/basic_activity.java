package com.kakacat.materialdesign.activity.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.kakacat.materialdesign.R;
import com.kakacat.materialdesign.adapter.TitleAdapter;
import com.kakacat.materialdesign.util.Util;

public class BasicActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int[] fileIds = {R.raw.bottom_nav_basic_activity, R.raw.activity_bottom_navigation_basic,R.raw};
    private static final String[] fileNames = {"activity", "xml"};

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
        if(actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView rv = findViewById(R.id.rv);
        rv.setAdapter(new TitleAdapter());
        rv.setLayoutManager(new LinearLayoutManager(this));
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
        if(v.getId() == R.id.btn_show_code){
            Util.showCode(this,fileIds,fileNames);
        }
    }
}