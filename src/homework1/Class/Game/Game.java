package homework1.Class.Game;

import homework1.Class.Food.Drink.Coffee;

import java.util.Scanner;

public class Game {
    private int score;
    private int time;
    private String managerName;
    private Scanner sc;
    public Game(){
        sc = new Scanner(System.in);
        this.score = 0;
        this.time=9;
    }

    public void start(){
        System.out.println("안녕하세요! 오늘부터 당신이 맡게 될 KaTeBu 카페입니다~");
        System.out.println("당신의 이름을 알려주세요!");
        this.managerName = sc.nextLine();
        System.out.println(managerName + " 매니저님! 환영합니다~! 지금부터 간단한 규칙 알려드리겠습니다");
        showManual();
        run();
    }
    private void run() {
        while (time < 19) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("현재 시간: " + time + ":00     현재 이익: " + score + "     매니저: " + managerName);
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 손님 맞이하기");
            System.out.println("2. 메뉴판 보기");
            System.out.println("3. 규칙 보기");
            System.out.println("4. 영업 종료하기");
            System.out.println("--------------------------------------------------------------");

            int command = sc.nextInt();
            sc.nextLine();
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
                default:
                    System.out.println("잘못된 명령어를 입력하셨습니다. 다시 시도해주세요.");
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
        System.out.println("  6-3. 모든 음료는 HOT, ICE를 선택할 수 있으나, 에이드는 무조건 ICE 밖에 제공안되는 점 명시해주세요");
        System.out.println("  6-4. 커피는 원두 종류를 선택할 수 있습니다! 고객의 요구사항에 맞는 원두를 선택해주세요");
        System.out.println("  6-5. 에이드는 휘핑크림 여부를 선택할 수 있습니다!");
        System.out.println("7. 그럼 화이팅해주세요!");
    }
    private void showMenu() {
        System.out.println("메뉴판:");
        System.out.println("1. 샌드위치 - 치킨 샌드위치, 계란 샌드위치");
        System.out.println("2. 케이크 - 생크림 케이크, 초콜릿 케이크");
        System.out.println("3. 커피 - 아메리카노, 에스프레소");
        System.out.println("4. 에이드 - 레몬에이드, 자몽에이드");
    }
    private void meetCustomer() {
        Customer customer = new Customer();
        for(String order : customer.getOrders()){
            System.out.print(order);
        }
        System.out.print("손님이 원하는 메뉴를 골라주세요!");

    }
    private void exitGame() {
        System.out.println("영업을 종료합니다. 최종 이익: " + score);
        if (score < 0) {
            System.out.println("해고되었습니다...");
        } else {
            System.out.println("오늘 하루도 수고하셨습니다!");
        }
    }
    private Coffee getCoffee(){
        System.out.println("손님이 원하는 커피는 무엇인가요? 선택지 외에 다른 것을 입력한다면, 주문하지 않음으로 처리됩니다. ");
        System.out.println("1. 주문하지 않았음");
        System.out.println("2. 아메리카노 ");
        System.out.println("3. 카페라테 ");
        int choice =sc.nextInt();
        if(choice ==2 || choice ==3){
            System.out.println
        }
    }

}
