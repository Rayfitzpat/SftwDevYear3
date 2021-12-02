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

    private ArrayList<AvengerInterface> avengers = new ArrayList();


    public AvengerList() throws RemoteException {

    }

    public void add(Avenger a) throws RemoteException {

                this.avengers.add(a);
            }

    @Override
    public void add(AvengerInterface a) throws RemoteException {
        this.avengers.add(a);
    }

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

    @Override
    public ArrayList<AvengerInterface> getList() throws RemoteException {
        // TODO Auto-generated method stub
        return avengers;
    }

    @Override
    public AvengerInterface getAvenger(int index) throws RemoteException {
        return null;
    }

    public boolean serialize() throws RemoteException {
        return false;
    }

    public boolean deserialize() throws RemoteException {
        return false;
    }

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
    public void add(String name, String superPower, int age, String nationality) throws RemoteException {
    AvengerInterface ai = new Avenger(name, superPower, age, nationality);
        this.avengers.add(ai);
    }
}
