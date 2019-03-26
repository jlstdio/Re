package com.joonheelee.roadster;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;


public class Start extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Setting the layout;[.
        setContentView(R.layout.activity_start);
        changeView(0);
    }

    public void beginning(View V){
        changeView(1);
    }

    public void introducing(View V){
        changeView(2);
    }

    public void setting(View V){
        startActivity(new Intent(this, MainActivity.class));
    }

    private void changeView(int index) {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        FrameLayout frame = findViewById(R.id.frame);

        if (frame.getChildCount() > 0) {frame.removeViewAt(0);}

        View view = null ; switch (index) {
            case 0 :
                view = inflater.inflate(R.layout.beginning, frame, false) ;
                break ;
            case 1 :
                view = inflater.inflate(R.layout.introducing, frame, false) ;
                break ;
            case 2 :
                view = inflater.inflate(R.layout.setting, frame, false) ;
                break ;
        }
        // FrameLayout에 뷰 추가.
        if (view != null) { frame.addView(view) ; } }
}