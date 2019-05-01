package com.test.mavenirassignment;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.mavenirassignment.models.BaseArt;
import com.test.mavenirassignment.models.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ListRepository implements IListContract.Repository {

    private Gson gson = new Gson();

    @Override
    public List<BaseArt> loadData(Context context) {

        InputStream raw =  context.getResources().openRawResource(R.raw.exc_data);
        Reader reader = new BufferedReader(new InputStreamReader(raw));

        Data dataObject = gson.fromJson(reader, Data.class);

        return dataObject.getArtList();
    }

}
