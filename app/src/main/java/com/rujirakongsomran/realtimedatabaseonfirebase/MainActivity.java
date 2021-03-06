package com.rujirakongsomran.realtimedatabaseonfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rujirakongsomran.realtimedatabaseonfirebase.Adapter.MyAdapter;
import com.rujirakongsomran.realtimedatabaseonfirebase.Interface.IFirebaseLoadDone;
import com.rujirakongsomran.realtimedatabaseonfirebase.Model.Calorie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IFirebaseLoadDone {

    DatabaseReference caloriesRef;
    IFirebaseLoadDone iFirebaseLoadDone;
    List<Calorie> calories;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init DB
        caloriesRef = FirebaseDatabase.getInstance().getReference("Calories");
        // Init interface
        iFirebaseLoadDone = this;
        // Get data
        caloriesRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Calorie> calories = new ArrayList<>();
                for (DataSnapshot calorieSnapshot : snapshot.getChildren()) {
                    calories.add(calorieSnapshot.getValue(Calorie.class));
                }
                iFirebaseLoadDone.onFirebaseLoadSuccess(calories);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                iFirebaseLoadDone.onFirebaseLoadFailed(error.getMessage());

            }
        });

        recyclerView = findViewById(R.id.recyclerView);

        // Setting Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onFirebaseLoadSuccess(List<Calorie> calorieList) {
        calories = calorieList;
        MyAdapter adapter = new MyAdapter(this, calories);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onFirebaseLoadFailed(String message) {

    }
}