package com.kakacat.materialdesign.activity.bottomappbar;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kakacat.materialdesign.R;
import com.kakacat.materialdesign.util.Util;

public class BasicActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String[] fileNames = {"activity", "xml", "menu", "toolbar"};
    private static final int[] fileIds = {R.raw.basic_activity, R.raw.activity_bottom_appbar_basic, R.raw.bottom_nav, R.raw.layout_toolbar};
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_appbar_basic);

        initView();
    }

    private void initView() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        BottomNavigationView btmNav = findViewById(R.id.bottom_nav);
        context = this;

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        btmNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu: {
                    Toast.makeText(context, "点击了menu指示器", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.search: {
                    Toast.makeText(context, "点击了search指示器", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.rotation_3d: {
                    Toast.makeText(context, "点击了3d旋转指示器", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.more: {
                    Toast.makeText(context, "点击了more指示器", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            return true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
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