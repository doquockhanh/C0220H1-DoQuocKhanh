package ConTrollers;

import Model.Employee;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShowAllEmployee {
    public ShowAllEmployee() {
        Map<Integer, Employee> map = new HashMap<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\CODEGYM\\Module2\\CaseStudy\\Furama\\src\\ConTrollers\\Data\\Employee.csv");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            String line = "";
            int index = 0;
            while ((line = dataInputStream.readLine()) != null) {
                ++index;
                String[] employeeData = line.split(",");
                map.put(index , new Employee(employeeData[0], employeeData[1], employeeData[2]));
            }

            for (int i = 1; i <= index; i++) {
                System.out.println(map.get(i) + "\n");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
