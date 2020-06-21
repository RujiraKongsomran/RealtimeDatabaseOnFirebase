package com.rujirakongsomran.realtimedatabaseonfirebase.Interface;

import com.rujirakongsomran.realtimedatabaseonfirebase.Model.Calorie;

import java.util.List;

public interface IFirebaseLoadDone {
    void onFirebaseLoadSuccess(List<Calorie> calorieList);
    void onFirebaseLoadFailed(String message);
}
