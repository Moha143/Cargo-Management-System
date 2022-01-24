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
public class customerclass {
    
    String ID , Name ,Phone , Address, Gender;

    public customerclass(String ID, String Name, String Phone, String Address, String Gender) {
        this.ID = ID;
        this.Name = Name;
        this.Phone = Phone;
        this.Address = Address;
        this.Gender = Gender;
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    
    
}
