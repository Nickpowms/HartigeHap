package domain;

public class Meal extends Consumable {
    private String Name, Desc;
    private Double Price;
    private int ID;
    
    public Meal(String n, String d, Double p, int id) {
        super(n, d, p, id);
    }
    
    public int getID() {
        return ID;
    }
    
}
