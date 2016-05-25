package datastorage;

import domain.Drink;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DrinkDAO {
    
    public DrinkDAO() {
        
    }
    
    public ArrayList<Drink> getAllDrinks() {
        ArrayList<Drink> drinks = new ArrayList<>();
        
        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if(connection.openConnection())
        {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                "SELECT * FROM drink;");

            if(resultset != null)
            {
                try
                {
                    if(resultset.next())
                    {
                        int IDFromDb = resultset.getInt("DrinkID");
                        String NameFromDb = resultset.getString("Name");
                        String DescFromDb = resultset.getString("Description");
                        Double PriceFromDb = resultset.getDouble("Price");
                        
                        Drink newMeal = new Drink(NameFromDb, DescFromDb, PriceFromDb, IDFromDb);
                        drinks.add(newMeal);
                    }
                }
                catch(SQLException e)
                {
                    System.out.println(e);
                    drinks.clear();
                }
            }
            // We had a database connection opened. Since we're finished,
            // we need to close it.
            connection.closeConnection();
        }
        
        return drinks;
    }
}
