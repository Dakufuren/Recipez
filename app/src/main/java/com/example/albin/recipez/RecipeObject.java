package com.example.albin.recipez;

/**
 * Created by Albin on 2016-05-09.
 */
public class RecipeObject {




    private String recipeName;
    private String recipeCategory;
    private String recipeCategory2;
    private String recipeCategory3;
    private String description;
    private int price;
    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private String ingredient4;
    private String ingredient5;
    private String ingredient6;
    private String ingredient7;


    public RecipeObject(String recipeName, String recipeCategory, String description, int price, String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5) {
        this.recipeName = recipeName;
        this.recipeCategory = recipeCategory;
        this.description = description;
        this.price = price;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.ingredient5 = ingredient5;
    }

    public RecipeObject(String recipeName, String recipeCategory, String description, int price, String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5, String ingredient6, String ingredient7) {
        this.recipeName = recipeName;
        this.recipeCategory = recipeCategory;
        this.description = description;
        this.price = price;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.ingredient5 = ingredient5;
        this.ingredient6 = ingredient6;
        this.ingredient7 = ingredient7;
    }

    public RecipeObject(String recipeName, String recipeCategory, String recipeCategory2, String description, int price, String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5) {
        this.recipeName = recipeName;
        this.recipeCategory = recipeCategory;
        this.recipeCategory2 = recipeCategory2;
        this.description = description;
        this.price = price;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;

    }

    public RecipeObject(String recipeName, String recipeCategory, String description, int price, String ingredient1, String ingredient2, String ingredient3, String ingredient4) {
        this.recipeName = recipeName;
        this.recipeCategory = recipeCategory;
        this.description = description;
        this.price = price;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;

    }

    public RecipeObject(String recipeName, String recipeCategory, String description, int price, String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5, String ingredient6) {
        this.recipeName = recipeName;
        this.recipeCategory = recipeCategory;
        this.description = description;
        this.price = price;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.ingredient5 = ingredient5;
        this.ingredient6 = ingredient6;

    }




    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeCategory() {
        return recipeCategory;
    }

    public String getRecipeCategory2() {
        return recipeCategory2;
    }

    public String getDescription() {
        return description;
    }

    public String getRecipeCategory3() {
        return recipeCategory3;
    }

    public int getPrice() {
        return price;
    }

    public String getIngredient1() {
        return ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public String getIngredient4() {
        return ingredient4;
    }

    public String getIngredient5() {
        return ingredient5;
    }

    public String getIngredient6() {
        return ingredient6;
    }

    public String getIngredient7() {
        return ingredient7;
    }
}