package Server;

import Model.Avenger;
import Model.AvengerList;

import java.rmi.Naming;

public class AvengerServer {

    public static void main(String[] args) {

        System.out.println("Server has started.....");

        try {
            AvengerList al = new AvengerList();  // creates new Avenger list called al

            // creates new Avengers
            Avenger ironMan = new Avenger("Tony Stark",  "Money", 46, "American");
            System.out.println("IronMan created....");
            Avenger thor = new Avenger("Thor",  "God of Thunder", 3474, "Asgardian");
            System.out.println("Thor created...");
            Avenger hulk  = new Avenger("Bruce Banner",  "Strength", 45, "American");
            System.out.println("Hulk created...");
            Avenger blackWidow  = new Avenger("Natasha Romanov",  "Assassin", 37, "Russian");
            System.out.println("Black Widow created...");
            Avenger hawkeye  = new Avenger("Clint Barton",  "Archer", 42,"American");
            System.out.println("Hawkeye created...");
            Avenger captainAmerica  = new Avenger("Steve Rogers",  "Strength", 103, "American");
            System.out.println("Hulk created...");

            // adds created Avengers to the Avenger List
            al.add(ironMan);
            al.add(thor);
            al.add(hulk);
            al.add(blackWidow);
            al.add(hawkeye);
            al.add(captainAmerica);
            Naming.rebind("listOfAvengers", al);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
