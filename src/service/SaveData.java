package service;

import model.*;

import java.io.*;
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
