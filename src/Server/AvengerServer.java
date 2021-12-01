package Server;

import Model.Avenger;
import Model.AvengerList;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.Naming;
import java.rmi.*;

//import static Model.AvengerList.avengers;

public class AvengerServer {




//    public void serialization() throws IOException {
//        try{
//            FileOutputStream fileOut = new FileOutputStream("avenger.ser");
//            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
//
//            for (Avenger a : al) {
//                objectOut.writeObject(a);
//                System.out.println("Name: " + a.getName() + ", Age: " + a.getAge() + ", Super Power: " + a.getSuperPower() + ", Nationality: " + a.getNationality());
//
//            }
//            System.out.println("File Serialized");
//            System.out.println("*************************************************************");
//            System.out.println();
//            objectOut.close();
//
//        }catch (FileNotFoundException e){
//            //TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("Server has started.....");

        try {
            AvengerList al = new AvengerList();

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
