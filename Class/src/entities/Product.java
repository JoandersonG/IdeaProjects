package entities;

public class Product {

    public String name;
    public double price;
    public int quantityInStock;

    public double totalValueinStock(){
        return this.price*this.quantityInStock;
    }
    public void addProducts(int quantity){
        quantityInStock+=quantity;
    }
    public void removeProducts(int quantity){
        quantityInStock-=quantity;
    }

}
