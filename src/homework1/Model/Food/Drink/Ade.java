package homework1.Model.Food.Drink;

import homework1.Utill.InputHandler;

public class Ade extends Drink {
    private boolean isWhipped;
    public Ade(int price, int amount, String name, String temperature, boolean isWhipped) {
        super(price,amount,name,"ICE");
        this.isWhipped = isWhipped;
    }
    public boolean isWhipped() {
        return isWhipped;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Ade ade = (Ade) obj;
        return this.getAmount() == ade.getAmount() &&
                this.getName().equals(ade.getName()) &&
                this.getTemperature().equals(ade.getTemperature()) &&
                this.isWhipped() == ade.isWhipped();
    }
    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("그리고 ")
                    .append(getName())
                    .append(" ")
                    .append(getAmount())
                    .append("잔 주세요. ");
            if(isWhipped()){
                sb.append("휘핑크림은 올려주세요!\n");
            }else{
                sb.append("휘핑크림은 빼고요! \n");
            }
        return sb.toString();
    }

    @Override
    public Ade getMenu() {
        String[] adeNames = {"레몬에이드", "자몽에이드"};
        String[] adeTemperatures={"HOT","ICE"};
        int drinkChoice = InputHandler.getIntInput("손님이 원하는 에이드는 무엇인가요?\n1. 레몬에이드\n2. 자몽에이드\n3. 주문하지 않음", 1, 3);
        if(drinkChoice==3){
            return null;
        }
        String adeName=adeNames[drinkChoice-1];
        int tempChoice = InputHandler.getIntInput("ICE 인가요? HOT 인가요?\n1. ICE\n2. HOT", 1, 2);
        String temperature=adeTemperatures[tempChoice-1];
        boolean isWhipped = InputHandler.getBooleanInput("휘핑크림을 추가할까요?");
        int amountChoice = InputHandler.getIntInput("마지막으로 몇 잔 시키셨나요?", 1, 10);

        return new Ade(4000,amountChoice,adeName,temperature,isWhipped);
    }
}
