package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ViewPager promoViewPager;
    private int currentPage = 0;

    private static final short DELAY_MS = 3000;
    private static final short PERIOD_MS = 3000;
    List<FoodModel> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        promoViewPager = findViewById(R.id.promoViewPager);

        // Gantilah dengan sumber daya gambar yang sesuai
        int[] promoImages = {R.drawable.banner_discount_food, R.drawable.banner_discount_food, R.drawable.banner_discount_food};

        PromoPagerAdapter promoPagerAdapter = new PromoPagerAdapter(this, promoImages);
        promoViewPager.setAdapter(promoPagerAdapter);

        // Otomatis ganti halaman setiap beberapa detik
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == promoImages.length) {
                    currentPage = 0;
                }
                promoViewPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_MS, PERIOD_MS);
        addData();
    }
//        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.item_spacing);


    private void addData() {
        elements = new ArrayList<>();
        elements.add(new FoodModel("Rendang", "20000", "4", R.drawable.rendang));
        elements.add(new FoodModel("Mie Ayam", "10000", "5", R.drawable.mieayam));
        elements.add(new FoodModel("Baso", "120000", "4", R.drawable.baso));
        elements.add(new FoodModel("Rendang", "20000", "4", R.drawable.rendang));
        elements.add(new FoodModel("Mie Ayam", "10000", "5", R.drawable.mieayam));
        elements.add(new FoodModel("Baso", "120000", "4", R.drawable.baso));
        elements.add(new FoodModel("Rendang", "20000", "4", R.drawable.rendang));
        elements.add(new FoodModel("Mie Ayam", "10000", "5", R.drawable.mieayam));
        elements.add(new FoodModel("Baso", "120000", "4", R.drawable.baso));

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
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new RecyclerViewItemDecoration(this));
    }


//    private void detail(FoodModel item) {
//        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//        intent
//    }
}