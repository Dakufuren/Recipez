package com.example.albin.recipez;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wenchao.cardstack.CardStack;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchMenueFragment extends android.support.v4.app.Fragment {


    private CheckBox vegetarian;
    private CheckBox vegan;
    private CheckBox glutenFree;
    private CheckBox laktos;
    private CheckBox meat;
    private Button shuffle;
    private Spinner dropDown1;
    private Spinner dropDown2;
    private SeekBar priceBar;
    private TextView priceDisplay;
    private String contentOne[] = {"", "Beef", "Pork", "Chicken", "Minced meat", "Oumph"};
    private String contentTwo[] = {"", "Pasta", "Rice", "Noodles", "Bulgur", "Potatis", "Couscous", "Lentils"};
    private int price = 0;


    private RequestQueue requestQueue;
    private JsonObjectRequest request;
    private static String URL = "http://wolfcrew.se/scripts/get_recipe.php";

    private CardStack mCardStack;
    private CardsDataAdapter mCardAdapter;


    ArrayAdapter<String> adapterContentOneType;
    ArrayAdapter<String> adapterContentTwoType;

    public SearchMenueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_search_menue_layout,container,false);
        Bundle bundle = getArguments();


        mCardStack = (CardStack)view.findViewById(R.id.container);
        mCardStack.setContentResource(R.layout.card_stack);
        mCardStack.setStackMargin(20);
        mCardStack.setVisibility(View.GONE);


        mCardAdapter = new CardsDataAdapter(this.getActivity(),0);

        vegetarian = (CheckBox) view.findViewById(R.id.vegetarianBox);
        vegan = (CheckBox) view.findViewById(R.id.veganBox);
        glutenFree = (CheckBox) view.findViewById(R.id.glutenBox);
        laktos = (CheckBox) view.findViewById(R.id.lactoseBox);
        meat = (CheckBox) view.findViewById(R.id.meatBox);
        dropDown1 = (Spinner) view.findViewById(R.id.dropDownOne);
        dropDown2 = (Spinner) view.findViewById(R.id.dropDownTwo);
        shuffle = (Button) view.findViewById(R.id.ShuffleButton);
        priceBar = (SeekBar) view.findViewById(R.id.priceBar);
        priceDisplay = (TextView) view.findViewById(R.id.priceDisplay);

        adapterContentOneType = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, contentOne);
        dropDown1.setAdapter(adapterContentOneType);
        adapterContentTwoType = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, contentTwo);
        dropDown2.setAdapter((adapterContentTwoType));

        final HashMap<String, String> params = new HashMap<String, String>();

        priceDisplay.setText("Price: " + priceBar.getProgress() + " sek");

        priceBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar priceBar, int progresValue, boolean fromUser) {
                price = progresValue;


            }

            @Override
            public void onStartTrackingTouch(SeekBar priceBar) {
                priceDisplay.setText("Price: " + price + " sek");

            }

            @Override
            public void onStopTrackingTouch(SeekBar priceBar) {
                priceDisplay.setText("Price: " + price + " sek");
            }
        });

        requestQueue = Volley.newRequestQueue(this.getActivity());


        shuffle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                CustomRequest jsonObjRequest = new CustomRequest(Request.Method.POST, URL, params, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONObject jsonObject = response.getJSONObject("recipeName");
                            String test = jsonObject.toString();
                            System.out.println(test);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error);
                    }
                });


                String categoryOne = dropDown1.getSelectedItem().toString();
                String categoryTwo = dropDown2.getSelectedItem().toString();
                String priceString = Integer.toString(price);
                String glutenFreeId = "0";
                String vegetarianId ="0";
                String veganId = "0";
                String lactoseId = "0";
                String meatId = "0";
                if (glutenFree.isChecked()) {
                    glutenFreeId = "1";
                } if (vegetarian.isChecked()) {
                    vegetarianId = "2";
                } if (vegan.isChecked()) {
                    veganId = "3";
                } if (laktos.isChecked()) {
                    lactoseId = "4";
                }
                if(meat.isChecked()){
                    meatId = "5";
                }

                params.put("categoryone", categoryOne);
                params.put("categorytwo", categoryTwo);
                params.put("price", priceString);
                params.put("glutenfree", glutenFreeId);
                params.put("vegetarian", vegetarianId);
                params.put("vegan", veganId);
                params.put("lactosefree", lactoseId);

                mCardStack.setVisibility(View.VISIBLE);
                mCardAdapter.add("test1");
                mCardAdapter.add("test2");
                mCardAdapter.add("test3");
                mCardAdapter.add("test4");
                mCardAdapter.add("test5");

                mCardStack.setAdapter(mCardAdapter);
                System.out.println("sending request");
                requestQueue.add(jsonObjRequest);





            }
        });




        return view;
    }



}
