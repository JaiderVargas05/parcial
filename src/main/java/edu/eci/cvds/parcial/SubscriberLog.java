package edu.eci.cvds.parcial;

public class SubscriberLog extends Subscriber{
    public void notifyChange(String product,Integer newQuant){
        System.out.println("Product: "+ product + " -> "+ newQuant+ " available units");
    }
}
