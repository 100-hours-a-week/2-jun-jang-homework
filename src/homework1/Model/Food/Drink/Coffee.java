package homework1.Model.Food.Drink;

import homework1.Utill.InputHandler;

public class Coffee extends Drink{
    private String coffeeBean;

    public Coffee(int price, int amount , String name, String temperature, String coffeeBean) {
        super(price, amount, name, temperature);
        this.coffeeBean = coffeeBean;
    }
    public String getCoffeeBean() {
        return coffeeBean;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Coffee coffee = (Coffee) obj;
        return this.getAmount() == coffee.getAmount() &&
                this.getName().equals(coffee.getName()) &&
                this.getTemperature().equals(coffee.getTemperature()) &&
                this.getCoffeeBean().equals(coffee.getCoffeeBean());
    }

    @Override
    public String getDescription() {
        StringBuilder sb=new StringBuilder();
        sb.append("안녕하세요! 먼저 커피는 ")
                .append(getName())
                .append(" 로 주시고, ")
                .append(getTemperature())
                .append("로 해주세요. 아 원두는 ")
                .append(getCoffeeBean())
                .append("로 해주시고 ")
                .append(getAmount())
                .append("잔 주세요. \n");

        return sb.toString();
    }

    @Override
    public Coffee getMenu() {
        String[] coffeeNames={"아메리카노", "카페라테"};
        String[] coffeeTemperatures={"ICE","HOT"};
        String[] coffeeBeans={"아라비아타","로부스타"};

        int drinkChoice = InputHandler.getIntInput("손님이 원하는 커피는 무엇인가요?\n1. 아메리카노\n2. 카페라테\n3.주문하지 않음.", 1, 3);

        if(drinkChoice==3) {
            return null;
        }

        String coffeeName=coffeeNames[drinkChoice-1];

        int tempChoice = InputHandler.getIntInput("ICE 인가요? HOT 인가요?\n1. ICE\n2. HOT", 1, 2);
        String temperature=coffeeTemperatures[tempChoice-1];

        int beanChoice = InputHandler.getIntInput("원두 종류는 무엇인가요?\n1. 아라비아타\n2. 로부스타", 1, 2);
        String coffeeBean=coffeeBeans[beanChoice-1];
        int amountChoice = InputHandler.getIntInput("마지막으로 몇 잔 시키셨나요?", 1, 10000);

        return new Coffee(3000,amountChoice,coffeeName,temperature,coffeeBean);
    }
}
