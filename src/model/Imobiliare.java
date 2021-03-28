package model;

public class Imobiliare extends Produs{
    private int nrCamere;
    private int etaj;
    private int anConstruire;
    private boolean principala;

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
    //set

    public void setNrCamere(int nr){ this.nrCamere=nr; }
    public void setEtaj(int e){ this.etaj=e; }
    public void setAnConstruire(int ac){ this.anConstruire=ac; }
    public void setPrincipala(boolean p){ this.principala=p; }

    //get
    public int getNrCamere() { return nrCamere; }
    public int getEtaj(){ return etaj; }
    public int getAnConstruire(){ return anConstruire; }
    public boolean getPrincipala(){ return principala; }


    //Overrides

    @Override //annotation
    public String toString() {
        return nrCamere + " / " + etaj + " / " + anConstruire + " / " + principala  + " / " + super.toString() ;
    }
}
