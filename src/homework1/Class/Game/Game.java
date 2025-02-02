package homework1.Class.Game;

import homework1.Class.Food.Dessert.Cake;
import homework1.Class.Food.Dessert.Sandwich;
import homework1.Class.Food.Drink.Ade;
import homework1.Class.Food.Drink.Coffee;
import homework1.Class.Utill.InputHandler;

public class Game {
    private int score;
    private int time;
    private String managerName;
    public Game(){
        this.score = 0;
        this.time=9;
    }

    public void start() {
        System.out.println("안녕하세요! 오늘부터 당신이 맡게 될 KaTeBu 카페입니다~");
        System.out.println("당신의 이름을 알려주세요!");
        this.managerName = InputHandler.getStringInput();
        System.out.println(managerName + " 매니저님! 환영합니다~! 지금부터 간단한 규칙 알려드리겠습니다");
        showManual();
        run();
    }
    private void run() {
        while (time < 19) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("현재 시간: " + time + ":00     현재 이익: " + score + "원     매니저: " + managerName);
            System.out.println("1. 손님 맞이하기");
            System.out.println("2. 메뉴판 보기");
            System.out.println("3. 규칙 보기");
            System.out.println("4. 영업 종료하기");
            System.out.println("--------------------------------------------------------------");

            int command = InputHandler.getIntInput("행동을 입력해주세요.",1,4);
            switch (command) {
                case 1:
                    meetCustomer();
                    time++;
                    break;
                case 2:
                    showMenu();
                    break;
                case 3:
                    showManual();
                    break;
                case 4:
                    exitGame();
                    time = 20;
                    break;
            }
        }
    }
    private void showManual() {
        System.out.println("1. KaTeBu 카페 영업 시간은 9시부터 18시까지입니다.");
        System.out.println("2. KaTeBu 카페는 프리미엄 카페라 1시간에 한 번 예약된 손님을 받습니다.");
        System.out.println("3. 손님의 요구 사항에 맞춰 메뉴를 제공해 주세요.");
        System.out.println("4. 잘못된 메뉴를 제공하면 손실액만큼 이익이 차감됩니다.");
        System.out.println("  4-1. 저희 손님들은 자부심이 높기 때문에 서비스를 준다면, 자신을 무시했다고 생각해, 돈을 내지 않습니다.");
        System.out.println("5. 영업 종료 후 순이익이 마이너스면 해고되니 주의해주세요!");
        System.out.println("6. 다음은 각 메뉴의 체크리스트입니다.");
        System.out.println("  6-1. 디저트는 포크의 개수를 요구사항에 맞게 정확히 드려야합니다");
        System.out.println("  6-2. 샌드위치는 길이, 그리고 케이크는 사이즈를 요구사항에 맞게 정확히 드려야합니다.");
        System.out.println("  6-3. 모든 음료는 HOT, ICE를 선택할 수 있으나, 에이드는 무조건 \"ICE\" 밖에 제공안되는 점 명시해주세요");
        System.out.println("  6-4. 커피는 원두 종류를 선택할 수 있습니다! 고객의 요구사항에 맞는 원두를 선택해주세요");
        System.out.println("  6-5. 에이드는 휘핑크림 여부를 선택할 수 있습니다!");
        System.out.println("7. 그럼 화이팅해주세요!");
    }
    private void showMenu() {
        System.out.println("메뉴판:");
        System.out.println("1. 샌드위치 - 치킨 샌드위치, 계란 샌드위치 - 5,000 원 ");
        System.out.println("2. 케이크 - 생크림 케이크, 초콜릿 케이크 - 7,000 원");
        System.out.println("3. 커피 - 아메리카노, 에스프레소 - 3,000 원");
        System.out.println("4. 에이드 - 레몬에이드, 자몽에이드 - 4,000 원");
    }
    private void meetCustomer() {
        Customer customer = new Customer();
        System.out.println("--------------------------------------------------------------");
        for(String order : customer.getOrders()){
            System.out.print(order);
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("손님이 원하는 메뉴를 골라주세요!");
        Coffee coffee=new Coffee(0,0,"","","");
        coffee= coffee.getMenu();
        Ade ade=new Ade(0,0,"","",false);
        ade= ade.getMenu();
        Cake cake=new Cake(0,0,"",0,"");
        cake= cake.getMenu();
        Sandwich sandwich=new Sandwich(0,0,"",0,0);
        sandwich= sandwich.getMenu();

        showResult(customer,coffee,ade,sandwich,cake);
        System.out.println("--------------------------------------------------------------");
        if(isEqual(customer,coffee,ade,sandwich,cake)){
            System.out.println("결과 : 성공!");
            System.out.println("손님 : 감사합니다! 좋은 하루되세요~");
            score+= sum(coffee,ade,sandwich,cake);
        }else{
            System.out.println("결과 : 실패..");
            System.out.println("손님 : 제가 주문한게 아닌데요? 환불해주세요!");
            score -= sum(coffee,ade,sandwich,cake);;
        }
    }
    private void showResult(Customer customer,Coffee coffee,Ade ade, Sandwich sandwich ,Cake cake){
        Coffee customerCoffee = customer.getCoffee();
        Cake customerCake = customer.getCake();
        Ade customerAde = customer.getAde();
        Sandwich customerSandwich = customer.getSandwich();
        System.out.println("--------------------------------------------------------------");
        System.out.println("손님이 주문하신 것");
        System.out.println("커피 : " + customerCoffee.getName());
        System.out.println("   - 온도 : " +customerCoffee.getTemperature());
        System.out.println("   - 커피 원두 : "+ customerCoffee.getCoffeeBean());
        System.out.println("   - 수량 : "+customerCoffee.getAmount()+"잔");
        if(customerAde !=null){
            System.out.println("에이드 : " + customerAde.getName());
            System.out.println("   - 휘핑크림 여부 : "+ (customerAde.isWhipped()? "포함" : "미포함"));
            System.out.println("   - 수량 : "+customerAde.getAmount()+"잔");
        }
        if(customerCake!=null){
            System.out.println("케이크 : " + customerCake.getName());
            System.out.println("   - 사이즈 : "+ customerCake.getSize());
            System.out.println("   - 포크 개수 : "+ customerCake.getFork()+"개");
            System.out.println("   - 수량 : "+customerCake.getAmount()+"개");
        }
        if(customerSandwich!=null){
            System.out.println("샌드위치 : " + customerSandwich.getName());
            System.out.println("   - 길이 : "+ customerSandwich.getLength()+"Cm");
            System.out.println("   - 포크 개수 : "+ customerSandwich.getFork()+"개");
            System.out.println("   - 수량 : "+customerSandwich.getAmount()+"개");
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("매니저님이 선택하신 것");
        if(coffee!=null){
            System.out.println("커피 : " + coffee.getName());
            System.out.println("   - 온도 : " +coffee.getTemperature());
            System.out.println("   - 커피 원두 : "+ coffee.getCoffeeBean());
            System.out.println("   - 수량 : "+coffee.getAmount()+"잔");
        }
        if(ade !=null){
            System.out.println("에이드 : " + ade.getName());
            System.out.println("   - 휘핑크림 여부 : "+ (ade.isWhipped()? "포함" : "미포함"));
            System.out.println("   - 수량 : "+ade.getAmount()+"잔");
        }
        if(cake!=null){
            System.out.println("케이크 : " + cake.getName());
            System.out.println("   - 사이즈 : "+ cake.getSize());
            System.out.println("   - 포크 개수 : "+ cake.getFork()+"개");
            System.out.println("   - 수량 : "+cake.getAmount()+"개");
        }
        if(sandwich!=null) {
            System.out.println("케이크 : " + sandwich.getName());
            System.out.println("   - 길이 : " + sandwich.getLength() + "Cm");
            System.out.println("   - 포크 개수 : " + sandwich.getFork() + "개");
            System.out.println("   - 수량 : " + sandwich.getAmount() + "개");
        }

    }
    private int sum(Coffee coffee,Ade ade, Sandwich sandwich ,Cake cake){
        int totalPrice = 0;
        if (coffee != null) {
            totalPrice += coffee.getPrice() * coffee.getAmount();
        }
        if (ade != null){
            totalPrice += ade.getPrice() * ade.getAmount();
        }
        if (sandwich != null){
            totalPrice += sandwich.getPrice() * sandwich.getAmount();
        }
        if (cake != null){
            totalPrice += cake.getPrice() * cake.getAmount();
        }
        return totalPrice;
    }
    private boolean isEqual(Customer customer, Coffee coffee, Ade ade, Sandwich sandwich, Cake cake) {
        Coffee customerCoffee = customer.getCoffee();
        Cake customerCake = customer.getCake();
        Ade customerAde = customer.getAde();
        Sandwich customerSandwich = customer.getSandwich();
        boolean coffeeMatch=false;
        boolean adeMatch=false;
        boolean sandwichMatch=false;
        boolean cakeMatch=false;

        if(customerCoffee!=null && coffee!=null) {
            coffeeMatch = customerCoffee.getName().equals(coffee.getName()) &&
                    customerCoffee.getTemperature().equals(coffee.getTemperature()) &&
                    customerCoffee.getCoffeeBean().equals(coffee.getCoffeeBean()) &&
                    customerCoffee.getAmount() == coffee.getAmount();
        } else if(customerCoffee==null && coffee==null) {
            coffeeMatch = true;
        }
        if(customerAde!=null && ade!=null) {
            adeMatch = customerAde.getName().equals(ade.getName()) &&
                customerAde.getTemperature().equals(ade.getTemperature()) &&
                customerAde.isWhipped()==ade.isWhipped() &&
                customerAde.getAmount()==ade.getAmount();
        }else if(customerAde==null && ade==null) {
            adeMatch = true;
        }
        if(customerSandwich!=null && sandwich!=null) {
            sandwichMatch= customerSandwich.getName().equals(sandwich.getName()) &&
                customerSandwich.getLength() == sandwich.getLength() &&
                customerSandwich.getFork() == sandwich.getFork() &&
                customerSandwich.getAmount() == sandwich.getAmount();
        }else if(customerSandwich==null && sandwich==null) {
            sandwichMatch = true;
        }

        if(customerCake!=null && cake!=null) {
            cakeMatch = customerCake.getName().equals(cake.getName()) &&
                customerCake.getSize().equals(cake.getSize()) &&
                customerCake.getFork() == cake.getFork() &&
                customerCake.getAmount()==cake.getAmount();
        }else if(customerCake==null && cake==null) {
            cakeMatch = true;
        }




        return coffeeMatch && adeMatch && sandwichMatch && cakeMatch;
    }
    private void exitGame() {
        System.out.println("영업을 종료합니다. 최종 이익: " + score+"원");
        if (score <= 0) {
            System.out.println("해고되었습니다...");
        } else {
            System.out.println("오늘 하루도 수고하셨습니다!");
        }
    }


}
