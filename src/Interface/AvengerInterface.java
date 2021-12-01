package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AvengerInterface extends Remote {

    public String getName() throws RemoteException;
    public int getAge() throws RemoteException;
    public String getSuperPower() throws RemoteException;
    public String getNationality() throws RemoteException;

    void setName(String name) throws RemoteException;
    void setAge(int age) throws RemoteException;
    void setSuperPower(String superPower) throws RemoteException;
    void setNationality(String nationality) throws RemoteException;

}
