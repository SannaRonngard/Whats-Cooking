package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Querys for database 
 * @author Sofia Larsson
 * @author Linus Forsberg
 */
public class DBController {
	private DBConnection c;

	public DBController() {
		this.c = new DBConnection();
		c.initiate();
	}
	
	/**
	 * Returns a recipe
	 * @param recipeTitle - title of recipe
	 */
	public Recipe[] getTitleSearch(String title) {
		
		ArrayList<Recipe> result = new ArrayList<Recipe>();
		Statement stmt;
		try {
			stmt = c.getConnection().createStatement();
			String sql = "SELECT name, prep_time, measure, instructions FROM recipe WHERE recipe.name ='" + title + "';";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Recipe recipe = new Recipe();
	
				recipe.setTitle(rs.getString("name"));
				recipe.setPrepTime(rs.getString("prep_time"));
				recipe.setMeasure(rs.getString("measure"));
				recipe.setInstructions(rs.getString("instructions"));
				result.add(recipe);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Recipe[] rArray = new Recipe[result.size()];
		result.toArray(rArray);
		return rArray;
	}
	/**
	 * Ingredients format must be: (1,2,3)!!!
	 * @param ingredients
	 * @return
	 */
public String[] getRecipeByIngredients(String ingredients) {
		
		ArrayList<String> result = new ArrayList<String>();
		Recipe recipe = new Recipe();
		Statement stmt;
		try {
			stmt = c.getConnection().createStatement();
			String sql1 = "WITH cte AS (SELECT recipe_id, count(*) AS cnt "+
			"FROM Recipe_Ingredient WHERE ingredient_id IN " + "(" + ingredients + ") " + 
					" GROUP BY recipe_id) SELECT r.id as Recipeid, "+ 
			"r.name, c.cnt FROM Recipe r JOIN cte c "+
					" ON r.id = c.recipe_id ORDER BY c.cnt DESC";
		
			ResultSet rs = stmt.executeQuery(sql1);
			
			while(rs.next()){
				recipe.setRecipeNameToList(rs.getString("name"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String[] rArray = new String[result.size()];
		result.toArray(rArray);
		return rArray;
	}
	
	
	public static void main(String[] args) {
		
		DBController dbc = new DBController();

		
		/* Test titleSearch() */
		
		Recipe[] titleSearch = dbc.getTitleSearch("Guacamole");
		
		for (Recipe i : titleSearch) {
			
			System.out.println(i.getTitle());
			System.out.println(i.getPrepTime());
			System.out.println("---------------------------");
			System.out.println(i.getMeasure());
			System.out.println(i.getInstructions());
		}
		
		/* Test ingredientSearch() */
		

		String ingredientString = "1,8";
		String[] ingredientSearch = dbc.getRecipeByIngredients(ingredientString);
		
		for (String i : ingredientSearch) {
			
			System.out.println(i);
		}

		
	}
}