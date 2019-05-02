package com.test.mavenirassignment;

import com.test.mavenirassignment.models.BaseArt;

import java.util.ArrayList;
import java.util.List;

public class ListPresenter implements IListContract.Presenter {

    private IListContract.View mView;
    private IListContract.Repository mRepository;

    public ListPresenter(IListContract.View mView) {
        this.mView = mView;
        mRepository = new ListRepository();
    }

    @Override
    public void onUiReady() {
        List<BaseArt> list = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            list.add(new BaseArt("title" + i, "author" + i, "book" ));
        }
        list.addAll(mRepository.loadData(mView.getContext()));
        mView.showData(list);
    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onItemLongClicked(int position) {

    }

    @Override
    public void onAddItemClicked() {

    }

    @Override
    public void onDestroy() {
        // Clear here resources.
    }
}
