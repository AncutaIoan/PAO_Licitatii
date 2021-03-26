package model;

public class Licitatie{

    private long id_Licitatie;
    private String nume_Licitatie;
    private Produs[] products=new Produs[100];
    private Utilizator[] users=new Utilizator[100];
    private Bid[] bids=new Bid[100];


    public Licitatie(){

    }
    //LICITATIE
    public long getId_Licitatie() {return id_Licitatie; }
    public void setId_Licitatie(long id_Licitatie) {this.id_Licitatie=id_Licitatie; }

    public String getNume_Licitatie() {return nume_Licitatie; }
    public void setNume_Licitatie(String nume_Licitatie) {this.nume_Licitatie=nume_Licitatie; }

    //USERS
    public Utilizator[] getUsers() {  return users; }
    public void setUsers(Utilizator[] users) {
        this.users = users;
    }


    //PRODUS
    public Produs[] getProducts() {
        return products;
    }
    public void setProducts(Produs[] products) {
        this.products = products;
    }


    //BIDS
    public Bid[] getBids() {
        return bids;
    }
    public void setBids(Bid[] bids) {
        this.bids = bids;
    }
}
