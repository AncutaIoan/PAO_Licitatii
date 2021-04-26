package service;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
public class Audit {


    public void addRequest(String args) throws FileNotFoundException {
        try {
            String data = args;
            File f1 = new File("audit.txt");
            if(!f1.exists()) {
                f1.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(f1.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(data);
            bw.close();
            System.out.println("Done");
        } catch(IOException e){
            e.printStackTrace();
        }

    }



}
