package homework1.Class.Food.Dessert;

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
                    .append(getAmount())
                    .append("개 주세요. ")
                    .append("포크는 ")
                    .append(getPork())
                    .append("개 주세요. \n");
        return sb.toString();
    }
}
