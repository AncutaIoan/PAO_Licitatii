package model;

public class Teren extends Produs{
    private String tip;//extra / intra
    private String zona;// campie padure pasune
    private double lungime;
    private double latime;
    private boolean electricitate;//posibilitate legare la energie electrica
    private boolean apa;// -||- apa
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
    //set
    public void setTip(String t){ this.tip=t;}
    public void setZona(String z){this.zona=z;}
    public void setLungime(double l){this.lungime=l;}
    public void setLatime(double la){this.latime=la;}
    public void setElectricitate(boolean e){this.electricitate=e;}
    public void setApa(boolean a){this.apa=a;}
    //get
    public String getTip(){ return tip; }
    public String getZona(){ return zona; }
    public double getLungime() {return lungime; }
    public double getLatime(){ return latime; }
    public boolean getElectricitate(){return electricitate; }
    public boolean getApa(){return apa; }

    @Override //annotation
    public String toString() {
        return tip + " / " + zona + " / " + lungime + " / " +latime + " / "+ electricitate + " / "+ apa + " / " + super.toString() ;
    }

}
