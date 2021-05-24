package model;
import java.util.*;

/**
 * Trebuie decis daca fac update aici si las sa poate fi folosit independent de utilizatori.
 */
public class Auction{

    private long idAuction;
    private String nameAuction;
    private Product[] products=new Product[100];
    private User[] users=new User[100];
    private Bid[] bids=new Bid[100];
    private List<Bid> bidsdone=new ArrayList<Bid>();


    public Auction(){

    }
    //LICITATIE
    public long getIdAuction() {return idAuction; }
    public void setIdAuction(long id_Licitatie) {this.idAuction=id_Licitatie; }

    public String getNume_Licitatie() {return nameAuction; }
    public void setNume_Licitatie(String nume_Licitatie) {this.nameAuction=nume_Licitatie; }

    //USERS
    public User[] getUsers() {  return users; }
    public void setUsers(User[] users) {
        this.users = users;
    }
    public User getUser(int i){ return users[i];}

    //PRODUS
    public Product[] getProducts() {
        return products;
    }
    public int getLastProductId(){
        int lastId = 0;
        for(Product p : products) {
            if(p != null) {
                lastId=p.getIdProduct();
            }
        }
        return lastId+1;
        
    }
    public void setProducts(Product[] products) {
        this.products = products;
    }
    public Product getProduct(int i){return products[i];}

    //BIDS
    public Bid[] getBids() {
        return bids;
    }
    public void setBids(Bid[] bids) {
        this.bids = bids;
    }
    public void sortBids(){
        //nu merge :c
    }
}
