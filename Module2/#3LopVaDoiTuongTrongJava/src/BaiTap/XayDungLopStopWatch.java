package BaiTap;

import java.time.LocalTime;
import java.util.Calendar;

public class XayDungLopStopWatch {
    private LocalTime starTime;
    private LocalTime endTime;

    public XayDungLopStopWatch() {
        starTime = LocalTime.now();
    }

    public LocalTime getStarTime() {
        return starTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalTime getElapsedTime(){
        return starTime;
    }

    public static void main(String[] args) {
        XayDungLopStopWatch stopWatch = new XayDungLopStopWatch();
        System.out.println(stopWatch.getStarTime());
    }
}
