package com.example.appgrade_v2;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityClicker extends AppCompatActivity {

    RecyclerView recyclerClick;
    ArrayList<Clicker> clickerList = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_clicker);

        recyclerClick = findViewById(R.id.recycler_clicker);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerClick.setLayoutManager(layoutManager);

        clickerList = (ArrayList<Clicker>) getIntent().getExtras().getSerializable("list");

        recyclerClick.setAdapter(new ClickerAdapter(clickerList));
    }
}

