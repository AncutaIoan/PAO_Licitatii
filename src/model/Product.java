package model;

public abstract class Product{
    private long idProduct;
    private String productType;
    private double minimValue;
    private boolean sold;

    public Product() {

    }

    public Product(long id, String product_Name, double minimValue, boolean sold) {
        this.idProduct = id;
        this.productType = product_Name;
        this.minimValue = minimValue;
        this.sold=sold;

    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long id) {
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


    @Override //annotation
    public String toString() {
        return productType + "," + minimValue + "," + sold;
    }
}