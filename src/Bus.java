import java.util.UUID;

public class Bus {
    private int max_passenger;
    private int current_passenger;
    private int fee;
    private final String number;
    private int fuel;
    private int current_Speed;
    private Bus_status bus_status;

    public Bus(int max_passenger, int current_passenger, int fee, int fuel, int current_Speed){
        this.max_passenger = max_passenger;
        this.current_passenger = current_passenger;
        this.fee = fee;
        this.number = UUID.randomUUID().toString();
        this.fuel = fuel;
        this.current_Speed = current_Speed;
        this.bus_status = Bus_status.RUN;
        if(this.fuel<10){
            System.out.println("주유가 필요합니다");
            this.bus_status = Bus_status.GARAGE;
        }
    }

    public int getMax_passenger() {
        return max_passenger;
    }

    public int getCurrent_passenger() {
        return current_passenger;
    }

    public int getFee() {
        return fee;
    }

    public String getNumber() {
        return number;
    }

    public int getFuel() {
        return fuel;
    }

    public int getCurrent_Speed() {return current_Speed;}


    public Bus_status getBus_status() {
        return bus_status;
    }

    public void setMax_passenger(int max_passenger) {
        if(max_passenger<0){
            System.out.println("최대 승객수는 음수가 될수 없습니다");
        }else{
            this.max_passenger = max_passenger;
        }

    }

    public void setCurrent_passenger(int current_passenger) {
        if(current_passenger<0){
            System.out.println("현재 승객수는 0보다 작을수 없습니다");
        } else if (current_passenger>this.max_passenger) {
            System.out.println("현재 승객수가 최대 승객수를 넘을 수 없습니다.");
        }else{
            this.current_passenger = current_passenger;
            System.out.println("현재 승객수:"+getCurrent_passenger());
        }

    }

    public void setFee(int fee) {
        if(fee<0){
            System.out.println("요금은 음수가 될수 없습니다.");
        }else{
            this.fee = fee;
        }
    }

    public void setFuel(int fuel) {
        if(fuel<0){
            System.out.println("주유량은 음수가 될수 없습니다");
        }else{
            this.fuel = fuel;
            System.out.println("주유량:"+this.fuel);
        }
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
        System.out.println("현재 속도:"+getCurrent_Speed());
    }

    public void setBus_status(Bus_status bus_status) {
        this.bus_status = bus_status;
    }

    public void run(){
        if(this.fuel<10){
            System.out.println("주유량이 부족하여 운행 할 수 없습니다");
        }else{
            setBus_status(Bus_status.RUN);
            System.out.println("운행을 시작합니다.");
        }
    }

    public void quit_run(){
        setBus_status(Bus_status.GARAGE);
    }

    public void take(int passenger){
        if(this.bus_status == Bus_status.GARAGE){
            System.out.println("차량 운행이 중단되어 승객을 태울 수 없습니다.");
            return;
        }

        setCurrent_passenger(this.current_passenger+passenger);

    }

    public void change_speed(int speed){
        if(this.fuel<10){
            System.out.println("주유량이 부족하여 운행할수 없습니다.");
            quit_run();
        }else{
            System.out.println("주유량을 확인해주세요");
            setCurrent_Speed(this.current_Speed+speed);
            setFuel(fuel-1);
            if(this.fuel<10){
                System.out.println("주유량이 부족하여 운행할수 없습니다.");
                quit_run();
            }

        }

    }

    public void show_info(){
        System.out.println("최대 승객수:"+this.getNumber());
        System.out.println("현재 승객수:"+this.getFuel());
        System.out.println("요금:"+this.getFee());
        System.out.println("버스 번호:"+this.getNumber());
        System.out.println("주유량:"+this.getFuel());
        System.out.println("현재 속도:"+this.getCurrent_Speed());
        System.out.println("상태:"+this.getBus_status());

    }

}
