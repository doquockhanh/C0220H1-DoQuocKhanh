package ConTrollers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Pattern;

public class CheckValidInformation {

    //chuan hoa 1 chuoi bat ki nhap vao
    public String formatStringInput(String string) {
        String stringAfterFormat = "";
        boolean a = false;
        String[] array = string.split("", string.length());
        for (int i = 0; i < string.length(); i++) {
            if (array[i].equals(" ") && a) {
                if (array[i].equals(array[i - 1])) {
                    stringAfterFormat += "";
                } else {
                    stringAfterFormat += " ";
                }
            } else if (!array[i].equals(" ")) {
                if (a == false || (a && array[i - 1].equals(" "))) {
                    stringAfterFormat += array[i].toUpperCase();
                } else {
                    stringAfterFormat += array[i].toLowerCase();
                }
                a = true;
            }
        }

        //kiem tra ten nhap vao co giong voi ten da su hay khong
//        if (nameCustomerAfterCheck.equals(nameCustomer)){
//            return true;
//        }else {
//            return false;
//        }
        return stringAfterFormat;
    }

    public boolean checkEmailCustomer(String emailCustomer) {
        String emailCustomerPattern = "^[a-zA-Z0-9]+[@][a-z]+[.][a-z]+$";
        return Pattern.matches(emailCustomerPattern, emailCustomer);
    }

    public boolean checkGenderCustomer(String genderCustomer) {
        String genderCustomerAfterCheck = "";
        boolean a = false;
        String[] array = genderCustomer.split("", genderCustomer.length());
        for (int i = 0; i < genderCustomer.length(); i++) {
            if (array[i].equals(" ") && a) {
                if (array[i].equals(array[i - 1])) {
                    genderCustomerAfterCheck += "";
                }
            } else if (!array[i].equals(" ")) {
                if (a == false || (a && array[i - 1].equals(" "))) {
                    genderCustomerAfterCheck += array[i].toUpperCase();
                } else {
                    genderCustomerAfterCheck += array[i].toLowerCase();
                }
            }
            a = true;
        }
        if (genderCustomerAfterCheck.equals("Male") || genderCustomerAfterCheck.equals("Female") || genderCustomerAfterCheck.equals("Unknow")) {
            return true;
        } else {
            return false;
        }
    }

    public String returnGenderCustomer(String genderCustomer) {
        String returnGenderCustomer = "";
        boolean a = false;
        String[] array = genderCustomer.split("", genderCustomer.length());
        for (int i = 0; i < genderCustomer.length(); i++) {
            if (array[i].equals(" ") && a) {
                if (array[i].equals(array[i - 1])) {
                    returnGenderCustomer += "";
                }
            } else if (!array[i].equals(" ")) {
                if (a == false || (a && array[i - 1].equals(" "))) {
                    returnGenderCustomer += array[i].toUpperCase();
                } else {
                    returnGenderCustomer += array[i].toLowerCase();
                }
            }
            a = true;
        }
        return returnGenderCustomer;
    }

    public boolean checkIDCustomer(String idCustomer) {
        String idCustomerPattern = "^[0-9]{9}$" + "^[0]&";
        return Pattern.matches(idCustomerPattern, idCustomer);
    }

    public boolean checkBirthDayCustomer(String birthDayCustomer) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();
        int day = localDate.getDayOfMonth();
        String birthDayCustomerPattern = "^[0-9]{2}[/][0-9]{2}[/][0-9]{4}$";
        String[] array = birthDayCustomer.split("/", 3);
        if (Pattern.matches(birthDayCustomerPattern, birthDayCustomer) && Integer.parseInt(array[2]) > 1900) {
            if (year - Integer.parseInt(array[2]) > 18) {
                return true;
            } else if ((year - Integer.parseInt(array[2]) == 18 && month > Integer.parseInt(array[1]))) {
                return true;
            } else if ((year - Integer.parseInt(array[2]) == 18 && month == Integer.parseInt(array[1]) && day >= Integer.parseInt(array[0]))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean checkServiceID(String serviceID, String type) {
        String serviceIDPattern = null;
        if (type.equals("villa")) {
            serviceIDPattern = "^SVVL-[0-9]{4}$";
        } else if (type.equals("house")) {
            serviceIDPattern = "^SVHO-[0-9]{4}$";
        } else if (type.equals("room")) {
            serviceIDPattern = "^SVRO-[0-9]{4}$";
        }
        return Pattern.matches(serviceIDPattern, serviceID);
    }

    public boolean checkMoreService(String moreService) {
        String[] services = {"massage", "karaoke", "food", "drink", "car"};
        for (int i = 0; i < services.length; i++) {
            if (moreService.toLowerCase().equals(services[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPoolArea(String poolArea) {
        if (Integer.parseInt(poolArea) > 30) {
            return true;
        }
        return false;
    }

    public boolean checkRentPrice(String rentPrice) {
        if (Integer.parseInt(rentPrice) > 0) {
            return true;
        }
        return false;
    }

    public boolean checkMaxPeople(String maxPeople) {
        if (Integer.parseInt(maxPeople) > 0 && Integer.parseInt(maxPeople) < 20) {
            return true;
        }
        return false;
    }

    public boolean checkNumberOfFloor(String numberOfFloor) {
        if (Integer.parseInt(numberOfFloor) > 0) {
            return true;
        }
        return false;
    }
}
