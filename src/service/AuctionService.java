package service;

import model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AuctionService {
    private NotificationService notificationService;

    public AuctionService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void addProduct(Auction auction, Product product) {
        int nextAvailableIndex = getNumberOfProducts(auction);
        auction.getProducts()[nextAvailableIndex] = product;
        System.out.println(nextAvailableIndex);
        String message = "Product " + product.getProductType() + " was added to the AUCTION";
        notificationService.sendNotification(new Notification(message, "office@shop.com"));
    }

    public void addUser(Auction auction, User user) {
        int nextAvailableIndex = getNumberOfUsers(auction);
        auction.getUsers()[nextAvailableIndex] = user;

        String message = "User " + user.getName() + " was added to the auction";
        //Receiver receiver = new Receiver("John", "john@gmail.com");
        notificationService.sendNotification(new Notification(message, "office@shop.com"));
    }
    public void deleteProduct(Auction auction,int pId){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao_auctions", "root", "MATRICE123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM `pao_auctions`.`product`\n" +
                    "WHERE idProduct="+pId+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void editProduct(Auction auction,int pId){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao_auctions", "root", "MATRICE123");
            Statement statement = connection.createStatement();




        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addBid(Auction auction, Bid bid) {
        int nextAvailableIndex = getNumberOfBids(auction);
        auction.getBids()[nextAvailableIndex] = bid;
        auction.sortBids();
        String message = "S-a adaugat bid.";
        //Receiver receiver = new Receiver("John", "john@gmail.com");
        notificationService.sendNotification(new Notification(message, "office@shop.com"));
    }

    public void printProductsDetails(Auction auction) {
        for(Product p : auction.getProducts()) {
            if(p != null) {
                System.out.println(p.getIdProduct()+ ", " +p);
            }
        }
    }
    public void printUsersDetails(Auction auction) {
        for(User p : auction.getUsers()) {
            if(p != null) {
                System.out.println(p);
            }
        }
    }
    public int getNumberOfProducts(Auction auction) {
        int numberOfProducts = 0;
        for(Product p : auction.getProducts()) {
            if(p != null) {
                numberOfProducts+=1;
            }
        }
        return numberOfProducts+1;
    }
    public int getNumberOfUsers(Auction auction) {
        int nrUsers = 0;
        for(User p : auction.getUsers()) {
            if(p != null) {
                nrUsers++;
            }
        }
        return nrUsers;
    }
    public int getNumberOfBids(Auction auction){
        int nrBids=0;
        for(Bid b: auction.getBids()){
            if(b!= null)
            {
                nrBids++;

            }
        }
        return nrBids;

    }
}