package homework1.Class.Food.Dessert;

import homework1.Class.Utill.InputHandler;

import java.util.Scanner;

public class Sandwich extends Dessert{
    private int length;
    public Sandwich(int price, int amount,String name,int pork,int length){
        super(price,amount,name,pork);
        this.length = length;
    }
    public int getLength() {
        return this.length;
    }
    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("그리고 샌드위치는 ")
                    .append(getName())
                    .append("로 ")
                    .append("길이는 ")
                    .append(getLength())
                    .append("cm 로 ")
                    .append("포크는 ")
                    .append(getFork())
                    .append("개 주시고요. ")
                    .append(getAmount())
                    .append("개 주세요! \n");
        return sb.toString();
    }

    @Override
    public Sandwich getMenu() {
        String[] sandwichNames = {"치킨 샌드위치", "계란 샌드위치"};
        int[] sandwichLengths = {15, 30};
        int sandwichChoice = InputHandler.getIntInput("손님이 원하는 샌드위치는 무엇인가요?\n1. 치킨 샌드위치\n2. 계란 샌드위치\n3. 주문하지 않음", 1, 3);
        if (sandwichChoice == 3) return null;  // 주문하지 않음 처리
        String sandwichName = sandwichNames[sandwichChoice - 1];
        int lengthChoice = InputHandler.getIntInput("샌드위치 길이를 선택해주세요\n1. 15cm\n2. 30cm", 1, 2);
        int sandwichLength = sandwichLengths[lengthChoice - 1];
        int forkCount = InputHandler.getIntInput("포크 개수를 입력해주세요.", 1, 10);
        int amountChoice = InputHandler.getIntInput("마지막으로 몇 개 시키셨나요?", 1, 10);
        return new Sandwich(5000, amountChoice, sandwichName, forkCount, sandwichLength);
    }
}
