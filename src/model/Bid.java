package model;

public class Bid implements Comparable<Bid>{
    private long idBid;
    private double bidValue;
    private Product product;
    private User user;
    public Bid() {

    }
    public Bid(long id_Bid, double bidValue,Product produs, User user){
        this.idBid=id_Bid;
        this.bidValue=bidValue;
        this.product=produs;
        this.user=user;

    }
    public long getIdBid() {
        return idBid;
    }

    public void setIdBid(long id_Bid) {
        this.idBid = id_Bid;
    }
    public double getBidValue(){
        return bidValue;
    }
    public void setBidValue(double s){
        this.bidValue=s;
    }

    public User getUser() {
        return user;
    }
    public Product getProduct() {
        return product;
    }

    public void setUser(User utilizator) {
        this.user = utilizator;
    }
    public void setProduct(Product produs){
        this.product=produs;
    }
    @Override //annotation
    public String toString() {
        return idBid + "," + bidValue + "," + product.getIdProduct() + "," + user.getId();
    }
    @Override
    public int compareTo(Bid d) {
            return (int)this.bidValue - (int)d.getBidValue();
    }
}
