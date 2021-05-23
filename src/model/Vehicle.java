package model;

public class Vehicle  extends Product{
    private String maker;
    private String model;
    private int yearOfFab;
    private double consume;
    private boolean accident;
    private boolean repaired;
    private int power;
    public Vehicle()
    {

    }
    public Vehicle(int id_Product, String product_Type, double minimVal, boolean sold,
                   String marca, String model, int anFabricatie, double consum, boolean acc, boolean rep, int putere){
        super(id_Product, product_Type, minimVal, sold);
        this.maker=marca;
        this.model=model;
        this.yearOfFab=anFabricatie;
        this.consume=consum;
        this.accident=acc;
        this.repaired=rep;
        this.power=putere;
    }
    //set
    public void setMaker(String m){ this.maker=m; }
    public void setModel(String m){ this.model=m; }
    public void setYearOfFab(int af){ this.yearOfFab=af; }
    public void setConsume(double c){ this.consume=c; }

    public void setAccident(boolean acc){this.accident=acc; }
    public void setRepaired(boolean rep){this.repaired=rep;}
    public void setPower(int p){ this.power=p; }
    //get
    public String getMaker(){ return maker; }
    public String getModel(){ return model; }
    public int getYearOfFab(){ return yearOfFab;}
    public double getConsume(){ return consume;}
    public boolean getAccident(){ return accident;}
    public boolean getRepaired(){ return repaired;}
    public int getPower(){ return power;}

    //Overrides

    @Override //annotation
    public String toString() {
        return  super.toString()+ "," + maker + "," + model + "," + yearOfFab + "," + consume + "," + accident + "," + repaired+ ","+ power  ;
    }

}
