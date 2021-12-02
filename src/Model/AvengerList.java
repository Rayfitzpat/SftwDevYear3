package Model;

import Interface.AvengerInterface;
import Interface.AvengerListInterface;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class AvengerList extends UnicastRemoteObject implements AvengerListInterface, Serializable {

    // Creates an array list called avengers from Avenger Interface
    private ArrayList<AvengerInterface> avengers = new ArrayList();


    public AvengerList() throws RemoteException {

    }

    // add method using Avenger object - not used
    public void add(Avenger a) throws RemoteException {

                this.avengers.add(a);
            }

            // Add method not used
    @Override
    public void add(AvengerInterface a) throws RemoteException {
        this.avengers.add(a);
    }

    // Delete Method
    @Override
    public void delete(String name) throws RemoteException {
        for (int i = 0; i < this.avengers.size(); ++i) {
            System.out.println("delete middle");
            if (Objects.equals(name, ((AvengerInterface) this.avengers.get(i)).getName())) {
                System.out.println("delete inside");
                this.avengers.remove(i);
            }
        }
    }


    // Get List
    @Override
    public ArrayList<AvengerInterface> getList() throws RemoteException {
        // TODO Auto-generated method stub
        return avengers;
    }


    // Not Used
    @Override
    public AvengerInterface getAvenger(int index) throws RemoteException {
        return null;
    }


    // Not Used
    public boolean serialize() throws RemoteException {
        return false;
    }

    // Not used
    public boolean deserialize() throws RemoteException {
        return false;
    }

    // Edit Method
    public void edit(String name, String superPower, int age, String nationality) throws RemoteException {
        Iterator avenger = this.avengers.iterator();

        while(avenger.hasNext()) {
            AvengerInterface ai = (AvengerInterface)avenger.next();
            if (name.equals(ai.getName())) {
                ai.setSuperPower(superPower);
                ai.setAge(age);
                ai.setNationality(nationality);
            }
        }
    }

    // Add method using 4 parameters and then created an Avenger object using these
    public void add(String name, String superPower, int age, String nationality) throws RemoteException {
    AvengerInterface ai = new Avenger(name, superPower, age, nationality);
        this.avengers.add(ai);
    }
}
