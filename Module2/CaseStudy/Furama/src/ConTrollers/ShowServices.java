package ConTrollers;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class ShowServices {
    public ShowServices() {
        int numberSelect = 0;
        Scanner scanner = new Scanner(System.in);
        while (numberSelect > -1) {
            System.out.println("1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Name Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n");
            System.out.println();
            System.out.print("Select One : ");
            numberSelect = scanner.nextInt();
            System.out.println();

            switch (numberSelect) {
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

                        FileInputStream fileInputStream = new FileInputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\House.txt");
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
                case 7:
                    new MainController();
                    break;
                case 8:
                    System.exit(0);
                    break;
                case 4:
//                    FileInputStream fileInputStream = new FileInputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\Villa.csv");
//                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
//                    TreeSet<String> listService = new TreeSet<>();
//                    while ((line = dataInputStream.readLine()) != null) {
//                        String[] a = line.split(",", 8);
//                        listService.add(a[0]);
//                        for (String name : listService) {
//                            System.out.print(name + "\t");
//                        }
//                    }
                    try {
                        String[] listService = new String[100];
                        String[] nameService = new String[100];
                        FileInputStream fileInputStream = new FileInputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\Villa.csv");
                        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                        String line = "";
                        while ((line = dataInputStream.readLine()) != null) {
                            String[] a = line.split(",", 8);
                            int i = 0;
                            boolean isNameExist = false;

                            //kiem tra phan ten bi trung
                            for (int j = 0; j < 100; j++) {
                                if (Objects.equals(nameService[j], a[0])) {
                                    isNameExist = true;
                                    break;
                                } else if (nameService[j] == null) {
                                    break;
                                }
                            }

                            //them ten khong trung vao cho con trong cua mang
                            if (isNameExist == false) {
                                for (i = 0; i < 100; i++) {
                                    if (listService[i] == null) {
                                        nameService[i] = a[0];
                                        listService[i] = line;
                                        break;
                                    }
                                }
                            }
                        }
                        int i = 0;
                        System.out.println("danh sach ten cac villa khong trung nhau");
                        System.out.println();
                        while (listService[i] != null) {
                            System.out.print(listService[i] + "\n");
                            i++;
                        }
                        System.out.println();
                        System.out.println();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        String[] nameService = new String[100];
                        String[] listService = new String[100];
                        FileInputStream fileInputStream = new FileInputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\House.csv");
                        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                        String line = "";
                        while ((line = dataInputStream.readLine()) != null) {
                            String[] a = line.split(",", 8);
                            int i = 0;
                            boolean isNameExist = false;

                            //kiem tra phan ten bi trung
                            for (int j = 0; j < 100; j++) {
                                if (Objects.equals(nameService[j], a[0])) {
                                    isNameExist = true;
                                    break;
                                } else if (nameService[j] == null) {
                                    break;
                                }
                            }

                            //them ten khong trung vao cho con trong cua mang
                            if (isNameExist == false) {
                                for (i = 0; i < 100; i++) {
                                    if (nameService[i] == null) {
                                        nameService[i] = a[0];
                                        listService[i] = line;
                                        break;
                                    }
                                }
                            }
                        }
                        int i = 0;
                        System.out.println("danh sach ten cac house khong trung nhau");
                        System.out.println();
                        while (listService[i] != null) {
                            System.out.print(listService[i] + " | ");
                            i++;
                        }
                        System.out.println();
                        System.out.println();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        String[] nameService = new String[100];
                        String[] listService = new String[100];
                        FileInputStream fileInputStream = new FileInputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\Room.csv");
                        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                        String line = "";
                        while ((line = dataInputStream.readLine()) != null) {
                            String[] a = line.split(",", 8);
                            int i = 0;
                            boolean isNameExist = false;

                            //kiem tra phan ten bi trung
                            for (int j = 0; j < 100; j++) {
                                if (Objects.equals(nameService[j], a[0])) {
                                    isNameExist = true;
                                    break;
                                } else if (nameService[j] == null) {
                                    break;
                                }
                            }

                            //them ten khong trung vao cho con trong cua mang
                            if (isNameExist == false) {
                                for (i = 0; i < 100; i++) {
                                    if (nameService[i] == null) {
                                        nameService[i] = a[0];
                                        listService[i] = line;
                                        break;
                                    }
                                }
                            }
                        }
                        int i = 0;
                        System.out.println("danh sach ten cac room khong trung nhau");
                        System.out.println();
                        while (listService[i] != null) {
                            System.out.print(listService[i] + " | ");
                            i++;
                        }
                        System.out.println();
                        System.out.println();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}
