package main;

import model.*;
import service.*;

import java.io.FileNotFoundException;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        LoadData loadData=new LoadData();
        Auction auction=new Auction();
        AuctionService auctionService=new AuctionService(new NotificationService());
        Scanner scanner=new Scanner(System.in);
        loadData.addUsers(auction);
        loadData.addProducts(auction, auctionService);
        Audit audit=new Audit();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        while(true)
        {
            System.out.println("Please type one of the following commands: add, view or exit");
            String line=scanner.nextLine();
            switch (line){
                case "add": {
                    System.out.println("You want to add : user or product. Please type in User or Product");
                    String addType = scanner.nextLine();
                    switch (addType) {
                        case "User": {
                            System.out.println("Please specify the user details:username/password/lastName/firstName/address:");
                            auctionService.addUser(auction, buildUser(scanner.nextLine()));
                            audit.addRequest("add,user,"+dtf.format(now));

                            break;
                        }
                        case "Product": {
                            System.out.println("Please choose a product type land/vehicle/realestate/business: ");
                            String productType = scanner.nextLine();
                            switch (productType) {
                                case "land": {

                                    audit.addRequest("add,land,"+dtf.format(now));
                                    System.out.println("Please specify the land details: product_Type/minimValue/sold/tip/zona/lungime/latime/electricitate/apa");
                                    //product_Type=teren, nu vrea fara
                                    auctionService.addProduct(auction, buildLand(scanner.nextLine()));
                                    break;
                                }
                                case "vehicle": {
                                    System.out.println("Please specify the car details: " +
                                            "product_Type/minimValue/sold/marca/model/anFabricatie/consum/accident/reparat/putere");
                                    auctionService.addProduct(auction, buildCar(scanner.nextLine()));
                                    audit.addRequest("add,vehicle,"+dtf.format(now));

                                    break;
                                }
                                case "realestate": {
                                    System.out.println("Please specify the real estate details: product_Type/minimValue/sold/nrCamere/etaj/anConstruire/principala");
                                    auctionService.addProduct(auction, buildRealEstate(scanner.nextLine()));
                                    audit.addRequest("add,realestate,"+dtf.format(now));

                                    break;
                                }
                                case "business": {
                                    System.out.println("Please specify the business details: product_Type/minimValue/sold/profitAnual/ocupatie/nrAng");
                                    auctionService.addProduct(auction, buildBusiness(scanner.nextLine()));
                                    audit.addRequest("add,business,"+dtf.format(now));

                                    break;
                                }
                                default:
                                    System.out.println("This product type doesn't exist.");
                            }
                            break;
                        }
                        case "Bid":{
                            System.out.println("Please specify the user details:value/id_produs/id_utilizator:");

                            auctionService.addBid(auction, buildBid(auction, scanner.nextLine(), auctionService.getNumberOfUsers(auction) ,auctionService.getNumberOfProducts(auction)));
                            audit.addRequest("add,bid,"+dtf.format(now));

                            break;

                        }
                    }
                    break;
                }
                case "view":{
                        auctionService.printProductsDetails(auction);
                        System.out.println("-----------------------------------------------------------------------");
                        auctionService.printUsersDetails(auction);
                    break;
                }
                case "exit":{
                    System.out.println("Bye bye!");
                    SaveData saveData=new SaveData();
                   saveData.saveProducts(auction,auctionService);
                   saveData.saveUsers(auction);
                      //  saveData.saveBids(auction);
                    System.exit(0);
                    break;
                }
                default : System.out.println("This command doesn't exist.");

            }
        }

    }
    private static void readData(Auction auction, AuctionService auctionService)
    {






    }
    private static User buildUser(String productDetails) {
        String[] attributes = productDetails.split("/");
        String username = attributes[0];
        String password = attributes[1];
        String firstName = attributes[2];
        String lastName = attributes[3];
        String address = attributes[4];
        return new User(new Random().nextInt(100), username, password, firstName, lastName, address);
    }


    private static Land buildLand(String productDetails) {
        String[] attributes = productDetails.split("/");

        String product_Type = attributes[0];
        double minimValue = Double.valueOf(attributes[1]);
        boolean sold = Boolean.valueOf(attributes[2]);
        String tip = attributes[3];
        String zona = attributes[4];
        double lungime=Double.valueOf(attributes[5]);
        double latime=Double.valueOf(attributes[6]);
        boolean electricitate = Boolean.valueOf(attributes[7]);
        boolean apa = Boolean.valueOf(attributes[8]);

        return new Land(new Random().nextInt(100), product_Type, minimValue,sold, tip, zona, lungime, latime, electricitate, apa);
    }


    private static Vehicle buildCar(String productDetails) {
        //impartire date
        String[] attributes = productDetails.split("/");
        //aranjare date
        String product_Type = attributes[0];
        double minimValue = Double.valueOf(attributes[1]);
        boolean sold = Boolean.valueOf(attributes[2]);
        String marca = attributes[3];
        String model = attributes[4];
        int anFabricatie=Integer.valueOf(attributes[5]);
        double consum=Double.valueOf(attributes[6]);
        boolean accident = Boolean.valueOf(attributes[7]);
        boolean reparat = Boolean.valueOf(attributes[8]);
        int putere=Integer.valueOf(attributes[9]);
        return new Vehicle(new Random().nextInt(100), product_Type, minimValue,sold, marca,model, anFabricatie, consum, accident, reparat, putere);
    }

    private static RealEstate buildRealEstate(String productDetails) {
        //impartire date
        String[] attributes = productDetails.split("/");
        //aranjare date

        String product_Type = attributes[0];
        double minimValue = Double.valueOf(attributes[1]);
        boolean sold = Boolean.valueOf(attributes[2]);
        int nrCamere = Integer.valueOf(attributes[3]);
        int etaj = Integer.valueOf(attributes[4]);
        int anConstruire = Integer.valueOf(attributes[5]);
        boolean principala = Boolean.valueOf(attributes[6]);

        return new RealEstate(new Random().nextInt(100), product_Type, minimValue,sold, nrCamere, etaj, anConstruire, principala);
    }

    private static Business buildBusiness(String productDetails) {
        //impartire date
        String[] attributes = productDetails.split("/");
        //aranjare date

        String product_Type = attributes[0];
        double minimValue = Double.valueOf(attributes[1]);
        boolean sold = Boolean.valueOf(attributes[2]);

        double profitAnual=Double.valueOf(attributes[3]);
        String ocupatie=attributes[4];
        int nrAng=Integer.valueOf(attributes[5]);

        return new Business(new Random().nextInt(100), product_Type, minimValue,sold, profitAnual, ocupatie, nrAng);
    }
    private static Bid buildBid(Auction auction,String bidDetails,int mU,int mP){
        //impartire date
        String[] attributes = bidDetails.split("/");
        //aranjare date

        double bValue = Double.valueOf(attributes[0]);
        int idP=Integer.valueOf(attributes[1]);
        int idU=Integer.valueOf(attributes[2]);
        if(idP>=mP || idU >= mU)
            return new Bid();

        /*
        Aici ar trebui facut un throw cred, doar ca nu-mi pot da seama cum sa zic ca valorile bagate > decat cele existente
         */

        return new Bid(new Random().nextInt(100), bValue, auction.getProduct(idP), auction.getUser(idU));    }
}