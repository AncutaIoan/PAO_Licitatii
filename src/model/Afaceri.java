package model;

public class Afaceri extends Produs{
    private double profitAnual;
    private String ocupatie;
    private int nrAng;
    /*
           private long id_Product;
       private String product_Type;
       private double minimValue;
       private boolean sold;

        */
    public Afaceri()
    {

    }
    public Afaceri(long id_Product, String product_Type, double minimVal, boolean sold,
                    double profitAnual, String ocupatie, int nrAng){
        super(id_Product, product_Type, minimVal, sold);
        this.profitAnual=profitAnual;
        this.ocupatie=ocupatie;
        this.nrAng=nrAng;
    }
}
