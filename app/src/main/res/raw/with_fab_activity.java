package com.kakacat.materialdesign.activity.bottomappbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kakacat.materialdesign.R;

public class WithFabActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int[] fileIds = {};
    private static final String[] fileNames = {"activity","xml","menu","toolbar"};

    private BottomAppBar bottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_fab);

        initView();
    }

    private void initView(){
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        }

        bottomAppBar = findViewById(R.id.bottom_appbar);
        ToggleButton togBtn = findViewById(R.id.btn_hide_fab);
        FloatingActionButton fab = findViewById(R.id.fab);
        togBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                fab.show();
            }else{
                fab.hide();
            }
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
        switch (v.getId()){
            case R.id.btn_end:{
                bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
                break;
            }
            case R.id.btn_center:{
                bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                break;
            }
            case R.id.fab:{
                Toast.makeText(this,"fab is clicked",Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}