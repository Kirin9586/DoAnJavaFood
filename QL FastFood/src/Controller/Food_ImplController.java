package Controller;

import Model.Food.Food;
import Model.Food.FoodModel;
import View.AddFood;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Food_ImplController implements FoodController {
    private Component parent;
    private FoodModel model;
    private AddFood view;
    public Food_ImplController(Component parent,FoodModel model,AddFood view){
        this.parent = parent;
        this.model = model;
        this.view = view;
    }
    @Override
    public void UpdateFood( int id) throws SQLException {
        int option = JOptionPane.showConfirmDialog(parent, view.getRootPanel() , "Edit mon an", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if(option == JOptionPane.YES_OPTION){
            if(view.getName() == null){
                JOptionPane.showConfirmDialog(null, "Chưa nhập tên món ăn", "Lỗi !!!", JOptionPane.OK_OPTION);
            }else {
                String Name = view.getName();
                int price = view.getPrice();
                int amount = view.getAmount();
                String Name_dishside = view.getName_dishside();
                int price_dishside = view.getPrice_dishside();
                Food food = new Food();
                food.setName(Name);
                food.setPrice(price);
                food.setAmount(amount);
                food.setName_dishside(Name_dishside);
                food.setPrice_dishside(price_dishside);
                model.UpdateFood(food,id);
            }
        }
    }

    @Override
    public void DeleteFood(int id) throws SQLException {
        int option = JOptionPane.showConfirmDialog(parent, "Bạn có muốn xóa ???", "Xóa món ăn", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            model.DeleteFood(id);
        }
    }

    @Override
    public void ChooseFood(int id) throws SQLException {
        int option = JOptionPane.showConfirmDialog(parent, "Bạn có muốn xóa ???", "Xóa món ăn", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            model.ChooseFood(id);
        }
    }
}
