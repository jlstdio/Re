package com.joonheelee.roadster;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    long now = System.currentTimeMillis();
    // 현재시간을 date 변수에 저장한다.
    Date date = new Date(now);
    // 시간을 나타냇 포맷을 정한다 ( yyyy/MM/dd 같은 형태로 변형 가능 )

    public void curtime(){
        SimpleDateFormat sdfNow = new SimpleDateFormat("HH:mm");
        // nowDate 변수에 값을 저장한다.
        MainActivity.anydata = sdfNow.format(date);
    }

    public void curdate(){
        SimpleDateFormat sdfNow = new SimpleDateFormat("M/d");
        // nowDate 변수에 값을 저장한다.
        MainActivity.anydata = sdfNow.format(date);
    }

    public void timer(){
        SimpleDateFormat sdfNow = new SimpleDateFormat("HH:mm");
        // nowDate 변수에 값을 저장한다.
        MainActivity.anydata = sdfNow.format(date);
    }

//yyyy/MM/dd HH:mm:ss
}
