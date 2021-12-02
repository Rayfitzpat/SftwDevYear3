package Interface;

import Model.Avenger;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AvengerListInterface extends Remote{

    void add(AvengerInterface a) throws RemoteException;

    void add(String name, String superPower, int age, String nationality) throws RemoteException;

    void delete(String name) throws RemoteException;

    void edit(String name, String superPower, int age, String nationality) throws RemoteException;

    ArrayList<AvengerInterface> getList() throws RemoteException ;

    AvengerInterface getAvenger(int index) throws RemoteException;
}
