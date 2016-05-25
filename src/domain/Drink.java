package domain;

public class Drink extends Consumable {
    private String Name, Desc;
    private Double Price;
    private int ID;
    
    public Drink(String n, String d, Double p, int id) {
        super(n, d, p, id);
    }
    
    public int getID() {
        return ID;
    }
    
}
