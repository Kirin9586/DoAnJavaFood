package View;

import Model.Food.Food;
import Model.Food.FoodModel;
import Model.Food.TableObserverFood;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SceenLoad extends JFrame{
    private JPanel rootPanel;
    private JPanel CardLayout;
    private JPanel FoodCard;
    private JPanel DishSideCard;
    private JTable Foodtable;
    private JTable Dishsidetable;
    private JPanel OrderCard;
    private JTable Ordertable;
    private JButton payButton;
    private FoodModel foodModel;
    private GetDishSideTable getDishSideTable;
    private GetFoodTable getFoodTable;
    public SceenLoad(FoodModel model){
        this.foodModel = model ;
        setTitle("Employees Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(600,400));
        setLocation(500,200);
        pack();
        setVisible(true);
        getDishSideTable = new GetDishSideTable();
        Dishsidetable.setModel(getDishSideTable);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
