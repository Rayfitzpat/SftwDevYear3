package Client;

import Interface.AvengerInterface;
import Interface.AvengerListInterface;
import Model.Avenger;
import View.AvengerGUI;

import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.rmi.Naming;

public class AvengerClient {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        // TODO Auto-generated method stub
        String url="rmi:///"; //no IP address, this is local.
        System.out.println("Client Started");

        try {
            AvengerListInterface avenger= (AvengerListInterface) Naming.lookup(url+"listOfAvengers");
            ArrayList<AvengerInterface> avengerList = avenger.getList();
            for(AvengerInterface avengerInterface : avengerList){
                System.out.println(avengerInterface.getName());
                System.out.println(avengerInterface.getNationality());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        new AvengerGUI();
    }
}

