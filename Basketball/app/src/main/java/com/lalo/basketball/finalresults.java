package com.lalo.basketball;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;

import com.lalo.basketball.databinding.ActivityFinalresultsBinding;

public class finalresults extends AppCompatActivity {

    public static final String PLAYER1_RESULT = "1";

    public static final String PLAYER2_RESULT = "2";

    public static final String FINAL_RESULT = "Resultado";

    ActivityFinalresultsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFinalresultsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras  = getIntent().getExtras();
        binding.setFinalScorePlayer1(String.valueOf(extras.getInt(PLAYER1_RESULT)));
        binding.setFinalScorePlayer2(String.valueOf(extras.getInt(PLAYER2_RESULT)));
        binding.setFinalScore(extras.getString(FINAL_RESULT));
    }


}