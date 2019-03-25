package com.joonheelee.roadster;

import android.speech.tts.TextToSpeech;

public class Input {

    static public String resultoutput;

    Time i = new Time();

    public void word(){
        String input = MainActivity.voiceinput;

        //Weather
        /* 오늘/내일(다른 날짜) 날씨 어때
        * 오늘 기온 어때
        * 오늘 미세먼지 어때
        * 오늘 비와?
        * 오늘 맑아?
        * 오늘 온도어떄
        */
        if(input.contains("기온")  || input.contains("온도")){

        }

        else if(input.contains("미세먼지")){

        }

        else if(input.contains("비") || input.contains("눈") || input.contains("안개")){

        }

        else if(input.contains("맑아") || input.contains("흐려")){

        }

        //Volume
        /*소리/볼륨/음량/음성 올려줘
        * 10만큼 올려줘/내려줘
        * 음소거
        * 소리 최대로
        * 더 크게 틀어
        * 가장 크게 틀어
        * */
        else if(input.contains("소리") || input.contains("볼륨") || input.contains("볼룸") || input.contains("음성") || input.contains("음량")){
            resultoutput = "현재 음량은 수동으로만 조절가능합니다.";
        }

        //timer matter
        else if(input.contains("몇 시") || input.contains("몇시")){
            if(input.contains("지금")){

                i.curtime();
                resultoutput = "현재시각은.." + MainActivity.anydata + ".입니다";
            }
        }

        //date
        else if(input.contains("날짜") || input.contains("요일")){
           if(input.contains("오늘")){

               i.curdate();
               String date[] = MainActivity.anydata.split("/");
               resultoutput = "오늘은.." + date[1] + "월" +date[0] + "일" + ".입니다";
            }
        }

        //music
        else if(input.contains("노래") || input.contains("음악")){

           resultoutput = "노래 틀어드릴께요";
        }

        //alarm
        if(input.contains("알람") || input.contains("알림")){
            resultoutput = "현재 알람 기능은 지원하지 않습니다";
        }

        //memo
        if(input.contains("메모")){
            resultoutput = "현재 메모 기능은 지원하지 않습니다";
        }

        //search
        if(input.contains("검색") || input.contains("뭐야")){
            resultoutput = "현재 검색 기능은 지원하지 않습니다";
        }

        //radio, podcast
        if(input.contains("라디오")){
            resultoutput = "현재 라디오 기능은 지원하지 않습니다";
        }

        //calculate
        if(input.contains("계산")){
            resultoutput = "현재 계산 기능은 지원하지 않습니다";
        }

        //message
        if(input.contains("메세지") || input.contains("메시지") || input.contains("문자")){
            resultoutput = "현재 문자 기능은 지원하지 않습니다";
        }

        //reminder

        //news

        //sports

        //currency

        //stock

        //dictionary

        //movie

        //Tv

        //find my phone

        //introducing
        else if(input.contains("너") || input.contains("누구야")){
            resultoutput = "저는.안드로이드스마트폰으로 스파트 스피커를 만드는..RE..프로젝트의 일환으로 탄생한 프로그램입니다";
        }

        //greeting
        else if(input.contains("안녕") || input.contains("반가워") || input.contains("하이")){
            resultoutput = "네...안녕하세요...반가워요";
        }

        else
            resultoutput = "네...말씀하세요";
    }
}
