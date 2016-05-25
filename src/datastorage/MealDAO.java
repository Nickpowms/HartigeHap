package datastorage;

import domain.Meal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MealDAO {
    
    public MealDAO() {
        
    }
    
    public ArrayList<Meal> getAllMeals() {
        ArrayList<Meal> meals = new ArrayList<>();
        
        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if(connection.openConnection())
        {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                "SELECT * FROM meal;");

            if(resultset != null)
            {
                try
                {
                    if(resultset.next())
                    {
                        int IDFromDb = resultset.getInt("MealID");
                        String NameFromDb = resultset.getString("Name");
                        String DescFromDb = resultset.getString("Description");
                        Double PriceFromDb = resultset.getDouble("Price");
                        
                        Meal newMeal = new Meal(NameFromDb, DescFromDb, PriceFromDb, IDFromDb);
                        meals.add(newMeal);
                    }
                }
                catch(SQLException e)
                {
                    System.out.println(e);
                    meals.clear();
                }
            }
            // We had a database connection opened. Since we're finished,
            // we need to close it.
            connection.closeConnection();
        }
        
        return meals;
    }
}
