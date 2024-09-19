package edu.eci.cvds.parcial;

import org.springframework.stereotype.Component;

@Component
public class SubscriberWarning extends Subscriber {
    public void notifyChange(String product,Integer newQuant){
        if(newQuant<=5)System.out.println("ALERT!!! The stock of the Product: " + product+ " is very low, only " + newQuant + " units left.");
        setNotified(true);
    }
}
