 package com.example.on2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private DonutAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Donut> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList=new ArrayList<>();

        EditText editText= findViewById(R.id.editextS1);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


        for(int i=1;i<4;i++){
            arrayList.add(new Donut("Banana Donut","$10",R.drawable.donut_yellow));
            arrayList.add(new Donut("Candy Donut" ,"$20",R.drawable.tasty_donut));
            arrayList.add(new Donut("Matcha Donut","$30",R.drawable.green_donut));
            arrayList.add(new Donut("Red Donut","$40",R.drawable.donut_red));


    }

        mRecyclerView=findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mAdapter=new DonutAdapter(this,arrayList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
    private void filter(String tx){
        ArrayList<Donut> filterList= new ArrayList<>();
        for(Donut i:arrayList){
            if(i.getName().toLowerCase().contains(tx.toLowerCase())){
                filterList.add(i);
            }
        }
        mAdapter.filterListH(filterList);
    }
}