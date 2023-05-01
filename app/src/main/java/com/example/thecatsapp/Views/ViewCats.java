package com.example.thecatsapp.Views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecatsapp.Models.Cat;
import com.example.thecatsapp.R;
import com.example.thecatsapp.ViewModel.ViewModelCat;

import java.util.List;

public class ViewCats extends AppCompatActivity {
    private ViewModelCat viewModelCat;
    private RecyclerView recyclerView;
    private AdapterCat adapterCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterCat = new AdapterCat(this);
        recyclerView.setAdapter(adapterCat);
        viewModelCat = new ViewModelProvider(this).get(ViewModelCat.class);
        viewModelCat.getCats().observe(this, new Observer<List<Cat>>() {
            @Override
            public void onChanged(List<Cat> cats) {
                adapterCat.setCats(cats);
            }
        });
    }
}
