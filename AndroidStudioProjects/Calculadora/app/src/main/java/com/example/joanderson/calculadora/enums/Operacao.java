package com.example.joanderson.calculadora.enums;

public enum Operacao {
    PONTO,
    ABRE_PARENTESES,
    FECHA_PARENTESES,
    NUMERO,
    MAIS,
    MENOS,
    VEZES,
    DIVIDIDO,
    CLEAR,
    BACKSPACE,
    IGUAL,
    MAISMENOS;


    public char operadorMatematico() {
        switch(this) {
            case MAIS:
                return '+';
            case MENOS:
                return '-';
            case VEZES:
                return '*';
            case DIVIDIDO:
                return '/';
            default:
                return ' ';
        }
    }
}
