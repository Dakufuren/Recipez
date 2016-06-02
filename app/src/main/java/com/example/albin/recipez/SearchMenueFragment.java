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

import java.util.ArrayList;
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
    //private CheckBox meat;
    private Button shuffle;
    private Spinner dropDown1;
    private Spinner dropDown2;
    private SeekBar priceBar;
    private TextView priceDisplay;
    private String contentOne[] = {"", "Beef", "Pork", "Chicken", "Minced meat", "Oumph"};
    private String contentTwo[] = {"", "Pasta", "Rice", "Noodles", "Bulgur", "Potatis", "Couscous", "Lentils"};
    private int price = 0;



    private RequestQueue requestQueue;
    private StringRequest request;
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
       // meat = (CheckBox) view.findViewById(R.id.meatBox);
        dropDown1 = (Spinner) view.findViewById(R.id.dropDownOne);
        dropDown2 = (Spinner) view.findViewById(R.id.dropDownTwo);
        shuffle = (Button) view.findViewById(R.id.ShuffleButton);
        priceBar = (SeekBar) view.findViewById(R.id.priceBar);
        priceDisplay = (TextView) view.findViewById(R.id.priceDisplay);

        adapterContentOneType = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, contentOne);
        dropDown1.setAdapter(adapterContentOneType);
        adapterContentTwoType = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, contentTwo);
        dropDown2.setAdapter((adapterContentTwoType));



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

                /*
                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray jsonArray = new JSONArray(response);
                            JSONObject jsonObject = (JSONObject) jsonArray.get(0);

                            String test = jsonObject.getString("recipe_name");
                            String test2 = jsonObject.getString("recipe_description");
                            String test3 = jsonObject.getString("price");
                            System.out.println(test);
                            System.out.println(test2);
                            System.out.println(test3);



                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("hej");
                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        HashMap<String, String> hashMap = new HashMap<String, String>();

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

                        hashMap.put("categoryone", categoryOne);
                        hashMap.put("categorytwo", categoryTwo);
                        hashMap.put("price", priceString);
                        hashMap.put("glutenfree", glutenFreeId);
                        hashMap.put("vegetarian", vegetarianId);
                        hashMap.put("vegan", veganId);
                        hashMap.put("lactosefree", lactoseId);
                        return hashMap;
                    }

                };*/

                RecipeObject obj1 = new RecipeObject("Oumphs Special Blend", "vegan","vegetarian", "lorem dolar set amet", 25, "Oumph", "Onion", "Rice", "Avocado", "Beans");
                RecipeObject obj2 = new RecipeObject("Korvgryta", "Meat based", "lorim ipsum dolar set", 30, "Saucages", "Onion", "Rice", "Mushrooms");


                mCardStack.setVisibility(View.VISIBLE);

                mCardAdapter.add("\n\n" + obj1.getRecipeName()  + "\n\n" + "Description: \n" + obj1.getDescription() + "\n\n Ingredients: \n" + obj1.getIngredient1() + "\n" +
                obj1.getIngredient2() + "\n" + obj1.getIngredient3() + "\n\nCategories \n" + obj1.getRecipeCategory() + "\n" + obj1.getRecipeCategory2()  + "\n\n Price \n" + obj1.getPrice()
                );
                mCardAdapter.add("\n\n" + obj2.getRecipeName()  + "\n\n" + "Description: \n" + obj2.getDescription() + "\n\n Ingredients: \n" + obj2.getIngredient1() + "\n" +
                        obj2.getIngredient2() + "\n" + obj2.getIngredient3() + "\n\nCategories \n" + obj2.getRecipeCategory()  + "\n\n Price \n" + obj2.getPrice()
                );


                mCardStack.setAdapter(mCardAdapter);
                System.out.println("sending request");
                //requestQueue.add(request);





            }
        });




        return view;
    }



}
