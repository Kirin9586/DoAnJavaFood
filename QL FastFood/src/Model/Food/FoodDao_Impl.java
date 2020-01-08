package Model.Food;

import Model.Database;
import Model.Food.Food;
import Model.Food.FoodDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class FoodDao_Impl implements FoodDao {
    public FoodDao_Impl() throws SQLException {
        Database db = new Database();
        String SQL_CREATE_FOOD_TABLE = "CREATE TABLE IF NOT EXISTS FoodsTable (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    Name text NOT NULL,\n"
                + "    Price integer,\n"
                + "    Amount integer,\n"
                + "    Name_dishside text NOT NULL,\n"
                + "    Price_dishside integer\n"
                + ");";
        Statement statement = db.getConnection().createStatement();
        statement.execute(SQL_CREATE_FOOD_TABLE);
    }

    @Override
    public void insertFood(Food food) {
        Database db = new Database();
        final String SQL_CREATE_FOOD = "INSERT INTO FoodsTable(Name,Price,Amount,Name_dishside,Price_dishside)" +
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_FOOD, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, food.getName());
            ps.setInt(2, food.getPrice());
            ps.setInt(3,food.getAmount());
            ps.setString(4,food.getName_dishside());
            ps.setInt(5,food.getPrice_dishside());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                food.setId(id);
                System.out.println("Inserted id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public Food getFoodById(int id) {
        Food food = null;
        Database db = new Database();
        final String SQL_SELECT_FOOD_BY_ID = "SELECT * FROM FoodsTable WHERE ID=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT_FOOD_BY_ID);
            ps.setInt(1, food.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                String Name = rs.getString(2);
                int price = rs.getInt(3);
                int amount = rs.getInt(4);
                String Name_dishside = rs.getString(5);
                int price_dishside = rs.getInt(6);
                food = new Food(id,Name,price,amount,Name_dishside,price_dishside);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return food;
    }

    @Override
    public List<Food> getAllFoods() {
        List<Food> foods = new Vector<>();
        Database db = new Database();
        final String SQL_SELECT_ALL_FOOD = "SELECT * FROM FoodsTable";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_FOOD);
            while (rs.next()) {
                int id = rs.getInt(1);
                String Name = rs.getString(2);
                int price = rs.getInt(3);
                int amount = rs.getInt(4);
                String Name_dishside = rs.getString(5);
                int price_dishside = rs.getInt(6);
                Food food = new Food(id,Name,price,amount,Name_dishside,price_dishside);
                foods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }
    @Override
    public void updateFood(Food food, int id) {
        Database db = new Database();
        final String SQL_UPDATE_FOOD_BY_ID = "UPDATE FoodsTable SET Name = ?, Price = ?, Amount = ?, Name_dishside = ?, Price_dishside = ?  WHERE ID = ?";
        PreparedStatement ps = null;
        try {
            ps = db.getConnection().prepareStatement(SQL_UPDATE_FOOD_BY_ID);
            ps.setString(1, food.getName());
            ps.setInt(2, food.getPrice());
            ps.setInt(3,food.getAmount());
            ps.setString(4,food.getName_dishside());
            ps.setInt(5,food.getPrice_dishside());
            ps.setInt(6,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void deleteFood(int id) {
        Database db = new Database();
        final String SQL_DELETE_FOOD_BY_ID = "DELETE FROM FoodsTable WHERE ID = ?";
        PreparedStatement ps = null;
        try {
            ps = db.getConnection().prepareStatement(SQL_DELETE_FOOD_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }
}
