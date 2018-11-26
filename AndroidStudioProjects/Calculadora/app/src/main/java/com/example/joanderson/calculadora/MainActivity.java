package com.example.joanderson.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.joanderson.calculadora.treePackage.OperationTree;
import com.example.joanderson.calculadora.enums.Operacao;

import java.util.Locale;

import static com.example.joanderson.calculadora.enums.Operacao.MAISMENOS;
import static com.example.joanderson.calculadora.enums.Operacao.PONTO;

public class MainActivity extends AppCompatActivity {


    Locale locale = Locale.US;

    private OperationTree tree = new OperationTree();
    private String mainScreen = "",currentNumberDecimal = "0.";
    private double currentNumber = 0;
    private Boolean decimalFlag = false;

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
                operation(Operacao.PONTO);
                imprime('n');
            }
        });

        final Button buttonMaisMenos = findViewById(R.id.maismenos);
        buttonMaisMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation(MAISMENOS);
            }
        });

        final Button buttonFatorial = findViewById(R.id.fechaParen);
        buttonFatorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        final Button buttonPorcento = findViewById(R.id.abreParen);
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


    public boolean test(); //testa se entrada é válida
    public boolean imprime(); //salva na string da tela e imprime
    public void operacao(); //

    public boolean testePonto() {}

    public void printInScreen() {

    }



    //Define o que deve ser feito a depender do botão digitado
    private void operation(int num) {
        mainScreen += String.valueOf(num);
        if (decimalFlag) {
            currentNumberDecimal += String.valueOf(num);
        }
        else {
            currentNumber = currentNumber * 10 + num;
        }
        tree.addNode(currentNumber + Double.valueOf(currentNumberDecimal));
        //if (mainScreen.matches(".*[0-9]+[[^0-9]&&[^.]][0-9]+.*")) {
        if (mainScreen.matches(".*[0-9]+[[^0-9]&&[^.]][0-9]+")) {
            // regex: tem número, operadorMatematico e termina com numero
            double res = tree.calculateTree();
            String result;
            if (String.valueOf(res).matches(".*[.0]") ) {
                result = "= " +String.valueOf((long) res);
            }
            else {
                result = "= " + String.valueOf(res);
            }

            auxiliarView = result;
        }
        tree.removeLastAddedNode();

    }
    public void operation(Operacao operacao) {

        switch(operacao) {
            case MAIS:
                //igual ao próximo, não precisa do break
            case MENOS:
                //igual ao próximo, não precisa do break
            case VEZES:
                //igual ao próximo, não precisa do break
            case DIVIDIDO:
                if (mainScreen.matches("[0-9].*")) {
                    //regex: testa se há número(s)

                    tree.addNode(currentNumber + Double.valueOf(currentNumberDecimal));
                    if (mainScreen.matches(".*[[^0-9]&&[^.]]")) {
                        // último dígito foi um op

                        mainScreen = mainScreen.substring(0,mainScreen.length()-1);
                        tree.removeLastAddedNode();
                    }

                    mainScreen += String.valueOf(operacao.operadorMatematico());
                    tree.addNode(operacao.operadorMatematico());
                    currentNumber = 0;
                }
                auxiliarView = "";
                decimalFlag = false;
                currentNumberDecimal = "0.";
                break;

            case PONTO:
                if(mainScreen.matches(".*[[^0-9]&&[^.]]") || mainScreen.matches("")) {
                    //regex: algo terminando em operadorMatematico || String vazio
                    mainScreen += "0";
                }
                if (mainScreen.matches(".*[[^0-9]&&[^.]][0-9]*|[0-9]*")) {
                //if (mainScreen.matches(".*[0-9]")) {
                    //regex:
                    mainScreen += ".";
                    decimalFlag = true;
                }
                break;

            case IGUAL:
                if(mainScreen.matches(".*[^0-9]|[0-9]*[.][0-9]*|[0-9]*")) {//|| mainScreen.matches("[0-9]*[.][0-9]* | [0-9]*")) {
                    //todo: imprimir erro no balãozinho:operação não permitida
                }
                else {
                    tree.addNode(currentNumber + Double.valueOf(currentNumberDecimal));

                    double res = tree.calculateTree();
                    String result;
                    if (String.valueOf(res).matches(".*[.0]") ) {
                        //regex: não tem valor na parte decimal
                        result = String.valueOf((long) res);
                    }
                    else {
                        result = String.valueOf(res);
                    }
                    mainScreen = result;
                    auxiliarView = "";
                    tree = new OperationTree();
                    tree.addNode(res);
                }

                break;

            case CLEAR:
                mainScreen = "";
                auxiliarView = "";
                currentNumber = 0;
                currentNumberDecimal = "0.";
                decimalFlag = false;
                tree = new OperationTree();
                break;

            case MAISMENOS:
                if (mainScreen.matches(".*[[^.]&&[^0-9]]") || mainScreen.matches("")) {
                    tree.addNode('(');
                    currentNumber = ...
                }
                else {// termina com um número
                    String auxiliarString = mainScreen.substring(mainScreen.lastIndexOf(Double.toString(currentNumber)),mainScreen.length()); //ou seria menos 1?
                    mainScreen = mainScreen.substring(0,mainScreen.lastIndexOf(Double.toString(currentNumber)));
                    currentNumber = -currentNumber;
                    mainScreen += currentNumber;
                    mainScreen += auxiliarString;
                    tree.addNode(currentNumber + Double.valueOf(currentNumberDecimal));
                    if (mainScreen.matches(".*[0-9]+[[^0-9]&&[^.]][0-9]+")) {
                        // regex: tem número, operadorMatematico e termina com numero
                        double res = tree.calculateTree();
                        String result;
                        if (String.valueOf(res).matches(".*[.0]") ) {
                            result = String.valueOf((long) res);
                        }
                        else {
                            result = String.valueOf(res);
                        }

                        auxiliarView = result;
                    }
                    tree.removeLastAddedNode();
                }

                break;

            case ABRE_PARENTESES:
                tree.addNode('(');
                mainScreen += "(";

                break;

            case FECHA_PARENTESES:

                tree.addNode(')');
                mainScreen += ")";
                tree.addNode(currentNumber + Double.valueOf(currentNumberDecimal));
                if (mainScreen.matches(".*[0-9]+[[^0-9]&&[^.]][0-9]+")) {
                    // regex: tem número, operadorMatematico e termina com numero
                    double res = tree.calculateTree();
                    String result;
                    if (String.valueOf(res).matches(".*[.0]") ) {
                        result = String.valueOf((long) res);
                    }
                    else {
                        result = String.valueOf(res);
                    }

                    auxiliarView = result;
                }
                tree.removeLastAddedNode();
        }










        if (operacao == PONTO) {

            if(mainScreen.matches(".*[[^0-9]&&[^.]]") || mainScreen.matches("")) {
                mainScreen += "0";
            }
            if (mainScreen.matches(".*[[^0-9]&&[^.]][0-9]*|[0-9]*")) {
                mainScreen += ".";
                decimalFlag = true;
            }
            return;
        }

        if (mainScreen.matches("[0-9].*")) {

            tree.addNode(currentNumber + Double.valueOf(currentNumberDecimal));


            if (mainScreen.matches(".*[[^0-9]&&[^.]]")) {
                // último dígito foi um op

                mainScreen = mainScreen.substring(0,mainScreen.length()-1);
                tree.removeLastAddedNode();
            }

            mainScreen += String.valueOf(op);
            tree.addNode(op);
            currentNumber = 0;
        }
        //lastDigit = 'o';
        decimalFlag = false;
        currentNumberDecimal = "0.";

    }
/*    private void operation(char op) {

        if (op == 'p') {

            if(mainScreen.matches(".*[[^0-9]&&[^.]]") || mainScreen.matches("")) {
                mainScreen += "0";
            }
            if (mainScreen.matches(".*[[^0-9]&&[^.]][0-9]*|[0-9]*")) {
                mainScreen += ".";
                decimalFlag = true;
            }
            return;
        }

        if (mainScreen.matches("[0-9].*")) {

            tree.addNode(currentNumber + Double.valueOf(currentNumberDecimal));


            if (mainScreen.matches(".*[[^0-9]&&[^.]]")) {
                // último dígito foi um op

                mainScreen = mainScreen.substring(0,mainScreen.length()-1);
                tree.removeLastAddedNode();
            }

            mainScreen += String.valueOf(op);
            tree.addNode(op);
            currentNumber = 0;
        }
        //lastDigit = 'o';
        decimalFlag = false;
        currentNumberDecimal = "0.";

    }*/

    private void operation(int num) {

        mainScreen += String.valueOf(num);
        if (decimalFlag) {
            currentNumberDecimal += String.valueOf(num);
        }
        else {
            currentNumber = currentNumber * 10 + num;
        }

    }

    //todo:  documentação
    private void imprime(char op) {

        final TextView mainView = findViewById(R.id.mainText);
        final TextView secView = findViewById(R.id.secText);

        switch (op) {
            case 'c':
                mainScreen = "";
                currentNumber = 0;
                currentNumberDecimal = "0.";
                decimalFlag = false;
                //lastDigit = ' ';
                secView.setText("");
                mainView.setText("");
                tree = new OperationTree();
                break;
            case 'e':
                if(mainScreen.matches(".*[^0-9]|[0-9]*[.][0-9]*|[0-9]*")) {//|| mainScreen.matches("[0-9]*[.][0-9]* | [0-9]*")) {
                    //todo: imprimir erro no balãozinho
                }
                else {
                    tree.addNode(currentNumber + Double.valueOf(currentNumberDecimal));

                     double res = tree.calculateTree();
                    String result;
                    //if (mainScreen.matches(".*[/].*") || mainScreen.matches(".*[.].*")) {
                    if (String.valueOf(res).matches(".*[.0]") ) {
                        result = "= " +String.valueOf((long) res);
                    }
                    else {
                        result = "= " + String.valueOf(res);
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
                tree.addNode(currentNumber + Double.valueOf(currentNumberDecimal));
                if (mainScreen.matches(".*[0-9]+[[^0-9]&&[^.]][0-9]+.*")) {
                    double res = tree.calculateTree();
                    String result;

                    if (String.valueOf(res).matches(".*[.0]") ) {
                        result = "= " +String.valueOf((long) res);
                    }
                    else {
                        result = "= " + String.valueOf(res);
                    }

                    secView.setText(result);
                }
                tree.removeLastAddedNode();
                break;
            case 'p':
                mainView.setText(mainScreen);
                //todo: terminar isso também

        }
    }

    //todo: o que acontece se apagar mais de um operadorMatematico?

    //todo: mudar string para view ficar ...2312+432 e tals quando exceder tamanho da view

    //todo: definir tamanho máximo de um operando

    //todo: não pode receber op como primeiro elemento da árvore

    //todo: outro otão cleaner
}



