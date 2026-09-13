package com.practice.food;

// which type of food it created
// food behaviour changes at runtim
//game will decide which spawn strategy to use
// System will support mulltiple spawn strategies
public interface IFoodSpawnStrategy {

    FoodCreator nextFoodItem();
}
