package com.example.joanderson.classesemetodosnapratica;

/**
 * Created by joanderson on 04/04/18.
 */

class Funcionario {

    //propriedades/atributos
    String nome;
    double salario;

    //métodos

    void imprimirSalarioComDesconto (){
        System.out.println(this.salario - this.salario*0.1);
    }


    double recuperarSalario ( double bonus ){//método com/sem retorno
        this.salario = this.salario - (this.salario * 0.1);
        return this.salario + bonus;
       // System.out.println( this.salario );//sempre que quiser referenciar propriedade ou metodo dentro da própria classe usa this.

    }

}
