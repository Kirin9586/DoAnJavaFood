package Model.Food;

public class Food {
    private int id;
    private String name;
    private String name_dishside;
    private int price;
    private int price_dishside;
    private int amount;
    public Food(int id,String name,int price,int amount,String name_dishside,int price_dishside){
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.name_dishside = name_dishside;
        this.price_dishside = price_dishside;
    }
    public Food(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_dishside() {
        return name_dishside;
    }

    public void setName_dishside(String name_dishside) {
        this.name_dishside = name_dishside;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice_dishside() {
        return price_dishside;
    }

    public void setPrice_dishside(int price_dishside) {
        this.price_dishside = price_dishside;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
