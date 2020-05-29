package ConTrollers;

import java.io.*;
import java.util.Scanner;

public class AddNewBook {
    public AddNewBook() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String[][] listCustomer = new String[10][10];
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\CODEGYM\\Module2\\CaseStudy\\Furama\\src\\ConTrollers\\Data\\Customer.csv");
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


        do {
            int index = 0;
            String[] b = new String[100];
            System.out.println("1.\tBooking Villa\n" +
                    "2.\tBooking House\n" +
                    "3.\tBooking Room\n");
            System.out.println();
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    try {
                        FileInputStream fileInputStream = new FileInputStream("D:\\CODEGYM\\Module2\\CaseStudy\\Furama\\src\\ConTrollers\\Data\\Villa.csv");
                        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

                        String line = "";
                        while ((line = dataInputStream.readLine()) != null) {
                            String[] c = line.split(",", 10);
                            b[index] = c[0];
                            index++;
                            System.out.println(index + " " + line);
                        }
                        fileInputStream.close();
                        dataInputStream.close();
                        try {
                            System.out.println("chon dich vu muon dat");

                            FileOutputStream fileOutputStream = new FileOutputStream("D:\\CODEGYM\\Module2\\CaseStudy\\Furama\\src\\ConTrollers\\Data\\Booking.csv", true);
                            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

                            dataOutputStream.writeBytes(listCustomer[idCusBooking - 1][1] + ",");
                            dataOutputStream.writeBytes("Villa" + ",");
                            dataOutputStream.writeBytes(b[scanner.nextInt() - 1]);
                            dataOutputStream.writeBytes("\n");
                            System.out.println("da them thanh cong !");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        FileInputStream fileInputStream = new FileInputStream("D:\\CODEGYM\\Module2\\CaseStudy\\Furama\\src\\ConTrollers\\Data\\House.csv");
                        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

                        String line = "";
                        while ((line = dataInputStream.readLine()) != null) {
                            String[] c = line.split(",", 10);
                            b[index] = c[0];
                            index++;
                            System.out.println(index + " " + line);
                        }

                        fileInputStream.close();
                        dataInputStream.close();
                        try {
                            System.out.println("chon dich vu muon dat");

                            FileOutputStream fileOutputStream = new FileOutputStream("D:\\CODEGYM\\Module2\\CaseStudy\\Furama\\src\\ConTrollers\\Data\\Booking.csv", true);
                            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

                            dataOutputStream.writeBytes(listCustomer[idCusBooking - 1][1] + ",");
                            dataOutputStream.writeBytes("House" + ",");
                            dataOutputStream.writeBytes(b[scanner.nextInt() - 1]);
                            dataOutputStream.writeBytes("\n");
                            System.out.println("da them thanh cong !");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        FileInputStream fileInputStream = new FileInputStream("D:\\CODEGYM\\Module2\\CaseStudy\\Furama\\src\\ConTrollers\\Data\\Room.csv");
                        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

                        String line = "";
                        while ((line = dataInputStream.readLine()) != null) {
                            String[] c = line.split(",", 10);
                            b[index] = c[0];
                            index++;
                            System.out.println(index + " " + line);
                        }

                        fileInputStream.close();
                        dataInputStream.close();
                        try {
                            System.out.println("chon dich vu muon dat");

                            FileOutputStream fileOutputStream = new FileOutputStream("D:\\CODEGYM\\Module2\\CaseStudy\\Furama\\src\\ConTrollers\\Data\\Booking.csv", true);
                            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

                            dataOutputStream.writeBytes(listCustomer[idCusBooking - 1][1] + ",");
                            dataOutputStream.writeBytes("Room" + ",");
                            dataOutputStream.writeBytes(b[scanner.nextInt() - 1]);
                            dataOutputStream.writeBytes("\n");
                            System.out.println("da them thanh cong !");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
            }
            if (a == 1 || a == 2 || a == 3) {
                break;
            }
        } while (true);
    }
}
