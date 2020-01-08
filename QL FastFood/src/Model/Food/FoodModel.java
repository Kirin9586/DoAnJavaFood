package Model.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodModel {
    List<Food>getAllFoods() throws SQLException;
    void AddFood(Food food) throws SQLException;
    void UpdateFood(Food food,int id) throws SQLException;
    void DeleteFood(int id) throws SQLException;
    void ChooseFood(int id) throws SQLException;
    void registerObserver(TableObserverFood observer);
    void unregisterObserver(TableObserverFood observer);
    Food getAllFoodMain(int id) throws SQLException;
    Food getAllFoodDishSide(int id) throws SQLException;
}
