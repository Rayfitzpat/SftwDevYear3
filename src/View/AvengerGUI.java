package View;

import Controller.AvengerController;
import Interface.AvengerInterface;
import Interface.AvengerListInterface;
import Model.Avenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AvengerGUI extends JFrame implements ActionListener{

AvengerController avengerController = new AvengerController();

    public JButton b1 = new JButton("Show Avengers Array");
    public JButton b2 = new JButton("Hide the Array");
    public JButton b3 = new JButton("Add Avenger");
    public JButton b4 = new JButton("Delete Avenger");
    public JButton b5 = new JButton("Edit Avenger");
    public JButton b6 = new JButton("Serialization");
    public JButton b7 = new JButton("Deserialization");

    JTextArea t1 = new JTextArea("List Of Avengers will go Here");

   public JTextField tf2 = new JTextField("Super Here");
   public JTextField tf1 = new JTextField("Name Here");
   public JTextField tf3 = new JTextField("Age Here");
   public JTextField tf4 = new JTextField("Nationality");
    String url="rmi:///";
    AvengerListInterface ali= (AvengerListInterface) Naming.lookup(url+"listOfAvengers");

    public AvengerGUI() throws RemoteException, MalformedURLException, NotBoundException {

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    b7.addActionListener(this);

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        getContentPane().setLayout(gridbag);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        setSize(1200,900);

        constraints.gridx = 0;
        constraints.gridy = 9;
        gridbag.setConstraints(b1, constraints);
        getContentPane().add(b1);

        constraints.gridx = 1;
        constraints.gridy = 9;
        gridbag.setConstraints(b2, constraints);
        getContentPane().add(b2);

        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 11;
        gridbag.setConstraints(t1, constraints);
        t1.setSize(600,500);
        getContentPane().add(t1);

        constraints.gridx = 0;
        constraints.gridy = 0;
        gridbag.setConstraints(tf1, constraints);
        getContentPane().add(tf1);

        constraints.gridx = 0;
        constraints.gridy = 1;
        gridbag.setConstraints(tf2, constraints);
        getContentPane().add(tf2);

        constraints.gridx = 0;
        constraints.gridy = 2;
        gridbag.setConstraints(tf3, constraints);
        getContentPane().add(tf3);

        constraints.gridx = 0;
        constraints.gridy = 3;
        gridbag.setConstraints(tf4, constraints);
        getContentPane().add(tf4);

        constraints.gridx = 0;
        constraints.gridy = 4;
        gridbag.setConstraints(b3, constraints);
        getContentPane().add(b3);

        constraints.gridx = 0;
        constraints.gridy = 5;
        gridbag.setConstraints(b4, constraints);
        getContentPane().add(b4);

        constraints.gridx = 0;
        constraints.gridy = 6;
        gridbag.setConstraints(b5, constraints);
        getContentPane().add(b5);

        constraints.gridx = 0;
        constraints.gridy = 7;
        gridbag.setConstraints(b6, constraints);
        getContentPane().add(b6);

        constraints.gridx = 0;
        constraints.gridy = 8;
        gridbag.setConstraints(b7, constraints);
        getContentPane().add(b7);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        //SERIALIZE
        if (e.getSource().equals(b6)) {
            System.out.println("Ser");
            avengerController.Serialize();
        }

        //DESER
        if (e.getSource().equals(b7)) {
            System.out.println("deser");
            avengerController.Deserialize();
        }

        // SHOW LIST
        if (e.getSource().equals(b1)){
            t1.setText(null);
            t1.append(avengerController.Deserialize());
        }

        // EDIT
        if (e.getSource().equals(b5)){
            System.out.println("Edit method called");
            try {
                String avengerName = tf1.getText();
                String superPower = tf2.getText();
                int age = Integer.parseInt(tf3.getText());
                String nationality = tf4.getText();

                ali.edit(avengerName, superPower, age, nationality);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }

        // DELETE
        if (e.getSource().equals(b4)){
            System.out.println("Delete method called");
            try {
                String avengerName = tf1.getText();

                ali.delete(avengerName);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }

        // ADD NEW
        if (e.getSource().equals(b3)){
            System.out.println("Add New method called");
            try {
                String avengerName = tf1.getText();
                String superPower = tf2.getText();
                int age = Integer.parseInt(tf3.getText());
                String nationality = tf4.getText();
//                AvengerInterface newAvenger = new Avenger(avengerName, superPower, age, nationality);
                ali.add(avengerName, superPower, age, nationality);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }

        // HIDE LIST
        if (e.getSource().equals(b2)){ //Show current deserialized array
            t1.setText(null);
        }
    }
        public void edit(String avengerName, String superPower, int age, String nationality) throws MalformedURLException, NotBoundException, RemoteException {
            System.out.println(avengerName + ", " + superPower + ", " + age + ", " + nationality);
        }
}
