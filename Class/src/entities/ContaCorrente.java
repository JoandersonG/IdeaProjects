package entities;

public class ContaCorrente {
    private int numeroConta;
    private int digitoVerificador1;
    private int digitoVerificador2;
    private int agencia;
    private int grauConta;
    private double saldo;
    private double limite;
    private boolean atividade;

    public ContaCorrente(int numeroConta, int agencia, int grauConta, double limite, double depositoInicial) {
        boolean erro = testeErro(grauConta,depositoInicial,limite);
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        if (grauConta < 0 || grauConta > 3) {
            this.grauConta = 0; //defino como conta comum
        }
        else {
            this.grauConta = grauConta;
        }
        if (this.grauConta == 0 || limite < 0) {
            this.limite = 0;
        }
        else {
            this.limite = limite;
        }
        saldo = depositoInicial;
        atividade = !erro;
        if (!erro) {
            digitoVerificador1 = calc1DigV();
            digitoVerificador2 = calc2DigV();
        }
    }

    public int calc1DigV() {
        int k,auxNumConta=numeroConta, cont=1,soma=0,i=0,aux = 1;

        while (auxNumConta > 0) {
            cont=1;
            k=auxNumConta;
            i++;
            while (k >= 10) {
                k /= 10;
                cont *= 10;
            } //tenho o i-ésimo dígito
            soma += k * i;
            auxNumConta -= (cont * k);
        }
        while (soma>=10) {
            soma -= 9;
        }
        return  soma;
    }

    public int calc2DigV() {
        int k, auxNumConta = numeroConta, soma = 0;
        for (int i=1; auxNumConta > 0 ; i++) {
            k = (auxNumConta / 10) * 10; //k é o valor dos primeiros dígitos exceto o último;
            k = auxNumConta - k; //k é o último dígito;
            soma += k * i;
            auxNumConta /= 10;
        }

        for ( ; soma >= 10; ) {
            soma -= 9;
        }
        return soma;
    }

    public boolean lancOp(double valorOp, char tipoOp) {
        if (tipoOp == 'C') {
            saldo += valorOp;
            return true;
        }
        else if (tipoOp == 'D') {
            if (valorOp <= saldo + limite) {
                saldo -= valorOp;
                return true;
            }
            else {
                System.out.println("Erro: Limite + saldo insuficientes.");
                return false;
            }
        }
        else{
            System.out.println("Erro: Operação desconhecida rejeitada.");
            return false;
        }
    }

    public void setLimite ( double novoLimite) {
        if (novoLimite > 0 && grauConta == 0){
            System.out.println("Erro: conta comum deve ter limite zero.");
        }
        else if (novoLimite + saldo < 0) {
            System.out.println("Erro: novo limite não cobre o saldo negativo da conta.");
        }
        else {
            this.limite = novoLimite;
        }
    }

    public void setGrau(int novoGrau) {
        if(novoGrau < 0 || novoGrau > 3) {
            System.out.println("Erro: grau inválido.");
        }
        else if(novoGrau == 0){
            if(saldo >= 0){
                this.limite = 0;
                this.grauConta = novoGrau;
            }
            else {
                System.out.println("Erro: conta com saldo negativo não pode ter grau 0.");
            }
        }
        else {
            this.grauConta = novoGrau;
        }
    }

    public int getNumConta() {
        return this.numeroConta;
    }

    public int getNumAgencia() {
        return this.agencia;
    }

    public int getDigVer1() {
        return this.digitoVerificador1;
    }

    public int getDigVer2() {
        return this.digitoVerificador2;
    }

    public int getGrau() {
        return this.grauConta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double getLimite() {
        return this.limite;
    }

    public boolean isAtiva() {
        return atividade;
    }

    private boolean testeErro (int grauConta, double depositoInicial,double limite) {
        boolean erro = false;
        if (grauConta > 3 || grauConta < 0){
            erro = true;
            System.out.println("Erro na criacao da conta em: Grau da Conta.\n" + "Valor esperado: entre 0 e 3.");
        }
        else{
            switch (grauConta){
                case 0:
                    if (depositoInicial < 100){
                        erro = true;
                    }
                    break;
                case 1:
                    if (depositoInicial < 200){
                        erro = true;
                    }
                    break;
                case 2:
                    if (depositoInicial < 500){
                        erro = true;
                    }
                    break;
                case 3:
                    if (depositoInicial < 1000){
                        erro = true;
                    }
                    break;
            }
            if (erro) {
                System.out.println("Erro no valor de deposito. Quantia insuficiente." );
            }
        }
        if(limite < 0) {
            System.out.println("Erro no valor do limite. Não pode ser quantia negativa.");
            erro = true;
        }
        if(limite > 0 && grauConta==0){
            System.out.println("Erro no valor do limite. Contas de grau 0 devem ter limite zero.");
            erro = true;
        }
        return erro;
    }
}

/*
/**
 * ContaCorrente
 *
 * @Tayna Valverde Rosa
 *
 
package entities;
public class ContaCorrente
{
    private int numeroConta, numeroAgencia, digVer1, digVer2;
    private int grauDaConta;
    private double limite, saldo;
    private boolean isAtiva;

    public ContaCorrente(int numeroConta,int numeroAgencia,int grauDaConta,double limite,double depositoInicial)
    {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.grauDaConta = grauDaConta;
        this.limite = limite;
        this.saldo = depositoInicial;
        this.isAtiva = isAtiva();
        this.digVer1 = calc1DigV();
        this.digVer2 = calc2DigV();
    }

    public int getNumConta()
    {
        return numeroConta;
    }

    public int getNumAgencia()
    {
        return numeroAgencia;
    }



    public int getGrau()
    {
        return grauDaConta;
    }



    public double getLimite()
    {
        return limite;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public boolean isAtiva()
    {
        int grauDaConta = this.grauDaConta;
        double saldo = this.saldo;
        double limite = this.limite;
        boolean ativa = this.isAtiva;

        switch(grauDaConta){
            case 0:
                if(saldo >= 100 && limite == 0){
                    ativa = true;

                }else{
                    if(saldo < 100)
                        System.out.println("Saldo incompativel");
                    if(limite != 0)
                        System.out.println("Limite incompativel");

                    ativa = false;

                }
                break;

            case 1:
                if(saldo >= 200 && limite > 0){
                    ativa = true;

                }else{
                    if(saldo < 200)
                        System.out.println("Saldo incompativel");
                    if(limite < 0)
                        System.out.println("Limite incompativel");
                    ativa = false;

                }
                break;

            case 2:
                if(saldo >= 500 && limite > 0){
                    ativa=true;

                }else{
                    if(saldo < 500)
                        System.out.println("Saldo incompativel");
                    if(limite < 0)
                        System.out.println("Limite incompativel");
                    ativa = false;


                }
                break;

            case 3:
                if(saldo >= 1000 && limite > 0){
                    ativa = true;

                }else{
                    if(saldo < 1000)
                        System.out.println("Saldo incompativel");
                    if(limite < 0)
                        System.out.println("Limite incompativel");
                    ativa = false;

                }
                break;

            default:
                System.out.println("Type 0 a 3");

                if(limite < 0)
                    System.out.println("Limite incompativel");

                ativa = false;
                break;

        }

        return ativa;

    }






    public int calc1DigV(){
        int numeroConta = this.numeroConta;
        int soma=0,a = numeroConta,i=0,resto,cont=0;

        while(a > 0){
            a = a/10;
            cont++;
        }

        while(cont > 0){
            resto = (numeroConta%10)*cont--;
            numeroConta = numeroConta/10;
            soma += resto;
        }

        while(soma > 9){
            soma -= 9;
        }

        if(isAtiva() == true){
            return soma;
        }else{
            System.out.println("Conta Inativa, sem digVer");
            return 0;
        }
    }

    public int calc2DigV(){
        int numeroConta = this.numeroConta;
        int soma=0,a = numeroConta,cont=1,j,k,resto;

        for(j = a; j > 0; a = a/10){
            resto = (a%10)*j;

            soma += resto;
        }
        for(k = 0;k < numeroConta ; k++ ){

            if(soma > 9){
                soma -= 9;

            }else{
                break;
            }
        }

        if(isAtiva() == true){
            return soma;
        }else{
            System.out.println("Conta Inativa, sem digVer");
            return 0;
        }
    }
    public int  getDigVer1(){

        return digVer1;

    }

    public int getDigVer2(){

        return digVer2;

    }

    public boolean lancOp(double valorOp, char tipoOp){
        double saldo = this.saldo;
        double limite = this.limite;
        boolean message=false;
        switch(tipoOp){
            case 'D':
                saldo -= valorOp;
                if(saldo < (-1)*limite){
                    saldo = this.saldo;
                    System.out.println("Saldo > Limite (Negativo)");
                    message = false;
                }
                message = true;
                break;
            case 'C':
                saldo += valorOp;
                message = true;
                break;
            default:
                System.out.println("Type C ou D");
                break;

        }
        return message;
    }

    public void setLimite(double novoLimite){
        switch(this.grauDaConta){
            case 0:
                System.out.println("Grau 0 - Nao altera");
                break;
            case 1:
                if(this.saldo < (-1)*novoLimite){
                    System.out.println("Limite incompativel");

                }else{
                    this.limite = novoLimite;

                }
                break;
            case 2:
                if(this.saldo < (-1)*novoLimite){
                    System.out.println("Limite incompativel");

                }else{
                    this.limite = novoLimite;

                }
                break;
            case 3:
                if(this.saldo < (-1)*novoLimite){
                    System.out.println("Limite incompativel");

                }else{
                    this.limite = novoLimite;

                }
                break;
            default:
                System.out.println("Grau incompativel");
                break;
        }
    }

    public void setGrau(int novoGrau){
        switch(novoGrau){
            case 0:
                if(this.saldo >= 0){
                    this.limite = 0;
                    this.grauDaConta = 0;
                }else
                    System.out.println("Saldo negativo");
                break;
            case 1:
                this.grauDaConta = 1;
                break;
            case 2:
                this.grauDaConta = 2;
                break;
            case 3:
                this.grauDaConta = 3;
                break;
            default:
                System.out.println("Grau incompativel");
                break;
        }
    }



}
*/
