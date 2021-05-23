
package model;

public class Business extends Product{
    private double anualIncome;
    private String ocupation;
    private int nrEmp;
    public Business()
    {

    }
    public Business(int id_Product, String product_Type, double minimVal, boolean sold,
                   double profitAnual, String ocupatie, int nrAng){
        super(id_Product, product_Type, minimVal, sold);
        this.anualIncome=profitAnual;
        this.ocupation=ocupatie;
        this.nrEmp=nrAng;
    }
    public void setAnualIncome(double pa){
        this.anualIncome=pa;
    }
    public void setOcupation(String o){
        this.ocupation=o;

    }
    public void setNrEmp(int na){
        this.nrEmp=na;
    }
    public double getAnualIncome(){
        return anualIncome;
    }
    public String getOcupation(){
        return ocupation;

    }
    public int getNrEmp()
    {
        return nrEmp;


    }
    @Override //annotation
    public String toString() {
        return  super.toString()+ "," +anualIncome + "," + ocupation + "," + nrEmp  ;
    }
}
