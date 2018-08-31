package entities;

public class Triangle {

    public double a;
    public double b;
    public double c;

    public double area(){
        double p1 = (this.a+this.b+this.c)/2;
        p1 = Math.sqrt(p1*(p1-this.a)*(p1-this.b)*(p1-this.c));
        return  p1;
    }
}
