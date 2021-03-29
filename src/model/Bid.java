package model;

public class Bid implements Comparable<Bid>{
    private long id_Bid;
    private double bidValue;
    private Produs produs;
    private Utilizator utilizator;
    public Bid() {

    }
    public Bid(long id_Bid, double bidValue,Produs produs, Utilizator utilizator){
        this.id_Bid=id_Bid;
        this.bidValue=bidValue;
        this.produs=produs;
        this.utilizator=utilizator;

    }
    public long getId_Bid() {
        return id_Bid;
    }

    public void setId_Bid(long id_Bid) {
        this.id_Bid = id_Bid;
    }
    public double getBidValue(){
        return bidValue;
    }
    public void setBidValue(double s){
        this.bidValue=s;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }
    public Produs getProdus() {
        return produs;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }
    public void setProdus(Produs produs){
        this.produs=produs;
    }
    @Override //annotation
    public String toString() {
        return id_Bid + " / " + bidValue + " / " + produs.getId_Product() + " / " + utilizator.getId();
    }
    @Override
    public int compareTo(Bid d) {
            return (int)this.bidValue - (int)d.getBidValue();
    }
}
