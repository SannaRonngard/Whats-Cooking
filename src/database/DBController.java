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
			ResultSet rs = idSt.executeQuery("SELECT (SELECT COUNT(*) FROM recipe) AS recipeCount,"
												+"(SELECT COUNT(*) FROM ingredient) AS ingredientCount;");
			rs.next();
			int recipeId = rs.getInt("recipeCount");
			int ingredientId = rs.getInt("ingredientCount");
			recipeId++;
			ingredientId++;
			rs.close();

			String sql = "INSERT INTO recipe (recipeid,title,prepTime,content) " + "VALUES ('"
					+ recipeId + "','" + recipe.getTitle() + "','" + recipe.getprepTime()
					+ "','" + recipe.getContent() + "','" + "');";

			String[] ingredientsList = recipe.getIngredientsList();
			String ingredientList = "";

			for (int i = 0; i < ingredientList.length; i++) {
				sql += "\nINSERT INTO ingredient(ingredientid,recipeid,name) VALUES (" + ingredientId + "," + recipeId
						+ ",'" + ingredientList[i] + "');";
				ingredientId++;
			}
			st.executeUpdate(sql);
			st.close();
			db.getConnection().commit();
			db.getConnection().close();
			} catch (SQLException e) {}	
	}
}