package ConTrollers;

import Model.Employee;

import java.util.Stack;

public class TuHoSo {

    public static void main(String[] args) {
        //filingCabinets : tủ hồ sơ
        Stack filingCabinets  = new Stack();
        TuHoSo.addFile(filingCabinets, new Employee("khanh"," 19","hk"));
        TuHoSo.searchFile(filingCabinets, "khanh");
    }

    static void addFile(Stack filingCabinets, Employee employee){
        filingCabinets.push(employee);
    }

    static void popFile(Stack filingCabinets){
        filingCabinets.pop();
    }

    static void searchFile(Stack filingCabinets, String nameEmployee){
        for (int i = 0; i < filingCabinets.size(); i++) {
            Employee employee = (Employee) filingCabinets.get(i);
            if(employee.getNameEmployee().equals(nameEmployee)){
                System.out.println(filingCabinets.get(i));
            }
        }
    }
}
