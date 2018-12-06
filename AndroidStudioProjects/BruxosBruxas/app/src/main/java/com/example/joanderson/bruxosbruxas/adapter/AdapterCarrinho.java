package com.example.joanderson.bruxosbruxas.adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joanderson.bruxosbruxas.R;

public class AdapterCarrinho  extends RecyclerView.Adapter<AdapterCarrinho.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemCarrinho = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_carrinho, viewGroup,false);

        return new MyViewHolder(itemCarrinho);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.titulo.setText("Testando Título");
            myViewHolder.quantidade.setText("1");
            myViewHolder.descricaoResumida.setText("Este é um teste de descrição. I hope it worked...");

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imagem;
        TextView titulo, descricaoResumida,quantidade;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imagem = itemView.findViewById(R.id.imageProduto);
            titulo = itemView.findViewById(R.id.tvTitulo);
            descricaoResumida = itemView.findViewById(R.id.tvDescricao);
            quantidade = itemView.findViewById(R.id.tvQtd);



        }
    }

}
