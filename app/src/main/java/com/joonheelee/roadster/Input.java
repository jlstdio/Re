package com.joonheelee.roadster;

public class Input {

    public void word(){
        String input = MainActivity.voiceinput;


        //Weather
        /* 오늘/내일(다른 날짜) 날씨 어때
        * 오늘 기온 어때
        * 오늘 미세먼지 어때
        * 오늘 비와?
        * 오늘 맑아?
        * 오늘 온도어떄
        * */
        if(input.contains("기온")  || input.contains("온")){

        }

        if(input.contains("미세먼지")){

        }

        if(input.contains("비") || input.contains("눈") || input.contains("안개")){

        }

        if(input.contains("맑아") || input.contains("흐려")){

        }

        //Volume
        /*소리/볼륨/음량/음성 올려줘
        * 10만큼 올려줘/내려줘
        * 음소거
        * 소리 최대로
        * 더 크게 틀어
        * 가장 크게 틀어
        * */

        //timer matter
        if(input.contains("몇 시") || input.contains("몇시")){
            if(input.contains("지금")){

            }
        }

        //date
        if(input.contains("날짜") || input.contains("요일")){
           if(input.contains("오늘")){

            }
        }

        //alarm

        //memo

        //search

        //radio, podcast

        //calculate

        //message

        //reminder

        //news

        //sports

        //currency

        //stock

        //dictionary

        //movie

        //Tv

        //find my phone
    }
}
