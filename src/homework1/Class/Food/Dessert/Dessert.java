package homework1.Class.Food.Dessert;

import homework1.Class.Food.Food;

public abstract class Dessert extends Food {
    private int fork;
    public Dessert(int price, int amount,String name,int pork) {
        super(price,amount,name);
        this.fork = pork;
    }
    public int getFork() {
        return fork;
    }

}
