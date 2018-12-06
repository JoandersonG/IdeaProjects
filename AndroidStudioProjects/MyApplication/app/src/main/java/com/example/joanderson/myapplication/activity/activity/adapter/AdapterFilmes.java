package com.example.joanderson.myapplication.activity.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.MyViewwHolder> {


    @NonNull
    @Override
    public MyViewwHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewwHolder myViewwHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewwHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView ano;
        TextView genero;


        public MyViewwHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
