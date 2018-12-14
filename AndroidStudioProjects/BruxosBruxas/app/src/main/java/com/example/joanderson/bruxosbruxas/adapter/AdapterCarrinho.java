package com.example.joanderson.bruxosbruxas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joanderson.bruxosbruxas.R;
import com.example.joanderson.bruxosbruxas.model.Carrinho;
import com.example.joanderson.bruxosbruxas.model.Item;

public class AdapterCarrinho  extends RecyclerView.Adapter<AdapterCarrinho.MyViewHolder> {

    private Carrinho carrinho;
    private int teste;
    public AdapterCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
        if (carrinho == null) {
            System.out.println("Carrinho é null");
        }
        else {
            System.out.println("Carrinho não é null");
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View itemCarrinho = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_carrinho, viewGroup, false);

        System.out.println("onCreateViewHolder: " + (itemCarrinho == null));
        return new MyViewHolder(itemCarrinho);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int i) {

        Item it = carrinho.getItens().get(i);

        myViewHolder.titulo.setText(it.getProduto().getNome());

        myViewHolder.descricaoResumida.setText(it.getProduto().getDescricao());

        myViewHolder.quantidade.setText(String.valueOf(it.getQuantidade()));

        myViewHolder.imagem.setImageResource(it.getProduto().getImagem());

        myViewHolder.btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //it.setQuantidade(it.getQuantidade()+1);
                carrinho.getItens().get(i).setQuantidade(carrinho.getItens().get(i).getQuantidade() + 1);
                myViewHolder.quantidade.setText(String.valueOf(carrinho.getItens().get(i).getQuantidade()));
                //todo: alterar total também
            }
        });
        System.out.println("onBindViewHolder: depois okay");

        myViewHolder.btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carrinho.getItens().get(i).getQuantidade() > 1) {
                    carrinho.getItens().get(i).setQuantidade(carrinho.getItens().get(i).getQuantidade() - 1);
                    myViewHolder.quantidade.setText(String.valueOf(carrinho.getItens().get(i).getQuantidade()));
                }
            }
        });




    }

    @Override
    public int getItemCount() {
        System.out.println("itemCount: ok");
        return carrinho.getItens().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imagem;
        TextView titulo, descricaoResumida,quantidade;
        ImageButton btAdd,btSub,btRemove;

        public MyViewHolder(View itemView) {
            super(itemView);

            imagem = itemView.findViewById(R.id.imageProduto);
            titulo = itemView.findViewById(R.id.tvTitulo);
            descricaoResumida = itemView.findViewById(R.id.tvDescricao);
            quantidade = itemView.findViewById(R.id.tvQtd);
            btAdd = itemView.findViewById(R.id.ibAdd);
            btSub = itemView.findViewById(R.id.ibSub);
            btRemove = itemView.findViewById(R.id.ibTrash);

            System.out.println("MyViewHolder: ok");
        }

    }

}
