package com.lalo.basketball;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private  final MutableLiveData<Integer> scorePlayer1 = new MutableLiveData<>();
    private  final MutableLiveData<Integer> scorePlayer2 = new MutableLiveData<>();

    public MainViewModel() {
        scorePlayer1.setValue(0);
        scorePlayer2.setValue(0);
    }

    public LiveData<Integer> getScorePlayer1() {
        return scorePlayer1;
    }

    public LiveData<Integer> getScorePlayer2(){
        return scorePlayer2;
    }

    void addPointsPlayer1(int points){
        scorePlayer1.setValue(scorePlayer1.getValue() + points);
    }

    void addPointsPlayer2(int points){
        scorePlayer2.setValue(scorePlayer2.getValue() + points);
    }

    void decreasePointsPlayer1(){
        if(scorePlayer1.getValue() > 0 ){
            scorePlayer1.setValue(scorePlayer1.getValue() - 1);
        }
    }

    void decreasePointsPlayer2(){
        if(scorePlayer2.getValue() > 0 ){
            scorePlayer2.setValue(scorePlayer2.getValue() - 1);
        }
    }

    void resetGame(){
        scorePlayer1.setValue(0);
        scorePlayer2.setValue(0);
    }

}
