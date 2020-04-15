package BaiTap;

import java.util.Date;
import java.util.Scanner;

public class StopWatch {
    private long starTime;
    private long endTime;

    public StopWatch() {
        Date date = new Date();
        starTime = date.getTime();
    }

    public long getStarTime() {
        return starTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void star() {
        Date date = new Date();
        starTime = date.getTime();
    }

    public void stop(){
        Date date = new Date();
        endTime = date.getTime();
    }

    public long getElapsedTime(){
        return (endTime - starTime)/1000;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StopWatch stopWatch = new StopWatch();
        int numSelect = 0;
        while (numSelect != 3) {
            System.out.println("1 : star \n2 : stop \n3 : exit");
            numSelect = scanner.nextInt();
            switch (numSelect) {
                case 1:
                    stopWatch.star();
                    System.out.println("bat dau dem");
                    break;
                case 2:
                    stopWatch.stop();
                    System.out.println("thoi gian da ghi : " + stopWatch.getElapsedTime() + " giay");
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}
