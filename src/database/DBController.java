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
		String ingredient = "";
		try {
			for(int i = 0; i < ingredientArray.length; i++ ) {
				ingredient = ingredientArray[i];
		
			}
			stmt = dbc.getConnection().prepareStatement("SELECT title FROM recipe WHERE recipe.ingredients LIKE '%" + ingredient +"%'");
			rs = stmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("title"));
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets recipes from chosen ingredients
	 * @param ingredientArray - list of chosen ingredients
	 */
	public void getChosenRecipe(String[] ingredientArray) {
		try { 
			PreparedStatement stmt = dbc.getConnection().prepareStatement("SELECT recipe.title FROM recipe.ingredients WHERE content LIKE" + ingredientArray);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(4));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//testmetod för querys
	public static void main(String[] args) {
		DBController dbc = new DBController();
		String[] ingredientArray = {"salt"};
		dbc.showRecipeList(ingredientArray);
	}
}