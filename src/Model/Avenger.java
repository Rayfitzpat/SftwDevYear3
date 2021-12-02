package Model;

import Interface.AvengerInterface;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Avenger extends UnicastRemoteObject implements AvengerInterface, Serializable {

    String name;
    String superPower;
    int age;
    String nationality;

    public Avenger(String name, String superPower, int age, String nationality) throws RemoteException {
        this.name = name;
        this.superPower = superPower;
        this.age = age;
        this.nationality = nationality;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
