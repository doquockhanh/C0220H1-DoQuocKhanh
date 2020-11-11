public class HelloWorld {
    public static void main(String[] args){
//      {1,2,2,3,1,3,1,3}
        if(check(new int[]{1,2,2,2,3,1,3,1,3})){
            System.out.println("tan so xuat hien giong nhau");
        }else{
            System.out.println("tan so xuat hien khac nhau");
        }
    }

    public static boolean check(int[] arr){
// kiem tra so luong pt dau tien va lay do lam cot moc
        int flag1 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[0] == arr[i]){
                flag1 += 1;
            }
        }

// check truong hop dac biet
        if(flag1 > arr.length / 2){
            return false;
        }else if (flag1 == arr.length){
            return true;
        }

// kiem tra so luong pt tiep theo va so sanh voi cot moc
        int flag2;
        for(int i = 1; i < arr.length; i++){
            flag2 = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    flag2 += 1;
                }
            }
            if(flag1 != flag2){
                return false;
            }
        }
        return true;
    }
}
