package View;

import Controller.FoodController;
import Controller.Food_ImplController;
import Controller.NewFoodController;
import Controller.NewFood_ImplController;
import Model.Food.Food;
import Model.Food.FoodModel;
import Model.Food.TableObserverFood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class AddFoodList extends JFrame implements TableObserverFood {
    private JPanel rootPanel;
    private JTable table1;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton chooseButton;
    private FoodTable foodTable;
    private FoodModel foodModel;

    public AddFoodList(FoodModel model) throws SQLException {
        this.foodModel = model ;
        this.foodModel.registerObserver(this);

        setTitle("Employees Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(600,400));
        setLocation(500,200);
        pack();
        setVisible(true);
        foodTable = new FoodTable();
        table1.setModel(foodTable);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onAddFood(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        List<Food> foods = this.foodModel.getAllFoods();
        foodTable.updateFood(foods);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onUpdateFood(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onDeleteFood(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void onAddFood(ActionEvent e) throws SQLException {
        NewFoodController newFoodController = new NewFood_ImplController(this, (FoodModel) foodModel,new AddFood());
        newFoodController.newFood();
    }

    private void onDeleteFood(ActionEvent e) throws SQLException {
        if (table1.getSelectedRow() != -1) {
            FoodController foodController = (FoodController) new Food_ImplController(this, (FoodModel) foodModel, new AddFood());
            foodController.DeleteFood((Integer) foodTable.getValueAt(table1.getSelectedRow(), 0));
            System.out.println(table1.getSelectedRow());
        }else {
            JOptionPane.showConfirmDialog(null, "Chưa chọn bất kỳ món ăn nào", "Xóa nhân viên", JOptionPane.OK_OPTION);
        }
    }

    private void onUpdateFood(ActionEvent e) throws SQLException {
        if (table1.getSelectedRow() != -1) {
            FoodController foodController = new Food_ImplController(this, (FoodModel) foodModel, new AddFood());
            foodController.UpdateFood((Integer) foodTable.getValueAt(table1.getSelectedRow(), 0));
        }else {
            JOptionPane.showConfirmDialog(null, "Chưa chọn bất kỳ món ăn nào", "Sua thong tin", JOptionPane.OK_OPTION);
        }
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public void UpdateTableFood(List<Food> foods) {
        foodTable.updateFood(foods);
    }
}
