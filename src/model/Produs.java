package model;

public abstract class Produs extends Object{
    private long id_Product;
    private String name;
    private double minimValue;
    private Utilizator owner;
    public Produs() {

    }

    public Produs(long id, String name, double price) {
        this.id_Product = id;
        this.name = name;
        this.minimValue = price;
        //this.stock = stock;
    }

    public long getId() {
        return id_Product;
    }

    public void setId(long id) {
        this.id_Product = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }*/

    @Override //annotation
    public String toString() {
        return name + " / " + minimValue;
    }
}