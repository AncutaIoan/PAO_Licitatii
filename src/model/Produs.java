package model;

public abstract class Produs{
    private long id_Product;
    private String product_Type;
    private double minimValue;
    private boolean sold;

    public Produs() {

    }

    public Produs(long id, String product_Name, double minimValue, boolean sold) {
        this.id_Product = id;
        this.product_Type = product_Name;
        this.minimValue = minimValue;
        this.sold=sold;

    }

    public long getId_Product() {
        return id_Product;
    }

    public void setId_Product(long id) {
        this.id_Product = id;
    }

    public String getProduct_Name() {
        return product_Type;
    }

    public void setProduct_Name(String name) {
        this.product_Type = name;
    }

    public double getMinimValue() {
        return minimValue;
    }

    public void setMinimValue(double mV) {
        this.minimValue = mV;
    }


    @Override //annotation
    public String toString() {
        return product_Type + " / " + minimValue;
    }
}