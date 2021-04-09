package model;

public class RealEstate extends Product{
    private int nrRooms;
    private int floor;
    private int year;
    private boolean mainStreet;

    public RealEstate()
    {

    }
    public RealEstate(long id_Product, String product_Type, double minimVal, boolean sold,
                      int nrCamere,int etaj,int anConstruire,boolean principala){
        super(id_Product, product_Type, minimVal, sold);
        this.nrRooms=nrCamere;
        this.floor=etaj;
        this.year=anConstruire;
        this.mainStreet=principala;

    }
    //set

    public void setNrRooms(int nr){ this.nrRooms=nr; }
    public void setFloor(int e){ this.floor=e; }
    public void setYear(int ac){ this.year=ac; }
    public void setMainStreet(boolean p){ this.mainStreet=p; }

    //get
    public int getNrRooms() { return nrRooms; }
    public int getFloor(){ return floor; }
    public int getYear(){ return year; }
    public boolean getMainStreet(){ return mainStreet; }


    //Overrides

    @Override //annotation
    public String toString() {
        return nrRooms + " / " + floor + " / " + year + " / " + mainStreet  + " / " + super.toString() ;
    }
}
