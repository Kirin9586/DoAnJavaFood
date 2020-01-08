package View;

import Model.Food.Food;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class GetFoodTable extends AbstractTableModel {
    List<Food> foods = new Vector<>();
    private static final int ID= 0 , Name = 1, Price = 2,Amout = 3;
    private static  final String[]COLUMN_NAME = {"ID","Name","Price","Amount"};

    @Override
    public int getRowCount() {
        return foods.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAME.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Food food = foods.get(rowIndex);
        if(columnIndex == ID){
            return food.getId();
        }
        else if(columnIndex == Name){
            return food.getName();
        }
        else if(columnIndex == Price){
            return food.getPrice();
        }
        else if(columnIndex == Amout){
            return food.getAmount();
        }
        return null;
    }
    public void updateFood(List<Food>foodList){
        this.foods.clear();
        this.foods.addAll(foodList);
        fireTableDataChanged();
    }
}
