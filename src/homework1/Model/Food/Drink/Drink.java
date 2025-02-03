package homework1.Model.Food.Drink;

import homework1.Model.Food.Food;

public abstract class Drink extends Food {
    private String temperature;

    public Drink(int price, int amount , String name, String temperature) {
        super(price, amount,name);
        this.temperature = temperature;
    }
    public String getTemperature() {
        return temperature;
    }



}
