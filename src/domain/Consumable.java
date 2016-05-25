package domain;

public abstract class Consumable {
    private String Name, Desc;
    private Double Price;
    private int ID;
    
    public Consumable(String n, String d, Double p, int id) {
        Name = n;
        Desc = d;
        Price = p;
        ID = id;
    }
    
    public void setName(String newName) {
        Name = newName;
    }
    
    public void setPrice(Double newPrice) {
        Price = newPrice;
    }
    
    public String getName() {
        return Name;
    }
    
    public String getDesc() {
        return Desc;
    }
    
    public Double getPrice() {
        return Price;
    }
    
    abstract int getID();
}
