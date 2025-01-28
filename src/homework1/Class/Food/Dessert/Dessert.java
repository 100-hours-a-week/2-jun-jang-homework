package homework1.Class.Food.Dessert;

import homework1.Class.Food.Food;

public class Dessert extends Food {
    private int pork;
    public Dessert(int price, int amount,String name,int pork) {
        super(price,amount,name);
        this.pork = pork;
    }
    public int getPork() {
        return pork;
    }
}
