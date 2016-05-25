package domain;

import java.util.ArrayList;

public class OrderList {
    private ArrayList<Consumable> list;
    
    public void addConsumable(Consumable c) {
        list.add(c);
    }
    
    public void clear() {
        list.clear();
    }
}
