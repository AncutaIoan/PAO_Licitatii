package service;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;  // Import the Scanner class
import java.io.File;
import model.*;


public class LoadData {



    public void addProducts(Auction auction,AuctionService auctionService) throws FileNotFoundException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao_auctions", "root", "MATRICE123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product");


            Scanner scanner = new Scanner(new File("products.txt"));
            while (resultSet.next()) {

                switch (resultSet.getString("productType")) {
                    case "land": {
                        int idProduct = Integer.valueOf(resultSet.getString("idProduct"));
                        String productType = resultSet.getString("productType");
                        double minimValue = Double.valueOf(resultSet.getString("minimValue"));
                        int sol=Integer.valueOf(resultSet.getString("sold"));
                        boolean sold=false;
                        if(sol==1)
                            sold=true;
                        String tip = resultSet.getString("type");
                        String zona = resultSet.getString("area");
                        double lungime = Double.valueOf(resultSet.getString("length"));
                        double latime = Double.valueOf(resultSet.getString("width"));
                        int elect=Integer.valueOf(resultSet.getString("electricity"));
                        int wata=Integer.valueOf(resultSet.getString("water"));
                        boolean electricitate=false;
                        if(elect==1)
                           electricitate=true;
                        boolean apa = false;
                        if(wata==1)
                            apa=true;
                        auctionService.addProduct(auction, new Land(idProduct, productType, minimValue, sold, tip, zona, lungime, latime, electricitate, apa));
                        break;
                    }
                case "vehicle": {
                    int idProduct = Integer.valueOf(resultSet.getString("idProduct"));
                    String productType = resultSet.getString("productType");
                    double minimValue = Double.valueOf(resultSet.getString("minimValue"));
                    int sol=Integer.valueOf(resultSet.getString("sold"));
                    boolean sold=false;
                    if(sol==1)
                        sold=true;
                    /*
                    private String maker;
                    private String model;
                    private int yearOfFab;
                    private double consume;
                    private boolean accident;
                    private boolean repaired;
                    private int power;
                     */
                    String marca = resultSet.getString("maker");
                    String model = resultSet.getString("model");
                    int anFabricatie=Integer.valueOf(resultSet.getString("yearOfFab"));
                    double consum=Double.valueOf(resultSet.getString("consume"));
                    int acc=Integer.valueOf(resultSet.getString("accident"));

                    boolean accident = false;
                    if(acc==1)
                        accident=true;
                    int rep=Integer.valueOf(resultSet.getString("repaired"));
                    boolean reparat = false;
                    if(rep==1)
                        reparat=true;
                    int putere=Integer.valueOf(resultSet.getString("power"));
                    auctionService.addProduct(auction, new Vehicle(idProduct, productType, minimValue,sold, marca,model, anFabricatie, consum, accident, reparat, putere));
                    break;
                }
                case "realestate": {


                    int idProduct = Integer.valueOf(resultSet.getString("idProduct"));
                    String productType = resultSet.getString("productType");
                    double minimValue = Double.valueOf(resultSet.getString("minimValue"));
                    int sol=Integer.valueOf(resultSet.getString("sold"));
                    boolean sold=false;
                    if(sol==1)
                        sold=true;
                    /*
                        private int nrRooms;
    private int floor;
    private int year;
    private boolean mainStreet;
                     */
                    int nrCamere = Integer.valueOf(resultSet.getString("nrRooms"));
                    int etaj = Integer.valueOf(resultSet.getString("floor"));
                    int anConstruire = Integer.valueOf(resultSet.getString("year"));
                    int pr=Integer.valueOf(resultSet.getString("mainStreet"));
                    boolean principala = false;
                    if(pr==1)
                        principala=true;
                   auctionService.addProduct(auction, new RealEstate(idProduct, productType, minimValue,sold, nrCamere, etaj, anConstruire, principala));

                    break;
                }
                case "business": {

                    int idProduct = Integer.valueOf(resultSet.getString("idProduct"));
                    String productType = resultSet.getString("productType");
                    double minimValue = Double.valueOf(resultSet.getString("minimValue"));
                    int sol=Integer.valueOf(resultSet.getString("sold"));
                    boolean sold=false;
                    if(sol==1)
                        sold=true;
                    /*
                        private double anualIncome;
    private String ocupation;
    private int nrEmp;
                     */
                    double profitAnual=Double.valueOf(resultSet.getString("anualIncome"));
                    String ocupatie=resultSet.getString("ocupation");
                    int nrAng=Integer.valueOf(resultSet.getString("nrEmp"));

                    auctionService.addProduct(auction,  new Business(idProduct, productType, minimValue,sold, profitAnual, ocupatie, nrAng));
                    break;
                }



                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addUsers(Auction auction) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("users.txt"));
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
            String[] attributes = line.split(",");
            //aranjare date

            double bValue = Double.valueOf(attributes[0]);
            int idP=Integer.valueOf(attributes[1]);
            int idU=Integer.valueOf(attributes[2]);
            bids[k]=new Bid(new Random().nextInt(100), bValue, auction.getProduct(idP), auction.getUser(idU));
            auction.setBids(bids);
        }

    }



}
