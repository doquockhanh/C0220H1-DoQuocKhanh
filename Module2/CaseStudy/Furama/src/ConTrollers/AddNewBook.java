package ConTrollers;

import java.io.*;
import java.util.Scanner;

public class AddNewBook {
    public AddNewBook() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String[][] listCustomer = new String[10][10];
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\Customer.csv");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            String line = "";

            // doc file gi gia tri vao mang listCustomer va hien thi ra man hinh

            while ((line = dataInputStream.readLine()) != null) {
                String cusInfo = count + 1 + "," + line;
                String[] array = cusInfo.split(",", 10);
                for (int i = 0; i < array.length; i++) {
                    listCustomer[count][i] = array[i];
                    System.out.print(listCustomer[count][i] + "|");
                }
                System.out.println();
                count++;
            }

            System.out.println();
            System.out.println();
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

        //chon khach hang book
        System.out.println("chon khach hang muon dat dich vu theo so thu tu");
        int idCusBooking = scanner.nextInt();
        for (int i = 0; i < listCustomer.length; i++) {
            if ((idCusBooking + "").equals(listCustomer[i][0])) {
                System.out.print("dat dich vu cho khach hang " + "\"" + listCustomer[i][1] + "\"");
                break;
            }
        }
        System.out.println();

        //chon dich vu

        int a;
        do {
            System.out.println("1.\tBooking Villa\n" +
                    "2.\tBooking House\n" +
                    "3.\tBooking Room\n");
            System.out.println();
            a = scanner.nextInt();
            switch (a) {
                case 1:
                    try {
                        FileInputStream fileInputStream = new FileInputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\Villa.csv");
                        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

                        String line = "";
                        while ((line = dataInputStream.readLine()) != null) {
                            System.out.println(line);
                        }
                        fileInputStream.close();
                        dataInputStream.close();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        FileInputStream fileInputStream = new FileInputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\House.csv");
                        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

                        String line = "";
                        while ((line = dataInputStream.readLine()) != null) {
                            System.out.println(line);
                        }

                        fileInputStream.close();
                        dataInputStream.close();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        FileInputStream fileInputStream = new FileInputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\Room.csv");
                        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

                        String line = "";
                        while ((line = dataInputStream.readLine()) != null) {
                            System.out.println(line);
                        }

                        fileInputStream.close();
                        dataInputStream.close();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                default:
                    a = -1;
            }
        } while (a == -1);


        // ghi du lieu customer booking vao file
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\Booking.csv", true);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

            dataOutputStream.writeBytes(listCustomer[idCusBooking][1] + ",");
            dataOutputStream.writeBytes(listCustomer[idCusBooking][2] + ",");
            dataOutputStream.writeBytes(listCustomer[idCusBooking][3] + ",");
            dataOutputStream.writeBytes(listCustomer[idCusBooking][4] + ",");
            dataOutputStream.writeBytes(listCustomer[idCusBooking][5] + ",");
            dataOutputStream.writeBytes(listCustomer[idCusBooking][6] + ",");
            dataOutputStream.writeBytes(listCustomer[idCusBooking][7] + ",");
            dataOutputStream.writeBytes(listCustomer[idCusBooking][9] + ",");
            dataOutputStream.writeBytes(listCustomer[idCusBooking][10]);
            dataOutputStream.writeBytes("\n");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
