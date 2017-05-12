package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Querys for database 
 * @author Sofia Larsson
 */
public class DBController {
	private DBConnection db = new DBConnection();
	/******************************
	 * Store a recipe in database *
	 * @param recipe 			  *
	 ******************************/
	public void newRecipe(Recipe recipe) {
		try {
			db.getConnection().setAutoCommit(false);
			Statement st = db.getConnection().createStatement();
			Statement idSt = db.getConnection().createStatement();
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
			db.getConnection().commit();
			db.getConnection().close();
			} catch (SQLException e) {}	
	}
}