package model;

public abstract class Produs{
    private long id_Product;
    private String product_Name;
    private double minimValue;
    private Utilizator owner;
    private boolean sold;
    private Utilizator buyer;

    public Produs() {

    }

    public Produs(long id, String product_Name, double minimValue) {
        this.id_Product = id;
        this.product_Name = product_Name;
        this.minimValue = minimValue;
    }

    public long getId_Product() {
        return id_Product;
    }

    public void setId_Product(long id) {
        this.id_Product = id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String name) {
        this.product_Name = name;
    }

    public double getMinimValue() {
        return minimValue;
    }

    public void setMinimValue(double mV) {
        this.minimValue = mV;
    }


    @Override //annotation
    public String toString() {
        return product_Name + " / " + minimValue;
    }
}