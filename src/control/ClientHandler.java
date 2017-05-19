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
 * Class that handles all the checkboxes for different categories of
 * ingredients.
 * 
 * @author Sanna Rönngård
 * @author Sofia Larsson
 * @author Olle Olsson
 * @author Linus Forsberg
 */

public class ClientHandler implements Initializable {
	/* Checkboxes - Category Meat */
	@FXML
	private CheckBox checkBox_Chicken, checkBox_Lamb, checkBox_Pork, checkBox_Game, checkBox_Rabbit, checkBox_Beef,
			checkBox_Duck, checkBox_Ground_Beef, checkBox_Fish, checkBox_Shrimp, checkBox_Ground_Pork, checkBox_Egg;
	/* Checkboxes - Category Dairy */
	@FXML
	private CheckBox checkBox_Milk, checkBox_Cream, checkBox_Sour_Cream, checkBox_Creme_Fraiche, checkBox_Yogurt,
			checkBox_Hard_Cheese, checkBox_Soft_Cheese, checkBox_Cottage_Cheese, checkBox_Blue_Cheese,
			checkBox_Parmesan, checkBox_Butter;
	/* Checkboxes - Category Grains */
	@FXML
	private CheckBox checkBox_Wheat, checkBox_Oats, checkBox_Barley, checkBox_CornMeal, checkBox_Rye, checkBox_Rice,
			checkBox_Bulgur, checkBox_Couscous, checkBox_Cracked_Wheat, checkBox_Bread, checkBox_Pasta;
	/* Checkboxes - Category Fruit */
	@FXML
	private CheckBox checkBox_Apple, checkBox_Pear, checkBox_Orange, checkBox_Mandarin, checkBox_Grapefruit,
			checkBox_Lemon, checkBox_Lime, checkBox_Banana, checkBox_Strawberry, checkBox_Blueberry,
			checkBox_Blackberry, checkBox_Cherry, checkBox_Pineapple, checkBox_Apricot, checkBox_Grapes, checkBox_Mango,
			checkBox_Papaya, checkBox_Kiwi;
	/* Checkboxes - Category Vegetables */
	@FXML
	private CheckBox checkBox_Tomato, checkBox_Cucumber, checkBox_Pepper, checkBox_Zucchini, checkBox_Aubergine,
			checkBox_Pumpkin, checkBox_Avocado, checkBox_Onion, checkBox_Garlic, checkBox_Spring_Onion, checkBox_Leek,
			checkBox_Celery, checkBox_Aspargus, checkBox_Artichoke, checkBox_Potato, checkBox_Sweet_Potato,
			checkBox_Radish, checkBox_Parsnip, checkBox_Carrot, checkBox_Cabbage, checkBox_Cauliflower,
			checkBox_Lettuce, checkBox_Spinach, checkBox_Sweetcorn, checkBox_Green_Peas, checkBox_Chick_Peas,
			checkBox_White_Beans, checkBox_Black_Beans, checkBox_Coriander, checkBox_Tarragon, checkBox_Parsley,
			checkBox_Dill, checkBox_Chili, checkBox_Lemongrass;
	@FXML
	private Button returnBtn;
	static List<String> bigList = new ArrayList<String>();
	static List<String> listVeggies = new ArrayList<String>();
	static List<String> listMeat = new ArrayList<String>();
	static List<String> listDairy = new ArrayList<String>();
	static List<String> listFruit = new ArrayList<String>();
	static List<String> listGrains = new ArrayList<String>();
	protected static String selectedIngredients = "";
	private Recipe recipe = new Recipe();

	public ClientHandler() {
		InitiateMeat();
		InitiateDairy();
		InitiateGrains();
		InitiateFruit();
		InitiateVegetables();
	}
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
	/**
	 * Returns the joined lists
	 * @return bigList
	 */
	public static List<String> getBigList(){
		return bigList;
	}
	/**
	 * Convert a List<String> in a String with 
	 * all the values of the List comma separated
	 */
	public static void setListToString(){
		selectedIngredients = String.join(",", bigList);
	}
	/**
	 * Returns the selectet ingredients as 
	 * a String with comma separeted values
	 * @return selectedIngredients
	 */
	public static String getStringList(){
		return selectedIngredients;
	}
	/**
	 * Clears the list that is passed by the parameter
	 * @param list
	 */
	public static void clearList(List<String> list){
		list.clear();
	}
	/**
	 * Methods that saves checked item to a list or removes it from the list
	 * whenever box is unchecked.
	 */
	@FXML
	private void handleCheckBoxActionMeat(ActionEvent event) throws IOException {

		if (checkBox_Chicken.isSelected() == true) {
			if (!listMeat.contains("Chicken")) {
				listMeat.add("Chicken");
			}
		}
		if (checkBox_Chicken.isSelected() == false) {
			if (listMeat.contains("Chicken")) {
				listMeat.remove("Chicken");
			}
		}

		if (checkBox_Lamb.isSelected() == true) {
			if (!listMeat.contains("Lamb")) {
				listMeat.add("Lamb");
			}
		}
		if (checkBox_Lamb.isSelected() == false) {
			if (listMeat.contains("Lamb")) {
				listMeat.remove("Lamb");
			}
		}

		if (checkBox_Pork.isSelected() == true) {
			if (!listMeat.contains("Pork")) {
				listMeat.add("Pork");
			}
		}
		if (checkBox_Pork.isSelected() == false) {
			if (listMeat.contains("Pork")) {
				listMeat.remove("Pork");
			}
		}
		if (checkBox_Game.isSelected() == true) {
			if (!listMeat.contains("Game")) {
				listMeat.add("Game");
			}
		}
		if (checkBox_Game.isSelected() == false) {
			if (listMeat.contains("Game")) {
				listMeat.remove("Game");
			}
		}
		if (checkBox_Rabbit.isSelected() == true) {
			if (!listMeat.contains("Rabbit")) {
				listMeat.add("Rabbit");
			}
		}
		if (checkBox_Rabbit.isSelected() == false) {
			if (listMeat.contains("Rabbit")) {
				listMeat.remove("Rabbit");
			}
		}
		if (checkBox_Beef.isSelected() == true) {
			if (!listMeat.contains("Beef")) {
				listMeat.add("Beef");
			}
		}
		if (checkBox_Beef.isSelected() == false) {
			if (listMeat.contains("Beef")) {
				listMeat.remove("Beef");
			}
		}
		if (checkBox_Duck.isSelected() == true) {
			if (!listMeat.contains("Duck")) {
				listMeat.add("Duck");
			}
		}
		if (checkBox_Duck.isSelected() == false) {
			if (listMeat.contains("Duck")) {
				listMeat.remove("Duck");
			}
		}
		if (checkBox_Ground_Beef.isSelected() == true) {
			if (!listMeat.contains("Ground_Beef")) {
				listMeat.add("Ground_Beef");
			}
		}
		if (checkBox_Ground_Beef.isSelected() == false) {
			if (listMeat.contains("Ground_Beef")) {
				listMeat.remove("Ground_Beef");
			}
		}
		if (checkBox_Fish.isSelected() == true) {
			if (!listMeat.contains("Fish")) {
				listMeat.add("Fish");
			}
		}
		if (checkBox_Fish.isSelected() == false) {
			if (listMeat.contains("Fish")) {
				listMeat.remove("Fish");
			}
		}
		if (checkBox_Shrimp.isSelected() == true) {
			if (!listMeat.contains("Shrimp")) {
				listMeat.add("Shrimp");
			}
		}
		if (checkBox_Shrimp.isSelected() == false) {
			if (listMeat.contains("Shrimp")) {
				listMeat.remove("Shrimp");
			}
		}
		if (checkBox_Ground_Pork.isSelected() == true) {
			if (!listMeat.contains("Ground_Pork")) {
				listMeat.add("Ground_Pork");
			}
		}
		if (checkBox_Ground_Pork.isSelected() == false) {
			if (listMeat.contains("Ground_Pork")) {
				listMeat.remove("Ground_Pork");
			}
		}
		if (checkBox_Egg.isSelected() == true) {
			if (!listMeat.contains("Egg")) {
				listMeat.add("Egg");
			}
		}
		if (checkBox_Egg.isSelected() == false) {
			if (listMeat.contains("Egg")) {
				listMeat.remove("Egg");
			}
		}

		returnBtn.setOnAction(e -> {
			bigList.addAll(listMeat);
			System.out.println(bigList);
		});
	}

	@FXML
	private void handleCheckBoxActionVeg(ActionEvent event) throws IOException {

		if (checkBox_Avocado.isSelected() == true) {
			if (!listVeggies.contains("avocado")) {
				listVeggies.add("avocado");
			}
		}
		if (checkBox_Avocado.isSelected() == false) {
			if (listVeggies.contains("avocado")) {
				listVeggies.remove("avocado");
			}
		}
		if (checkBox_Tomato.isSelected() == true) {
			if (!listVeggies.contains("Tomato")) {
				listVeggies.add("Tomato");
			}
		}
		if (checkBox_Tomato.isSelected() == false) {
			if (listVeggies.contains("Tomato")) {
				listVeggies.remove("Tomato");
			}
		}
		if (checkBox_Cucumber.isSelected() == true) {
			if (!listVeggies.contains("Cucumber")) {
				listVeggies.add("Cucumber");
			}
		}
		if (checkBox_Cucumber.isSelected() == false) {
			if (listVeggies.contains("Cucumber")) {
				listVeggies.remove("Cucumber");
			}
		}
		if (checkBox_Pepper.isSelected() == true) {
			if (!listVeggies.contains("Pepper")) {
				listVeggies.add("Pepper");
			}
		}
		if (checkBox_Pepper.isSelected() == false) {
			if (listVeggies.contains("Pepper")) {
				listVeggies.remove("Pepper");
			}
		}
		if (checkBox_Zucchini.isSelected() == true) {
			if (!listVeggies.contains("Zucchini")) {
				listVeggies.add("Zucchini");
			}
		}
		if (checkBox_Zucchini.isSelected() == false) {
			if (listVeggies.contains("Zucchini")) {
				listVeggies.remove("Zucchini");
			}
		}
		if (checkBox_Aubergine.isSelected() == true) {
			if (!listVeggies.contains("Aubergine")) {
				listVeggies.add("Aubergine");
			}
		}
		if (checkBox_Aubergine.isSelected() == false) {
			if (listVeggies.contains("Aubergine")) {
				listVeggies.remove("Aubergine");
			}
		}
		if (checkBox_Pumpkin.isSelected() == true) {
			if (!listVeggies.contains("Pumpkin")) {
				listVeggies.add("Pumpkin");
			}
		}
		if (checkBox_Pumpkin.isSelected() == false) {
			if (listVeggies.contains("Pumpkin")) {
				listVeggies.remove("Pumpkin");
			}
		}
		if (checkBox_Onion.isSelected() == true) {
			if (!listVeggies.contains("Onion")) {
				listVeggies.add("Onion");
			}
		}
		if (checkBox_Onion.isSelected() == false) {
			if (listVeggies.contains("Onion")) {
				listVeggies.remove("Onion");
			}
		}
		if (checkBox_Garlic.isSelected() == true) {
			if (!listVeggies.contains("Garlic")) {
				listVeggies.add("Garlic");
			}
		}
		if (checkBox_Garlic.isSelected() == false) {
			if (listVeggies.contains("Garlic")) {
				listVeggies.remove("Garlic");
			}
		}
		if (checkBox_Spring_Onion.isSelected() == true) {
			if (!listVeggies.contains("Spring_Onion")) {
				listVeggies.add("Spring_Onion");
			}
		}
		if (checkBox_Spring_Onion.isSelected() == false) {
			if (listVeggies.contains("Spring_Onion")) {
				listVeggies.remove("Spring_Onion");
			}
		}
		if (checkBox_Leek.isSelected() == true) {
			if (!listVeggies.contains("Leek")) {
				listVeggies.add("Leek");
			}
		}
		if (checkBox_Leek.isSelected() == false) {
			if (listVeggies.contains("Leek")) {
				listVeggies.remove("Leek");
			}
		}
		if (checkBox_Celery.isSelected() == true) {
			if (!listVeggies.contains("Celery")) {
				listVeggies.add("Celery");
			}
		}
		if (checkBox_Celery.isSelected() == false) {
			if (listVeggies.contains("Celery")) {
				listVeggies.remove("Celery");
			}
		}
		if (checkBox_Aspargus.isSelected() == true) {
			if (!listVeggies.contains("Aspargus")) {
				listVeggies.add("Aspargus");
			}
		}
		if (checkBox_Aspargus.isSelected() == false) {
			if (listVeggies.contains("Aspargus")) {
				listVeggies.remove("Aspargus");
			}
		}
		if (checkBox_Artichoke.isSelected() == true) {
			if (!listVeggies.contains("Artichoke")) {
				listVeggies.add("Artichoke");
			}
		}
		if (checkBox_Artichoke.isSelected() == false) {
			if (listVeggies.contains("Artichoke")) {
				listVeggies.remove("Artichoke");
			}
		}
		if (checkBox_Potato.isSelected() == true) {
			if (!listVeggies.contains("Potato")) {
				listVeggies.add("Potato");
			}
		}
		if (checkBox_Potato.isSelected() == false) {
			if (listVeggies.contains("Potato")) {
				listVeggies.remove("Potato");
			}
		}
		if (checkBox_Sweet_Potato.isSelected() == true) {
			if (!listVeggies.contains("Sweet_Potato")) {
				listVeggies.add("Sweet_Potato");
			}
		}
		if (checkBox_Sweet_Potato.isSelected() == false) {
			if (listVeggies.contains("Sweet_Potato")) {
				listVeggies.remove("Sweet_Potato");
			}
		}
		if (checkBox_Radish.isSelected() == true) {
			if (!listVeggies.contains("Radish")) {
				listVeggies.add("Radish");
			}
		}
		if (checkBox_Radish.isSelected() == false) {
			if (listVeggies.contains("Radish")) {
				listVeggies.remove("Radish");
			}
		}
		if (checkBox_Parsnip.isSelected() == true) {
			if (!listVeggies.contains("Parsnip")) {
				listVeggies.add("Parsnip");
			}
		}
		if (checkBox_Parsnip.isSelected() == false) {
			if (listVeggies.contains("Parsnip")) {
				listVeggies.remove("Parsnip");
			}
		}
		if (checkBox_Carrot.isSelected() == true) {
			if (!listVeggies.contains("Carrot")) {
				listVeggies.add("Carrot");
			}
		}
		if (checkBox_Carrot.isSelected() == false) {
			if (listVeggies.contains("Carrot")) {
				listVeggies.remove("Carrot");
			}
		}
		if (checkBox_Cabbage.isSelected() == true) {
			if (!listVeggies.contains("Cabbage")) {
				listVeggies.add("Cabbage");
			}
		}

		if (checkBox_Cabbage.isSelected() == false) {
			if (listVeggies.contains("Cabbage")) {
				listVeggies.remove("Cabbage");
			}
		}
		if (checkBox_Cabbage.isSelected() == true) {
			if (!listVeggies.contains("Cabbage")) {
				listVeggies.add("Cabbage");
			}
		}

		if (checkBox_Cabbage.isSelected() == false) {
			if (listVeggies.contains("Cabbage")) {
				listVeggies.remove("Cabbage");
			}
		}
		if (checkBox_Cauliflower.isSelected() == true) {
			if (!listVeggies.contains("Cauliflower")) {
				listVeggies.add("Cauliflower");
			}
		}

		if (checkBox_Cauliflower.isSelected() == false) {
			if (listVeggies.contains("Cauliflower")) {
				listVeggies.remove("Cauliflower");
			}
		}
		if (checkBox_Lettuce.isSelected() == true) {
			if (!listVeggies.contains("Lettuce")) {
				listVeggies.add("Lettuce");
			}
		}

		if (checkBox_Lettuce.isSelected() == false) {
			if (listVeggies.contains("Lettuce")) {
				listVeggies.remove("Lettuce");
			}
		}
		if (checkBox_Spinach.isSelected() == true) {
			if (!listVeggies.contains("Spinach")) {
				listVeggies.add("Spinach");
			}
		}

		if (checkBox_Spinach.isSelected() == false) {
			if (listVeggies.contains("Spinach")) {
				listVeggies.remove("Spinach");
			}
		}
		if (checkBox_Sweetcorn.isSelected() == true) {
			if (!listVeggies.contains("Sweetcorn")) {
				listVeggies.add("Sweetcorn");
			}
		}

		if (checkBox_Sweetcorn.isSelected() == false) {
			if (listVeggies.contains("Sweetcorn")) {
				listVeggies.remove("Sweetcorn");
			}
		}
		if (checkBox_Green_Peas.isSelected() == true) {
			if (!listVeggies.contains("Green Peas")) {
				listVeggies.add("Green Peas");
			}
		}

		if (checkBox_Green_Peas.isSelected() == false) {
			if (listVeggies.contains("Green Peas")) {
				listVeggies.remove("Green Peas");
			}
		}
		if (checkBox_Chick_Peas.isSelected() == true) {
			if (!listVeggies.contains("Chick Peas")) {
				listVeggies.add("Chick Peas");
			}
		}

		if (checkBox_Chick_Peas.isSelected() == false) {
			if (listVeggies.contains("Chick Peas")) {
				listVeggies.remove("Chick Peas");
			}
		}
		if (checkBox_White_Beans.isSelected() == true) {
			if (!listVeggies.contains("White Beans")) {
				listVeggies.add("White Beans");
			}
		}

		if (checkBox_White_Beans.isSelected() == false) {
			if (listVeggies.contains("White Beans")) {
				listVeggies.remove("White Beans");
			}
		}
		if (checkBox_Black_Beans.isSelected() == true) {
			if (!listVeggies.contains("Black Beans")) {
				listVeggies.add("Black Beans");
			}
		}

		if (checkBox_Black_Beans.isSelected() == false) {
			if (listVeggies.contains("Black Beans")) {
				listVeggies.remove("Black Beans");
			}
		}
		if (checkBox_Coriander.isSelected() == true) {
			if (!listVeggies.contains("Coriander")) {
				listVeggies.add("Coriander");
			}
		}

		if (checkBox_Coriander.isSelected() == false) {
			if (listVeggies.contains("Coriander")) {
				listVeggies.remove("Coriander");
			}
		}
		if (checkBox_Tarragon.isSelected() == true) {
			if (!listVeggies.contains("Tarragon")) {
				listVeggies.add("Tarragon");
			}
		}

		if (checkBox_Tarragon.isSelected() == false) {
			if (listVeggies.contains("Tarragon")) {
				listVeggies.remove("Tarragon");
			}
		}
		if (checkBox_Dill.isSelected() == true) {
			if (!listVeggies.contains("Dill")) {
				listVeggies.add("Dill");
			}
		}

		if (checkBox_Dill.isSelected() == false) {
			if (listVeggies.contains("Dill")) {
				listVeggies.remove("Dill");
			}
		}
		if (checkBox_Chili.isSelected() == true) {
			if (!listVeggies.contains("Chili")) {
				listVeggies.add("Chili");
			}
		}

		if (checkBox_Chili.isSelected() == false) {
			if (listVeggies.contains("Chili")) {
				listVeggies.remove("Chili");
			}
		}
		if (checkBox_Lemongrass.isSelected() == true) {
			if (!listVeggies.contains("Lemongrass")) {
				listVeggies.add("Lemongrass");
			}
		}

		if (checkBox_Lemongrass.isSelected() == false) {
			if (listVeggies.contains("Lemongrass")) {
				listVeggies.remove("Lemongrass");
			}
		}
		returnBtn.setOnAction(e -> {
			bigList.addAll(listVeggies);
			System.out.println(bigList);
		});

	}

	@FXML
	private void handleCheckBoxActionFruit(ActionEvent event) throws IOException {

		if (checkBox_Apple.isSelected() == true) {
			if (!listFruit.contains("Apple")) {
				listFruit.add("Apple");
			}
		}
		if (checkBox_Apple.isSelected() == false) {
			if (listFruit.contains("Apple")) {
				listFruit.remove("Apple");
			}
		}
		if (checkBox_Pear.isSelected() == true) {
			if (!listFruit.contains("Pear")) {
				listFruit.add("Pear");
			}
		}
		if (checkBox_Pear.isSelected() == false) {
			if (listFruit.contains("Pear")) {
				listFruit.remove("Pear");
			}
		}
		if (checkBox_Orange.isSelected() == true) {
			if (!listFruit.contains("Orange")) {
				listFruit.add("Orange");
			}
		}
		if (checkBox_Orange.isSelected() == false) {
			if (listFruit.contains("Orange")) {
				listFruit.remove("Orange");
			}
		}
		if (checkBox_Mandarin.isSelected() == true) {
			if (!listFruit.contains("Mandarin")) {
				listFruit.add("Mandarin");
			}
		}
		if (checkBox_Mandarin.isSelected() == false) {
			if (listFruit.contains("Mandarin")) {
				listFruit.remove("Mandarin");
			}
		}
		if (checkBox_Grapefruit.isSelected() == true) {
			if (!listFruit.contains("Grapefruit")) {
				listFruit.add("Grapefruit");
			}
		}
		if (checkBox_Grapefruit.isSelected() == false) {
			if (listFruit.contains("Grapefruit")) {
				listFruit.remove("Grapefruit");
			}
		}
		if (checkBox_Lemon.isSelected() == true) {
			if (!listFruit.contains("Lemon")) {
				listFruit.add("Lemon");
			}
		}
		if (checkBox_Lemon.isSelected() == false) {
			if (listFruit.contains("Lemon")) {
				listFruit.remove("Lemon");
			}
		}
		if (checkBox_Lime.isSelected() == true) {
			if (!listFruit.contains("Lime")) {
				listFruit.add("Lime");
			}
		}
		if (checkBox_Lime.isSelected() == false) {
			if (listFruit.contains("Lime")) {
				listFruit.remove("Lime");
			}
		}
		if (checkBox_Banana.isSelected() == true) {
			if (!listFruit.contains("Banana")) {
				listFruit.add("Banana");
			}
		}
		if (checkBox_Banana.isSelected() == false) {
			if (listFruit.contains("Banana")) {
				listFruit.remove("Banana");
			}
		}
		if (checkBox_Strawberry.isSelected() == true) {
			if (!listFruit.contains("Strawberry")) {
				listFruit.add("Strawberry");
			}
		}
		if (checkBox_Strawberry.isSelected() == false) {
			if (listFruit.contains("Strawberry")) {
				listFruit.remove("Strawberry");
			}
		}
		if (checkBox_Blueberry.isSelected() == true) {
			if (!listFruit.contains("Blueberry")) {
				listFruit.add("Blueberry");
			}
		}
		if (checkBox_Blueberry.isSelected() == false) {
			if (listFruit.contains("Blueberry")) {
				listFruit.remove("Blueberry");
			}
		}
		if (checkBox_Blackberry.isSelected() == true) {
			if (!listFruit.contains("Blackberry")) {
				listFruit.add("Blackberry");
			}
		}
		if (checkBox_Blackberry.isSelected() == false) {
			if (listFruit.contains("Blackberry")) {
				listFruit.remove("Blackberry");
			}
		}
		if (checkBox_Cherry.isSelected() == true) {
			if (!listFruit.contains("Cherry")) {
				listFruit.add("Cherry");
			}
		}
		if (checkBox_Cherry.isSelected() == false) {
			if (listFruit.contains("Cherry")) {
				listFruit.remove("Cherry");
			}
		}
		if (checkBox_Pineapple.isSelected() == true) {
			if (!listFruit.contains("Pineapple")) {
				listFruit.add("Pineapple");
			}
		}
		if (checkBox_Pineapple.isSelected() == false) {
			if (listFruit.contains("Pineapple")) {
				listFruit.remove("Pineapple");
			}
		}
		if (checkBox_Apricot.isSelected() == true) {
			if (!listFruit.contains("Apricot")) {
				listFruit.add("Apricot");
			}
		}
		if (checkBox_Apricot.isSelected() == false) {
			if (listFruit.contains("Apricot")) {
				listFruit.remove("Apricot");
			}
		}
		if (checkBox_Grapes.isSelected() == true) {
			if (!listFruit.contains("Grapes")) {
				listFruit.add("Grapes");
			}
		}
		if (checkBox_Grapes.isSelected() == false) {
			if (listFruit.contains("Grapes")) {
				listFruit.remove("Grapes");
			}
		}
		if (checkBox_Mango.isSelected() == true) {
			if (!listFruit.contains("Mango")) {
				listFruit.add("Mango");
			}
		}
		if (checkBox_Mango.isSelected() == false) {
			if (listFruit.contains("Mango")) {
				listFruit.remove("Mango");
			}
		}
		if (checkBox_Papaya.isSelected() == true) {
			if (!listFruit.contains("Papaya")) {
				listFruit.add("Papaya");
			}
		}
		if (checkBox_Papaya.isSelected() == false) {
			if (listFruit.contains("Papaya")) {
				listFruit.remove("Papaya");
			}
		}
		if (checkBox_Kiwi.isSelected() == true) {
			if (!listFruit.contains("Kiwi")) {
				listFruit.add("Kiwi");
			}
		}
		if (checkBox_Kiwi.isSelected() == false) {
			if (listFruit.contains("Kiwi")) {
				listFruit.remove("Kiwi");
			}
		}
		returnBtn.setOnAction(e -> {
			bigList.addAll(listFruit);
			System.out.println(bigList);
		});
	}

	@FXML
	private void handleCheckBoxActionGrains(ActionEvent event) throws IOException {

		if (checkBox_Wheat.isSelected() == true) {
			if (!listGrains.contains("Wheat")) {
				listGrains.add("Wheat");
			}
		}
		if (checkBox_Wheat.isSelected() == false) {
			if (listGrains.contains("Wheat")) {
				listGrains.remove("Wheat");
			}
		}
		if (checkBox_Oats.isSelected() == true) {
			if (!listGrains.contains("Oats")) {
				listGrains.add("Oats");
			}
		}
		if (checkBox_Oats.isSelected() == false) {
			if (listGrains.contains("Oats")) {
				listGrains.remove("Oats");
			}
		}
		if (checkBox_Barley.isSelected() == true) {
			if (!listVeggies.contains("Barley")) {
				listVeggies.add("Barley");
			}
		}

		if (checkBox_Barley.isSelected() == false) {
			if (listVeggies.contains("Barley")) {
				listVeggies.remove("Barley");
			}
		}
		if (checkBox_CornMeal.isSelected() == true) {
			if (!listVeggies.contains("Cornmeal")) {
				listVeggies.add("Cornmeal");
			}
		}

		if (checkBox_CornMeal.isSelected() == false) {
			if (listVeggies.contains("Cornmeal")) {
				listVeggies.remove("Cornmeal");
			}
		}
		if (checkBox_Rye.isSelected() == true) {
			if (!listVeggies.contains("Rye")) {
				listVeggies.add("Rye");
			}
		}

		if (checkBox_Rye.isSelected() == false) {
			if (listVeggies.contains("Rye")) {
				listVeggies.remove("Rye");
			}
		}
		if (checkBox_Rice.isSelected() == true) {
			if (!listVeggies.contains("Rice")) {
				listVeggies.add("Rice");
			}
		}

		if (checkBox_Rice.isSelected() == false) {
			if (listVeggies.contains("Rice")) {
				listVeggies.remove("Rice");
			}
		}
		if (checkBox_Bulgur.isSelected() == true) {
			if (!listVeggies.contains("Bulgur")) {
				listVeggies.add("Bulgur");
			}
		}

		if (checkBox_Bulgur.isSelected() == false) {
			if (listVeggies.contains("Bulgur")) {
				listVeggies.remove("Bulgur");
			}
		}
		if (checkBox_Couscous.isSelected() == true) {
			if (!listVeggies.contains("Couscous")) {
				listVeggies.add("Couscous");
			}
		}

		if (checkBox_Couscous.isSelected() == false) {
			if (listVeggies.contains("Couscous")) {
				listVeggies.remove("Couscous");
			}
		}
		if (checkBox_Cracked_Wheat.isSelected() == true) {
			if (!listVeggies.contains("Cracked Wheat")) {
				listVeggies.add("Cracked Wheat");
			}
		}

		if (checkBox_Cracked_Wheat.isSelected() == false) {
			if (listVeggies.contains("Cracked Wheat")) {
				listVeggies.remove("Craked Wheat");
			}
		}
		if (checkBox_Bread.isSelected() == true) {
			if (!listVeggies.contains("Bread")) {
				listVeggies.add("Bread");
			}
		}

		if (checkBox_Bread.isSelected() == false) {
			if (listVeggies.contains("Bread")) {
				listVeggies.remove("Bread");
			}
		}
		if (checkBox_Pasta.isSelected() == true) {
			if (!listVeggies.contains("Pasta")) {
				listVeggies.add("Pasta");
			}
		}

		if (checkBox_Pasta.isSelected() == false) {
			if (listVeggies.contains("Pasta")) {
				listVeggies.remove("Pasta");
			}
		}
		returnBtn.setOnAction(e -> {
			bigList.addAll(listGrains);
			System.out.println(bigList);
		});

	}

	@FXML
	private void handleCheckBoxActionDairy(ActionEvent event) throws IOException {
		if (checkBox_Milk.isSelected() == true) {
			if (!listDairy.contains("Milk")) {
				listDairy.add("Milk");
			}
		}
		if (checkBox_Milk.isSelected() == false) {
			if (listDairy.contains("Milk")) {
				listDairy.remove("Milk");
			}
		}
		if (checkBox_Cream.isSelected() == true) {
			if (!listDairy.contains("Cream")) {
				listDairy.add("Cream");
			}
		}
		if (checkBox_Milk.isSelected() == false) {
			if (listDairy.contains("Cream")) {
				listDairy.remove("Cream");
			}
		}
		if (checkBox_Sour_Cream.isSelected() == true) {
			if (!listVeggies.contains("Sour Cream")) {
				listVeggies.add("Sour Cream");
			}
		}

		if (checkBox_Sour_Cream.isSelected() == false) {
			if (listVeggies.contains("Sour Cream")) {
				listVeggies.remove("Sour Cream");
			}
		}
		if (checkBox_Creme_Fraiche.isSelected() == true) {
			if (!listVeggies.contains("Creme Fraiche")) {
				listVeggies.add("Creme Fraiche");
			}
		}

		if (checkBox_Creme_Fraiche.isSelected() == false) {
			if (listVeggies.contains("Creme Fraiche")) {
				listVeggies.remove("Creme Fraiche");
			}
		}
		if (checkBox_Yogurt.isSelected() == true) {
			if (!listVeggies.contains("Yogurt")) {
				listVeggies.add("Yogurt");
			}
		}

		if (checkBox_Yogurt.isSelected() == false) {
			if (listVeggies.contains("Yogurt")) {
				listVeggies.remove("Yogurt");
			}
		}
		if (checkBox_Hard_Cheese.isSelected() == true) {
			if (!listVeggies.contains("Hard Cheese")) {
				listVeggies.add("Hard Cheese");
			}
		}

		if (checkBox_Hard_Cheese.isSelected() == false) {
			if (listVeggies.contains("Hard Cheese")) {
				listVeggies.remove("Hard Cheese");
			}
		}
		if (checkBox_Soft_Cheese.isSelected() == true) {
			if (!listVeggies.contains("Soft Cheese")) {
				listVeggies.add("Soft Cheese");
			}
		}

		if (checkBox_Soft_Cheese.isSelected() == false) {
			if (listVeggies.contains("Soft Cheese")) {
				listVeggies.remove("Soft Cheese");
			}
		}
		if (checkBox_Cottage_Cheese.isSelected() == true) {
			if (!listVeggies.contains("Cottage Cheese")) {
				listVeggies.add("Cottage Cheese");
			}
		}

		if (checkBox_Cottage_Cheese.isSelected() == false) {
			if (listVeggies.contains("Cottage Cheese")) {
				listVeggies.remove("Cottage Cheese");
			}
		}
		if (checkBox_Blue_Cheese.isSelected() == true) {
			if (!listVeggies.contains("Blue Cheese")) {
				listVeggies.add("Blue Cheese");
			}
		}

		if (checkBox_Blue_Cheese.isSelected() == false) {
			if (listVeggies.contains("Blue Cheese")) {
				listVeggies.remove("Blue Cheese");
			}
		}
		if (checkBox_Parmesan.isSelected() == true) {
			if (!listVeggies.contains("Parmesan")) {
				listVeggies.add("Parmesan");
			}
		}

		if (checkBox_Parmesan.isSelected() == false) {
			if (listVeggies.contains("Parmesan")) {
				listVeggies.remove("Parmesan");
			}
		}
		if (checkBox_Butter.isSelected() == true) {
			if (!listVeggies.contains("Butter")) {
				listVeggies.add("Butter");
			}
		}

		if (checkBox_Butter.isSelected() == false) {
			if (listVeggies.contains("Butter")) {
				listVeggies.remove("Butter");
			}
		}
		returnBtn.setOnAction(e -> {
			bigList.addAll(listDairy);
			System.out.println(bigList);
		});

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	/**
	 * Methods to initialize the checkboxes
	 * 
	 */

	public void InitiateMeat() {
		this.checkBox_Chicken = new CheckBox();
		this.checkBox_Lamb = new CheckBox();
		this.checkBox_Pork = new CheckBox();
		this.checkBox_Game = new CheckBox();
		this.checkBox_Rabbit = new CheckBox();
		this.checkBox_Beef = new CheckBox();
		this.checkBox_Duck = new CheckBox();
		this.checkBox_Ground_Beef = new CheckBox();
		this.checkBox_Fish = new CheckBox();
		this.checkBox_Shrimp = new CheckBox();
		this.checkBox_Ground_Pork = new CheckBox();
		this.checkBox_Egg = new CheckBox();

	}

	public void InitiateDairy() {
		this.checkBox_Milk = new CheckBox();
		this.checkBox_Cream = new CheckBox();
		this.checkBox_Sour_Cream = new CheckBox();
		this.checkBox_Creme_Fraiche = new CheckBox();
		this.checkBox_Yogurt = new CheckBox();
		this.checkBox_Hard_Cheese = new CheckBox();
		this.checkBox_Soft_Cheese = new CheckBox();
		this.checkBox_Cottage_Cheese = new CheckBox();
		this.checkBox_Blue_Cheese = new CheckBox();
		this.checkBox_Parmesan = new CheckBox();
		this.checkBox_Butter = new CheckBox();

	}

	public void InitiateGrains() {
		this.checkBox_Wheat = new CheckBox();
		this.checkBox_Oats = new CheckBox();
		this.checkBox_Barley = new CheckBox();
		this.checkBox_CornMeal = new CheckBox();
		this.checkBox_Rye = new CheckBox();
		this.checkBox_Rice = new CheckBox();
		this.checkBox_Bulgur = new CheckBox();
		this.checkBox_Couscous = new CheckBox();
		this.checkBox_Cracked_Wheat = new CheckBox();
		this.checkBox_Bread = new CheckBox();
		this.checkBox_Pasta = new CheckBox();

	}

	public void InitiateFruit() {
		this.checkBox_Apple = new CheckBox();
		this.checkBox_Pear = new CheckBox();
		this.checkBox_Orange = new CheckBox();
		this.checkBox_Mandarin = new CheckBox();
		this.checkBox_Grapefruit = new CheckBox();
		this.checkBox_Lemon = new CheckBox();
		this.checkBox_Lime = new CheckBox();
		this.checkBox_Banana = new CheckBox();
		this.checkBox_Strawberry = new CheckBox();
		this.checkBox_Blueberry = new CheckBox();
		this.checkBox_Blackberry = new CheckBox();
		this.checkBox_Cherry = new CheckBox();
		this.checkBox_Pineapple = new CheckBox();
		this.checkBox_Apricot = new CheckBox();
		this.checkBox_Grapes = new CheckBox();
		this.checkBox_Mango = new CheckBox();
		this.checkBox_Papaya = new CheckBox();
		this.checkBox_Kiwi = new CheckBox();

	}

	public void InitiateVegetables() {
		this.checkBox_Tomato = new CheckBox();
		this.checkBox_Cucumber = new CheckBox();
		this.checkBox_Pepper = new CheckBox();
		this.checkBox_Zucchini = new CheckBox();
		this.checkBox_Aubergine = new CheckBox();
		this.checkBox_Pumpkin = new CheckBox();
		this.checkBox_Avocado = new CheckBox();
		this.checkBox_Onion = new CheckBox();
		this.checkBox_Garlic = new CheckBox();
		this.checkBox_Spring_Onion = new CheckBox();
		this.checkBox_Leek = new CheckBox();
		this.checkBox_Celery = new CheckBox();
		this.checkBox_Aspargus = new CheckBox();
		this.checkBox_Artichoke = new CheckBox();
		this.checkBox_Potato = new CheckBox();
		this.checkBox_Sweet_Potato = new CheckBox();
		this.checkBox_Radish = new CheckBox();
		this.checkBox_Parsnip = new CheckBox();
		this.checkBox_Carrot = new CheckBox();
		this.checkBox_Cabbage = new CheckBox();
		this.checkBox_Cauliflower = new CheckBox();
		this.checkBox_Lettuce = new CheckBox();
		this.checkBox_Spinach = new CheckBox();
		this.checkBox_Sweetcorn = new CheckBox();
		this.checkBox_Green_Peas = new CheckBox();
		this.checkBox_Chick_Peas = new CheckBox();
		this.checkBox_White_Beans = new CheckBox();
		this.checkBox_Black_Beans = new CheckBox();
		this.checkBox_Coriander = new CheckBox();
		this.checkBox_Tarragon = new CheckBox();
		this.checkBox_Parsley = new CheckBox();
		this.checkBox_Dill = new CheckBox();
		this.checkBox_Chili = new CheckBox();
		this.checkBox_Lemongrass = new CheckBox();

	}

}
