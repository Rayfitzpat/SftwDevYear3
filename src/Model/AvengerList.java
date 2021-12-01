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

    @Override
    public void addToList(Avenger a) throws RemoteException {
        this.avengers.add(a);

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

//    public void deleteAvenger(String name1) throws RemoteException {
//        System.out.println("delete start");
//       for(int i = 0; i < this.avengers.size(); ++i) {
//           System.out.println("delete middle");
//           if (Objects.equals(name1, ((AvengerInterface) this.avengers.get(i)).getName())) {
//               System.out.println("delete inside");
//               this.avengers.remove(i);
//           }
//       }
//
//    }

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


//    public void editAvenger(String name) throws RemoteException {
//
//        for (AvengerInterface avenger : this.avengers) {
//            if (Objects.equals(name, ((AvengerInterface) avenger).getName())) {
//                ((AvengerInterface) avenger).setName(name);
//            }
//        }
//    }
}
