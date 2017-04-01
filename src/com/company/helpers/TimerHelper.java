package com.company.helpers;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Sebek on 2017-03-30.
 */
public class TimerHelper {

    public static void printTime(String outputMessage,long startTime){

        long estimatedTime = System.currentTimeMillis() - startTime;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println(outputMessage + formatter.format((estimatedTime) / 1000d) + " seconds");
       // int timeLapsed =  (int) estimatedTime / 1000;
      //  System.out.println("GRAPH BUILDED in time: " +timeLapsed );
    }

}
