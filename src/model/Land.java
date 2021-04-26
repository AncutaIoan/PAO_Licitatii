package model;

public class Land extends Product{
    private String type;//extra / intra
    private String area;// campie padure pasune
    private double length;
    private double width;
    private boolean electricity;//posibilitate legare la energie electrica
    private boolean water;// -||- apa
    public Land()
    {

    }
    public Land(long id_Product, String product_Type, double minimVal, boolean sold,
                 String tip, String zona, double lungime, double latime, boolean electricitate, boolean apa){
        super(id_Product, product_Type, minimVal, sold);
        this.type=tip;
        this.area=zona;
        this.length=lungime;
        this.width=latime;
        this.electricity=electricitate;
        this.water=apa;

    }
    //set
    public void setType(String t){ this.type=t;}
    public void setArea(String z){this.area=z;}
    public void setLength(double l){this.length=l;}
    public void setWidth(double la){this.width=la;}
    public void setElectricity(boolean e){this.electricity=e;}
    public void setWater(boolean a){this.water=a;}
    //get
    public String getType(){ return type; }
    public String getArea(){ return area; }
    public double getLength() {return length; }
    public double getWidth(){ return width; }
    public boolean getElectricity(){return electricity; }
    public boolean getWater(){return water; }

    @Override //annotation
    public String toString() {
        return  super.toString()+ "," +type + "," + area + "," + length + "," +width + ","+ electricity + ","+ water  ;
    }

}
