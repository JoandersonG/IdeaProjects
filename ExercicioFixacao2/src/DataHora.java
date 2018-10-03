public class DataHora {
    private int dia;
    private int mes;
    private int ano;
    private Horario hora;

    public DataHora(int dia, int mes, int ano, int hora, int minuto) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = new Horario(hora,minuto);
    }

    public DataHora(int dia, int mes, int ano) {
        this(dia,mes,ano,0,0);
    }

    public DataHora(int hora, int minuto) {
        this(0,0,0, hora, minuto);
    }

    public void ajustar(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this. ano = ano;
    }

    public void ajustar(int hora, int minuto) {
        this.hora.setHora(hora);
        this.hora.setMinuto(minuto);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Horario getHora() {
        return hora;
    }

    public void setHora(Horario hora) {
        this.hora = hora;
    }
}
