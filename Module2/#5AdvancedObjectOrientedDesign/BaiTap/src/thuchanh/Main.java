    package thuchanh;

public class Main {
    public static void main(String[] args) {
        animal[] animals = new animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].makeSound());
        }
    }
}

