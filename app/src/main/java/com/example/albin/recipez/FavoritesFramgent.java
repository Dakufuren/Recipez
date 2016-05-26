package com.example.albin.recipez;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFramgent extends android.support.v4.app.Fragment {

    private ListView favList;


    public FavoritesFramgent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites_framgent_layout, container,false);
        Bundle bundle = getArguments();

        favList = (ListView) view.findViewById(R.id.FavoritesListView);


        return view;
    }

}
