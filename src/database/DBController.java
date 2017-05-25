package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javafx.scene.control.ListView;

/**
 * Querys for database 
 * @author Sofia Larsson
 * @author Linus Forsberg
 */
public class DBController {
	private DBConnection c;
	private Recipe recipe;

	public DBController() {
		this.c = new DBConnection();
		this.recipe = recipe;
		
		c.initiate();
	}
	/******************************
	 * Store a recipe in database *
	 * @param recipe 			  *
	 ******************************/
	public void newRecipe(Recipe recipe) {
		try {
			c.getConnection().setAutoCommit(false);
			Statement st = c.getConnection().createStatement();
			Statement idSt = c.getConnection().createStatement();
			ResultSet rs = idSt.executeQuery("SELECT (SELECT COUNT(*) FROM recipe) AS recipeCounter,"
					+"(SELECT COUNT(*) FROM ingredient) AS ingredientCounter;");
			rs.next();
			int recipeId = rs.getInt("recipeCounter");
			int ingredientId = rs.getInt("ingredientCounter");
			recipeId++;
			ingredientId++;
			rs.close();

			String sql = "INSERT INTO recipe (recipeid,title,prepTime,content) " + "VALUES ('"
					+ recipeId + "','" + recipe.getTitle() + "','" + recipe.getPrepTime()
					+ "','" + recipe.getContent() + "','" + "');";
			String[] ingredientArray = recipe.getIngredientArray();
			for (int i = 0; i < ingredientArray.length; i++) {
				sql += "\nINSERT INTO ingredient(ingredientid,recipeid,name) VALUES (" + ingredientId + "," + recipeId
						+ ",'" + ingredientArray[i] + "');";
				ingredientId++;
			}
			st.executeUpdate(sql);
			st.close();
			c.getConnection().commit();
			c.getConnection().close();
		} catch (SQLException e) {}	
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
				recipe.setContent(rs.getString("instructions"));
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
	 * @param selectedIngredients
	 * @return
	 */
	public Recipe[] getRecipeByIngredients(ListView<String> selectedIngredients) {
		
		ArrayList<Recipe> result = new ArrayList<Recipe>();
		Statement stmt;
		try {
			stmt = c.getConnection().createStatement();
			String sql1 = "SELECT recipe_id, count(*) AS cnt" +
			"FROM Recipe_Ingredient WHERE ingredient_id IN " + selectedIngredients + 
					"GROUP BY recipe_id;";
			String sql2 = "SELECT r.id as Recipeid, r.name " +
			"FROM Recipe r JOIN cte cON r.id = c.recipe_id ORDER BY c.cnt DESC;";
			
			ResultSet rs1 = stmt.executeQuery(sql1);
			
			while(rs1.next())
                System.out.println(rs1.getString("ingredient_id"));
			
			ResultSet rs2 = stmt.executeQuery(sql2);

			while (rs1.next()) {
				Recipe recipe = new Recipe();
	
				recipe.setTitle(rs1.getString("name"));
				result.add(recipe);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Recipe[] rArray = new Recipe[result.size()];
		result.toArray(rArray);
		return rArray;
	}
	
	
	public static void main(String[] args) {
		DBController dbc = new DBController();
		String[] ingredientArray = {"1, 8"};
		/* Test titleSearch() */
		Recipe[] titleSearch = dbc.getTitleSearch("Guacamole");
		for (Recipe i : titleSearch) {
			
			System.out.println(i.getTitle());
			System.out.println(i.getPrepTime());
			System.out.println("---------------------------");
			System.out.println(i.getMeasure());
			System.out.println(i.getContent());
		}
		
		/* Test ingredientSearch() */
//		Recipe[] ingredientSearch = dbc.getRecipeByIngredients("(1,8)");
//
//		for (Recipe i : ingredientSearch) {
//			
//			System.out.println(i.getTitle());
//		}
		
		}
}