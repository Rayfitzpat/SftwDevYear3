package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AvengerInterface extends Remote {

    String getName() throws RemoteException;
    int getAge() throws RemoteException;
    String getSuperPower() throws RemoteException;
    String getNationality() throws RemoteException;

    void setName(String name) throws RemoteException;
    void setAge(int age) throws RemoteException;
    void setSuperPower(String superPower) throws RemoteException;
    void setNationality(String nationality) throws RemoteException;
}
