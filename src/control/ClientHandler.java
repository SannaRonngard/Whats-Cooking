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

	static List<String> listVeggies = new ArrayList<String>();
	static List<String> listMeat = new ArrayList<String>();
	protected static String secteditems = "";
	private Recipe recipe = new Recipe();

	public ClientHandler() {
		InitiateMeat();
		// InitiateDairy();
		// InitiateGrains();
		// InitiateFruit();
		InitiateVegetables();
		// this.recipe = new Recipe();

	}

	// @FXML
	// private void handleButtonAction(ActionEvent event) throws IOException {
	// // Handle Button event.
	// returnBtn.setOnAction(e -> {
	// System.out.println("Return button clicked");
	//// System.out.println(itemList);
	// System.out.println(Arrays.toString(Recipe.getIngredientArray()));
	// });
	// }
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

			returnBtn.setOnAction(e -> {
				System.out.println(listMeat);
			});
		}

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

		returnBtn.setOnAction(e -> {
			listVeggies.addAll(listMeat);
			System.out.println(listVeggies);
		});

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

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

	//
	// public void InitiateDairy() {
	// this.checkBox_Milk = new CheckBox();
	// this.checkBox_Cream = new CheckBox();
	// this.checkBox_Sour_Cream = new CheckBox();
	// this.checkBox_Creme_Fraiche = new CheckBox();
	// this.checkBox_Yogurt = new CheckBox();
	// this.checkBox_Hard_Cheese = new CheckBox();
	// this.checkBox_Soft_Cheese = new CheckBox();
	// this.checkBox_Cottage_Cheese = new CheckBox();
	// this.checkBox_Blue_Cheese = new CheckBox();
	// this.checkBox_Parmesan = new CheckBox();
	// this.checkBox_Butter = new CheckBox();
	//
	// }
	//
	// public void InitiateGrains() {
	// this.checkBox_Wheat = new CheckBox();
	// this.checkBox_Oats = new CheckBox();
	// this.checkBox_Barley = new CheckBox();
	// this.checkBox_CornMeal = new CheckBox();
	// this.checkBox_Rye = new CheckBox();
	// this.checkBox_Rice = new CheckBox();
	// this.checkBox_Bulgur = new CheckBox();
	// this.checkBox_Couscous = new CheckBox();
	// this.checkBox_Cracked_Wheat = new CheckBox();
	// this.checkBox_Bread = new CheckBox();
	// this.checkBox_Pasta = new CheckBox();
	//
	// }
	//
	// public void InitiateFruit() {
	// this.checkBox_Apple = new CheckBox();
	// this.checkBox_Pear = new CheckBox();
	// this.checkBox_Orange = new CheckBox();
	// this.checkBox_Mandarin = new CheckBox();
	// this.checkBox_Grapefruit = new CheckBox();
	// this.checkBox_Lemon = new CheckBox();
	// this.checkBox_Lime = new CheckBox();
	// this.checkBox_Banana = new CheckBox();
	// this.checkBox_Strawberry = new CheckBox();
	// this.checkBox_Blueberry = new CheckBox();
	// this.checkBox_Blackberry = new CheckBox();
	// this.checkBox_Cherry = new CheckBox();
	// this.checkBox_Pineapple = new CheckBox();
	// this.checkBox_Apricot = new CheckBox();
	// this.checkBox_Grapes = new CheckBox();
	// this.checkBox_Mango = new CheckBox();
	// this.checkBox_Papaya = new CheckBox();
	// this.checkBox_Kiwi = new CheckBox();
	//
	// }
	//
	public void InitiateVegetables() {
		// this.checkBox_Tomato = new CheckBox();
		// this.checkBox_Cucumber = new CheckBox();
		// this.checkBox_Pepper = new CheckBox();
		// this.checkBox_Zucchini = new CheckBox();
		// this.checkBox_Aubergine = new CheckBox();
		// this.checkBox_Pumpkin = new CheckBox();
		this.checkBox_Avocado = new CheckBox();
		// this.checkBox_Onion = new CheckBox();
		// this.checkBox_Garlic = new CheckBox();
		// this.checkBox_Spring_Onion = new CheckBox();
		// this.checkBox_Leek = new CheckBox();
		// this.checkBox_Celery = new CheckBox();
		// this.checkBox_Aspargus = new CheckBox();
		// this.checkBox_Artichoke = new CheckBox();
		// this.checkBox_Potato = new CheckBox();
		// this.checkBox_Sweet_Potato = new CheckBox();
		// this.checkBox_Radish = new CheckBox();
		// this.checkBox_Parsnip = new CheckBox();
		// this.checkBox_Carrot = new CheckBox();
		// this.checkBox_Cabbage = new CheckBox();
		// this.checkBox_Cauliflower = new CheckBox();
		// this.checkBox_Lettuce = new CheckBox();
		// this.checkBox_Spinach = new CheckBox();
		// this.checkBox_Sweetcorn = new CheckBox();
		// this.checkBox_Green_Peas = new CheckBox();
		// this.checkBox_Chick_Peas = new CheckBox();
		// this.checkBox_White_Beans = new CheckBox();
		// this.checkBox_Black_Beans = new CheckBox();
		// this.checkBox_Coriander = new CheckBox();
		// this.checkBox_Tarragon = new CheckBox();
		// this.checkBox_Parsley = new CheckBox();
		// this.checkBox_Dill = new CheckBox();
		// this.checkBox_Chili = new CheckBox();
		// this.checkBox_Lemongrass = new CheckBox();

	}

}
