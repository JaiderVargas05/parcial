package edu.eci.cvds.parcial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class StockService {
    private List<Product> products = new ArrayList<>();
    private List<Subscriber> subscribers = new ArrayList<>();
    @Autowired
    public  StockService(SubscriberLog log, SubscriberWarning warning){
        this.subscribers.add(log);
        this.subscribers.add(warning);
    }
    public Boolean addProduct(Product product){

        if(this.products.stream().anyMatch(p-> p.getId().equals(product.getId())))return false;
        if(product.getQuantity()<0 || product.getPrice()<0)return false;
        this.products.add(product);
        return true;
    }
    public Boolean modifyStock(String idProduct, Integer newQuant){
        if(!products.stream().anyMatch(p->p.getId().equals(idProduct)) || newQuant<0) return false;
        else{
            Product product = this.products.stream().filter(p-> p.getId().equals(idProduct)).findFirst().orElse(new Product());
            product.setQuantity(newQuant);
            for(Subscriber sub: subscribers){
                sub.notifyChange(product.getName(),newQuant);
            }
        }
        return true;
    }
}
