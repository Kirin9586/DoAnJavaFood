package Model.Food;

import Model.Food.Food;

import java.util.List;

public interface FoodDao {
    void insertFood(Food food);
    Food getFoodById(int id);
    List<Food> getAllFoods();
    void updateFood(Food food,int id);
    void deleteFood(int id);
}
