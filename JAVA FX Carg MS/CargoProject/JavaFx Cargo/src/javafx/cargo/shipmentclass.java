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
public class shipmentclass {
    
    String ID ,Source ,Destination;

    public shipmentclass(String ID, String Source, String Destination) {
        this.ID = ID;
        this.Source = Source;
        this.Destination = Destination;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }
    
}
