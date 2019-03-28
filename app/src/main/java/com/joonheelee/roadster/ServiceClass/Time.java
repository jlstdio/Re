package com.joonheelee.roadster.ServiceClass;

import com.joonheelee.roadster.MainClass.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    static String strtimerdata = "0:0:0";
    public static int timetocompare = -1;

    long now = System.currentTimeMillis();
    Date date = new Date(now);

    //현재 시각을 알아냅니다.
    public void curtime(){
        SimpleDateFormat sdfNow = new SimpleDateFormat("HH:mm");
        MainActivity.anydata = sdfNow.format(date);
    }

    //현재 날자을 알아냅니다.
    public void curdate(){
        SimpleDateFormat sdfNow = new SimpleDateFormat("M/d");
        MainActivity.anydata = sdfNow.format(date);
    }

    //TODO ?
    public void timer(){
        SimpleDateFormat sdfNow = new SimpleDateFormat("HH:mm:ss");
        MainActivity.anydata = sdfNow.format(date);

    }

    //타이머를 설정합니다.
    public void settimer(){

        String buf = MainActivity.voiceinput;

        MainActivity.timecount = 0;

        if(MainActivity.voiceinput.contains("초")){
            strtimerdata = buf.replaceAll("[^0-9]", "");
            timetocompare = Integer.parseInt(strtimerdata);

        }

        else if(MainActivity.voiceinput.contains("분")){
            strtimerdata = buf.replaceAll("[^0-9]", "");
            timetocompare = Integer.parseInt(strtimerdata);
            timetocompare = 60 * timetocompare;
        }

        else if(MainActivity.voiceinput.contains("시간")){
            strtimerdata = buf.replaceAll("[^0-9]", "");
            timetocompare = Integer.parseInt(strtimerdata);
            timetocompare = 3600 * timetocompare;
        }

        else if(MainActivity.voiceinput.contains("분") && MainActivity.voiceinput.contains("초")){
            String set[] = buf.split("분");

            for(int i = 0; i < 2; i++)
                set[i] = set[i].replaceAll("[^0-9]", "");

            strtimerdata = "m:s-" + set[0] + ":" + set[1];

            timetocompare = 60 * Integer.parseInt(set[0]) + Integer.parseInt(set[0]);
        }

        else if(MainActivity.voiceinput.contains("시간") && MainActivity.voiceinput.contains("분")){
            String set[] = buf.split("시간");

            for(int i = 0; i < 2; i++)
                set[i] = set[i].replaceAll("[^0-9]", "");

            timetocompare = 3600 * Integer.parseInt(set[0]) + 60 * Integer.parseInt(set[0]);
        }

        else if(MainActivity.voiceinput.contains("시간") && MainActivity.voiceinput.contains("초")){
            String set[] = buf.split("시간");

            for(int i = 0; i < 2; i++)
                set[i] = set[i].replaceAll("[^0-9]", "");

            timetocompare = 3600 * Integer.parseInt(set[0]) + Integer.parseInt(set[0]);
        }

        else if(MainActivity.voiceinput.contains("시간") && MainActivity.voiceinput.contains("분") && MainActivity.voiceinput.contains("초")){
            //TODO 시, 분, 초 타이머 처리
        }

    }

    //알람을 설정합니다.
    public void setalarm(){

        if(MainActivity.voiceinput.contains("요일")){

        }

        else if(MainActivity.voiceinput.contains("매일")){

        }

        if(MainActivity.voiceinput.contains("주말")){

        }

        if(MainActivity.voiceinput.contains("주중")){

        }

        else{
            String buf[] = MainActivity.voiceinput.split("시");
        }
    }


//yyyy/MM/dd HH:mm:ss
}
