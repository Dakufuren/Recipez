package com.example.albin.recipez;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFramgent extends ListFragment {

    private ListView favList;
    private RecipeObject obj1 = new RecipeObject("Oumphs Special Blend", "vegan","vegetarian", "lorem dolar set amet", 25, "Oumph", "Onion", "Rice", "Avocado", "Beans");
    private RecipeObject obj2 = new RecipeObject("Korvgryta", "Meat based", "lorim ipsum dolar set", 30, "Saucages", "Onion", "Rice", "Mushrooms");

    public FavoritesFramgent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites_framgent_layout, container,false);
        Bundle bundle = getArguments();



        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        String[] strArr = new String[2];

        //ADD OBJECTS

        strArr[0] = obj1.getRecipeName();
        strArr[1] = obj2.getRecipeName();

        //ADD OBJECTS TITEL TO strArr

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1, strArr);
        setListAdapter(adapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                int tempId = position;
                String tempMsg = "";
                String tempTitel = "";

                if(position == 0){
                    tempTitel = obj1.getRecipeName();
                    tempMsg = "Description: \n" +
                            obj1.getDescription() + "\n" +
                            "\n" +
                            "Ingredients: \n" +
                            obj1.getIngredient1() + "\n" +
                            obj1.getIngredient2() + "\n" +
                            obj1.getIngredient3() + "\n" +
                            obj1.getIngredient4() + "\n" +
                            "\n" +
                            "Categories: \n" +
                            obj1.getRecipeCategory() + "\n" +
                            obj1.getRecipeCategory2() + "\n" +
                            "\n" +
                            "Price: " +
                            obj1.getPrice();
                }

                if(position == 1){
                    tempTitel = obj2.getRecipeName();
                    tempMsg = "Description: \n" +
                            obj2.getDescription() + "\n" +
                            "\n" +
                            "Ingredients: \n" +
                            obj2.getIngredient1() + "\n" +
                            obj2.getIngredient2() + "\n" +
                            obj2.getIngredient3() + "\n" +
                            obj2.getIngredient4() + "\n" +
                            "\n" +
                            "Categories: \n" +
                            obj2.getRecipeCategory() + "\n" +
                            "\n" +
                            "Price: " +
                            obj2.getPrice();
                }
                System.out.println(position);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        getActivity());

                alertDialogBuilder.setTitle(tempTitel);

                // set dialog message
                alertDialogBuilder
                        .setMessage(tempMsg)
                        .setCancelable(false)
                     /*   .setPositiveButton("Remove",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                    Context context = getActivity();
                                    CharSequence text = "Workout Deleted!";
                                    int duration = Toast.LENGTH_SHORT;

                                    Toast toast = Toast.makeText(context, text, duration);
                                    toast.show();
                            }
                        }) */
                        .setNegativeButton("Done", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }

        });
    }

}
