package com.example.gk.testjson;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.gk.testjson.model.CityListData;
import com.example.gk.testjson.model.Destination;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import noman.googleplaces.NRPlaces;
import noman.googleplaces.Place;
import noman.googleplaces.PlaceType;
import noman.googleplaces.PlacesException;
import noman.googleplaces.PlacesListener;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements PlacesListener {
    int responseCount = 0;
    ArrayList<CityListData> cityListDatas;
    HashMap<String, Destination> destinationHashMap = new HashMap<>();

    HashMap<String, Place> placeHashMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityListDatas = loadJSONFromAsset();

           // loadData(cityListDatas.get(0).getPlaceCode());
        getNearbyPlaces(cityListDatas.get(0).getLat(),cityListDatas.get(0).getLng());
    }

    public void loadData(String placeID) {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://app.abc.com/rest/content/")
                .build();

        //Creating an object of our api interface
        JSONAPI api = adapter.create(JSONAPI.class);
        api.getBooks(placeID, new Callback<Destination>() {
            @Override
            public void success(Destination destination, Response response) {
                //Dismissing the loading progressbar
                responseCount++;
                if(responseCount<cityListDatas.size()){
                    loadData(cityListDatas.get(responseCount).getPlaceCode());
                }

                String placeCode = destination.getCityListData().getPlaceCode();
                Log.e("placecode",placeCode);
                destination.setPlaceCode(placeCode);
                destinationHashMap.put(placeCode, destination);
                if (responseCount == cityListDatas.size()) {
                    List<Destination> values = new ArrayList<Destination>(destinationHashMap.values());
                    Gson gson=new Gson();
                    String data=gson.toJson(values);
                    generateNoteOnSD(MainActivity.this,"attraction.json",data);
                }

            }

            @Override
            public void failure(RetrofitError error) {
                //you can handle the errors here
                Log.e("error",error.toString());
            }
        });
    }


    public void generateNoteOnSD(Context context, String sFileName, String sBody) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<CityListData> loadJSONFromAsset() {
        ArrayList<CityListData> cityListData = new ArrayList<>();
        String json = null;
        try {
            InputStream is = getAssets().open("All_destinations.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Type type = new TypeToken<ArrayList<CityListData>>() {
        }.getType();
        Gson gson = new Gson();
        cityListData = gson.fromJson(json, type);
        return cityListData;
    }

    public void getNearbyPlaces(double lat,double lng) {
        new NRPlaces.Builder()
                .listener(this)
                .key("AIzaSyA2Qz6K0nwKqk4nIz8Q3F01Vb_x7JYNsUc")
                .latlng(lat,lng)
                .radius(50000)
                .type(PlaceType.HINDU_TEMPLE)
                .build()
                .execute();
    }

    @Override
    public void onPlacesFailure(PlacesException e) {

    }

    @Override
    public void onPlacesStart() {

    }

    @Override
    public void onPlacesSuccess(List<Place> places) {

        responseCount++;
        if(responseCount<cityListDatas.size()){
            getNearbyPlaces(cityListDatas.get(responseCount).getLat(),cityListDatas.get(responseCount).getLng());
        }


        for(int i=0;i<places.size();i++){
            placeHashMap.put(places.get(i).getPlaceId(),places.get(i));
        }


        if (responseCount == cityListDatas.size()) {
            List<Place> values = new ArrayList<Place>(placeHashMap.values());
            Gson gson=new Gson();
            String data=gson.toJson(values);
            generateNoteOnSD(MainActivity.this,"attraction.json",data);
        }
    }

    @Override
    public void onPlacesFinished() {

    }
}
