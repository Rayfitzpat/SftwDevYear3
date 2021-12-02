package Controller;

import Interface.AvengerInterface;
import Interface.AvengerListInterface;

import java.io.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class AvengerController {

    String url="rmi:///";
    public AvengerController() throws RemoteException, MalformedURLException, NotBoundException {
        avengersLi = (AvengerListInterface) Naming.lookup(url+"listOfAvengers");
    }
//    AvengerGUI gui = new AvengerGUI();

    private String res = "";
    private AvengerListInterface avengersLi;

    //Serialize
    public void Serialize() {
        try {
            res = "";
            ArrayList<AvengerInterface> avengerList = avengersLi.getList();
            System.out.println("Serialization Started");
            FileOutputStream fileOut = new FileOutputStream("Avenger.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(avengerList);

            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Deserialize & add to Text area
    public String Deserialize() {

        try {
            System.out.println("Deserialization");
            FileInputStream fileIn = new FileInputStream("Avenger.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            AvengerInterface newAvengerI;
            ArrayList<AvengerInterface> avengerArray = (ArrayList<AvengerInterface>) objectIn.readObject();
            System.out.println("Deserialization completed");
            res = "";
            for (AvengerInterface avenger : avengerArray){

                res += "\nAvenger Name: " + avenger.getName() + ", Avenger Power : " + avenger.getSuperPower() + "\nAge: " + avenger.getAge() + ", Nationality : " + avenger.getNationality() + "\n";
            }
            return res;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }return null;
    }
}