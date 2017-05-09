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
 * @author Sanna Rönngård 
 */
public class Recipe implements Serializable {
	private ArrayList<String> recipeTitleList = new ArrayList<String>();
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
	public ArrayList<String> getRecipeTitleList() {
		return recipeTitleList;
	}
	public void setRecipeTitleList(ArrayList<String> recipeTitleList) {
		this.recipeTitleList = recipeTitleList;
	}
	
}
