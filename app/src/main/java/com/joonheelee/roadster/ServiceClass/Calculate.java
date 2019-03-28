package com.joonheelee.roadster.ServiceClass;

import com.joonheelee.roadster.MainClass.Input;
import com.joonheelee.roadster.MainClass.MainActivity;

public class Calculate {

    String input = MainActivity.voiceinput;

    public void plus(){
        input = input.replaceAll("마크","");
        String math[] = input.split("더하기");

        int mathint[] = {0};

        mathint[0] = Integer.valueOf(math[0]);
        mathint[1] = Integer.valueOf(math[1]);

        String result = String.valueOf(mathint[0] + mathint[1]);
        Input.resultoutput = "계산된 값은" + result + ".입니다";
    }

    public void subtract(){
        String math[] = input.split("빼기");

        int mathint[] = {0};

        mathint[0] = Integer.valueOf(math[0]);
        mathint[1] = Integer.valueOf(math[1]);

        String result = String.valueOf(mathint[0] - mathint[1]);
        Input.resultoutput = "계산된 값은" + result + ".입니다";
    }

    public void divide(){
        String math[] = input.split("나누기");

        int mathint[] = {0};

        mathint[0] = Integer.valueOf(math[0]);
        mathint[1] = Integer.valueOf(math[1]);

        String result = String.valueOf(mathint[0] / mathint[1]);
        Input.resultoutput = "계산된 값은" + result + ".입니다";
    }

    public void multiple(){
        String math[] = input.split("곱하기");

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
