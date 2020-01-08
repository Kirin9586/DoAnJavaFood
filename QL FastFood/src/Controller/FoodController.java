package Controller;

import java.sql.SQLException;

public interface FoodController {
    void UpdateFood(int id) throws SQLException;
    void DeleteFood(int id) throws SQLException;
    void ChooseFood(int id) throws SQLException;
}
