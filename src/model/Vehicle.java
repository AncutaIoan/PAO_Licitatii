package model;

public class Vehicle  extends Produs{
    private String marca;
    private String model;
    private int anFabricatie;
    private double consum;
    private boolean accident;
    private boolean reparat;
    private int putere;
    /*
        private long id_Product;
    private String product_Type;
    private double minimValue;
    private boolean sold;

     */
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

}
