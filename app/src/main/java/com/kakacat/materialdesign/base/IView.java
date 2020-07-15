package com.kakacat.materialdesign.base;

import android.content.Context;

public interface IView {
    void setPresenter(IPresenter presenter);

    void initView();

    Context getContext();
}
