package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<FoodModel> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();
    }

    private void addData() {
        elements = new ArrayList<>();
        elements.add(new FoodModel("Rendang", "20000", "4"));
        elements.add(new FoodModel("Mie Ayam", "10000", "5"));
        elements.add(new FoodModel("Baso", "120000", "4"));

        FoodAdapter adapter = new FoodAdapter(elements, this, new FoodAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(FoodModel item) {
//                detail(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rvFoods);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

//    private void detail(FoodModel item) {
//        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//        intent
//    }
}