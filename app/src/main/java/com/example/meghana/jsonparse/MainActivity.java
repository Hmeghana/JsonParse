package com.example.meghana.jsonparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
List<MLAItem> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.list_of_mlas);

        try {
            InputStream inputStream=getApplicationContext().getAssets().open("listOfMLA.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, "UTF-8");
            list=new ArrayList<>();
            try {
                JSONObject jsonObject = new JSONObject(json);
               JSONArray jsonArray= jsonObject.getJSONArray("listofMLAS");
               Log.d("Test",jsonArray.length()+"");
               for (int i=0;i<jsonArray.length();i++){
                   JSONObject mlaDetails= jsonArray.getJSONObject(i);
                   Log.d("Test",mlaDetails.toString());
                   MLAItem mlaItem =new MLAItem();
                   mlaItem.setName(mlaDetails.getString("MLA"));
                   mlaItem.setConstituencyName(mlaDetails.getString("constiuency"));
                   mlaItem.setParty(mlaDetails.getString("party"));
                   list.add(mlaItem);
               }
                MLAAdapetr adapeter=new MLAAdapetr(this,list);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adapeter);
                adapeter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
