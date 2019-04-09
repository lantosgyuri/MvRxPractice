package com.lantosgyuri.mvrxpractice

data class Food( val foodName: String, val isVegetarian: Boolean, val isGlutenfree: Boolean) {
}

data class FoodState( val foods: List<Food>) {
    val vegetarianFoods = foods.filter { it.isVegetarian}
    val glutenfreeFoods = foods.filter { it.isGlutenfree}
}