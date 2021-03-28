package model;

public class Vehicle  extends Produs{
    private String marca;
    private String model;
    private int anFabricatie;
    private double consum;
    private boolean accident;
    private boolean reparat;
    private int putere;
    public Vehicle()
    {

    }
    public Vehicle(long id_Product, String product_Type, double minimVal, boolean sold,
                   String marca, String model, int anFabricatie, double consum, boolean acc, boolean rep, int putere){
        super(id_Product, product_Type, minimVal, sold);
        this.marca=marca;
        this.model=model;
        this.anFabricatie=anFabricatie;
        this.consum=consum;
        this.accident=acc;
        this.reparat=rep;
        this.putere=putere;
    }
    //set
    public void setMarca(String m){ this.marca=m; }
    public void setModel(String m){ this.model=m; }
    public void setAnFabricatie(int af){ this.anFabricatie=af; }
    public void setConsum(double c){ this.consum=c; }
    public void setAccident(boolean acc){this.accident=acc; }
    public void setReparat(boolean rep){this.reparat=rep;}
    public void setPutere(int p){ this.putere=p; }
    //get
    public String getMarca(){ return marca; }
    public String getModel(){ return model; }
    public int getAnFabricatie(){ return anFabricatie;}
    public double getConsum(){ return consum;}
    public boolean getAccident(){ return accident;}
    public boolean getReparat(){ return reparat;}
    public int getPutere(){ return putere;}

    //Overrides

    @Override //annotation
    public String toString() {
        return marca + " / " + model + " / " + anFabricatie + " / " + consum + " / " + accident + " / " + reparat+ " / "+ putere + " / " + super.toString() ;
    }

}
