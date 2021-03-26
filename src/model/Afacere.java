package model;

public class Afacere extends Produs{
    private double profitAnual;
    private String ocupatie;
    private int nrAng;
    /*
           private long id_Product;
       private String product_Type;
       private double minimValue;
       private boolean sold;

        */
    public Afacere()
    {

    }
    public Afacere(long id_Product, String product_Type, double minimVal, boolean sold,
                   double profitAnual, String ocupatie, int nrAng){
        super(id_Product, product_Type, minimVal, sold);
        this.profitAnual=profitAnual;
        this.ocupatie=ocupatie;
        this.nrAng=nrAng;
    }
    @Override //annotation
    public String toString() {
        return profitAnual + " / " + ocupatie + " / " + nrAng + " / " + super.toString() ;
    }
}
