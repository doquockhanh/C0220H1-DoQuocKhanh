package ConTrollers;

import java.util.LinkedList;
import java.util.Queue;

public class Cinema {
    public static void main(String[] args) {
        Queue<String> customerReservation = new LinkedList<>();
        addCustomer(customerReservation,"khanh");
        addCustomer(customerReservation, "huy");
        printTicket(customerReservation);
    }

    static void addCustomer(Queue customerReservation, String nameCustomer){
        customerReservation.add(nameCustomer);
    }

    static void printTicket(Queue customerReservation){
        int indexCustomer = 0;
        System.out.println("thu tu khach hang mua ve : ");
        while (customerReservation.peek() != null) {
            indexCustomer++;
            System.out.println(indexCustomer + " " + customerReservation.poll());
        }
    }
}
