package model;

public class Bid{
    private long id_Bid;
    private double bidValue;
    private Produs produs;
    private Utilizator utilizator;
    public Bid() {

    }
    public Bid(long id_Bid, Produs produs, Utilizator utilizator, double bidValue){
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
}
