package com.kakacat.materialdesign.contract;

import com.kakacat.materialdesign.base.IPresenter;
import com.kakacat.materialdesign.base.IView;
import com.kakacat.materialdesign.model.Group;

import java.util.List;

public interface MainContract {

    interface MainView extends IView {
        void initToolbar();
    }

    interface MainPresenter extends IPresenter {
        List<Group> getGroupList();

        void initGroupList();

    }


}
