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

        String message = "Product " + produs.getProduct_Name() + " was added to the shop";
        //Receiver receiver = new Receiver("John", "john@gmail.com");
        //notificationService.sendNotification(new Notification(message, "office@shop.com"));
    }
    public void addUser(Licitatie licitatie, Utilizator utilizator) {
        int nextAvailableIndex = getNumberOfUsers(licitatie);
        licitatie.getUsers()[nextAvailableIndex] = utilizator;

        String message = "Product " + utilizator.getName() + " was added to the shop";
        //Receiver receiver = new Receiver("John", "john@gmail.com");
        //notificationService.sendNotification(new Notification(message, "office@shop.com", receiver));
    }
    public void printProductsDetails(Licitatie licitatie) {
        for(Produs p : licitatie.getProducts()) {
            if(p != null) {
                System.out.println(p);
            }
        }
    }

    private int getNumberOfProducts(Licitatie licitatie) {
        int numberOfProducts = 0;
        for(Produs p : licitatie.getProducts()) {
            if(p != null) {
                numberOfProducts++;
            }
        }
        return numberOfProducts;
    }
    private int getNumberOfUsers(Licitatie licitatie) {
        int nrUsers = 0;
        for(Utilizator p : licitatie.getUsers()) {
            if(p != null) {
                nrUsers++;
            }
        }
        return nrUsers;
    }
}