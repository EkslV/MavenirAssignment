package com.test.mavenirassignment;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.test.mavenirassignment.models.BaseArt;
import com.test.mavenirassignment.models.Book;
import com.test.mavenirassignment.models.Data;
import com.test.mavenirassignment.models.Movie;
import com.test.mavenirassignment.models.TheatreShow;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.lang.reflect.Type;
import java.util.List;

public class ListRepository implements IListContract.Repository {

    @Override
    public List<BaseArt> loadData(Context context) {

        InputStream raw = context.getResources().openRawResource(R.raw.exc_data);
        Reader reader = new BufferedReader(new InputStreamReader(raw));

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(BaseArt.class, new CheckInterfaceDeserializer());
        Gson gson = builder.create();
        Data dataObject = gson.fromJson(reader, Data.class);

        return dataObject.getArtList();
    }

    public static class CheckInterfaceDeserializer implements JsonDeserializer<BaseArt> {

        @Override
        public BaseArt deserialize(JsonElement json, Type typeOfT,
                                   JsonDeserializationContext context) throws JsonParseException {
            JsonObject jObject = (JsonObject) json;
            JsonElement typeObj = jObject.get("type");

            if(typeObj!= null ) {
                String typeVal = typeObj.getAsString();

                switch (typeVal){
                    case "book":
                        return context.deserialize(json, Book.class);
                    case "movie":
                        return context.deserialize(json, Movie.class);
                    case "Theatre show":
                        return context.deserialize(json, TheatreShow.class);
                }
            }
            return null;
        }
    }

}
