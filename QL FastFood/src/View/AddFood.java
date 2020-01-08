package View;

import javax.swing.*;

public class AddFood  {
    private JPanel rootPanel;
    private JPanel FoodManagerPanel;
    private  JTextField nameTextfield;
    private  JTextField priceTextfield;
    private  JTextField amountTextfield;
    private JTextField nametextFieldDishside;
    private JTextField pricetextFieldDishside;

    public JPanel getRootPanel() {
        return rootPanel;
    }

   public String getName(){
        if (nameTextfield.getText().equals("")){
            return null;
        }
        else {
            return nameTextfield.getText();
        }
   }
   public String getName_dishside(){
       if (nametextFieldDishside.getText().equals("")){
           return null;
       }
       else {
           return nametextFieldDishside.getText();
       }
   }
   public int getPrice(){
        if (priceTextfield.getText().equals("")){
            return Integer.parseInt(String.valueOf(priceTextfield.getText() == null));
        }
        else {
            return Integer.parseInt(priceTextfield.getText());
        }
   }
   public int getPrice_dishside(){
       if (pricetextFieldDishside.getText().equals("")){
           return Integer.parseInt(String.valueOf(pricetextFieldDishside.getText() == null));
       }
       else {
           return Integer.parseInt(pricetextFieldDishside.getText());
       }
   }
    public int getAmount(){
        if (amountTextfield.getText().equals("")){
            return Integer.parseInt(String.valueOf(amountTextfield.getText() == null));
        }
        else {
            return Integer.parseInt(amountTextfield.getText());
        }
    }
}
