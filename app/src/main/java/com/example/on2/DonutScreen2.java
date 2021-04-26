package com.example.on2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DonutScreen2 extends AppCompatActivity {
    private TextView mName2;
    private TextView mPrice2;
    private ImageView mImg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut_screen2);

        int mImg=getIntent().getIntExtra("img2",2);
        String  mtvName=getIntent().getStringExtra("name");
        String mtvPrice=getIntent().getStringExtra("price");

        mName2=findViewById(R.id.tvNameS2);
        mPrice2=findViewById(R.id.tvPriceS2);
        mImg2=findViewById(R.id.imgS2);

        mName2.setText(mtvName);
        mPrice2.setText(mtvPrice);
        mImg2.setImageResource(mImg);

    }
}