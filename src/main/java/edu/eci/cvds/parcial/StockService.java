package edu.eci.cvds.parcial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class StockService {
    private List<Product> products = new ArrayList<>();
    private List<Agent> agents = new ArrayList<>();
    public void addProduct(Product product){
        this.products.add(product);
    }
    public void modifyStock(String idProduct, Integer newQuant){
        Product product = this.products.stream().filter(p-> p.id.equals(idProduct)).findFirst().orElseThrow(() -> new IllegalArgumentException("Product does not exist"));
    }
}
