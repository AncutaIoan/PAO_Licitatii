package model;

public class Imobiliare extends Produs{
    private int nrCamere;
    private int etaj;
    private int anConstruire;
    private boolean principala;


    /*
           private long id_Product;
       private String product_Type;
       private double minimValue;
       private boolean sold;

        */
    public Imobiliare()
    {

    }
    public Imobiliare(long id_Product, String product_Type, double minimVal, boolean sold,
                   int nrCamere,int etaj,int anConstruire,boolean principala){
        super(id_Product, product_Type, minimVal, sold);
        this.nrCamere=nrCamere;
        this.etaj=etaj;
        this.anConstruire=anConstruire;
        this.principala=principala;

    }
}
