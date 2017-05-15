package database;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.image.Image;
/**
 * Class that represents a recipe, and has 
 * an Arraylist that can contain a list of recipe titles. 
 * Class has a constructor that sets all om the recipe variables, 
 * one that set them all exept the image. 
 * Class also contains separete getters and setters for all variables. 
 * @author Sofia Larsson 
 * @author Sanna Rönngård 2017
 */
public class Recipe implements Serializable {
	private ArrayList<String> recipeTitleList = new ArrayList<String>();
	private ArrayList<String> ingredientList = new ArrayList<String>();
	private String title;
	private String prepTime;
	private String content;
	private Image recipeImage;
	/**
	 * A recipe that has no image. 
	 * @param title
	 * @param prepTime
	 * @param content
	 */
	public Recipe(String title, String prepTime, String content){
		this.title = title;
		this.prepTime = prepTime;
		this.content = content;
	}
	/**
	 * A recipe that contains all varibles.
	 * @param sender
	 * @param message
	 * @param picture
	 * @param serverTime
	 */
	public Recipe(String title, String prepTime, String content, Image recipeImage){
		this.title = title;
		this.prepTime = prepTime;
		this.content = content;
		this.recipeImage = recipeImage;
	}
	/*********************************/
	/*      Setters and getters      */
	/*********************************/
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setPrepTime(String prepTime){
		this.prepTime = prepTime;
	}
	public String getPrepTime(){
		return this.prepTime;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return this.content;
	}
	public void setRecipeImage(Image recipeImage){
		this.recipeImage = recipeImage;
	}
	public Image getRecipeImage(){
		return recipeImage;
	}
	// Setting recipe titles to list
	public void setRecipeTitleToList(String title) {
		recipeTitleList.add(title);
	}
	// Getting all ingredients assigned to the recipe. Returns av array of the ingredients
	public String[] getRecipeTitleList() {
		String[] titleArray = new String[recipeTitleList.size()];
		recipeTitleList.toArray(titleArray);
		return titleArray;
	}

	// Setting ingredients to a recipe
	public void setIngredientToList(String ingredient) {
		ingredientList.add(ingredient);
	}

	// Getting all ingredients assigned to the recipe. Returns av array of the ingredients
	public String[] getIngredientArray() {
		String[] ingredientArray = new String[ingredientList.size()];
		ingredientList.toArray(ingredientArray);
		return ingredientArray;
	}
	
}
