package com.joonheelee.roadster.ServiceClass;

import com.joonheelee.roadster.MainClass.Input;
import com.joonheelee.roadster.MainClass.MainActivity;

/*
계산 영역입니다. 사칙연산이 가능하고
추가적으론 제곱과 제곱근을 이어
다른 계산을 추가할 것입니다.
*/

public class Calculate {

    String input = MainActivity.voiceinput;

    public void plus(){
        if(input.contains("+")) input.replace("+", "더하기");
        String math[] = input.split("더하기");

        math[0] = math[0].replaceAll("[^0-9]", "");
        math[1] = math[1].replaceAll("[^0-9]", "");

        int mathint[] = {0};

        mathint[0] = Integer.valueOf(math[0]);
        mathint[1] = Integer.valueOf(math[1]);
        int plus = mathint[0] + mathint[1];
        String result = String.valueOf(plus);
        Input.resultoutput = "계산된 값은" + result + ".입니다";
    }

    public void subtract(){
        if(input.contains("+")) input.replace("-", "빼기");
        String math[] = input.split("빼기");

        math[0] = math[0].replaceAll("[^0-9]", "");
        math[1] = math[1].replaceAll("[^0-9]", "");

        int mathint[] = {0};

        mathint[0] = Integer.valueOf(math[0]);
        mathint[1] = Integer.valueOf(math[1]);

        String result = String.valueOf(mathint[0] - mathint[1]);
        Input.resultoutput = "계산된 값은" + result + ".입니다";
    }

    public void divide(){
        if(input.contains("+")) input.replace("/", "나누기");
        String math[] = input.split("나누기");

        math[0] = math[0].replaceAll("[^0-9]", "");
        math[1] = math[1].replaceAll("[^0-9]", "");

        int mathint[] = {0};

        mathint[0] = Integer.valueOf(math[0]);
        mathint[1] = Integer.valueOf(math[1]);

        String result = String.valueOf(mathint[0] / mathint[1]);
        Input.resultoutput = "계산된 값은" + result + ".입니다";
    }

    public void multiple(){
        if(input.contains("+")) input.replace("*", "곱하기");
        String math[] = input.split("곱하기");

        math[0] = math[0].replaceAll("[^0-9]", "");
        math[1] = math[1].replaceAll("[^0-9]", "");

        int mathint[] = {0};

        mathint[0] = Integer.valueOf(math[0]);
        mathint[1] = Integer.valueOf(math[1]);

        String result = String.valueOf(mathint[0] * mathint[1]);
        Input.resultoutput = "계산된 값은" + result + ".입니다";
    }
    public void square(){
        Input.resultoutput = "아직 ..계산하지 못해요";
    }

    public void root(){
        Input.resultoutput = "아직 ..계산하지 못해요";
    }

}
