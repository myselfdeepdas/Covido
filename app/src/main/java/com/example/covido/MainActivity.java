package com.example.covido;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //     <----  Declaring all the variables here !!! ---->

    ListView datalistview;
    List<Model> datamodellist = new ArrayList<>();
    Model modelClass;
    CovidAdapter covidAdapter;
    Button btncheck;
    ArrayAdapter<String> adapter;
    AutoCompleteTextView autoCompleteTextView;

    //     <---- mentioning all the STATE name here !!! ---->
    String[] stateName=
            {"Andaman and Nicobar Islands","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh",
                    "Chhattisgarh","Delhi","Dadra and Nagar Haveli and Daman and Diu","Goa","Gujarat",
                    "Himachal Pradesh","Haryana","Jharkhand","Jammu and Kashmir","Karnataka","Kerala",
                    "Ladakh","Lakshadweep","Maharashtra","Meghalaya","Manipur","Madhya Pradesh","Mizoram",
                    "Nagaland","Odisha","Punjab","Puducherry","Rajasthan","Sikkim","Telangana","Tamil Nadu",
                    "Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};


    //     <---- the API LINK is here, from where we will be fetching data  !!! ---->

    private static final String dataUrl = "https://data.covid19india.org/state_district_wise.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datalistview = findViewById(R.id.dataListview);
        btncheck = findViewById(R.id.btncheck);

        autoCompleteTextView = findViewById(R.id.autotextview);
        adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,stateName);
        autoCompleteTextView.setAdapter(adapter);
        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datamodellist.clear();
                showList();
            }
        });

    }

    public void showList(){
//     <---- Declaring STATE name & CITY OF---  !!! ---->
        //<---- Andaman and Nicobar Islands ---->
        if (autoCompleteTextView.getText().toString().trim().equals(stateName[0])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Andaman and Nicobar Islands");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Nicobars");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nicobars",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("North and Middle Andaman");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("North and Middle Andaman", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("South Andaman");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("South Andaman", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Unknown");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Unknown", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }
//     <---- Declaring STATE name & CITY OF---  !!! ---->

        // <---- Andhra Pradesh ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[1])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Andhra Pradesh");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Foreign Evacuees");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Foreign Evacuees",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Anantapur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Anantapur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Chittoor");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chittoor", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("East Godavari");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("East Godavari", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Guntur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Guntur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Krishna");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Krishna", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kurnool");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kurnool", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Other State");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other State", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Prakasam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Prakasam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("S.P.S. Nellore");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("S.P.S. Nellore", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Srikakulam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Srikakulam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Visakhapatnam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Visakhapatnam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Vizianagaram");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Vizianagaram", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("West Godavari");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("West Godavari", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Y.S.R. Kadapa");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Y.S.R. Kadapa", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }


        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Arunachal Pradesh ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[2])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Arunachal Pradesh");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Anjaw");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Anjaw",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Changlang");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Changlang", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("East Kameng");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("East Kameng", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("East Siang");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("East Siang", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kamle");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kamle", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kra Daadi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kra Daadi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kurung Kumey");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kurung Kumey", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Lepa Rada");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lepa Rada", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Lohit");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lohit", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Longding");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Longding", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Lower Dibang Valley");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lower Dibang Valley", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Lower Siang");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lower Siang", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Lower Subansiri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lower Subansiri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Namsai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Namsai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Pakke Kessang");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pakke Kessang", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Papum Pare");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Papum Pare", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Shi Yomi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Shi Yomi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Siang");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Siang", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tawang");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tawang", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tirap");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tirap", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Upper Dibang Valley");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Upper Dibang Valley", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Upper Siang");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Upper Siang", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Upper Subansiri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Upper Subansiri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("West Kameng");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("West Kameng", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("West Siang");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("West Siang", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Assam ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[3])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Assam");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Airport Quarantine");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Airport Quarantine",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Baksa");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Baksa", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Barpeta");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Barpeta", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Biswanath");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Biswanath", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bongaigaon");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bongaigaon", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Cachar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Cachar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Charaideo");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Charaideo", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Chirang");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chirang", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Darrang");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Darrang", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dhemaji");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dhemaji", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dhubri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dhubri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dibrugarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dibrugarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dima Hasao");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dima Hasao", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Goalpara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Goalpara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Golaghat");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Golaghat", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hailakandi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hailakandi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hojai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hojai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jorhat");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jorhat", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kamrup");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kamrup", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kamrup Metropolitan");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kamrup Metropolitan", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Karbi Anglong");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Karbi Anglong", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Karimganj");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Karimganj", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kokrajhar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kokrajhar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Lakhimpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lakhimpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Majuli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Majuli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Morigaon");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Morigaon", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nagaon");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nagaon", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nalbari");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nalbari", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nalbari");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nalbari", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Other State");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other State", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sivasagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sivasagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sonitpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sonitpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("South Salmara Mankachar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("South Salmara Mankachar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tinsukia");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tinsukia", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Udalguri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Udalguri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("West Karbi Anglong");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("West Karbi Anglong", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Unknown");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Unknown", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Bihar ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[4])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Bihar");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Araria");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Araria",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Arwal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Arwal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Aurangabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Aurangabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Banka");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Banka", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Begusarai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Begusarai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bhagalpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bhagalpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bhojpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bhojpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Buxar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Buxar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Darbhanga");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Darbhanga", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("East Champaran");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("East Champaran", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Gaya");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gaya", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Gopalganj");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gopalganj", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Jamui");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jamui", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Jehanabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jehanabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kaimur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kaimur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Katihar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Katihar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Khagaria");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Khagaria", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kishanganj");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kishanganj", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Lakhisarai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lakhisarai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Madhepura");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Madhepura", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Madhubani");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Madhubani", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Munger");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Munger", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Muzaffarpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Muzaffarpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nalanda");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nalanda", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nawada");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nawada", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Patna");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Patna", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Purnia");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Purnia", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rohtas");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rohtas", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Saharsa");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Saharsa", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Samastipur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Samastipur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Saran");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Saran", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sheikhpura");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sheikhpura", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sheohar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sheohar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sitamarhi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sitamarhi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Siwan");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Siwan", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Supaul");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Supaul", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Vaishali");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Vaishali", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("West Champaran");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("West Champaran", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Chandigarh ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[5])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Chandigarh");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Chandigarh");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chandigarh",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Chhattisgarh ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[6])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Chhattisgarh");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Other State");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other State",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Balod");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Balod", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Baloda Bazar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Baloda Bazar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Balrampur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Balrampur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bametara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bametara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bastar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bastar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bijapur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bijapur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bilaspur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bilaspur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dakshin Bastar Dantewada");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dakshin Bastar Dantewada", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dhamtari");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dhamtari", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Durg");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Durg", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Gariaband");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gariaband", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Janjgir Champa");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Janjgir Champa", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Jashpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jashpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kabeerdham");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kabeerdham", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kondagaon");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kondagaon", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Korba");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Korba", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Koriya");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Koriya", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mahasamund");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mahasamund", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mungeli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mungeli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Narayanpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Narayanpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Raigarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Raigarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Raipur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Raipur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rajnandgaon");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rajnandgaon", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sukma");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sukma", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Surajpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Surajpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Surguja");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Surguja", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Uttar Bastar Kanker");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Uttar Bastar Kanker", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Gaurela Pendra Marwahi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gaurela Pendra Marwahi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Delhi ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[7])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Delhi");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Central Delhi");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Central Delhi",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("East Delhi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("East Delhi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("New Delhi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("New Delhi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("North Delhi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("North Delhi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("North East Delhi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("North East Delhi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("North West Delhi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("North West Delhi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Shahdara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Shahdara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("South Delhi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("South Delhi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("South East Delhi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("South East Delhi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("South West Delhi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("South West Delhi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("West Delhi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("West Delhi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Unknown");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Unknown", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Dadra and Nagar Haveli and Daman and Diu ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[8])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Dadra and Nagar Haveli and Daman and Diu");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Other State");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other State",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dadra and Nagar Haveli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dadra and Nagar Haveli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Daman");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Daman", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Diu");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Diu", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Goa ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[9])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Goa");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Other State");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other State",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("North Goa");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("North Goa", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("South Goa");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("South Goa", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Unknown");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Unknown", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Gujarat ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[10])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Gujarat");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Other State");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other State",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Ahmedabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ahmedabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Amreli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Amreli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Anand");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Anand", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Aravalli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Aravalli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Banaskantha");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Banaskantha", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Bharuch");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bharuch", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Bhavnagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bhavnagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Botad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Botad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Chhota Udaipur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chhota Udaipur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Dahod");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dahod", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Dang");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dang", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Devbhumi Dwarka");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Devbhumi Dwarka", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Gandhinagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gandhinagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Gir Somnath");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gir Somnath", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jamnagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jamnagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Junagadh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Junagadh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kheda");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kheda", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kutch");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kutch", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mahisagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mahisagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mehsana");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mehsana", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Morbi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Morbi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Narmada");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Narmada", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Navsari");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Navsari", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Panchmahal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Panchmahal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Patan");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Patan", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Porbandar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Porbandar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rajkot");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rajkot", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sabarkantha");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sabarkantha", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Surat");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Surat", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Surendranagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Surendranagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tapi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tapi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Vadodara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Vadodara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Valsad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Valsad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Himachal Pradesh ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[11])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Himachal Pradesh");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Bilaspur");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bilaspur",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Chamba");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chamba", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hamirpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hamirpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kangra");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kangra", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kinnaur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kinnaur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kullu");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kullu", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Lahaul and Spiti");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lahaul and Spiti", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mandi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mandi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Shimla");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Shimla", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sirmaur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sirmaur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Solan");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Solan", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Una");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Una", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Haryana ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[12])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Haryana");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Foreign Evacuees");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Foreign Evacuees",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Ambala");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ambala", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Bhiwani");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bhiwani", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Charkhi Dadri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Charkhi Dadri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Faridabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Faridabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Fatehabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Fatehabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Gurugram");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gurugram", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hisar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hisar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Italians");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Italians", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jhajjar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jhajjar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jind");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jind", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kaithal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kaithal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Karnal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Karnal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kurukshetra");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kurukshetra", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mahendragarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mahendragarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nuh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nuh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Palwal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Palwal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Panchkula");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Panchkula", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Panipat");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Panipat", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rewari");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rewari", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rohtak");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rohtak", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sirsa");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sirsa", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sonipat");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sonipat", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Yamunanagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Yamunanagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);



                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Jharkhand ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[13])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Jharkhand");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Bokaro");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bokaro",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Chatra");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chatra", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Deoghar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Deoghar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dhanbad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dhanbad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Dumka");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dumka", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("East Singhbhum");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("East Singhbhum", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Garhwa");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Garhwa", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Giridih");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Giridih", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Godda");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Godda", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Gumla");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gumla", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hazaribagh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hazaribagh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jamtara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jamtara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Khunti");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Khunti", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Koderma");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Koderma", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Latehar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Latehar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Lohardaga");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lohardaga", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Pakur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pakur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Palamu");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Palamu", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ramgarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ramgarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ranchi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ranchi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sahibganj");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sahibganj", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Saraikela-Kharsawan");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Saraikela-Kharsawan", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Simdega");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Simdega", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("West Singhbhum");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("West Singhbhum", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);



                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Jammu and Kashmir ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[14])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Jammu and Kashmir");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Anantnag");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Anantnag",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bandipora");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bandipora", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Baramulla");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Baramulla", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Budgam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Budgam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Doda");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Doda", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ganderbal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ganderbal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jammu");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jammu", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kathua");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kathua", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kishtwar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kishtwar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kulgam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kulgam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kupwara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kupwara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mirpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mirpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Muzaffarabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Muzaffarabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Pulwama");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pulwama", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Punch");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Punch", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rajouri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rajouri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ramban");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ramban", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Palamu");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Palamu", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Reasi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Reasi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Samba");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Samba", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Shopiyan");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Shopiyan", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Srinagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Srinagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Udhampur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Udhampur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Karnataka ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[15])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Karnataka");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Bagalkote");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bagalkote",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ballari");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ballari", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Belagavi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Belagavi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bengaluru Rural");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bengaluru Rural", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Bengaluru Urban");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bengaluru Urban", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Bidar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bidar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Chamarajanagara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chamarajanagara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Chikkaballapura");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chikkaballapura", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Chikkamagaluru");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chikkamagaluru", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Chitradurga");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chitradurga", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Dakshina Kannada");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dakshina Kannada", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Davanagere");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Davanagere", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Dharwad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dharwad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Gadag");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gadag", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hassan");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hassan", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Haveri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Haveri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kalaburagi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kalaburagi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kodagu");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kodagu", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kolar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kolar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Koppal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Koppal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mandya");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mandya", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mysuru");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mysuru", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Other State");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other State", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Raichur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Raichur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ramanagara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ramanagara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Shivamogga");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Shivamogga", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tumakuru");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tumakuru", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Udupi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Udupi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Uttara Kannada");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Uttara Kannada", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Vijayapura");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Vijayapura", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Yadgir");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Yadgir", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Kerala ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[16])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Kerala");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Other State");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other State",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Alappuzha");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Alappuzha", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ernakulam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ernakulam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Idukki");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Idukki", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kannur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kannur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kasaragod");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kasaragod", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kollam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kollam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kottayam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kottayam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kozhikode");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kozhikode", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Malappuram");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Malappuram", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Palakkad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Palakkad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Pathanamthitta");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pathanamthitta", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Thiruvananthapuram");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Thiruvananthapuram", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Thrissur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Thrissur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Wayanad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Wayanad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Ladakh ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[17])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Ladakh");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Kargil");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kargil",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Leh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Leh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Lakshadweep ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[18])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Lakshadweep");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Lakshadweep");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lakshadweep",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Unknown");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Unknown", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Maharashtra ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[19])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Maharashtra");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Aurangabad");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Aurangabad",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Nashik");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nashik", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Pune");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pune", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Mumbai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mumbai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kolhapur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kolhapur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Nagpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nagpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Ahmednagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ahmednagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Akola");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Akola", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Amravati");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Amravati", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Beed");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Beed", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bhandara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bhandara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Buldhana");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Buldhana", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Chandrapur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chandrapur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dhule");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dhule", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Gadchiroli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gadchiroli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Gondia");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gondia", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Hingoli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hingoli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Jalgaon");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jalgaon", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Jalna");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jalna", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Latur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Latur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Nanded");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nanded", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Nandurbar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nandurbar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Osmanabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Osmanabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Palghar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Palghar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Parbhani");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Parbhani", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Raigad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Raigad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Ratnagiri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ratnagiri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Sangli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sangli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Satara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Satara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Sindhudurg");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sindhudurg", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Solapur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Solapur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Thane");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Thane", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Wardha");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Wardha", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Washim");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Washim", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Yavatmal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Yavatmal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);




                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Meghalaya ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[20])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Meghalaya");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("East Garo Hills");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("East Garo Hills",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("East Jaintia Hills");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("East Jaintia Hills", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("East Khasi Hills");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("East Khasi Hills", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("North Garo Hills");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("North Garo Hills", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Ribhoi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ribhoi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("South Garo Hills");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("South Garo Hills", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("South West Garo Hills");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("South West Garo Hills", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("South West Khasi Hills");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("South West Khasi Hills", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("West Garo Hills");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("West Garo Hills", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("West Jaintia Hills");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("West Jaintia Hills", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("West Khasi Hills");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("West Khasi Hills", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Manipur ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[21])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Manipur");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("CAPF Personnel");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("CAPF Personnel",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bishnupur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bishnupur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Chandel");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chandel", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Churachandpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Churachandpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Imphal East");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Imphal East", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Imphal West");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Imphal West", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Jiribam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jiribam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kakching");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kakching", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kamjong");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kamjong", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kangpokpi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kangpokpi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Noney");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Noney", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Pherzawl");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pherzawl", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Senapati");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Senapati", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tamenglong");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tamenglong", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tengnoupal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tengnoupal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Thoubal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Thoubal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ukhrul");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ukhrul", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Unknown");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Unknown", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Madhya Pradesh ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[22])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Madhya Pradesh");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Agar Malwa");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Agar Malwa",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Alirajpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Alirajpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Anuppur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Anuppur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Ashoknagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ashoknagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Balaghat");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Balaghat", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Barwani");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Barwani", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Betul");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Betul", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bhind");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bhind", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bhopal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bhopal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Burhanpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Burhanpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Chhatarpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chhatarpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Chhindwara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chhindwara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Damoh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Damoh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Datia");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Datia", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Dewas");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dewas", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Dhar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dhar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Dindori");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dindori", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Guna");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Guna", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Gwalior");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gwalior", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Harda");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Harda", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hoshangabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hoshangabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Indore");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Indore", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jabalpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jabalpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jhabua");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jhabua", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Katni");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Katni", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Khandwa");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Khandwa", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Khargone");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Khargone", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mandla");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mandla", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mandsaur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mandsaur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Morena");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Morena", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Narsinghpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Narsinghpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Neemuch");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Neemuch", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Niwari");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Niwari", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Other Region");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other Region", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Panna");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Panna", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Raisen");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Raisen", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rajgarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rajgarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ratlam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ratlam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rewa");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rewa", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Satna");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Satna", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sehore");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sehore", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Seoni");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Seoni", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Shahdol");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Shahdol", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Shajapur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Shajapur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sheopur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sheopur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Shivpuri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Shivpuri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sidhi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sidhi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Singrauli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Singrauli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tikamgarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tikamgarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ujjain");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ujjain", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Umaria");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Umaria", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Vidisha");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Vidisha", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Unknown");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Unknown", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Mizoram ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[23])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Mizoram");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Aizawl");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Aizawl",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Champhai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Champhai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Hnahthial");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hnahthial", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Khawzawl");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Khawzawl", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kolasib");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kolasib", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Lawngtlai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lawngtlai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Lunglei");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lunglei", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Mamit");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mamit", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Saiha");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Saiha", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Saitual");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Saitual", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Serchhip");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Serchhip", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Nagaland ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[24])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Nagaland");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Others");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Others",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dimapur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dimapur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kiphire");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kiphire", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kohima");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kohima", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Longleng");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Longleng", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Mokokchung");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mokokchung", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Mon");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mon", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Peren");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Peren", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Phek");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Phek", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Tuensang");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tuensang", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Wokha");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Wokha", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Zunheboto");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Zunheboto", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Odisha ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[25])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Odisha");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("State Pool");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("State Pool",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Others");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Others", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Angul");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Angul", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Balangir");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Balangir", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Balasore");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Balasore", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bargarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bargarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bhadrak");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bhadrak", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Boudh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Boudh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Cuttack");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Cuttack", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Deogarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Deogarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dhenkanal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dhenkanal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Gajapati");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gajapati", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ganjam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ganjam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jagatsinghpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jagatsinghpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jajpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jajpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jharsuguda");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jharsuguda", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kalahandi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kalahandi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kandhamal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kandhamal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kendrapara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kendrapara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kendujhar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kendujhar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Khordha");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Khordha", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Koraput");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Koraput", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Malkangiri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Malkangiri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mayurbhanj");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mayurbhanj", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nabarangapur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nabarangapur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nayagarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nayagarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nuapada");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nuapada", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Puri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Puri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rayagada");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rayagada", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sambalpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sambalpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Subarnapur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Subarnapur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sundargarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sundargarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Punjab ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[26])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Punjab");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Amritsar");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Amritsar",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Barnala");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Barnala", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bathinda");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bathinda", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Faridkot");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Faridkot", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Fatehgarh Sahib");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Fatehgarh Sahib", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Fazilka");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Fazilka", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Ferozepur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ferozepur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Gurdaspur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gurdaspur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Hoshiarpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hoshiarpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Jalandhar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jalandhar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kapurthala");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kapurthala", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ludhiana");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ludhiana", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mansa");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mansa", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Moga");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Moga", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Pathankot");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pathankot", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Patiala");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Patiala", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rupnagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rupnagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("S.A.S. Nagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("S.A.S. Nagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sangrur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sangrur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Shahid Bhagat Singh Nagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Shahid Bhagat Singh Nagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sri Muktsar Sahib");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sri Muktsar Sahib", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tarn Taran");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tarn Taran", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Puducherry ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[27])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Puducherry");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Karaikal");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Karaikal",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Mahe");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mahe", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Puducherry");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Puducherry", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Yanam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Yanam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Rajasthan ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[28])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Rajasthan");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Ajmer");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ajmer",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Alwar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Alwar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Banswara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Banswara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Baran");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Baran", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Barmer");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Barmer", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bharatpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bharatpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bhilwara");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bhilwara", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bikaner");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bikaner", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("BSF Camp");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("BSF Camp", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bundi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bundi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Chittorgarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chittorgarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Churu");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Churu", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Dausa");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dausa", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Dholpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dholpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Dungarpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dungarpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Evacuees");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Evacuees", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ganganagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ganganagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hanumangarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hanumangarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Italians");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Italians", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jaipur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jaipur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jaisalmer");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jaisalmer", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jalore");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jalore", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jhalawar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jhalawar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jhunjhunu");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jhunjhunu", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jodhpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jodhpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Karauli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Karauli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kota");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kota", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nagaur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nagaur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Other State");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other State", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Pali");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pali", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Pratapgarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pratapgarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rajsamand");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rajsamand", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sawai Madhopur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sawai Madhopur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sikar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sikar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sirohi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sirohi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tonk");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tonk", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Udaipur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Udaipur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Sikkim ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[29])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Sikkim");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("East Sikkim");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("East Sikkim",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("North Sikkim");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("North Sikkim", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("South Sikkim");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("South Sikkim", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("West Sikkim");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("West Sikkim", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Unknown");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Unknown", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Telangana ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[30])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Telangana");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Foreign Evacuees");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Foreign Evacuees",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Other State");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other State", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Adilabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Adilabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bhadradri Kothagudem");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bhadradri Kothagudem", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Hyderabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hyderabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Jagtial");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jagtial", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Jangaon");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jangaon", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Jayashankar Bhupalapally");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jayashankar Bhupalapally", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Jogulamba Gadwal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jogulamba Gadwal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Kamareddy");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kamareddy", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Karimnagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Karimnagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Khammam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Khammam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Komaram Bheem");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Komaram Bheem", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mahabubabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mahabubabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mahabubnagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mahabubnagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mancherial");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mancherial", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Medak");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Medak", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Medchal Malkajgiri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Medchal Malkajgiri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mulugu");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mulugu", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nagarkurnool");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nagarkurnool", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nalgonda");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nalgonda", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Narayanpet");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Narayanpet", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nirmal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nirmal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nizamabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nizamabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Peddapalli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Peddapalli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rajanna Sircilla");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rajanna Sircilla", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ranga Reddy");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ranga Reddy", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sangareddy");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sangareddy", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Siddipet");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Siddipet", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Suryapet");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Suryapet", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Vikarabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Vikarabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Wanaparthy");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Wanaparthy", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Warangal Rural");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Warangal Rural", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Warangal Urban");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Warangal Urban", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Yadadri Bhuvanagiri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Yadadri Bhuvanagiri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Unknown");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Unknown", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Tamil Nadu ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[31])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Tamil Nadu");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Railway Quarantine");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Railway Quarantine",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Airport Quarantine");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Airport Quarantine", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Other State");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other State", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Ariyalur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ariyalur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Chengalpattu");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chengalpattu", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Chennai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chennai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Coimbatore");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Coimbatore", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Cuddalore");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Cuddalore", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dharmapuri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dharmapuri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dindigul");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dindigul", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Erode");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Erode", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kallakurichi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kallakurichi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kancheepuram");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kancheepuram", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kanyakumari");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kanyakumari", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Karur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Karur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Krishnagiri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Krishnagiri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Madurai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Madurai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nagapattinam");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nagapattinam", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Namakkal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Namakkal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nilgiris");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nilgiris", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Perambalur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Perambalur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Pudukkottai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pudukkottai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ramanathapuram");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ramanathapuram", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ranipet");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ranipet", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Salem");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Salem", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sivaganga");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sivaganga", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tenkasi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tenkasi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Thanjavur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Thanjavur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Theni");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Theni", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Thiruvallur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Thiruvallur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Thiruvarur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Thiruvarur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Thoothukkudi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Thoothukkudi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tiruchirappalli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tiruchirappalli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tirunelveli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tirunelveli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tirupathur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tirupathur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tiruppur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tiruppur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tiruvannamalai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tiruvannamalai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Vellore");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Vellore", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Viluppuram");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Viluppuram", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Virudhunagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Virudhunagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mayiladuthurai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mayiladuthurai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Tripura ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[32])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Tripura");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Dhalai");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dhalai",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Gomati");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gomati", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Khowai");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Khowai", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("North Tripura");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("North Tripura", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Sipahijala");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sipahijala", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("South Tripura");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("South Tripura", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Unokoti");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Unokoti", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("West Tripura");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("West Tripura", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Uttar Pradesh ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[33])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Uttar Pradesh");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Agra");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Agra",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Aligarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Aligarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Ambedkar Nagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ambedkar Nagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Amethi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Amethi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Amroha");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Amroha", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Auraiya");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Auraiya", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Ayodhya");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ayodhya", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Azamgarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Azamgarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Bahraich");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bahraich", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ballia");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ballia", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Balrampur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Balrampur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Banda");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Banda", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Barabanki");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Barabanki", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Bareilly");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bareilly", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Basti");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Basti", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Bhadohi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bhadohi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Bijnor");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bijnor", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Budaun");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Budaun", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Bulandshahr");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bulandshahr", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Chandauli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chandauli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Chitrakoot");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chitrakoot", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Deoria");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Deoria", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Etah");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Etah", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Etawah");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Etawah", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Farrukhabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Farrukhabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Fatehpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Fatehpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Firozabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Firozabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Gautam Buddha Nagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gautam Buddha Nagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ghaziabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ghaziabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Ghazipur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Ghazipur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Gonda");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gonda", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Gorakhpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Gorakhpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hamirpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hamirpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hapur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hapur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hardoi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hardoi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hardoi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hardoi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Hathras");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hathras", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jalaun");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jalaun", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jaunpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jaunpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jhansi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jhansi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kannauj");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kannauj", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kanpur Dehat");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kanpur Dehat", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kanpur Nagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kanpur Nagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kasganj");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kasganj", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kaushambi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kaushambi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kushinagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kushinagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Lakhimpur Kheri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lakhimpur Kheri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Lalitpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lalitpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Lucknow");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Lucknow", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Maharajganj");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Maharajganj", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mahoba");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mahoba", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mainpuri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mainpuri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mathura");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mathura", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mau");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mau", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Meerut");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Meerut", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Mirzapur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Mirzapur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Moradabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Moradabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Muzaffarnagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Muzaffarnagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Pilibhit");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pilibhit", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Pratapgarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pratapgarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Prayagraj");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Prayagraj", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rae Bareli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rae Bareli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rampur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rampur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Saharanpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Saharanpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sambhal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sambhal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sant Kabir Nagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sant Kabir Nagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Shahjahanpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Shahjahanpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Shamli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Shamli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Shrawasti");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Shrawasti", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Siddharthnagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Siddharthnagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sitapur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sitapur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sonbhadra");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sonbhadra", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Sultanpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Sultanpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Unnao");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Unnao", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Varanasi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Varanasi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- Uttarakhand ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[34])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("Uttarakhand");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Almora");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Almora",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bageshwar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bageshwar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Chamoli");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Chamoli", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Champawat");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Champawat", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dehradun");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dehradun", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Haridwar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Haridwar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Nainital");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nainital", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Pauri Garhwal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pauri Garhwal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Pithoragarh");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Pithoragarh", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Rudraprayag");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Rudraprayag", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Tehri Garhwal");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Tehri Garhwal", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Udham Singh Nagar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Udham Singh Nagar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Uttarkashi");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Uttarkashi", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

        //     <---- Declaring STATE name & CITY OF---  !!! ---->

        //<---- West Bengal ---->
        else if (autoCompleteTextView.getText().toString().trim().equals(stateName[35])){

            StringRequest stringRequest  = new StringRequest(Request.Method.GET, dataUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try
                    {

                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject jsonObject1 = jsonObject.getJSONObject("West Bengal");
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        JSONObject jsonObject3 = jsonObject2.getJSONObject("Alipurduar");
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");

                        String activeCase = jsonObject3.getString("active");
                        String confirmed = jsonObject3.getString("confirmed");
                        String deceased = jsonObject3.getString("deceased");
                        String recovered = jsonObject3.getString("recovered");

                        String confInc = jsonObject4.getString("confirmed");
                        String confDec = jsonObject4.getString("deceased");
                        String confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Alipurduar",confirmed,deceased,recovered,activeCase,confInc,confDec,confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Bankura");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Bankura", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Birbhum");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Birbhum", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Cooch Behar");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Cooch Behar", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Dakshin Dinajpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Dakshin Dinajpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Darjeeling");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Darjeeling", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Hooghly");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Hooghly", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        jsonObject3 = jsonObject2.getJSONObject("Howrah");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Howrah", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jalpaiguri");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jalpaiguri", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Jhargram");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Jhargram", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kalimpong");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kalimpong", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Kolkata");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Kolkata", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Malda");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Malda", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Murshidabad");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Murshidabad", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Nadia");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Nadia", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("North 24 Parganas");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("North 24 Parganas", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Other State");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Other State", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Paschim Bardhaman");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Paschim Bardhaman", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Paschim Medinipur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Paschim Medinipur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Purba Bardhaman");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Purba Bardhaman", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Purba Medinipur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Purba Medinipur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Purulia");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Purulia", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("South 24 Parganas");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("South 24 Parganas", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);

                        jsonObject3 = jsonObject2.getJSONObject("Uttar Dinajpur");
                        activeCase = jsonObject3.getString("active");
                        confirmed = jsonObject3.getString("confirmed");
                        deceased = jsonObject3.getString("deceased");
                        recovered = jsonObject3.getString("recovered");
                        jsonObject4 = jsonObject3.getJSONObject("delta");
                        confInc = jsonObject4.getString("confirmed");
                        confDec = jsonObject4.getString("deceased");
                        confRec = jsonObject4.getString("recovered");

                        modelClass = new Model("Uttar Dinajpur", confirmed, deceased, recovered, activeCase,confInc, confDec, confRec);
                        datamodellist.add(modelClass);


                        covidAdapter = new CovidAdapter(MainActivity.this,datamodellist);
                        datalistview.setAdapter(covidAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("exp",error.getMessage());
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }
        //     <---- Declared all the  STATE name & CITY OF INDIA here Finished ---  !!! ---->

//     <---- If user did'nt give valid fiel here then show this massage---  !!! ---->

        else {
            autoCompleteTextView.setError("Enter valid field");
        }

    }


}