package main;

import model.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Utilizator u = new Utilizator(1, "wow", "pas", "A", "B", "Strada");
        Utilizator u1 = new Utilizator(2, "wow", "pas", "A", "B", "Strada");

        String s=u.toString()+u1.toString();
        System.out.println(s);


    }
}