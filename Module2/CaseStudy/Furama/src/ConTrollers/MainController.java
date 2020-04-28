package ConTrollers;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        new MainController();
    }

    public MainController() {
        Scanner scanner = new Scanner(System.in);
        int numberSelect = 0;
        while (numberSelect > -1) {
            try {
                System.out.println("1.\tAdd New Services\n" +
                        "2.\tShow Services\n" +
                        "3.\tAdd New Customer\n" +
                        "4.\tShow Information of Customer\n" +
                        "5.\tAdd New Booking\n" +
                        "6.\tShow Information of Employee\n" +
                        "7.\tExit\n");
                System.out.println();
                System.out.print("choose action: ");
                numberSelect = scanner.nextInt();
                System.out.println();

                switch (numberSelect) {
                    case 1:
                        new AddNewServices();
                        break;
                    case 2:
                        new ShowServices();
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    case 3:
                        new AddNewCustomer();
                        break;
                    case 4:
                        new ShowListCustomer();
                        break;
                    case 5:
                        new AddNewBook();
                        break;
                    case 6:
                        new ShowAllEmployee();
                        break;
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("vui long nhap dung!");
                System.out.println();
                new MainController();
            }
        }
    }
}
