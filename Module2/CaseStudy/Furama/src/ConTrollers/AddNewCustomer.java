package ConTrollers;

import Model.Customer;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class AddNewCustomer {
    public AddNewCustomer() {
        CheckValidInformation checkValidInformation = new CheckValidInformation();
        Scanner scanner = new Scanner(System.in);
        String nameCus = "";
        String birthday = "";
        String gender = "";
        String Id = "";
        String email = "";
        String phoneNumber = "";
        String typeCus = "";
        String address = "";
        String nameService = "";

        System.out.println("vui long nhap dung theo huong dan");
        System.out.println();
        System.out.println("nhap ten khach hang");
        nameCus = scanner.next();

        while (true) {
            System.out.println("ngay sinh (dd/mm/yyyy)");
            birthday = scanner.next();
            if (checkValidInformation.checkBirthDayCustomer(birthday)) break;
            else System.out.println("nhap sai! vui long nhap lai");
        }

        while (true) {
            System.out.println("gioi tinh (male/female/unknow)");
            gender = scanner.next();
            if (checkValidInformation.checkGenderCustomer(gender)) break;
            else System.out.println("nhap sai! vui long nhap lai");
        }

        while (true) {
            System.out.println("Cmnd ( bao gom 9 chu so)");
            Id = scanner.next();
            if (checkValidInformation.checkIDCustomer(Id)) break;
            else System.out.println("nhap sai! vui long nhap lai");
        }

        while (true) {
            System.out.println("so dien thoai ( bao gom 9 chu so)");
            phoneNumber = scanner.next();
            if (checkValidInformation.checkIDCustomer(phoneNumber)) break;
            else System.out.println("nhap sai! vui long nhap lai");
        }

        while (true) {
            System.out.println("email ( abc@abc.abc)");
            email = scanner.next();
            if (checkValidInformation.checkEmailCustomer(email)) break;
            else System.out.println("nhap sai! vui long nhap lai");
        }

        System.out.println("loai khach hang");
        typeCus = scanner.next();
        System.out.println("dia chi");
        address = scanner.next();
        System.out.println("ten dich vu su dung");
        nameService = scanner.next();


        Customer customer = new Customer(
                checkValidInformation.formatStringInput(nameCus), birthday,
                checkValidInformation.returnGenderCustomer(gender), Id,
                phoneNumber, email, typeCus, address, nameService
        );

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\luu file chay thu\\Case study\\CaseStudyModul2\\Furama\\src\\ConTrollers\\data\\Customer.csv", true);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

            dataOutputStream.writeBytes(customer.getName());
            dataOutputStream.writeBytes(",");
            dataOutputStream.writeBytes(customer.getBirthDay());
            dataOutputStream.writeBytes(",");
            dataOutputStream.writeBytes(customer.getGender());
            dataOutputStream.writeBytes(",");
            dataOutputStream.writeBytes(customer.getIDNumber());
            dataOutputStream.writeBytes(",");
            dataOutputStream.writeBytes(customer.getPhoneNumber());
            dataOutputStream.writeBytes(",");
            dataOutputStream.writeBytes(customer.getEmail());
            dataOutputStream.writeBytes(",");
            dataOutputStream.writeBytes(customer.getTypeCustomer());
            dataOutputStream.writeBytes(",");
            dataOutputStream.writeBytes(customer.getAddress());
            dataOutputStream.writeBytes(",");
            dataOutputStream.writeBytes(customer.getUseService());
            dataOutputStream.writeBytes("\n");

            fileOutputStream.close();
            dataOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("them thanh cong !");
    }
}
