package com.example.albin.recipez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.github.pwittchen.swipe.library.Swipe;
import com.github.pwittchen.swipe.library.SwipeListener;

public class ShuffleRecipeActivity extends AppCompatActivity {

    private Swipe swipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuffle_recipe);

        swipe = new Swipe();

        swipe.addListener(new SwipeListener() {
            @Override
            public void onSwipingLeft(final MotionEvent event) {
                System.out.println("Swiping Left");
            }

            @Override
            public void onSwipedLeft(final MotionEvent event) {
                System.out.println("Swiped Left");

            }

            @Override
            public void onSwipingRight(final MotionEvent event) {System.out.println("Swiping Right"); }

            @Override
            public void onSwipedRight(final MotionEvent event) {
                System.out.println("Swiped Right");
            }

            @Override
            public void onSwipingUp(final MotionEvent event) {}

            @Override
            public void onSwipedUp(final MotionEvent event) {}

            @Override
            public void onSwipingDown(final MotionEvent event) {}

            @Override
            public void onSwipedDown(final MotionEvent event) {}



        });
    }

    @Override public boolean dispatchTouchEvent(MotionEvent event) {
        swipe.dispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }
}
