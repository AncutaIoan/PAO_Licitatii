package main;

import model.*;
import service.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Licitatie licitatie=new Licitatie();
        AuctionService auctionService=new AuctionService(new NotificationService());
        Scanner scanner=new Scanner(System.in);

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
                            auctionService.addUser(licitatie, buildUser(scanner.nextLine()));
                            break;
                        }
                        case "Product": {
                            System.out.println("Please choose a product type: ");
                            String productType = scanner.nextLine();
                            switch (productType) {
                                case "teren": {
                                    System.out.println("Please specify the land details: product_Type/minimValue/sold/tip/zona/lungime/latime/electricitate/apa");
                                    //product_Type=teren, nu vrea fara
                                    auctionService.addProduct(licitatie, buildTeren(scanner.nextLine()));
                                    break;
                                }
                                case "vehicle": {
                                    System.out.println("Please specify the car details: " +
                                            "product_Type/minimValue/sold/marca/model/anFabricatie/consum/accident/reparat/putere");
                                    auctionService.addProduct(licitatie, buildCar(scanner.nextLine()));
                                    break;
                                }
                                case "imobil": {
                                    System.out.println("Please specify the real estate details: product_Type/minimValue/sold/nrCamere/etaj/anConstruire/principala");
                                    auctionService.addProduct(licitatie, buildImobil(scanner.nextLine()));
                                    break;
                                }
                                case "afacere": {
                                    System.out.println("Please specify the business details: product_Type/minimValue/sold/profitAnual/ocupatie/nrAng");
                                    auctionService.addProduct(licitatie, buildAfacere(scanner.nextLine()));
                                    break;
                                }
                                default:
                                    System.out.println("This product type doesn't exist.");
                            }
                            break;
                        }
                        case "Bid":{
                            System.out.println("Please specify the user details:value/id_produs/id_utilizator:");

                            auctionService.addBid(licitatie, buildBid(licitatie, scanner.nextLine(), auctionService.getNumberOfUsers(licitatie) ,auctionService.getNumberOfProducts(licitatie)));
                            break;

                        }
                    }
                    break;
                }
                case "view":{
                        auctionService.printProductsDetails(licitatie);
                        System.out.println("-----------------------------------------------------------------------");
                        auctionService.printUsersDetails(licitatie);
                    break;
                }
                case "exit":{
                    System.out.println("Bye bye!");
                    System.exit(0);
                    break;
                }
                default : System.out.println("This command doesn't exist.");

            }
        }

    }
    private static Utilizator buildUser(String productDetails) {
        String[] attributes = productDetails.split("/");
        String username = attributes[0];
        String password = attributes[1];
        String firstName = attributes[2];
        String lastName = attributes[3];
        String address = attributes[4];
        return new Utilizator(new Random().nextInt(100), username, password, firstName, lastName, address);
    }


    private static Produs buildTeren(String productDetails) {
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

        return new Teren(new Random().nextInt(100), product_Type, minimValue,sold, tip, zona, lungime, latime, electricitate, apa);
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

    private static Imobiliare buildImobil(String productDetails) {
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

        return new Imobiliare(new Random().nextInt(100), product_Type, minimValue,sold, nrCamere, etaj, anConstruire, principala);
    }

    private static Afacere buildAfacere(String productDetails) {
        //impartire date
        String[] attributes = productDetails.split("/");
        //aranjare date

        String product_Type = attributes[0];
        double minimValue = Double.valueOf(attributes[1]);
        boolean sold = Boolean.valueOf(attributes[2]);

        double profitAnual=Double.valueOf(attributes[3]);
        String ocupatie=attributes[4];
        int nrAng=Integer.valueOf(attributes[5]);

        return new Afacere(new Random().nextInt(100), product_Type, minimValue,sold, profitAnual, ocupatie, nrAng);
    }
    private static Bid buildBid(Licitatie licitatie,String bidDetails,int mU,int mP){
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

        return new Bid(new Random().nextInt(100), bValue, licitatie.getProduct(idP), licitatie.getUser(idU));    }
}