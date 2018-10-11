package com.example.joanderson.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.joanderson.calculadora.treePackage.OperationTree;

public class MainActivity extends AppCompatActivity {

    private OperationTree tree = new OperationTree();
    private String mainScreen = "";
    private int currentNumber = 0;
    private char lastDigit = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        final Button button1 = findViewById(R.id.um);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operation(1);
                imprime('n');
            }
        });

        final Button button2 = findViewById(R.id.dois);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation(2);
                imprime('n');
            }
        });

        final Button button3 = findViewById(R.id.tres);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation(3);
                imprime('n');
            }
        });

        final Button button4 = findViewById(R.id.quatro);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation(4);
                imprime('n');
            }
        });

        final Button button5 = findViewById(R.id.cinco);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation(5);
                imprime('n');
            }
        });

        final Button button6 = findViewById(R.id.seis);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation(6);
                imprime('n');
            }
        });

        final Button button7 = findViewById(R.id.sete);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation(7);
                imprime('n');
            }
        });

        final Button button8 = findViewById(R.id.oito);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation(8);
                imprime('n');
            }
        });

        final Button button9 = findViewById(R.id.nove);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation(9);
                imprime('n');
            }
        });

        final Button button0 = findViewById(R.id.zero);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation(0);
                imprime('n');
            }

        });

        final Button buttonc = findViewById(R.id.clean);
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imprime('c');
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
                operation('+');
                imprime('o');
            }
        });

        final Button buttonMenos = findViewById(R.id.menos);
        buttonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation('-');
                imprime('o');
            }
        });

        final Button buttonVezes = findViewById(R.id.vezes);
        buttonVezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation('*');
                imprime('o');
            }
        });

        final Button buttonDividido = findViewById(R.id.dividido);
        buttonDividido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation('/');
                imprime('o');
            }
        });


        final Button buttonEq = findViewById(R.id.igual);
        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imprime('e');
            }
        });
    }


    private void operation(char op) {



        tree.insertNode(currentNumber);

        //if (lastDigit == 'o') {
        if (mainScreen.matches(".*[^0-9]")) {
            // último dígito foi um op
            // tree.replaceLastOperation(op);
            //todo: consertar os erros disso
            mainScreen = mainScreen.substring(0,mainScreen.length()-1);
            tree.removeLastAddedNode();
        }
        else {
            mainScreen += String.valueOf(op);
        }
        tree.insertNode(op);
        currentNumber = 0;
        //lastDigit = 'o';

    }

    private void operation(int num) {

        mainScreen += String.valueOf(num);
        //preciso guardar all of the número digitado
        currentNumber = currentNumber * 10 + num;
        //lastDigit = 'n';

    }

/*
    private void imprime() {

        final TextView mainView = findViewById(R.id.mainText);
        mainView.setText(mainScreen);
        if (lastDigit == 'n') {
            tree.insertNode(currentNumber);
        }

        if (mainScreen.matches(".*[0-9]+[^0-9][0-9]+")) {
            double res = tree.calculateTree();
            final TextView secView = findViewById(R.id.secText);
            String result = "= " + String.valueOf(res);
            secView.setText(result);
        }
        if(lastDigit == 'n'){
            tree.removeLastAddedNode();
        }
    }
*/

    private void imprime(char op) {

        final TextView mainView = findViewById(R.id.mainText);
        final TextView secView = findViewById(R.id.secText);

        switch (op) {
            case 'c':
                mainScreen = "";
                currentNumber = 0;
                lastDigit = ' ';
                secView.setText("");
                mainView.setText("");
                tree = new OperationTree();
                break;
            case 'e':
                if(mainScreen.matches(".*[^0-9]")) {
                    //todo: imprimir erro no balãozinho
                }
                else {
                    if (lastDigit == 'n') {
                        tree.insertNode(currentNumber);
                    }
                    //String result = "= " + String.valueOf(tree.calculateTree());
                    //mainView.setText(result);
                    double res = tree.calculateTree();
                    String result;
                    if (mainScreen.matches(".*[/].*")) {
                        result = "= " + String.valueOf(res);
                    }
                    else {
                        result = "= " +String.valueOf((long) res);
                    }
                    mainView.setText(result);
                    secView.setText("");
                }
                break;

            case 'o':
                mainView.setText(mainScreen);
                secView.setText("");
                break;

            case 'n':

                mainView.setText(mainScreen);
                tree.insertNode(currentNumber);
                if (mainScreen.matches(".*[0-9]+[^0-9][0-9]+")) {

                    double res = tree.calculateTree();
                    String result;
                    if (mainScreen.matches(".*[/].*")) {
                        result = "= " + String.valueOf(res);
                    }
                    else {
                        result = "= " +String.valueOf((long) res);
                        //todo: consertar formatação condicional
                    }

                    secView.setText(result);
                }
                tree.removeLastAddedNode();
                break;
        }
    }

    //todo: o que acontece se apagar mais de um operador?

    //todo: mudar string para view ficar ...2312+432 e tals quando exceder tamanho da view

    //todo: definir tamanho máximo de um operando

    //todo: não pode receber op como primeiro elemento da árvore

    //todo: outro otão cleaner
}



