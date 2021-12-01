package Interface;

import Model.Avenger;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AvengerListInterface extends Remote{


    public void addToList(Avenger h) throws RemoteException;

//    void deleteAvenger(String name) throws RemoteException;

    void edit(String name, String superPower, int age, String nationality) throws RemoteException;

    public ArrayList<AvengerInterface> getList() throws RemoteException ;

    AvengerInterface getAvenger(int index) throws RemoteException;

}
