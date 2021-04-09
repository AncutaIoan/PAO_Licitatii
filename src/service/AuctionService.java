package service;

import model.*;

public class AuctionService {
    private NotificationService notificationService;

    public AuctionService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void addProduct(Auction auction, Product product) {
        int nextAvailableIndex = getNumberOfProducts(auction);
        auction.getProducts()[nextAvailableIndex] = product;

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
                System.out.println(p);
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
                numberOfProducts++;
            }
        }
        return numberOfProducts;
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