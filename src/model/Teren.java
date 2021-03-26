package model;

public class Teren extends Produs{
    private String tip;//extra / intra
    private String zona;// campie padure pasune
    private double lungime;
    private double latime;
    private boolean electricitate;//posibilitate legare la energie electrica
    private boolean apa;// -||- apa

    /*
           private long id_Product;
       private String product_Type;
       private double minimValue;
       private boolean sold;

        */
    public Teren()
    {

    }
    public Teren(long id_Product, String product_Type, double minimVal, boolean sold,
                   String tip, String zona, double lungime, double latime, boolean electricitate, boolean apa){
        super(id_Product, product_Type, minimVal, sold);
        this.tip=tip;
        this.zona=zona;
        this.lungime=lungime;
        this.latime=latime;
        this.electricitate=electricitate;
        this.apa=apa;

    }
}
