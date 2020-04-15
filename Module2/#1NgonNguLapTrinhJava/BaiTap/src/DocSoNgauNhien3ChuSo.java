import java.util.Scanner;

public class DocSoNgauNhien3ChuSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so nguyen (lon hon 0 , nhieu nhat 3 chu so)");
        int inputNumber = scanner.nextInt();
        String outputString = "";

        if (inputNumber <= 999 && inputNumber >= 0) {
            if ((inputNumber - (inputNumber % 100)) / 100 < 10) {
                switch ((inputNumber - (inputNumber % 100)) / 100) {
                    case 1:
                        outputString += "một trăm ";
                        break;
                    case 2:
                        outputString += "hai trăm ";
                        break;
                    case 3:
                        outputString += "ba trăm ";
                        break;
                    case 4:
                        outputString += "bốn trăm ";
                        break;
                    case 5:
                        outputString += "năm trăm ";
                        break;
                    case 6:
                        outputString += "sáu trăm ";
                        break;
                    case 7:
                        outputString += "bảy trăm ";
                        break;
                    case 8:
                        outputString += "tám trăm ";
                        break;
                    case 9:
                        outputString += "chín trăm ";
                        break;
                }
            }

            if (((inputNumber % 100) - inputNumber % 10) / 10 < 10) {
                switch (((inputNumber % 100) - inputNumber % 10) / 10) {
                    case 1:
                        outputString += "mười ";
                        break;
                    case 2:
                        outputString += "hai mươi ";
                        break;
                    case 3:
                        outputString += "ba mươi ";
                        break;
                    case 4:
                        outputString += "bốn mươi ";
                        break;
                    case 5:
                        outputString += "năm mươi ";
                        break;
                    case 6:
                        outputString += "sáu mươi ";
                        break;
                    case 7:
                        outputString += "bảy mươi ";
                        break;
                    case 8:
                        outputString += "tám mươi ";
                        break;
                    case 9:
                        outputString += "chín mươi ";
                        break;
                }
            }

            if (inputNumber % 10 < 10) {
                switch (inputNumber % 10) {
                    case 1:
                        outputString += "một";
                        break;
                    case 2:
                        outputString += "hai";
                        break;
                    case 3:
                        outputString += "ba";
                        break;
                    case 4:
                        outputString += "bốn";
                        break;
                    case 5:
                        outputString += "năm";
                        break;
                    case 6:
                        outputString += "sáu";
                        break;
                    case 7:
                        outputString += "bảy";
                        break;
                    case 8:
                        outputString += "tám";
                        break;
                    case 9:
                        outputString += "chín";
                        break;
                }
            }
        }
        System.out.println(outputString);
    }
}
