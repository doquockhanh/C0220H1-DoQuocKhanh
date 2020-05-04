package ConTrollers;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ShowListCustomer {
    public ShowListCustomer(){
        int count = 0;
        try{
            FileInputStream fileInputStream = new FileInputStream("D:\\CODEGYM\\Module2\\CaseStudy\\Furama\\src\\ConTrollers\\Data\\Customer.csv");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            String line = "";
            while ((line = dataInputStream.readLine()) != null) {
                ++count;
                System.out.println(count + " " + line);
            }

            System.out.println();
            System.out.println();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
