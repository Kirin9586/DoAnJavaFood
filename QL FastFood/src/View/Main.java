package View;


import Model.Food.FoodModel;

import Model.Food.FoodModel_Impl;

import java.sql.SQLException;

public class Main {
    public static void main(String[]args) throws SQLException {

        FoodModel model = (FoodModel) new FoodModel_Impl();
        SceenLoad sceenLoad = new SceenLoad(model);
    }
}
