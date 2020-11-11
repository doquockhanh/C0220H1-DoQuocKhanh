import java.util.Scanner;

public class SoNguyenTo {
    public static void main(String args[]){
        int num = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap sau thu 1: ");
        String s1 = sc.next();
        System.out.println("nhap sau thu 2: ");
        String s2 = sc.next();
        int k = 0;
        if(s1.length() < s2.length()){
            while(k < s1.length()){
                for(int i = 0; i < s1.length(); i++){
                    for(int j = 0; j < s2.length(); j++)
                        if(s1.indexOf(s1.toString(i, k+i)) === i && s1.toString(i, k+i) === s2.toString(j, k+j){
                        num++;
                        return;
                    }
                }
            }
            k++;
        }
    }
else{
        while(k < s2.lengt){
            for(int i = 0; i < s1.lengh; i++){
                for(int j = 0; j < s2.lengt; j++)
                    if(s1.indexOf(s1.toStr(i, k+i)) === i && s1.toStr(i, k+i) === s2.toStr(j, k+j){
                    num++;
                    return;
                }
            }
        }
        k++;
    }
}
    }
}
