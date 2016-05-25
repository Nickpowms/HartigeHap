package buisinesslogic;

import datastorage.DrinkDAO;
import datastorage.MealDAO;
import domain.Drink;
import domain.Meal;
import java.util.ArrayList;

public class OrderManager {
    private ArrayList<Meal> meals;
    private ArrayList<Drink> drinks;
    
    public OrderManager() {
        meals = new ArrayList<>();
        drinks = new ArrayList<>();
    }
    
    public ArrayList<Meal> getAllMeals() {

        return meals;
    }
    
    public ArrayList<Drink> getAllDrinks() {

        return drinks;
    }
    
    public void newOrder() {
        //TODO
    }
    
    public void initialize() {
        MealDAO mealDAO = new MealDAO();
        meals = mealDAO.getAllMeals();
        
        DrinkDAO drinkDAO = new DrinkDAO();
        drinks = drinkDAO.getAllDrinks();

        
    }
}
