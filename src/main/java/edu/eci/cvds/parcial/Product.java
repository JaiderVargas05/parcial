package edu.eci.cvds.parcial;

public class Product {
    private String id;
    private String name;
    private Integer price;
    private String category;
    private Integer quantity;
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPrice(Integer price){
        this.price = price;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
}
