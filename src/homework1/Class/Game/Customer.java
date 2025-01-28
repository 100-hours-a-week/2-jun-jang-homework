package homework1.Class.Game;

import homework1.Class.Food.Dessert.Cake;
import homework1.Class.Food.Dessert.Sandwich;
import homework1.Class.Food.Drink.Ade;
import homework1.Class.Food.Drink.Coffee;
import homework1.Class.Food.Drink.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer {
    private final List<String> orders=  new ArrayList<>();
    private Coffee coffee;
    private Ade ade=null;
    private Cake cake=null;
    private Sandwich sandwich=null;

    //커피 주문 프리셋, 커피는 무조건 주문한다.
    String[] coffeeNames={"아메리카노", "카페라테"};
    String[] coffeeTemperatures={"HOT","ICE"};
    String[] coffeeBeans={"아라비아타","로부스타"};

    public Customer(){
        Random rand = new Random();

        // 커피 생성
        coffee = createCoffee(rand);
        orders.add(coffee.getDescription());

        // 에이드 생성 여부
        if (rand.nextBoolean()) {
            ade = createAde(rand);
            orders.add(ade.getDescription());
        }

        // 케이크 생성 여부
        if (rand.nextBoolean()) {
            cake = createCake(rand);
            orders.add(cake.getDescription());
        }

        // 샌드위치 생성 여부
        if (rand.nextBoolean()) {
            sandwich = createSandwich(rand);
            orders.add(sandwich.getDescription());
        }

    }

    public Coffee getCoffee() {
        return coffee;
    }

    public Ade getAde() {
        return ade;
    }
    public Cake getCake() {
        return cake;
    }
    public Sandwich getSandwich() {
        return sandwich;
    }


    public List<String> getOrders() {
        return orders;
    }

    private Coffee createCoffee(Random rand) {
        String[] coffeeNames = {"아메리카노", "카페라테"};
        String[] coffeeTemperatures = {"HOT", "ICE"};
        String[] coffeeBeans = {"아라비아타", "로부스타"};
        String name = coffeeNames[rand.nextInt(coffeeNames.length)];
        String temperature = coffeeTemperatures[rand.nextInt(coffeeTemperatures.length)];
        String bean = coffeeBeans[rand.nextInt(coffeeBeans.length)];
        int price = 3000;
        int amount = rand.nextInt(5) + 1;
        return new Coffee(price, amount, name, temperature, bean);
    }

    private Ade createAde(Random rand) {
        String[] adeNames = {"레몬에이드", "자몽에이드"};
        boolean isWhipped = rand.nextBoolean();
        String name = adeNames[rand.nextInt(adeNames.length)];
        int price = 4000;
        int amount = rand.nextInt(5) + 1;
        return new Ade(price, amount, name, isWhipped);
    }

    private Cake createCake(Random rand) {
        String[] cakeNames = {"딸기 케이크", "초콜릿 케이크"};
        String[] sizes = {"small", "medium", "large"};
        String name = cakeNames[rand.nextInt(cakeNames.length)];
        String size = sizes[rand.nextInt(sizes.length)];
        int forkCount = rand.nextInt(3) + 1;
        int price = 7000;
        int amount = rand.nextInt(5) + 1;
        return new Cake(price, amount, name, forkCount, size);
    }

    private Sandwich createSandwich(Random rand) {
        String[] sandwichNames = {"치킨 샌드위치", "계란 샌드위치"};
        int[] lengths = {15, 30};
        String name = sandwichNames[rand.nextInt(sandwichNames.length)];
        int length = lengths[rand.nextInt(lengths.length)];
        int forkCount = rand.nextInt(3) + 1;
        int price = 5000;
        int amount = rand.nextInt(5) + 1;
        return new Sandwich(price, amount, name, forkCount, length);
    }
}
