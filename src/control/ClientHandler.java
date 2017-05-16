package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

/**
 * Class that handles all the checkboxes for different categories of ingredients.
 * 
 * @author Sanna Rönngård
 * @author Sofia Larsson
 * @author Olle Olsson
 * @author Linus Forsberg
 */

public class ClientHandler implements Initializable {
	/**
	 * Checkboxes - Category Meat
	 * 
	 */
	@FXML
	private CheckBox checkBox_Chicken;
	@FXML
	private CheckBox checkBox_Lamb;
	@FXML
	private CheckBox checkBox_Pork;
	@FXML
	private CheckBox checkBox_Game;
	@FXML
	private CheckBox checkBox_Rabbit;
	@FXML
	private CheckBox checkBox_Beef;
	@FXML
	private CheckBox checkBox_Duck;
	@FXML
	private CheckBox checkBox_Ground_Beef;
	@FXML
	private CheckBox checkBox_Fish;
	@FXML
	private CheckBox checkBox_Shrimp;
	@FXML
	private CheckBox checkBox_Ground_Pork;
	@FXML
	private CheckBox checkBox_Egg;
	/**
	 * Checkboxes - Category Dairy
	 * 
	 */
	@FXML
	private CheckBox checkBox_Milk;
	@FXML
	private CheckBox checkBox_Cream;
	@FXML
	private CheckBox checkBox_Sour_Cream;
	@FXML
	private CheckBox checkBox_Creme_Fraiche;
	@FXML
	private CheckBox checkBox_Yogurt;
	@FXML
	private CheckBox checkBox_Hard_Cheese;
	@FXML
	private CheckBox checkBox_Soft_Cheese;
	@FXML
	private CheckBox checkBox_Cottage_Cheese;
	@FXML
	private CheckBox checkBox_Blue_Cheese;
	@FXML
	private CheckBox checkBox_Parmesan;
	@FXML
	private CheckBox checkBox_Butter;
	/**
	 * Checkboxes - Category Grains
	 * 
	 */
	@FXML
	private CheckBox checkBox_Wheat;
	@FXML
	private CheckBox checkBox_Oats;
	@FXML
	private CheckBox checkBox_Barley;
	@FXML
	private CheckBox checkBox_CornMeal;
	@FXML
	private CheckBox checkBox_Rye;
	@FXML
	private CheckBox checkBox_Rice;
	@FXML
	private CheckBox checkBox_Bulgur;
	@FXML
	private CheckBox checkBox_Couscous;
	@FXML
	private CheckBox checkBox_Cracked_Wheat;
	@FXML
	private CheckBox checkBox_Bread;
	@FXML
	private CheckBox checkBox_Pasta;
	/**
	 * Checkboxes - Category Fruit
	 * 
	 */
	@FXML
	private CheckBox checkBox_Apple;
	@FXML
	private CheckBox checkBox_Pear;
	@FXML
	private CheckBox checkBox_Orange;
	@FXML
	private CheckBox checkBox_Mandarin;
	@FXML
	private CheckBox checkBox_Grapefruit;
	@FXML
	private CheckBox checkBox_Lemon;
	@FXML
	private CheckBox checkBox_Lime;
	@FXML
	private CheckBox checkBox_Banana;
	@FXML
	private CheckBox checkBox_Strawberry;
	@FXML
	private CheckBox checkBox_Blueberry;
	@FXML
	private CheckBox checkBox_Blackberry;
	@FXML
	private CheckBox checkBox_Cherry;
	@FXML
	private CheckBox checkBox_Pineapple;
	@FXML
	private CheckBox checkBox_Apricot;
	@FXML
	private CheckBox checkBox_Grapes;
	@FXML
	private CheckBox checkBox_Mango;
	@FXML
	private CheckBox checkBox_Papaya;
	@FXML
	private CheckBox checkBox_Kiwi;
	/**
	 * Checkboxes - Category Vegetables
	 * 
	 */
	@FXML
	private CheckBox checkBox_Tomato;
	@FXML
	private CheckBox checkBox_Cucumber;
	@FXML
	private CheckBox checkBox_Pepper;
	@FXML
	private CheckBox checkBox_Zucchini;
	@FXML
	private CheckBox checkBox_Aubergine;
	@FXML
	private CheckBox checkBox_Pumpkin;
	@FXML
	private CheckBox checkBox_Avocado;
	@FXML
	private CheckBox checkBox_Onion;
	@FXML
	private CheckBox checkBox_Garlic;
	@FXML
	private CheckBox checkBox_Spring_Onion;
	@FXML
	private CheckBox checkBox_Leek;
	@FXML
	private CheckBox checkBox_Celery;
	@FXML
	private CheckBox checkBox_Aspargus;
	@FXML
	private CheckBox checkBox_Artichoke;
	@FXML
	private CheckBox checkBox_Potato;
	@FXML
	private CheckBox checkBox_Sweet_Potato;
	@FXML
	private CheckBox checkBox_Radish;
	@FXML
	private CheckBox checkBox_Parsnip;
	@FXML
	private CheckBox checkBox_Carrot;
	@FXML
	private CheckBox checkBox_Cabbage;
	@FXML
	private CheckBox checkBox_Cauliflower;
	@FXML
	private CheckBox checkBox_Lettuce;
	@FXML
	private CheckBox checkBox_Spinach;
	@FXML
	private CheckBox checkBox_Sweetcorn;
	@FXML
	private CheckBox checkBox_Greean_Peas;
	@FXML
	private CheckBox checkBox_Chick_Peas;
	@FXML
	private CheckBox checkBox_White_Bean;
	@FXML
	private CheckBox checkBox_Black_Bean;
	@FXML
	private CheckBox checkBox_Coriander;
	@FXML
	private CheckBox checkBox_Tarragon;
	@FXML
	private CheckBox checkBox_Parsley;
	@FXML
	private CheckBox checkBox_Dill;
	@FXML
	private CheckBox checkBox_Chili;
	@FXML
	private CheckBox checkBox_Lemongrass;

	public ClientHandler() {
		InitiateMeat();
		InitiateDairy();
		InitiateGrains();
		InitiateFruit();
		InitiateVegetables();

	}

	/**
	 * Method saves checked item to a list or removes it from the list whenever
	 * box is unchecked.
	 * 
	 */
	List<String> itemList = new ArrayList<String>();

	@FXML
	private void handleCheckBoxActionMeat(ActionEvent event) throws IOException {
		// if(event.getSource() == checkBox_Chicken) {
		boolean checkBox_Chicken_Selected = checkBox_Chicken.isSelected();
		boolean checkBox_Lamb_Selected = checkBox_Lamb.isSelected();
		boolean checkBox_Pork_Selected = checkBox_Pork.isSelected();

		// checkBox_Chicken.setSelected(true);

		if (checkBox_Chicken_Selected == true) {
			if (!itemList.contains("Chicken")) {
				itemList.add("Chicken");
			}
		}

		if (checkBox_Chicken_Selected == false) {
			if (itemList.contains("Chicken")) {
				itemList.remove("Chicken");
			}
		}

		if (checkBox_Lamb_Selected == true) {
			if (!itemList.contains("Lamb")) {
				itemList.add("Lamb");
			}
		}

		if (checkBox_Lamb_Selected == false) {
			if (itemList.contains("Lamb")) {
				itemList.remove("Lamb");
			}
		}

		if (checkBox_Pork_Selected == true) {
			if (!itemList.contains("Pork")) {
				itemList.add("Pork");
			}
		}

		if (checkBox_Pork_Selected == false) {
			if (itemList.contains("Pork")) {
				itemList.remove("Pork");
			}
		}

		System.out.println(itemList);

	}

	/**
	 * Method saves checked item to a list or removes it from the list whenever
	 * box is unchecked.
	 * 
	 */

	@FXML
	private void handleCheckBoxActionVeg(ActionEvent event) throws IOException {
		// if(event.getSource() == checkBox_Chicken) {
		boolean checkBox_Tomato_Selected = checkBox_Tomato.isSelected();
		boolean checkBox_Potato_Selected = checkBox_Potato.isSelected();
		boolean checkBox_Cucumber_Selected = checkBox_Cucumber.isSelected();

		if (checkBox_Tomato_Selected == true) {
			if (!itemList.contains("Tomato")) {
				itemList.add("Tomato");
			}
		}

		if (checkBox_Tomato_Selected == false) {
			if (itemList.contains("Tomato")) {
				itemList.remove("Tomato");
			}
		}

		if (checkBox_Potato_Selected == true) {
			if (!itemList.contains("Potato")) {
				itemList.add("Potato");
			}
		}

		if (checkBox_Potato_Selected == false) {
			if (itemList.contains("Potato")) {
				itemList.remove("Potato");
			}
		}

		if (checkBox_Cucumber_Selected == true) {
			if (!itemList.contains("Cucumber")) {
				itemList.add("Cucumber");
			}
		}

		if (checkBox_Cucumber_Selected == false) {
			if (itemList.contains("Cucumber")) {
				itemList.remove("Cucumber");
			}
		}

		System.out.println(itemList);

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
		// this.checkBox_Tomato= new CheckBox();
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
		this.checkBox_Greean_Peas = new CheckBox();
		this.checkBox_Chick_Peas = new CheckBox();
		this.checkBox_White_Bean = new CheckBox();
		this.checkBox_Black_Bean = new CheckBox();
		this.checkBox_Coriander = new CheckBox();
		this.checkBox_Tarragon = new CheckBox();
		this.checkBox_Parsley = new CheckBox();
		this.checkBox_Dill = new CheckBox();
		this.checkBox_Chili = new CheckBox();
		this.checkBox_Lemongrass = new CheckBox();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
