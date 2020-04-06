import java.util.Scanner;

public class none {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a number : ");
        int number = scanner.nextInt();
        boolean check = true;
        if (number < 2) {
            System.out.println(number + " is not prime");
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0){
                    check = false;
                    break;
                }
            }
        }
        if (check == true){
            System.out.println(number + " is prime");
        }else {
            System.out.println(number + " is not prime");
        }
    }
}
