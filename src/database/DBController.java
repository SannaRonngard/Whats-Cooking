package database;

import java.sql.*;

/**
 * Querys for database 
 * @author Sofia Larsson
 * @author Linus Forsberg
 */
public class DBController {
	private DBConnection dbc;
	private Recipe recipe;

	public DBController() {
		this.dbc = new DBConnection();
		this.recipe = recipe;
		dbc.initiate();
	}
	/******************************
	 * Store a recipe in database *
	 * @param recipe 			  *
	 ******************************/
	public void newRecipe(Recipe recipe) {
		try {
			dbc.getConnection().setAutoCommit(false);
			Statement st = dbc.getConnection().createStatement();
			Statement idSt = dbc.getConnection().createStatement();
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
			dbc.getConnection().commit();
			dbc.getConnection().close();
		} catch (SQLException e) {}	
	}

	/**
	 * Gets a list of recipes and shows it in user interface.
	 * @param ingredientArray - list of chosen ingredients
	 */

	public void showRecipeList(String[] ingredientArray) {
		PreparedStatement stmt;
		ResultSet rs;
		String sql = "select recipe.title from recipe join "
				+ "recipe_ingredients on recipe.recipeid = recipe_ingredients.recipeid join "
				+ "ingredients on recipe_ingredients.ingredientsid = ingredients.ingredientsid where ingredients.name like ?";
		try {
			for(int i = 0; i < ingredientArray.length; i++) {
				if(i > 0) {
					sql += " AND ";
				}
				sql = " ingredients.name like ? ";
			}

			stmt = dbc.getConnection().prepareStatement(sql);

			for(int i = 0; i < ingredientArray.length; i++) {
				stmt.setString(i+1, ingredientArray[i]);
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("title"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets chosen recipe
	 * @param recipeTitle - title of recipe
	 */
	public void getRecipeByName(String recipeTitle) {
		try { 
			PreparedStatement stmt = dbc.getConnection().prepareStatement("SELECT * FROM recipe WHERE recipe.name = ?");
			stmt.setString(1, recipeTitle);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//testmetod för querys
	public static void main(String[] args) {
		DBController dbc = new DBController();
		String[] ingredientArray = {"pasta, salt"};
//		dbc.showRecipeList(ingredientArray);
		dbc.getRecipeByName("Guacamole");
	}
}