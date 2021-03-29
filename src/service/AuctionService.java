package service;

import model.*;

public class AuctionService {
    private NotificationService notificationService;

    public AuctionService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void addProduct(Licitatie licitatie, Produs produs) {
        int nextAvailableIndex = getNumberOfProducts(licitatie);
        licitatie.getProducts()[nextAvailableIndex] = produs;

        String message = "Product " + produs.getProduct_Name() + " was added to the AUCTION";
        notificationService.sendNotification(new Notification(message, "office@shop.com"));
    }
    public void addUser(Licitatie licitatie, Utilizator utilizator) {
        int nextAvailableIndex = getNumberOfUsers(licitatie);
        licitatie.getUsers()[nextAvailableIndex] = utilizator;

        String message = "User " + utilizator.getName() + " was added to the auction";
        //Receiver receiver = new Receiver("John", "john@gmail.com");
        notificationService.sendNotification(new Notification(message, "office@shop.com"));
    }
    public void addBid(Licitatie licitatie, Bid bid) {
        int nextAvailableIndex = getNumberOfBids(licitatie);
        licitatie.getBids()[nextAvailableIndex] = bid;
        licitatie.sortBids();
        String message = "S-a adaugat bid.";
        //Receiver receiver = new Receiver("John", "john@gmail.com");
        notificationService.sendNotification(new Notification(message, "office@shop.com"));
    }

    public void printProductsDetails(Licitatie licitatie) {
        for(Produs p : licitatie.getProducts()) {
            if(p != null) {
                System.out.println(p);
            }
        }
    }
    public void printUsersDetails(Licitatie licitatie) {
        for(Utilizator p : licitatie.getUsers()) {
            if(p != null) {
                System.out.println(p);
            }
        }
    }
    public int getNumberOfProducts(Licitatie licitatie) {
        int numberOfProducts = 0;
        for(Produs p : licitatie.getProducts()) {
            if(p != null) {
                numberOfProducts++;
            }
        }
        return numberOfProducts;
    }
    public int getNumberOfUsers(Licitatie licitatie) {
        int nrUsers = 0;
        for(Utilizator p : licitatie.getUsers()) {
            if(p != null) {
                nrUsers++;
            }
        }
        return nrUsers;
    }
    public int getNumberOfBids(Licitatie licitatie){
        int nrBids=0;
        for(Bid b: licitatie.getBids()){
            if(b!= null)
            {
                nrBids++;

            }
        }
        return nrBids;

    }
}