package View;

import Model.Food.Food;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class GetDishSideTable extends AbstractTableModel {
    List<Food> foods = new Vector<>();
    private static final int ID= 0 , Name_dishside = 1, Price_dishside = 2;
    private static  final String[]COLUMN_NAME = {"ID","Name_dishside","Price_dishside"};
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
        else if(columnIndex == Name_dishside){
            return food.getName_dishside();
        }
        else if(columnIndex == Price_dishside){
            return food.getPrice_dishside();
        }
        return null;
    }
    public void updateFood(List<Food>foodList){
        this.foods.clear();
        this.foods.addAll(foodList);
        fireTableDataChanged();
    }
}
