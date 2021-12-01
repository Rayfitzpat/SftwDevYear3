package Controller;

import Interface.AvengerInterface;
import Interface.AvengerListInterface;
import Model.Avenger;
import Model.AvengerList;
import View.AvengerGUI;

import java.awt.event.ActionEvent;
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

    public void Serialize() {
        try {
            res = "";
            ArrayList<AvengerInterface> avengerList = avengersLi.getList();
            System.out.println("Serialization Started");
            FileOutputStream fileOut = new FileOutputStream("Avenger.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

//            for (int i = 0; i < avengerList.size(); i++) {
//                objectOut.writeObject(avengerList.get(i));
//            }
            objectOut.writeObject(avengerList);
            //Serialize
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String Deserialize() {
        res = "";
        try {
//            ArrayList<AvengerInterface> avengerArray = avengersLi.getList();

            System.out.println("Deserialization");
            FileInputStream fileIn = new FileInputStream("Avenger.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            AvengerInterface newAvengerI;
            ArrayList<AvengerInterface> avengerArray = (ArrayList<AvengerInterface>) objectIn.readObject();
            System.out.println("Deserialization completed");

            for (AvengerInterface avenger : avengerArray){
                res += "\nAvenger Name: " + avenger.getName() + ", Avenger Power : " + avenger.getSuperPower() + "\nAge: " + avenger.getAge() + ", Nationality : " + avenger.getNationality() + "\n";
            }
            return res;
            //Deserialize

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }return null;
    }
}