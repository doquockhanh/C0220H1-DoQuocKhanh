package BaiTap;

public class XayDungLopFan {
    int speed;
    double radius;
    boolean status;
    String color;

    public XayDungLopFan(int speed, double radius, boolean status, String color) {
        this.speed = speed;
        this.radius = radius;
        this.status = status;
        this.color = color;
    }

    public String display(){
        if (this.status == true){
            return "speed : " + setSpeed(speed) +"\ncolor : " + color + "\nradius : " + radius + "\nFan is on";
        }else {
            return"color : " + color + "\nradius : " + radius + "\nFan is off";
        }
    }

    public String setSpeed(int speed) {
        this.speed = speed;
        if (this.speed == 1) {
            return "SLOW";
        } else if (this.speed == 2) {
            return "MEDIUM";
        } else if (this.speed == 3) {
            return "FAST";
        }else return "SLOW";
    }

    public static void main(String[] args) {
        XayDungLopFan fan1 = new XayDungLopFan(3,5,true,"red");
        XayDungLopFan fan2 = new XayDungLopFan( 5,5,false,"blue");
        System.out.println(fan1.display());
        System.out.println(fan2.display());
    }
}

