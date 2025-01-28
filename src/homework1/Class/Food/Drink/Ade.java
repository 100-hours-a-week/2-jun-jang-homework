package homework1.Class.Food.Drink;

public class Ade extends Drink {
    private boolean isWhipped;
    public Ade(int price, int amount, String name, boolean isWhipped) {
        super(price,amount,name,"ICE");
        this.isWhipped = isWhipped;
    }
    public boolean isWhipped() {
        return isWhipped;
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
}
