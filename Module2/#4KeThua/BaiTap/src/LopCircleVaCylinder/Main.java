package LopCircleVaCylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("green",2);
        System.out.println(circle.toString());
        Cylinder cylinder = new Cylinder("green",2,2);
        System.out.println(cylinder.toString());
    }
}
