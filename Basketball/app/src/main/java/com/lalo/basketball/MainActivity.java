package com.lalo.basketball;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.lalo.basketball.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding  binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getScorePlayer1().observe(this, score -> {
            updateScorePlayer1(score);
        });

        viewModel.getScorePlayer2().observe(this, score ->{
            updateScorePlayer2(score);
        });

        binding.btnIncrementOnePlayer1.setOnClickListener(v -> {
            viewModel.addPointsPlayer1(1);
        });

        binding.btnIncrementTwoPlayer1.setOnClickListener(v -> {
            viewModel.addPointsPlayer1(2);
        });

        binding.btnIncrementOnePlayer2.setOnClickListener(v -> {
            viewModel.addPointsPlayer2(1);
        });

        binding.btnIncrementTwoPlayer2.setOnClickListener(v ->{
            viewModel.addPointsPlayer2(2);
        });

        binding.btnMinusPlayer1.setOnClickListener(v -> {
            viewModel.decreasePointsPlayer1();
        });

        binding.btnMinusplayer2.setOnClickListener(v -> {
            viewModel.decreasePointsPlayer2();
        });

        binding.btnResetGame.setOnClickListener(v -> {
            viewModel.resetGame();
        });

        binding.btnResult.setOnClickListener(v -> {
            int player1Score = Integer.parseInt(binding.txtScorePlayer1.getText().toString());
            int player2Score = Integer.parseInt(binding.txtScorePlayer2.getText().toString());
            openResultActivity(player1Score, player2Score);
        });

    }

    private void updateScorePlayer1(int score) {
        binding.txtScorePlayer1.setText(String.valueOf(score));
    }

    private void updateScorePlayer2(int score){
        binding.txtScorePlayer2.setText(String.valueOf(score));
    }

    private void openResultActivity(int player1Result, int player2Result){
        String finalResult =finalResult(player1Result, player2Result);
        Intent intent = new Intent(this, finalresults.class);
        intent.putExtra(finalresults.PLAYER1_RESULT, player1Result);
        intent.putExtra(finalresults.PLAYER2_RESULT, player2Result);
        intent.putExtra(finalresults.FINAL_RESULT, finalResult);
        startActivity(intent);
    }

    private String finalResult(int player1Result, int player2Result){
        String result = "Es un empate";
            if(player1Result > player2Result){
                result = "El equipo local ha ganado";
            }else if(player1Result < player2Result){
                result = "El equipo visitante ha ganado";
            }
        return result;
    }

}