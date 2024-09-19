package edu.eci.cvds.parcial;

import org.springframework.stereotype.Component;

@Component
public abstract class Subscriber {
    public abstract void notifyChange(String product,Integer newQuant);
}
