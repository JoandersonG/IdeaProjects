package com.example.joanderson.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double x=0,y=0,op1=0,resultAnt=0;
    int sFlag=0,flag=0;
    boolean flag2=false,jaApertouUmaOp=false;
    //flag2: se false, então não imprima no principal, só no sec. Se true, no principal e remove do sec.
    //x: primeiro operando
    //y: segundo operando
    String s,saver;
    char op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = findViewById(R.id.um);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operador(1);
                imprime();
            }
        });

        final Button button2 = findViewById(R.id.dois);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador(2);
                imprime();
            }
        });

        final Button button3 = findViewById(R.id.tres);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador(3);
                imprime();
            }
        });

        final Button button4 = findViewById(R.id.quatro);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador(4);
                imprime();
            }
        });

        final Button button5 = findViewById(R.id.cinco);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador(5);
                imprime();
            }
        });

        final Button button6 = findViewById(R.id.seis);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador(6);
                imprime();
            }
        });

        final Button button7 = findViewById(R.id.sete);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador(7);
                imprime();
            }
        });

        final Button button8 = findViewById(R.id.oito);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador(8);
                imprime();
            }
        });

        final Button button9 = findViewById(R.id.nove);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador(9);
                imprime();
            }
        });

        final Button button0 = findViewById(R.id.zero);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador(0);
                imprime();
            }

        });

        final Button buttonc = findViewById(R.id.clean);
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op=' ';
            }
        });

        final Button buttonPonto = findViewById(R.id.ponto);
        buttonPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        final Button buttonMaisMenos = findViewById(R.id.maismenos);
        buttonMaisMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        final Button buttonFatorial = findViewById(R.id.fatorial);
        buttonFatorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        final Button buttonPorcento = findViewById(R.id.porcento);
        buttonPorcento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        final Button buttonMais = findViewById(R.id.mais);
        buttonMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op='+';
                if(flag==2){
                    //se a flag é 2, ou seja, (x + y), e a pessoa digitou uma operação, então
                    //resolvo a operação, coloco em x, zero y e volto com a flag para 1 e imprimo
                    x=operacao(x,y);
                    y=0;
                    flag=1;
                }
                else{
                    flag++;
                }
                imprime();
            }
        });

        final Button buttonMenos = findViewById(R.id.menos);
        buttonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op='-';
                flag++;
            }
        });

        final Button buttonVezes = findViewById(R.id.vezes);
        buttonVezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op='*';
                flag++;
            }
        });

        final Button buttonDividido = findViewById(R.id.dividido);
        buttonDividido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op='/';
                flag++;
            }
        });


        final Button buttonEq = findViewById(R.id.igual);
        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void operador (long numDig){
       if(flag==0) {
           if (x <= 99999999999999L) {
               x = (x * 10) + numDig;
           }
       }
       else {
           if (y <= 99999999999999L) {
               y = (y * 10) + numDig;
           }
       }
    }
    /*
    public void impressaoMain (){
        final TextView mainText = findViewById(R.id.mainText);
            mainText.setText(s);
    }
    */
    public boolean valida(){
        return s.matches("\\d{1,}[+ | - | * | / | ! | %]\\d{1,}");
    }

    public void imprime(){
        TextView mainText = findViewById(R.id.mainText);
        if(flag>=2){
            TextView secText = findViewById(R.id.secText);
            double result = operacao(x,y);
            secText.setText(String.valueOf(result));
        }
        switch (flag){
            case 0:
                s=String.valueOf(x);
                mainText.setText(s);
                break;
            case 1:
                s=String.valueOf(x)+op;
                mainText.setText(s);
                break;
            case 2:
                s=String.valueOf(x)+op+String.valueOf(y);
                mainText.setText(s);
                break;
            case 3:
                //resultado
                s="="+String.valueOf(operacao(x,y));

        }
    }
    public double operacao(double k,double z){
        //só mande para operacoes() se valida() for true
        switch (op){
            case '+':
                return k+z;
            case '-':
                return k-z;
            case '*':
                return k*z;
            case '/':
                return k/z;
            case '!':
             //   return fatorial(k);
            case '%':
             //   return porcentagem(k,z);
        }
        return -111;
    }
    /*
    public void soma (long x,long y){
       long result = x+y;
       if(flag2) {//imprime no principal
           final TextView mainText = findViewById(R.id.mainText);
           mainText.setText("=" + String.valueOf(result));

           final TextView secText = findViewById(R.id.secText);
           secText.setText(" ");
       }
       else {//imprime no secundário
           final TextView secText = findViewById(R.id.secText);
           secText.setText(String.valueOf(result));
       }
    }
    */
    /*
    public double fatorial (double k){

    }

    public double porcentagem (double k, double z){

    }
    public void maismenos (){

    }

    public void floatpoint (){

    }
    */
    //------------------------------------------------------------------------------

}
