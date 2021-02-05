package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button goButton;
    TextView timerTextView;
    TextView scoreTextView;
    CountDownTimer countDownTimer;
    String secondsLeft;
    TextView finalScoreTextView;
    GridLayout gridLayout;
    TextView sumTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         goButton = findViewById(R.id.goButton);
         timerTextView = findViewById(R.id.timerTextView);
         scoreTextView = findViewById(R.id.scoreTextView);
         finalScoreTextView = findViewById(R.id.finalScoreTextView);
         gridLayout = findViewById(R.id.grid);
         sumTextView = findViewById(R.id.sumTextView);
         sumTextView.setVisibility(View.INVISIBLE);
         finalScoreTextView.setVisibility(View.INVISIBLE);
         timerTextView.setVisibility(View.INVISIBLE);
         scoreTextView.setVisibility(View.INVISIBLE);
         gridLayout.setVisibility(View.GONE);

    }

    public void go(View view){

        timerTextView.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.INVISIBLE);
        finalScoreTextView.setVisibility(View.INVISIBLE);
        goButton.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        sumTextView.setVisibility(View.VISIBLE);

        countDownTimer = new CountDownTimer(30*1000 + 100 , 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                secondsLeft = Long.toString(millisUntilFinished/1000);
                if (millisUntilFinished/1000 <= 9){
                    secondsLeft = "0" + secondsLeft;
                }
                timerTextView.setText("00:" + secondsLeft);
            }

            @Override
            public void onFinish() {

                goButton.setVisibility(View.VISIBLE);
                finalScoreTextView.setText("Your score is: " + scoreTextView.getText());
                finalScoreTextView.setVisibility(View.VISIBLE);
                gridLayout.setVisibility(View.GONE);
                sumTextView.setVisibility(View.INVISIBLE);

            }
        }.start();

    }

    public void chooseAnswer(View view){

    }
}