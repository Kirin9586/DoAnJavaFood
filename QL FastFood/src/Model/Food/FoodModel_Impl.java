package Model.Food;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class FoodModel_Impl implements FoodModel {
    private List<TableObserverFood> observers = new Vector<>();
    @Override
    public List<Food> getAllFoods() throws SQLException {
        FoodDao dao = new FoodDao_Impl();
        return dao.getAllFoods();
    }

    @Override
    public void AddFood(Food food) throws SQLException {
        FoodDao dao = new FoodDao_Impl();
        dao.insertFood(food);
        notifyObserver();
    }

    @Override
    public void UpdateFood(Food food, int id) throws SQLException {
        FoodDao dao = new FoodDao_Impl();
        dao.updateFood(food,id);
        notifyObserver();
    }

    @Override
    public void DeleteFood(int id) throws SQLException {
        FoodDao dao = new FoodDao_Impl();
        dao.deleteFood(id);
        notifyObserver();
    }

    @Override
    public void ChooseFood(int id) throws SQLException {
        FoodDao dao = new FoodDao_Impl();
        dao.getFoodById(id);
        notifyObserver();
    }

    @Override
    public void registerObserver(TableObserverFood observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(TableObserverFood observer) {
        observers.remove(observer);
    }

    @Override
    public Food getAllFoodMain(int id) throws SQLException {
        FoodDao dao = new FoodDao_Impl();
        notifyObserver();
        return dao.getFoodById(id);
    }

    @Override
    public Food getAllFoodDishSide(int id) throws SQLException {
        FoodDao dao = new FoodDao_Impl();
        notifyObserver();
        return dao.getFoodById(id);
    }


    private void notifyObserver() throws SQLException {
        List<Food> foods = getAllFoods();
        for (TableObserverFood observer : observers) {
            observer.UpdateTableFood(foods);
        }
    }
}
