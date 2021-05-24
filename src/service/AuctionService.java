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
    public void editProduct(Auction auction,int pId, String str){
        for(Product p: auction.getProducts())
        {
            if(p.getIdProduct()==pId) {
                        System.out.println(p.getIdProduct()+ ", " +p);
                        break;}
        }
        String[] attributes = str.split("/");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao_auctions", "root", "MATRICE123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM `pao_auctions`.`product`\n" +
                    "WHERE idProduct="+pId+";");
            String product_Type=attributes[0];
            double minimValue=Double.valueOf(attributes[1]);
            String so= attributes[2];
            int sold=1;
            if(so=="false")
                sold=0;

            switch (attributes[0]) {
                case "land": {
                    String tip = attributes[3];
                    String zona = attributes[4];
                    double lungime=Double.valueOf(attributes[5]);
                    double latime=Double.valueOf(attributes[6]);
                    boolean el = Boolean.valueOf(attributes[7]);
                    boolean ap = Boolean.valueOf(attributes[8]);
                    int elect=0;
                    int apa=0;
                    if(el)
                        elect=1;
                    if(ap)
                        apa=1;
                    statement.executeUpdate("INSERT INTO `pao_auctions`.`product`\n" +
                            "(\n" +
                            "`productType`,\n" +
                            "`minimValue`,\n" +
                            "`sold`,\n" +
                            "`type`,\n" +
                            "`area`,\n" +
                            "`length`,\n" +
                            "`width`,\n" +
                            "`electricity`,\n" +
                            "`water`\n" +
                            ")\n" +
                            "VALUES\n" +
                            "(\n" +
                            "'" + product_Type + "',\n" +
                            "'" + minimValue + "',\n" +
                            "'" + sold + "',\n" +
                            "'" + tip + "',\n" +
                            "'" + zona + "',\n" +
                            "'" + lungime + "',\n" +
                            "'" + latime + "',\n" +
                            "'" + elect + "',\n" +
                            "'" + apa + "');");

                    break;
                }
                case "vehicle": {
                    String marca = attributes[3];
                    String model = attributes[4];
                    int anFabricatie=Integer.valueOf(attributes[5]);
                    double consum=Double.valueOf(attributes[6]);
                    boolean accident = Boolean.valueOf(attributes[7]);
                    int ac=0;
                    if(accident)
                        ac=1;
                    int rep=0;
                    boolean reparat = Boolean.valueOf(attributes[8]);
                    if(reparat)
                        rep=1;
                    int putere=Integer.valueOf(attributes[9]);
                    statement.executeUpdate("INSERT INTO `pao_auctions`.`product`\n" +
                            "(\n" +
                            "`productType`,\n" +
                            "`minimValue`,\n" +
                            "`sold`,\n" +
                            "`maker`,\n" +
                            "`model`,\n" +
                            "`yearOfFab`,\n" +
                            "`consume`,\n" +
                            "`accident`,\n" +
                            "`repaired`,\n" +
                            "`power`\n" +
                            ")\n" +
                            "VALUES\n" +
                            "(\n" +
                            "'" + product_Type + "',\n" +
                            "'" + minimValue + "',\n" +
                            "'" + sold + "',\n" +
                            "'" + marca + "',\n" +
                            "'" + model + "',\n" +
                            "'" + anFabricatie + "',\n" +
                            "'" + consum + "',\n" +
                            "'" + ac + "',\n" +
                            "'" + rep + "',\n" +
                            "'" + putere + "');");
                    break;
                }
                case "realestate": {
                    int nrCamere = Integer.valueOf(attributes[3]);
                    int etaj = Integer.valueOf(attributes[4]);
                    int anConstruire = Integer.valueOf(attributes[5]);
                    boolean pr = Boolean.valueOf(attributes[6]);
                    int principala=0;
                    if(pr)
                        principala=1;
                    statement.executeUpdate("INSERT INTO `pao_auctions`.`product`\n" +
                            "(\n" +
                            "`productType`,\n" +
                            "`minimValue`,\n" +
                            "`sold`,\n" +
                            "`nrRooms`,\n" +
                            "`floor`,\n" +
                            "`year`,\n" +
                            "`mainStreet`\n" +
                            ")\n" +
                            "VALUES\n" +
                            "(\n" +
                            "'" + product_Type + "',\n" +
                            "'" + minimValue + "',\n" +
                            "'" + sold + "',\n" +
                            "'" + nrCamere + "',\n" +
                            "'" + etaj + "',\n" +
                            "'" + anConstruire + "',\n" +
                            "'" + principala + "');");

                    break;
                }
                case "business": {
                    double profitAnual=Double.valueOf(attributes[3]);
                    String ocupatie=attributes[4];
                    int nrAng=Integer.valueOf(attributes[5]);
                    /*
                        private double anualIncome;
    private String ocupation;
    private int nrEmp;
                     */
                    statement.executeUpdate("INSERT INTO `pao_auctions`.`product`\n" +
                            "(\n" +
                            "`productType`,\n" +
                            "`minimValue`,\n" +
                            "`sold`,\n" +
                            "`anualIncome`,\n" +
                            "`ocupation`,\n" +
                            "`nrEmp`\n" +
                            ")\n" +
                            "VALUES\n" +
                            "(\n" +
                            "'" + product_Type + "',\n" +
                            "'" + minimValue + "',\n" +
                            "'" + sold + "',\n" +
                            "'" + profitAnual + "',\n" +
                            "'" + ocupatie + "',\n" +
                            "'" + nrAng + "');");
                    break;
                }
                default:
                    System.out.println("");
            }
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