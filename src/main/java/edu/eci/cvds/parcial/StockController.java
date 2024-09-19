package edu.eci.cvds.parcial;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/stockManager")
public class StockController {
    @Autowired
    private StockService stockService;


    @PostMapping (value = "addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody Product product) {
        stockService.addProduct(product);
    }
    @PostMapping("modifyStock")
    public void modifyStock(@RequestParam String idProduct,@RequestParam Integer newQuant){
        stockService.modifyStock(idProduct, newQuant);
    }
}