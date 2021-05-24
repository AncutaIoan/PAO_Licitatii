package model;

public abstract class Product{
    private int idProduct;
    private String productType;
    private double minimValue;
    private boolean sold;

    public Product() {

    }

    public Product(int id, String product_Name, double minimValue, boolean sold) {
        this.idProduct = id;
        this.productType = product_Name;
        this.minimValue = minimValue;
        this.sold=sold;

    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int id) {
        this.idProduct = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String name) {
        this.productType = name;
    }

    public double getMinimValue() {
        return minimValue;
    }

    public void setMinimValue(double mV) {
        this.minimValue = mV;
    }

    public boolean getSold(){
        return sold;
    }
    @Override //annotation
    public String toString() {
        return productType + "," + minimValue + "," + sold;
    }
}