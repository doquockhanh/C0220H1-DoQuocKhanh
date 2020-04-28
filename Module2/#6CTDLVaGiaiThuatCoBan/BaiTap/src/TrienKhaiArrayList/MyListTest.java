package TrienKhaiArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList myList = new MyList(10);
        myList.add(1, "khanh");
        System.out.println("ton tai gia tri vua nhap : " + myList.indexOf("1"));
    }
}
