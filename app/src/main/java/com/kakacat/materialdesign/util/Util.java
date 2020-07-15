package com.kakacat.materialdesign.util;

import android.content.Context;
import android.content.Intent;

import com.kakacat.materialdesign.activity.ShowCodeActivity;
import com.kakacat.materialdesign.activity.bottomappbar.BasicActivity;
import com.kakacat.materialdesign.activity.bottomappbar.WithFabActivity;
import com.kakacat.materialdesign.activity.bottomnavigation.IconActivity;
import com.kakacat.materialdesign.activity.bottomnavigation.ShiftActivity;

public class Util {

    public static void startActivity(Context context, int groupPosition, int childPosition) {
        Intent intent = new Intent();
        Context packageContext = context.getApplicationContext();

        switch (groupPosition){
            case 0:{
                if (childPosition == 0) {
                    intent.setClass(packageContext, BasicActivity.class);
                } else if (childPosition == 1) {
                    intent.setClass(packageContext, WithFabActivity.class);
                }
                break;
            }
            case 1:{
                if(childPosition == 0){
                    intent.setClass(packageContext, com.kakacat.materialdesign.activity.bottomnavigation.BasicActivity.class);
                }else if(childPosition == 1){
                    intent.setClass(packageContext, ShiftActivity.class);
                }else if(childPosition == 2){
                    intent.setClass(packageContext, IconActivity.class);
                }
                break;
            }
        }

        context.startActivity(intent);
    }

    public static void showCode(Context context,int[] fileIds,String[] fileNames){
        Intent intent = new Intent();
        intent.setClass(context.getApplicationContext(), ShowCodeActivity.class);
        intent.putExtra("fileIds", fileIds);
        intent.putExtra("fileNames", fileNames);
        context.startActivity(intent);
    }
}
