import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//            버스정보확인
        Bus bus = new Bus(10, 5, 500, 20, 10);
        bus.show_info();
        bus.run();


        while (bus.getBus_status() != Bus_status.GARAGE) {
            Scanner sc = new Scanner(System.in);
            System.out.print("탑승할 승객을 입력해주세요:");
            int passenger = sc.nextInt();
            bus.take(passenger);
            System.out.print("변경할 속도를 입력해주세요:");
            int speed = sc.nextInt();
            bus.change_speed(speed);


//              택시 정보 확인

//            Taxi taxi = new Taxi(15,20);
//            taxi.show_info();
//
//            boolean pay =true;
//
//            taxi.run();
//
//            while(taxi.getFuel()>10){
//                Scanner sc = new Scanner(System.in);
//                System.out.print("손님을 태우시려면 1을 입력해주세요:");
//                int take_passenger = sc.nextInt();
//                if(take_passenger != 1){
//                    System.out.println("손님을 태우지 않았습니다.");
//                    continue;
//                }
//                taxi.take();
//
//
//                if(pay){
//                    System.out.print("목적지를 입력해주세요:");
//                    String destination = sc.next();
//                    taxi.setDestination(destination);
//
//                    System.out.print("목적지 까지의 거리를 입력해주세요:");
//                    int destination_distance = sc.nextInt();
//                    taxi.setDestination_distance(destination_distance);
//
//                    System.out.print("변경할 속도를 입력해주세요:");
//                    int speed = sc.nextInt();
//                    taxi.change_speed(speed);
//                    if(taxi.getCurrent_Speed() == 0){
//                        break;
//                    }
//
//                    System.out.print("추가할 거리당 요금을 입력해주세요:");
//                    int add_fee = sc.nextInt();
//                    taxi.add_fee(add_fee);
//                }
//
//                System.out.print("요금결제를 하시려면 1을 입력해주세요:");
//                int pay_fee = sc.nextInt();
//                if(pay_fee != 1){
//                    pay= false;
//                    continue;
//                }
//
//                taxi.last_fee();
//
//
//            }
        }
    }
}