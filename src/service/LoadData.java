package service;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;  // Import the Scanner class
import java.io.File;
import model.*;


public class LoadData {



    public void addProducts(Auction auction,AuctionService auctionService) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("PAO_Licitatii/data/bids.txt"));
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] attributes = line.split(",");
            String productType = attributes[0];
            switch (productType) {
                case "land": {
                    double minimValue = Double.valueOf(attributes[1]);
                    boolean sold = Boolean.valueOf(attributes[2]);
                    String tip = attributes[3];
                    String zona = attributes[4];
                    double lungime=Double.valueOf(attributes[5]);
                    double latime=Double.valueOf(attributes[6]);
                    boolean electricitate = Boolean.valueOf(attributes[7]);
                    boolean apa = Boolean.valueOf(attributes[8]);
                    auctionService.addProduct(auction, new Land(new Random().nextInt(100), productType, minimValue,sold, tip, zona, lungime, latime, electricitate, apa));
                    break;
                }
                case "vehicle": {
                    double minimValue = Double.valueOf(attributes[1]);
                    boolean sold = Boolean.valueOf(attributes[2]);
                    String marca = attributes[3];
                    String model = attributes[4];
                    int anFabricatie=Integer.valueOf(attributes[5]);
                    double consum=Double.valueOf(attributes[6]);
                    boolean accident = Boolean.valueOf(attributes[7]);
                    boolean reparat = Boolean.valueOf(attributes[8]);
                    int putere=Integer.valueOf(attributes[9]);
                    auctionService.addProduct(auction, new Vehicle(new Random().nextInt(100), productType, minimValue,sold, marca,model, anFabricatie, consum, accident, reparat, putere));
                    break;
                }
                case "realestate": {


                    double minimValue = Double.valueOf(attributes[1]);
                    boolean sold = Boolean.valueOf(attributes[2]);
                    int nrCamere = Integer.valueOf(attributes[3]);
                    int etaj = Integer.valueOf(attributes[4]);
                    int anConstruire = Integer.valueOf(attributes[5]);
                    boolean principala = Boolean.valueOf(attributes[6]);
                   auctionService.addProduct(auction, new RealEstate(new Random().nextInt(100), productType, minimValue,sold, nrCamere, etaj, anConstruire, principala));

                    break;
                }
                case "business": {
                    double minimValue = Double.valueOf(attributes[1]);
                    boolean sold = Boolean.valueOf(attributes[2]);

                    double profitAnual=Double.valueOf(attributes[3]);
                    String ocupatie=attributes[4];
                    int nrAng=Integer.valueOf(attributes[5]);

                    auctionService.addProduct(auction,  new Business(new Random().nextInt(100), productType, minimValue,sold, profitAnual, ocupatie, nrAng));
                    break;
                }

            }
        }

    }
    public void addUsers(Auction auction) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("filename"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int k=0;
        User[] users=new User[100];
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] attributes = line.split(",");
            String username = attributes[0];
            String password = attributes[1];
            String firstName = attributes[2];
            String lastName = attributes[3];
            String address = attributes[4];
            users[k]=new User(new Random().nextInt(100), username, password, firstName, lastName, address);
            auction.setUsers(users);
        }


    }
    public void addBids(Auction auction) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("bids.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int k=0;
        Bid[] bids=new Bid[100];
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] attributes = line.split("/");
            //aranjare date

            double bValue = Double.valueOf(attributes[0]);
            int idP=Integer.valueOf(attributes[1]);
            int idU=Integer.valueOf(attributes[2]);
            bids[k]=new Bid(new Random().nextInt(100), bValue, auction.getProduct(idP), auction.getUser(idU));
            auction.setBids(bids);
        }

    }



}
