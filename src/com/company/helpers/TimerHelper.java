package com.company.helpers;

/**
 * Created by Sebek on 2017-03-30.
 */
public class TimerHelper {

    public static void printTime(long startTime){

        long estimatedTime = System.currentTimeMillis() - startTime;
        int timeLapsed =  (int) estimatedTime / 1000;
        System.out.println("GRAPH BUILDED in time: " +timeLapsed );
    }

}
