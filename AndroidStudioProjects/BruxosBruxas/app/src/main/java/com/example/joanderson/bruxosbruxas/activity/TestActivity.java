package com.example.joanderson.bruxosbruxas.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.joanderson.bruxosbruxas.R;
import com.example.joanderson.bruxosbruxas.adapter.AdapterCarrinho;

public class TestActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho_);

        recyclerView = findViewById(R.id.rvCarrinho);

    }
}
