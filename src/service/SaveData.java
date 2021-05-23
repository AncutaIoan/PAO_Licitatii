package service;

import model.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class SaveData {


    public void saveProducts(Auction auction, AuctionService auctionService) throws FileNotFoundException {
       // Scanner scanner = new Scanner(new File("PAO_Licitatii/data/bids.txt"));


        File file = new File("products.txt");
        //Instantiating the PrintStream class
        PrintStream stream;
        stream = new PrintStream(file);

        System.setOut(stream);
        for(Product p : auction.getProducts()) {

            if(p != null) {
                System.out.println(p);
            }
        }

    }
    public void saveProduct(Auction auction, Product product){
        String[] attributes = product.toString().split(",");

        String product_Type = attributes[0];
        double minimValue = Double.valueOf(attributes[1]);
        boolean sl = Boolean.valueOf(attributes[2]);
        int sold=0;
        if(sl)
            sold=1;


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao_auctions", "root", "MATRICE123");
            Statement statement = connection.createStatement();
            switch (product.getProductType()) {
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
    public void saveUsers(Auction auction) {


        File file = new File("users.txt");
        //Instantiating the PrintStream class
        PrintStream stream = null;
        try {
            stream = new PrintStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.setOut(stream);
        for(User p : auction.getUsers()) {

            if(p != null) {
                System.out.println(p);
            }
        }




    }
    public void saveBids(Auction auction) {
        try {
            File myObj = new File("bids");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        File file = new File("bids");
        //Instantiating the PrintStream class
        PrintStream stream = null;
        try {
            stream = new PrintStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.setOut(stream);
        for(Bid p : auction.getBids()) {

            if(p != null) {
                System.out.println(p);
            }
        }




    }


}
