/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.cargo;

/**
 *
 * @author HP
 */
public class Cargoclass {
    String ID, Name, Item,Kg, pay;

    public Cargoclass(String ID, String Name, String Item, String Kg, String pay) {
        this.ID = ID;
        this.Name = Name;
        this.Item = Item;
        this.Kg = Kg;
        this.pay = pay;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

   

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }

    public String getKg() {
        return Kg;
    }

    public void setKg(String Kg) {
        this.Kg = Kg;
    }

    
}
