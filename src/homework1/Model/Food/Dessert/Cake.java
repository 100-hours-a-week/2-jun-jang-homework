package homework1.Model.Food.Dessert;

import homework1.Utill.InputHandler;

public class Cake extends Dessert{
    private String size;
    public Cake(int price, int amount,String name,int pork,String size){
        super(price,amount,name,pork);
        this.size = size;
    }
    public String getSize(){
        return size;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Cake cake = (Cake) obj;
        return this.getAmount() == cake.getAmount() &&
                this.getName().equals(cake.getName()) &&
                this.getSize().equals(cake.getSize()) &&
                this.getFork() == cake.getFork();
    }
    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("그리고 케이크는 ")
                .append(getName())
                .append("로 ")
                .append("사이즈는 ")
                .append(getSize())
                .append("로 ")
                .append("포크는 ")
                .append(getFork())
                .append("개 주시고요. ")
                .append(getAmount())
                .append("개 주세요! \n");
        return sb.toString();
    }

    @Override
    public Cake getMenu() {
        String[] cakeNames = {"딸기 케이크", "초콜릿 케이크"};
        String[] cakeSizes = {"small", "medium", "large"};

        int cakeChoice = InputHandler.getIntInput("손님이 원하는 케이크는 무엇인가요?\n1. 딸기 케이크\n2. 초콜릿 케이크\n3. 주문하지 않음", 1, 3);
        if (cakeChoice == 3) {
            return null;
        }
        String cakeName = cakeNames[cakeChoice - 1];
        int sizeChoice = InputHandler.getIntInput("사이즈를 선택해주세요\n1. small\n2. medium\n3. large", 1, 3);
        String cakeSize = cakeSizes[sizeChoice - 1];
        int forkCount = InputHandler.getIntInput("포크 개수를 입력해주세요.", 1, 100);
        int amountChoice = InputHandler.getIntInput("마지막으로 몇 개 시키셨나요?", 1, 100);
        return new Cake(7000, amountChoice, cakeName, forkCount, cakeSize);
    }

}
