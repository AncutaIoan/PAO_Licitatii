package model;

public class Afacere extends Produs{
    private double profitAnual;
    private String ocupatie;
    private int nrAng;
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
    public void setProfitAnual(double pa){
        this.profitAnual=pa;
    }
    public void setOcupatie(String o){
        this.ocupatie=o;

    }
    public void setNrAng(int na){
        this.nrAng=na;
    }
    public double getProfitAnual(){
        return profitAnual;
    }
    public String getOcupatie(){
        return ocupatie;

    }
    public int getNrAng()
    {
        return nrAng;

    }
    @Override //annotation
    public String toString() {
        return profitAnual + " / " + ocupatie + " / " + nrAng + " / " + super.toString() ;
    }
}
