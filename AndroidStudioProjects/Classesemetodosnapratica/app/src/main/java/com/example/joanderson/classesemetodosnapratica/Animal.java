package com.example.joanderson.classesemetodosnapratica;

/**
 * Created by joanderson on 04/04/18.
 */

class Animal {

    int tamanho;
    String cor;
    double peso;

    //getter: usado para recuperar o valor de uma propriedade
    //setter: usado para cofigurar o valor de uma propriedade


    public void setCor(String cor) {
    //  posso fazer formatação e validação


        this.cor = cor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    String getCor(){
        return this.cor;
    }
    void dormir(){//método
        System.out.println("Dormir como um animal");
    }

    void correr(){//método
        System.out.println("Correr como um animal");
    }
}
