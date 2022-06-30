import java.util.UUID;

public class Taxi {
    private final String number;
    private int fuel;
    private int current_Speed;

    private String destination;
    private final int default_distance;

    private int destination_distance;
    private final int default_fee;
    private int fee_per_distance;
    Taxi_status taxi_status;

    public Taxi(int fuel, int current_Speed){
        this.number = UUID.randomUUID().toString();
        this.fuel = fuel;
        this.current_Speed = current_Speed;
        this.destination = "";
        this.default_distance = 10;
        this.destination_distance = 0;
        this.default_fee = 3000;
        this.fee_per_distance = 1000;
        this.taxi_status = Taxi_status.NORMAL;
        if(this.fuel<10){
            System.out.println("주유가 필요합니다");
        }
    }

    public String getNumber() {
        return number;
    }

    public int getFuel() {
        return fuel;
    }

    public int getCurrent_Speed() {
        return current_Speed;
    }

    public String getDestination() {return destination;}

    public int getDefault_distance() {
        return default_distance;
    }

    public int getDestination_distance() {
        return destination_distance;
    }

    public  int getDefault_fee() {
        return default_fee;
    }

    public int getFee_per_distance() {
        return fee_per_distance;
    }

    public Taxi_status getTaxi_status() {
        return taxi_status;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFuel(int fuel) {
        if(fuel<0){
            System.out.println("주유량은 음수가 될수 없습니다");
        }else{
            this.fuel = fuel;
            System.out.println("주유량을 확인해주세요");
            System.out.println("주유량:"+this.fuel);
        }
    }

    public void setTaxi_status(Taxi_status taxi_status) {
        this.taxi_status = taxi_status;
    }

    public void setCurrent_Speed(int current_Speed) {
        if(current_Speed<0){
            System.out.println("속도값을 음수로 할수 없습니다.");
        } else if (current_Speed==0) {
            System.out.println("속도가 0이되어 운행을 중단합니다");
            this.current_Speed = current_Speed;

        }else{
            this.current_Speed = current_Speed;
        }
        System.out.println("현재 속도:"+this.current_Speed);
    }


    public void setDestination_distance(int destination_distance) {
        if(destination_distance<0){
            System.out.println("잘못된 목적지 거리입니다");
            return;
        }
        this.destination_distance = destination_distance;
    }

    public void setFee_per_distance(int fee_per_distance) {
        if(fee_per_distance>=0){
            this.fee_per_distance = fee_per_distance;
            System.out.println("현재 거리당 요금은:"+ fee_per_distance);
        }else{
            System.out.println("거리당 요금은 음수가 될수 없습니다");
        }
    }

    public void run(){
        if(this.fuel<10){
            System.out.println("주유량이 적어 운행할수 없습니다.");
        }else{
            System.out.println("운행을 시작 합니다.");
        }
    }

    public void take(){
        if(this.taxi_status == Taxi_status.RUNNING){
            System.out.println("손님이 타고있어 다른 손님이 탑승 불가합니다.");
            return;
        }
        System.out.println("손님을 태웠습니다.");
        setTaxi_status(Taxi_status.RUNNING);

    }

    public void quit_run(){
        System.out.println("운행을 중단합니다.");
    }

    public void change_speed(int speed){
        if(fuel<10){
            System.out.println("주유량이 부족하여 운행할수 없습니다.");
            quit_run();
        }else{
            setFuel(fuel-1);
            setCurrent_Speed(current_Speed+speed);
        }

    }


    public void last_fee(){

        if(destination_distance<default_distance){
            System.out.println(default_fee);
            return;
        }
        int last_fee = default_fee + fee_per_distance*(destination_distance-default_distance);
        System.out.println("결제된 금액은"+last_fee+"입니다");
        setTaxi_status(Taxi_status.NORMAL);

    }

    public void add_fee(int add_fee_per_distance){
        setFee_per_distance(fee_per_distance+add_fee_per_distance);
        System.out.println("거리당 요금이"+add_fee_per_distance+"만큼 추가되었습니다.");
    }

    public void show_info(){
        System.out.println("택시 번호:"+this.getNumber());
        System.out.println("주유량:"+this.getFuel());
        System.out.println("현재 속도:"+this.getCurrent_Speed());
        System.out.println("목적지:"+this.getDestination());
        System.out.println("기본거리:"+this.getDefault_distance());
        System.out.println("목적지까지의 거리:"+this.getDestination_distance());
        System.out.println("기본 요금:"+this.getDefault_fee());
        System.out.println("거리당 요금:"+this.getFee_per_distance());
        System.out.println("상태:"+this.getTaxi_status());
    }


}
