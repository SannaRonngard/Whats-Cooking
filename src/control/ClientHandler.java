package control;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import database.Recipe;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

/**
 * Class that manages the lists with added ingredients
 * 
 * @author Sanna Rönngård
 * @author Sofia Larsson
 */

public class ClientHandler implements Initializable {

	static List<String> bigList = new ArrayList<String>();
	static List <String>bigListDB = new ArrayList<String>();
	
	static List<String> listVeggies = new ArrayList<String>();
	static List<String> listMeat = new ArrayList<String>();
	static List<String> listDairy = new ArrayList<String>();
	static List<String> listFruit = new ArrayList<String>();
	static List<String> listGrains = new ArrayList<String>();
	static List<String> listVeggiesDB = new ArrayList<String>();
	static List<String> listMeatDB = new ArrayList<String>();
	static List<String> listDairyDB = new ArrayList<String>();
	static List<String> listFruitDB = new ArrayList<String>();
	static List<String> listGrainsDB = new ArrayList<String>();
	
	protected static String selectedIngredients = "";
	protected static String selectedIngredientsDB = "";
	private Recipe recipe = new Recipe();


	/**
	 * Joins lists from each category into one list "bigList". 
	 * Does not modify original lists
	 */
	public static void setbigList(){
			bigList.addAll(listGrains);
			bigList.addAll(listDairy);
			bigList.addAll(listFruit);
			bigList.addAll(listMeat);
			bigList.addAll(listVeggies);
	}
	public static void setbigListDB(){
		bigListDB.addAll(listGrainsDB);
		bigListDB.addAll(listDairyDB);
		bigListDB.addAll(listFruitDB);
		bigListDB.addAll(listMeatDB);
		bigListDB.addAll(listVeggiesDB);
}
	/**
	 * Returns the joined lists
	 * @return bigList
	 */
	public static List<String> getBigList(){
		return bigList;
	}
	
	public static List<String> getBigListDB(){
		return bigListDB;
	}
	/**
	 * Convert a List<String> in a String with 
	 * all the values of the List comma separated
	 */
	public static void setListToString(){
		selectedIngredients = String.join(",", bigList);
	}
	
	public static void setListToStringDB(){
		selectedIngredientsDB = String.join(",", bigListDB);
		
	}
	/**
	 * Returns the selectet ingredients as 
	 * a String with comma separeted values
	 * @return selectedIngredients
	 */
	public static String getStringList(){
		return selectedIngredients;
	}
	
	public static String getStringListDB(){
		return selectedIngredientsDB;
	}
	/**
	 * Clears the list that is passed by the parameter
	 * @param list
	 */
	public static void clearList(List<String> list){
		list.clear();
	}
	
	public static void clearListDB(List<String> listDB){
		listDB.clear();
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	

}
