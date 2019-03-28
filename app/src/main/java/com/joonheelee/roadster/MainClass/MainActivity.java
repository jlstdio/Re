package com.joonheelee.roadster.MainClass;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.joonheelee.roadster.R;
import com.joonheelee.roadster.ServiceClass.Time;
import com.vikramezhil.droidspeech.DroidSpeech;
import com.vikramezhil.droidspeech.OnDSListener;
import com.vikramezhil.droidspeech.OnDSPermissionsListener;

import android.media.MediaPlayer;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity implements OnClickListener, OnDSListener, OnDSPermissionsListener, OnInitListener {
    public final String TAG = "Activity_DroidSpeech";

    private DroidSpeech droidSpeech;
    private Button start, stop;
    TextView finalSpeechResult;

    static public String voiceinput;
    static public String anydata;

    TextToSpeech tts;

    MediaPlayer mp;
    int resMp3[] = {R.raw.me, R.raw.backwalking, R.raw.womancry, R.raw.recovery, R.raw.music, R.raw.relove};

    Timer timer;
    public static int timecount = 0;

    Time t = new Time();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Setting the layout;[.
        setContentView(R.layout.activity_main);

        // Initializing the droid speech and setting the listenerdroidSpeech = new DroidSpeech(this, getFragmentManager());
        droidSpeech = new DroidSpeech(this, getFragmentManager());
        droidSpeech.setOnDroidSpeechListener(this);
        droidSpeech.setShowRecognitionProgressView(true);
        droidSpeech.setRecognitionProgressMsgColor(Color.WHITE);
        droidSpeech.setOneStepVerifyConfirmTextColor(Color.WHITE);
        droidSpeech.setOneStepVerifyRetryTextColor(Color.WHITE);
        droidSpeech.setPreferredLanguage("ko-KR");

        finalSpeechResult = findViewById(R.id.result);

        tts = new TextToSpeech(this, this);

        start = findViewById(R.id.start);
        start.setOnClickListener(this);

        stop = findViewById(R.id.close);
        stop.setOnClickListener(this);

        Timer();
    }

    //타이머, 알람 체커
    private void Timer()
    {
        timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                timecount++;
                if(timecount == Time.timetocompare){
                    Time.timetocompare = -1;
                    timecount = 0;
                    tts.speak("타이머가 울립니다", TextToSpeech.QUEUE_FLUSH, null);
                    Play(2);
                }

            }
        }, 0, 1000);
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        if(stop.getVisibility() == View.VISIBLE)
        {
            stop.performClick();
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if(stop.getVisibility() == View.VISIBLE)
        {
            stop.performClick();
        }
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.start:

                // Starting droid speech
                droidSpeech.startDroidSpeechRecognition();

                // Setting the view visibilities when droid speech is running
                start.setVisibility(View.GONE);
                stop.setVisibility(View.VISIBLE);

                break;

            case R.id.close:

                // Closing droid speech
                droidSpeech.closeDroidSpeechOperations();

                stop.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);

                break;
        }
    }

    @Override
    public void onDroidSpeechSupportedLanguages(String currentSpeechLanguage, List<String> supportedSpeechLanguages)
    {
       /* Log.i(TAG, "Current speech language = " + currentSpeechLanguage);
        Log.i(TAG, "Supported speech languages = " + supportedSpeechLanguages.toString());

        if(supportedSpeechLanguages.contains("en-US"))
        {
            // Setting the droid speech preferred language as tamil if found
            droidSpeech.setPreferredLanguage("en-US");

            // Setting the confirm and retry text in tamil
            droidSpeech.setOneStepVerifyConfirmText("confirm");
            droidSpeech.setOneStepVerifyRetryText("Retry");
        }*/
    }

    @Override
    public void onDroidSpeechRmsChanged(float rmsChangedValue)
    {
        // Log.i(TAG, "Rms change value = " + rmsChangedValue);
    }

    private void Play(int selNo){

        Stop();

        mp = MediaPlayer.create(MainActivity.this, resMp3[selNo]);
        mp.start();
    }

    private void Stop(){

        if(mp!=null){
            mp.stop();
            mp = null;
        }

    }


    public void callname(){

        Input i = new Input();
        i.word();

        tts.speak(Input.resultoutput, TextToSpeech.QUEUE_FLUSH, null);

        if(Input.resultoutput.contains("노래")){

            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    Play(0);

                }
            }, 600);// 0.5초 정도 딜레이를 준 후 시작
        }

        if(voiceinput.contains("그만")){
            Stop();
            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    String str = "노래를 멈췄어요";
                    tts.speak(str, TextToSpeech.QUEUE_FLUSH, null);
                }
            }, 150);// 0.5초 정도 딜레이를 준 후 시작
        }
    }

    @Override
    public void onDroidSpeechLiveResult(String liveSpeechResult)
    {
        Log.i(TAG, "Live speech result = " + liveSpeechResult);
    }

    @Override
    public void onDroidSpeechFinalResult(String finalSpeechResult) {

        if (finalSpeechResult.contains("마크") || finalSpeechResult.contains("그만")) {
            voiceinput = finalSpeechResult;
            droidSpeech.closeDroidSpeechOperations();
            callname();

            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    droidSpeech.startDroidSpeechRecognition();
                }
            }, 1500);
        }

        else{
            voiceinput = finalSpeechResult;
            droidSpeech.closeDroidSpeechOperations();
            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    droidSpeech.startDroidSpeechRecognition();
                }
            }, 500);
        }

    }

    @Override
    public void onDroidSpeechClosedByUser()
    {
        stop.setVisibility(View.GONE);
        start.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDroidSpeechError(String errorMsg)
    {
        // Speech error
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();

        stop.post(new Runnable()
        {
            @Override
            public void run()
            {
                // Stop listening
                stop.performClick();
            }
        });
    }

    @Override
    public void onDroidSpeechAudioPermissionStatus(boolean audioPermissionGiven, String errorMsgIfAny)
    {
        if(audioPermissionGiven)
        {
            start.post(new Runnable()
            {
                @Override
                public void run()
                {
                    // Start listening
                    start.performClick();
                }
            });
        }
        else
        {
            if(errorMsgIfAny != null)
            {
                // Permissions error
                Toast.makeText(this, errorMsgIfAny, Toast.LENGTH_LONG).show();
            }

            stop.post(new Runnable()
            {
                @Override
                public void run()
                {
                    // Stop listening
                    stop.performClick();
                }
            });
        }
    }

    @Override
    public void onInit(int status) {
    }

}