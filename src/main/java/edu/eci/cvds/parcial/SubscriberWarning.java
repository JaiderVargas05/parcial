package edu.eci.cvds.parcial;

public class SubscriberWarning extends Subscriber {
    public void notifyChange(String product,Integer newQuant){
        System.out.println("ALERT!!! The stock of the Product: " + product+ " is very low, only " + newQuant + " units left.");
    }
}
