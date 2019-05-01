package com.test.mavenirassignment;

import android.content.Context;

import com.test.mavenirassignment.models.BaseArt;

import java.util.List;

public interface IListContract {
    interface View {
        void showData(List<BaseArt> artItems);
        void updateCurrentItem(BaseArt baseArt);
        Context getContext();
    }

    interface Presenter {
        void onUiReady();
        void onItemClicked(int position);
        void onItemLongClicked(int position);
        void onAddItemClicked();
        void onDestroy();
    }

    interface Repository {
        List<BaseArt> loadData(Context context);
    }
}
