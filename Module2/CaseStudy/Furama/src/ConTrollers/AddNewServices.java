package ConTrollers;

import Model.House;
import Model.Room;
import Model.Villa;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class AddNewServices {
    public AddNewServices() {
        String type;
        String serviceID = "";
        String nameService = "";
        String maxPeople = "";
        String rentType = "";
        String rentPrice = "";
        String roomStandard = "";
        String moreStandard = "";
        String numberOfFloor = "";
        String poolArea = "";
        String freeService = "";
        CheckValidInformation checkValidInformation = new CheckValidInformation();
        int numberSelect = 0;
        Scanner scanner = new Scanner(System.in);
        while (numberSelect > -1) {
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit\n");
            System.out.println();
            System.out.print("Select One : ");
            numberSelect = scanner.nextInt();
            System.out.println();

            switch (numberSelect) {
                case 1:
                    type = "villa";

                    System.out.println("vui long nhap theo huong dan");
                    System.out.println();

                    while (true) {
                        System.out.println("ma dich vu (SVVL-xxxx) : ");
                        serviceID = scanner.next();
                        if (checkValidInformation.checkServiceID(serviceID, type) == false) {
                            System.out.println("nhap sai! moi nhap lai");
                        } else break;
                    }

                    System.out.println("ten dich vu : ");
                    nameService = scanner.next();

                    while (true) {
                        System.out.println("so nguoi toi da (0 < x < 20) : ");
                        maxPeople = scanner.next();
                        if (checkValidInformation.checkMaxPeople(maxPeople) == false) {
                            System.out.println("nhap sai! moi nhap lai");
                        } else break;
                    }

                    System.out.println("kieu thue : ");
                    rentType = scanner.next();

                    while (true) {
                        System.out.println("gia thue ( >0) : ");
                        rentPrice = scanner.next();
                        if (checkValidInformation.checkRentPrice(rentPrice) == false) {
                            System.out.println("nhap sai! moi nhap lai");
                        } else break;
                    }

                    System.out.println("tieu chuan phong : ");
                    roomStandard = scanner.next();

                    while (true) {
                        System.out.println("dich vu khac (massage, karaoke, food, drink, car): ");
                        moreStandard = scanner.next();
                        if (checkValidInformation.checkMoreService(moreStandard) == false) {
                            System.out.println("nhap sai! moi nhap lai");
                        } else break;
                    }

                    while (true) {
                        System.out.println("so tang ( > 0): ");
                        numberOfFloor = scanner.next();
                        if (checkValidInformation.checkNumberOfFloor(numberOfFloor) == false) {
                            System.out.println("nhap sai! moi nhap lai");
                        } else break;
                    }

                    while (true) {
                        System.out.println("dien tich ho boi ( > 30) : ");
                        poolArea = scanner.next();
                        if (checkValidInformation.checkRentPrice(rentPrice) == false) {
                            System.out.println("nhap sai! moi nhap lai");
                        } else break;
                    }

                    Villa villa = new Villa(serviceID, checkValidInformation.formatStringInput(nameService), maxPeople, checkValidInformation.formatStringInput(rentType),
                            rentPrice, checkValidInformation.formatStringInput(roomStandard), moreStandard, numberOfFloor, poolArea);


                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\Villa.csv", true);
                        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

                        dataOutputStream.writeBytes(villa.getServiceID());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(villa.getNameService());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(villa.getMaxPeople());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(villa.getRentType());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(villa.getRentPrice());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(villa.getRoomStandard());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(villa.getMoreStandard());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(villa.getNumberOfFloor());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(villa.getPoolArea());
                        dataOutputStream.writeBytes("\n");

                        fileOutputStream.close();
                        dataOutputStream.close();
                        System.out.println("them thanh cong !");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    type = "house";

                    System.out.println("vui long nhap theo huong dan");
                    System.out.println();

                    while (true) {
                        System.out.println("ma dich vu (SVHO-xxxx) : ");
                        serviceID = scanner.next();
                        if (checkValidInformation.checkServiceID(serviceID, type) == false) {
                            System.out.println("nhap sai! vui long nhap lai");
                        } else break;
                    }

                    System.out.println("ten dich vu : ");
                    nameService = scanner.next();

                    while (true) {
                        System.out.println("so nguoi toi da (0 < x < 20) : ");
                        maxPeople = scanner.next();
                        if (checkValidInformation.checkMaxPeople(maxPeople) == false) {
                            System.out.println("nhap sai! moi nhap lai");
                        } else break;
                    }

                    System.out.println("kieu thue : ");
                    rentType = scanner.next();

                    while (true) {
                        System.out.println("gia thue ( >0) : ");
                        rentPrice = scanner.next();
                        if (checkValidInformation.checkRentPrice(rentPrice) == false) {
                            System.out.println("nhap sai! moi nhap lai");
                        } else break;
                    }

                    System.out.println("tieu chuan phong : ");
                    roomStandard = scanner.next();

                    while (true) {
                        System.out.println("dich vu khac (massage, karaoke, food, drink, car) : ");
                        moreStandard = scanner.next();
                        if (checkValidInformation.checkMoreService(moreStandard) == false) {
                            System.out.println("nhap sai! vui long nhap lai");
                        } else break;
                    }

                    while (true) {
                        System.out.println("dien tich ho boi ( > 30) : ");
                        poolArea = scanner.next();
                        if (checkValidInformation.checkPoolArea(poolArea) == false) {
                            System.out.println("nhap sai! moi nhap lai");
                        } else break;
                    }

                    House house = new House(serviceID, checkValidInformation.formatStringInput(nameService), maxPeople, checkValidInformation.formatStringInput(rentType),
                            rentPrice, checkValidInformation.formatStringInput(roomStandard), moreStandard, poolArea);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\House.csv", true);
                        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

                        dataOutputStream.writeBytes(house.getServiceID());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(house.getNameService());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(house.getMaxPeople());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(house.getRentType());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(house.getRentPrice());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(house.getRoomStandard());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(house.getMoreStandard());
                        dataOutputStream.writeBytes(",");
                        dataOutputStream.writeBytes(house.getPoolArea());
                        dataOutputStream.writeBytes("\n");

                        fileOutputStream.close();
                        dataOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("them thanh cong !");
                    break;
                case 3:
                    type = "room";

                    System.out.println("vui long nhap dung theo huong dan");
                    System.out.println();

                    while (true) {
                        System.out.println("ma dich vu (SVRO-xxxx) : ");
                        serviceID = scanner.next();
                        if (checkValidInformation.checkServiceID(serviceID, type) == false) {
                            System.out.println("nhap sai! vui long nhap lai");
                        } else break;
                    }
                    System.out.println("ten dich vu : ");
                    nameService = scanner.next();

                    while (true) {
                        System.out.println("so nguoi toi da : ");
                        maxPeople = scanner.next();
                        if (checkValidInformation.checkMaxPeople(maxPeople) == false) {
                            System.out.println("nhap sai! vui long nhap lai");
                        } else break;
                    }

                    System.out.println("kieu thue : ");
                    rentType = scanner.next();

                    while (true) {
                        System.out.println("gia thue : ");
                        rentPrice = scanner.next();
                        if (checkValidInformation.checkRentPrice(rentPrice) == false) {
                            System.out.println("nhap sai! vui long nhap lai");
                        } else break;
                    }

                    System.out.println("dich vu mien phi : ");
                    freeService = scanner.next();
            Room room = new Room(serviceID, checkValidInformation.formatStringInput(nameService), maxPeople, checkValidInformation.formatStringInput(rentType),
                    rentPrice, checkValidInformation.formatStringInput(freeService));
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\Room.csv", true);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

                dataOutputStream.writeBytes(room.getServiceID());
                dataOutputStream.writeBytes(",");
                dataOutputStream.writeBytes(room.getNameService());
                dataOutputStream.writeBytes(",");
                dataOutputStream.writeBytes(room.getMaxPeople());
                dataOutputStream.writeBytes(",");
                dataOutputStream.writeBytes(room.getRentType());
                dataOutputStream.writeBytes(",");
                dataOutputStream.writeBytes(room.getRentPrice());
                dataOutputStream.writeBytes(",");
                dataOutputStream.writeBytes(room.getFreeService());
                dataOutputStream.writeBytes("\n");

                fileOutputStream.close();
                dataOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("them thanh cong !");
            break;
            case 4:
                new MainController();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }
}
}
