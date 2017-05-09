package database;

import java.io.Serializable;
import javafx.scene.image.Image;
/**
 * Klassen ska representera ett recept
 * @author Sofia Larsson 
 */
public class Recipe implements Serializable {
	private String title;
	private String prepTime;
	private String content;
	private Image recipeImage;
	/**
	 * 
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
	
	public String getTitle(){
		return this.title;
	}
	
	public String getprepTime(){
		return this.prepTime;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public Image recipeImage(){
		return recipeImage;
	}
	
}
