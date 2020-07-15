package com.kakacat.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.kakacat.materialdesign.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_code);

        initView();
    }

    private void initView() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        }


        Intent intent = getIntent();
        int[] fileIds = intent.getIntArrayExtra("fileIds");
        String[] fileNames = intent.getStringArrayExtra("fileNames");
        ChipGroup mChipGroup = findViewById(R.id.chip_group);
        WebView webView = findViewById(R.id.web_view);

        assert fileIds != null;
        assert fileNames != null;
        for (int i = 0; i < fileNames.length; i++) {
            String fileName = fileNames[i];
            Chip chip = new Chip(this);

            chip.setCheckable(true);
            chip.setText(fileName);
            chip.setChipBackgroundColorResource(android.R.color.transparent);
            int finalI = i;
            chip.setOnClickListener(v -> showContent(fileIds[finalI], webView));

            mChipGroup.addView(chip);
        }

        showContent(fileIds[0], webView);
    }

    private void showContent(int resId, WebView webView) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(resId), "gbk"));
            StringBuilder sb = new StringBuilder();
            String temp;

            while ((temp = br.readLine()) != null) {
                sb.append(temp);
                sb.append('\n');
            }
            webView.loadData(sb.toString(), "text/plain", "gbk");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return true;
    }
}