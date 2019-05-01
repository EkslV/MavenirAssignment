package com.test.mavenirassignment;

public class ListPresenter implements IListContract.Presenter {

    private IListContract.View mView;
    private IListContract.Repository mRepository;

    public ListPresenter(IListContract.View mView) {
        this.mView = mView;
        mRepository = new ListRepository();
    }

    @Override
    public void onUiReady() {
        mView.showData(mRepository.loadData(mView.getContext()));
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
