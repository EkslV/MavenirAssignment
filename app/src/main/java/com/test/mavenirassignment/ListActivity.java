package com.test.mavenirassignment;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.mavenirassignment.R;
import com.test.mavenirassignment.adapters.ArtAdapter;
import com.test.mavenirassignment.models.BaseArt;

import java.util.List;

public class ListActivity extends AppCompatActivity implements IListContract.View {

    private IListContract.Presenter mPresenter;
    private ArtAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.artList);
        adapter = new ArtAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPresenter = new ListPresenter(this);
        mPresenter.onUiReady();
    }

    @Override
    public void showData(List<BaseArt> artItems) {
        adapter.setData(artItems);
    }

    @Override
    public void updateCurrentItem(BaseArt baseArt) {
        // todo implement functionality.
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
