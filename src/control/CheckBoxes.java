package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/**
 * Class that handles all the checkboxes for different categories of
 * ingredients.
 * 
 * @author Sanna Rönngård
 */
public class CheckBoxes implements Initializable {

	
	@FXML Button returnBtn;

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

	public CheckBoxes() {
		InitiateMeat();
		InitiateDairy();
		InitiateGrains();
		InitiateFruit();
		InitiateVegetables();
		
	}
	/*///////////////BigList till ListView//////////////////////////////////////////////*/
	public static void setbigListDairy(){ ClientHandler.bigList.addAll(ClientHandler.listDairy); }
	public static void setbigListFruit(){ ClientHandler.bigList.addAll(ClientHandler.listFruit); }
	public static void setbigListMeat(){ ClientHandler.bigList.addAll(ClientHandler.listMeat); }
	public static void setbigListVeg(){ ClientHandler.bigList.addAll(ClientHandler.listVeggies); }
	public static void setbigListGrains(){ ClientHandler.bigList.addAll(ClientHandler.listGrains); }
	/*/////////////////////////////////////////////////////////////*/
	public static void setbigListDairyDB(){ ClientHandler.bigListDB.addAll(ClientHandler.listDairyDB); }
	public static void setbigListFruitDB(){ ClientHandler.bigListDB.addAll(ClientHandler.listFruitDB);}
	public static void setbigListMeatDB(){ ClientHandler.bigListDB.addAll(ClientHandler.listMeatDB); }
	public static void setbigListVegDB(){ ClientHandler.bigListDB.addAll(ClientHandler.listVeggiesDB); }
	public static void setbigListGrainsDB(){ ClientHandler.bigListDB.addAll(ClientHandler.listGrainsDB);}
	/**
	 * Methods that saves checked item to a list or removes it from the list
	 * whenever box is unchecked.
	 */
	@FXML
	private void handleCheckBoxActionMeat(ActionEvent event) throws IOException {

		if (checkBox_Chicken.isSelected() == true) {
			if (!ClientHandler.listMeat.contains("Chicken")&&!ClientHandler.listMeatDB.contains("13")) {
				ClientHandler.listMeat.add("Chicken");
				ClientHandler.listMeatDB.add("13");
			}
		}
		if (checkBox_Chicken.isSelected() == false) {
			if (ClientHandler.listMeat.contains("Chicken")&&!ClientHandler.listMeatDB.contains("13")) {
				ClientHandler.listMeat.remove("Chicken");
				ClientHandler.listMeatDB.remove("13");
			}
		}

		if (checkBox_Lamb.isSelected() == true) {
			if (!ClientHandler.listMeat.contains("Lamb")) {
				ClientHandler.listMeat.add("Lamb");
			}
		}
		if (checkBox_Lamb.isSelected() == false) {
			if (ClientHandler.listMeat.contains("Lamb")) {
				ClientHandler.listMeat.remove("Lamb");
			}
		}

		if (checkBox_Pork.isSelected() == true) {
			if (!ClientHandler.listMeat.contains("Pork")) {
				ClientHandler.listMeat.add("Pork");
			}
		}
		if (checkBox_Pork.isSelected() == false) {
			if (ClientHandler.listMeat.contains("Pork")) {
				ClientHandler.listMeat.remove("Pork");
			}
		}
		if (checkBox_Game.isSelected() == true) {
			if (!ClientHandler.listMeat.contains("Game")) {
				ClientHandler.listMeat.add("Game");
			}
		}
		if (checkBox_Game.isSelected() == false) {
			if (ClientHandler.listMeat.contains("Game")) {
				ClientHandler.listMeat.remove("Game");
			}
		}
		if (checkBox_Rabbit.isSelected() == true) {
			if (!ClientHandler.listMeat.contains("Rabbit")) {
				ClientHandler.listMeat.add("Rabbit");
			}
		}
		if (checkBox_Rabbit.isSelected() == false) {
			if (ClientHandler.listMeat.contains("Rabbit")) {
				ClientHandler.listMeat.remove("Rabbit");
			}
		}
		if (checkBox_Beef.isSelected() == true) {
			if (!ClientHandler.listMeat.contains("Beef")) {
				ClientHandler.listMeat.add("Beef");
			}
		}
		if (checkBox_Beef.isSelected() == false) {
			if (ClientHandler.listMeat.contains("Beef")) {
				ClientHandler.listMeat.remove("Beef");
			}
		}
		if (checkBox_Duck.isSelected() == true) {
			if (!ClientHandler.listMeat.contains("Duck")) {
				ClientHandler.listMeat.add("Duck");
			}
		}
		if (checkBox_Duck.isSelected() == false) {
			if (ClientHandler.listMeat.contains("Duck")) {
				ClientHandler.listMeat.remove("Duck");
			}
		}
		if (checkBox_Ground_Beef.isSelected() == true) {
			if (!ClientHandler.listMeat.contains("Ground Beef")) {
				ClientHandler.listMeat.add("Ground Beef");
			}
		}
		if (checkBox_Ground_Beef.isSelected() == false) {
			if (ClientHandler.listMeat.contains("Ground Beef")) {
				ClientHandler.listMeat.remove("Ground Beef");
			}
		}
		if (checkBox_Fish.isSelected() == true) {
			if (!ClientHandler.listMeat.contains("Fish")) {
				ClientHandler.listMeat.add("Fish");
			}
		}
		if (checkBox_Fish.isSelected() == false) {
			if (ClientHandler.listMeat.contains("Fish")) {
				ClientHandler.listMeat.remove("Fish");
			}
		}
		if (checkBox_Shrimp.isSelected() == true) {
			if (!ClientHandler.listMeat.contains("Shrimp")) {
				ClientHandler.listMeat.add("Shrimp");
			}
		}
		if (checkBox_Shrimp.isSelected() == false) {
			if (ClientHandler.listMeat.contains("Shrimp")) {
				control.ClientHandler.listMeat.remove("Shrimp");
			}
		}
		if (checkBox_Ground_Pork.isSelected() == true) {
			if (!ClientHandler.listMeat.contains("Ground Pork")) {
				ClientHandler.listMeat.add("Ground Pork");
			}
		}
		if (checkBox_Ground_Pork.isSelected() == false) {
			if (ClientHandler.listMeat.contains("Ground Pork")) {
				ClientHandler.listMeat.remove("Ground Pork");
			}
		}
		if (checkBox_Egg.isSelected() == true) {
			if (!ClientHandler.listMeat.contains("Egg")) {
				ClientHandler.listMeat.add("Egg");
			}
		}
		if (checkBox_Egg.isSelected() == false) {
			if (ClientHandler.listMeat.contains("Egg")) {
				ClientHandler.listMeat.remove("Egg");
			}
		}
	}

	@FXML
	private void handleCheckBoxActionVeg(ActionEvent event) throws IOException {

		if (checkBox_Avocado.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("avocado")
					&& !ClientHandler.listVeggiesDB.contains("1")) {
				ClientHandler.listVeggies.add("avocado");
				ClientHandler.listVeggiesDB.add("1");
			}
		}
		if (checkBox_Avocado.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("avocado")
					&& ClientHandler.listVeggiesDB.contains("1")) {
				ClientHandler.listVeggies.remove("avocado");
				ClientHandler.listVeggiesDB.remove("1");
			}
		}
		if (checkBox_Tomato.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Tomato")&&!ClientHandler.listVeggiesDB.contains("2")) {
				ClientHandler.listVeggies.add("Tomato");
				ClientHandler.listVeggiesDB.add("2");
			}
		}
		if (checkBox_Tomato.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Tomato")&&!ClientHandler.listVeggiesDB.contains("2")) {
				ClientHandler.listVeggies.remove("Tomato");
				ClientHandler.listVeggiesDB.add("2");
			}
		}
		if (checkBox_Cucumber.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Cucumber")) {
				ClientHandler.listVeggies.add("Cucumber");
			}
		}
		if (checkBox_Cucumber.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Cucumber")) {
				ClientHandler.listVeggies.remove("Cucumber");
			}
		}
		if (checkBox_Pepper.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Pepper")) {
				ClientHandler.listVeggies.add("Pepper");
			}
		}
		if (checkBox_Pepper.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Pepper")) {
				ClientHandler.listVeggies.remove("Pepper");
			}
		}
		if (checkBox_Zucchini.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Zucchini")) {
				ClientHandler.listVeggies.add("Zucchini");
			}
		}
		if (checkBox_Zucchini.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Zucchini")) {
				ClientHandler.listVeggies.remove("Zucchini");
			}
		}
		if (checkBox_Aubergine.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Aubergine")) {
				ClientHandler.listVeggies.add("Aubergine");
			}
		}
		if (checkBox_Aubergine.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Aubergine")) {
				ClientHandler.listVeggies.remove("Aubergine");
			}
		}
		if (checkBox_Pumpkin.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Pumpkin")) {
				ClientHandler.listVeggies.add("Pumpkin");
			}
		}
		if (checkBox_Pumpkin.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Pumpkin")) {
				ClientHandler.listVeggies.remove("Pumpkin");
			}
		}
		if (checkBox_Onion.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Onion")) {
				ClientHandler.listVeggies.add("Onion");
			}
		}
		if (checkBox_Onion.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Onion")) {
				ClientHandler.listVeggies.remove("Onion");
			}
		}
		if (checkBox_Garlic.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Garlic")&&!ClientHandler.listVeggiesDB.contains("4")) {
				ClientHandler.listVeggies.add("Garlic");
				ClientHandler.listVeggiesDB.add("4");
			}
		}
		if (checkBox_Garlic.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Garlic")&&!ClientHandler.listVeggiesDB.contains("4")) {
				ClientHandler.listVeggies.remove("Garlic");
				ClientHandler.listVeggiesDB.remove("4");
			}
		}
		if (checkBox_Spring_Onion.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Spring Onion")) {
				ClientHandler.listVeggies.add("Spring Onion");
				
			}
		}
		if (checkBox_Spring_Onion.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Spring Onion")) {
				ClientHandler.listVeggies.remove("Spring Onion");
			}
		}
		if (checkBox_Leek.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Leek")) {
				ClientHandler.listVeggies.add("Leek");
			}
		}
		if (checkBox_Leek.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Leek")) {
				ClientHandler.listVeggies.remove("Leek");
			}
		}
		if (checkBox_Celery.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Celery")) {
				ClientHandler.listVeggies.add("Celery");
			}
		}
		if (checkBox_Celery.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Celery")) {
				ClientHandler.listVeggies.remove("Celery");
			}
		}
		if (checkBox_Aspargus.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Aspargus")) {
				ClientHandler.listVeggies.add("Aspargus");
			}
		}
		if (checkBox_Aspargus.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Aspargus")) {
				ClientHandler.listVeggies.remove("Aspargus");
			}
		}
		if (checkBox_Artichoke.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Artichoke")) {
				ClientHandler.listVeggies.add("Artichoke");
			}
		}
		if (checkBox_Artichoke.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Artichoke")) {
				ClientHandler.listVeggies.remove("Artichoke");
			}
		}
		if (checkBox_Potato.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Potato")) {
				ClientHandler.listVeggies.add("Potato");
				ClientHandler.listVeggiesDB.add("12");
			}
		}
		if (checkBox_Potato.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Potato")) {
				ClientHandler.listVeggies.remove("Potato");
				ClientHandler.listVeggiesDB.remove("12");
			}
		}
		if (checkBox_Sweet_Potato.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Sweet_Potato")) {
				ClientHandler.listVeggies.add("Sweet_Potato");
			}
		}
		if (checkBox_Sweet_Potato.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Sweet_Potato")) {
				ClientHandler.listVeggies.remove("Sweet_Potato");
			}
		}
		if (checkBox_Radish.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Radish")) {
				ClientHandler.listVeggies.add("Radish");
			}
		}
		if (checkBox_Radish.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Radish")) {
				ClientHandler.listVeggies.remove("Radish");
			}
		}
		if (checkBox_Parsnip.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Parsnip")) {
				ClientHandler.listVeggies.add("Parsnip");
			}
		}
		if (checkBox_Parsnip.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Parsnip")) {
				ClientHandler.listVeggies.remove("Parsnip");
			}
		}
		if (checkBox_Carrot.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Carrot")) {
				ClientHandler.listVeggies.add("Carrot");
			}
		}
		if (checkBox_Carrot.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Carrot")) {
				ClientHandler.listVeggies.remove("Carrot");
			}
		}
		if (checkBox_Cabbage.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Cabbage")) {
				ClientHandler.listVeggies.add("Cabbage");
			}
		}

		if (checkBox_Cabbage.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Cabbage")) {
				ClientHandler.listVeggies.remove("Cabbage");
			}
		}
		if (checkBox_Cabbage.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Cabbage")) {
				ClientHandler.listVeggies.add("Cabbage");
			}
		}

		if (checkBox_Cabbage.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Cabbage")) {
				ClientHandler.listVeggies.remove("Cabbage");
			}
		}
		if (checkBox_Cauliflower.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Cauliflower")) {
				ClientHandler.listVeggies.add("Cauliflower");
			}
		}

		if (checkBox_Cauliflower.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Cauliflower")) {
				ClientHandler.listVeggies.remove("Cauliflower");
			}
		}
		if (checkBox_Lettuce.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Lettuce")) {
				ClientHandler.listVeggies.add("Lettuce");
			}
		}

		if (checkBox_Lettuce.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Lettuce")) {
				ClientHandler.listVeggies.remove("Lettuce");
			}
		}
		if (checkBox_Spinach.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Spinach")&&!ClientHandler.listVeggiesDB.contains("9")) {
				ClientHandler.listVeggies.add("Spinach");
				ClientHandler.listVeggiesDB.add("9");
			}
		}

		if (checkBox_Spinach.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Spinach")&&!ClientHandler.listVeggiesDB.contains("9")) {
				ClientHandler.listVeggies.remove("Spinach");
				ClientHandler.listVeggiesDB.remove("9");
			}
		}
		if (checkBox_Sweetcorn.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Sweetcorn")) {
				ClientHandler.listVeggies.add("Sweetcorn");
			}
		}

		if (checkBox_Sweetcorn.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Sweetcorn")) {
				ClientHandler.listVeggies.remove("Sweetcorn");
			}
		}
		if (checkBox_Green_Peas.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Green Peas")) {
				ClientHandler.listVeggies.add("Green Peas");
			}
		}

		if (checkBox_Green_Peas.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Green Peas")) {
				ClientHandler.listVeggies.remove("Green Peas");
			}
		}
		if (checkBox_Chick_Peas.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Chick Peas")) {
				ClientHandler.listVeggies.add("Chick Peas");
			}
		}

		if (checkBox_Chick_Peas.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Chick Peas")) {
				ClientHandler.listVeggies.remove("Chick Peas");
			}
		}
		if (checkBox_White_Beans.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("White Beans")) {
				ClientHandler.listVeggies.add("White Beans");
			}
		}

		if (checkBox_White_Beans.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("White Beans")) {
				ClientHandler.listVeggies.remove("White Beans");
			}
		}
		if (checkBox_Black_Beans.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Black Beans")) {
				ClientHandler.listVeggies.add("Black Beans");
			}
		}

		if (checkBox_Black_Beans.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Black Beans")) {
				ClientHandler.listVeggies.remove("Black Beans");
			}
		}
		if (checkBox_Coriander.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Coriander")) {
				ClientHandler.listVeggies.add("Coriander");
			}
		}

		if (checkBox_Coriander.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Coriander")) {
				ClientHandler.listVeggies.remove("Coriander");
			}
		}
		if (checkBox_Tarragon.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Tarragon")) {
				ClientHandler.listVeggies.add("Tarragon");
			}
		}

		if (checkBox_Tarragon.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Tarragon")) {
				ClientHandler.listVeggies.remove("Tarragon");
			}
		}
		if (checkBox_Dill.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Dill")) {
				ClientHandler.listVeggies.add("Dill");
			}
		}

		if (checkBox_Dill.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Dill")) {
				ClientHandler.listVeggies.remove("Dill");
			}
		}
		if (checkBox_Chili.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Chili")&&!ClientHandler.listVeggiesDB.contains("3")) {
				ClientHandler.listVeggies.add("Chili");
				ClientHandler.listVeggiesDB.add("3");
			}
		}

		if (checkBox_Chili.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Chili")&&!ClientHandler.listVeggiesDB.contains("3")) {
				ClientHandler.listVeggies.remove("Chili");
				ClientHandler.listVeggiesDB.remove("3");
			}
		}
		if (checkBox_Lemongrass.isSelected() == true) {
			if (!ClientHandler.listVeggies.contains("Lemongrass")) {
				ClientHandler.listVeggies.add("Lemongrass");
			}
		}

		if (checkBox_Lemongrass.isSelected() == false) {
			if (ClientHandler.listVeggies.contains("Lemongrass")) {
				ClientHandler.listVeggies.remove("Lemongrass");
			}
		}

	}

	@FXML
	private void handleCheckBoxActionFruit(ActionEvent event) throws IOException {

		if (checkBox_Apple.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Apple")) {
				ClientHandler.listFruit.add("Apple");
			}
		}
		if (checkBox_Apple.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Apple")) {
				ClientHandler.listFruit.remove("Apple");
			}
		}
		if (checkBox_Pear.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Pear")) {
				ClientHandler.listFruit.add("Pear");
			}
		}
		if (checkBox_Pear.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Pear")) {
				ClientHandler.listFruit.remove("Pear");
			}
		}
		if (checkBox_Orange.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Orange")) {
				ClientHandler.listFruit.add("Orange");
			}
		}
		if (checkBox_Orange.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Orange")) {
				ClientHandler.listFruit.remove("Orange");
			}
		}
		if (checkBox_Mandarin.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Mandarin")) {
				ClientHandler.listFruit.add("Mandarin");
			}
		}
		if (checkBox_Mandarin.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Mandarin")) {
				ClientHandler.listFruit.remove("Mandarin");
			}
		}
		if (checkBox_Grapefruit.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Grapefruit")) {
				ClientHandler.listFruit.add("Grapefruit");
			}
		}
		if (checkBox_Grapefruit.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Grapefruit")) {
				ClientHandler.listFruit.remove("Grapefruit");
			}
		}
		if (checkBox_Lemon.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Lemon")&&!ClientHandler.listFruitDB.contains("5")) {
				ClientHandler.listFruit.add("Lemon");
				ClientHandler.listFruitDB.add("5");
			}
		}
		if (checkBox_Lemon.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Lemon")&&!ClientHandler.listFruitDB.contains("5")) {
				ClientHandler.listFruit.remove("Lemon");
				ClientHandler.listFruitDB.remove("5");
			}
		}
		if (checkBox_Lime.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Lime")) {
				ClientHandler.listFruit.add("Lime");
			}
		}
		if (checkBox_Lime.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Lime")) {
				ClientHandler.listFruit.remove("Lime");
			}
		}
		if (checkBox_Banana.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Banana")) {
				ClientHandler.listFruit.add("Banana");
			}
		}
		if (checkBox_Banana.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Banana")) {
				ClientHandler.listFruit.remove("Banana");
			}
		}
		if (checkBox_Strawberry.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Strawberry")) {
				ClientHandler.listFruit.add("Strawberry");
			}
		}
		if (checkBox_Strawberry.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Strawberry")) {
				ClientHandler.listFruit.remove("Strawberry");
			}
		}
		if (checkBox_Blueberry.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Blueberry")) {
				ClientHandler.listFruit.add("Blueberry");
			}
		}
		if (checkBox_Blueberry.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Blueberry")) {
				ClientHandler.listFruit.remove("Blueberry");
			}
		}
		if (checkBox_Blackberry.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Blackberry")) {
				ClientHandler.listFruit.add("Blackberry");
			}
		}
		if (checkBox_Blackberry.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Blackberry")) {
				ClientHandler.listFruit.remove("Blackberry");
			}
		}
		if (checkBox_Cherry.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Cherry")) {
				ClientHandler.listFruit.add("Cherry");
			}
		}
		if (checkBox_Cherry.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Cherry")) {
				ClientHandler.listFruit.remove("Cherry");
			}
		}
		if (checkBox_Pineapple.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Pineapple")) {
				ClientHandler.listFruit.add("Pineapple");
			}
		}
		if (checkBox_Pineapple.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Pineapple")) {
				ClientHandler.listFruit.remove("Pineapple");
			}
		}
		if (checkBox_Apricot.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Apricot")) {
				ClientHandler.listFruit.add("Apricot");
			}
		}
		if (checkBox_Apricot.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Apricot")) {
				ClientHandler.listFruit.remove("Apricot");
			}
		}
		if (checkBox_Grapes.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Grapes")) {
				ClientHandler.listFruit.add("Grapes");
			}
		}
		if (checkBox_Grapes.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Grapes")) {
				ClientHandler.listFruit.remove("Grapes");
			}
		}
		if (checkBox_Mango.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Mango")) {
				ClientHandler.listFruit.add("Mango");
			}
		}
		if (checkBox_Mango.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Mango")) {
				ClientHandler.listFruit.remove("Mango");
			}
		}
		if (checkBox_Papaya.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Papaya")) {
				ClientHandler.listFruit.add("Papaya");
			}
		}
		if (checkBox_Papaya.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Papaya")) {
				ClientHandler.listFruit.remove("Papaya");
			}
		}
		if (checkBox_Kiwi.isSelected() == true) {
			if (!ClientHandler.listFruit.contains("Kiwi")) {
				ClientHandler.listFruit.add("Kiwi");
			}
		}
		if (checkBox_Kiwi.isSelected() == false) {
			if (ClientHandler.listFruit.contains("Kiwi")) {
				ClientHandler.listFruit.remove("Kiwi");
			}
		}
	}

	@FXML
	private void handleCheckBoxActionGrains(ActionEvent event) throws IOException {

		if (checkBox_Wheat.isSelected() == true) {
			if (!ClientHandler.listGrains.contains("Wheat")) {
				ClientHandler.listGrains.add("Wheat");
			}
		}
		if (checkBox_Wheat.isSelected() == false) {
			if (ClientHandler.listGrains.contains("Wheat")) {
				ClientHandler.listGrains.remove("Wheat");
			}
		}
		if (checkBox_Oats.isSelected() == true) {
			if (!ClientHandler.listGrains.contains("Oats")) {
				ClientHandler.listGrains.add("Oats");
			}
		}
		if (checkBox_Oats.isSelected() == false) {
			if (ClientHandler.listGrains.contains("Oats")) {
				ClientHandler.listGrains.remove("Oats");
			}
		}
		if (checkBox_Barley.isSelected() == true) {
			if (!ClientHandler.listGrains.contains("Barley")) {
				ClientHandler.listGrains.add("Barley");
			}
		}

		if (checkBox_Barley.isSelected() == false) {
			if (ClientHandler.listGrains.contains("Barley")) {
				ClientHandler.listGrains.remove("Barley");
			}
		}
		if (checkBox_CornMeal.isSelected() == true) {
			if (!ClientHandler.listGrains.contains("Cornmeal")) {
				ClientHandler.listGrains.add("Cornmeal");
			}
		}

		if (checkBox_CornMeal.isSelected() == false) {
			if (ClientHandler.listGrains.contains("Cornmeal")) {
				ClientHandler.listGrains.remove("Cornmeal");
			}
		}
		if (checkBox_Rye.isSelected() == true) {
			if (!ClientHandler.listGrains.contains("Rye")) {
				ClientHandler.listGrains.add("Rye");
			}
		}

		if (checkBox_Rye.isSelected() == false) {
			if (ClientHandler.listGrains.contains("Rye")) {
				ClientHandler.listGrains.remove("Rye");
			}
		}
		if (checkBox_Rice.isSelected() == true) {
			if (!ClientHandler.listGrains.contains("Rice")) {
				ClientHandler.listGrains.add("Rice");
			}
		}

		if (checkBox_Rice.isSelected() == false) {
			if (ClientHandler.listGrains.contains("Rice")) {
				ClientHandler.listGrains.remove("Rice");
			}
		}
		if (checkBox_Bulgur.isSelected() == true) {
			if (!ClientHandler.listGrains.contains("Bulgur")) {
				ClientHandler.listGrains.add("Bulgur");
			}
		}

		if (checkBox_Bulgur.isSelected() == false) {
			if (ClientHandler.listGrains.contains("Bulgur")) {
				ClientHandler.listGrains.remove("Bulgur");
			}
		}
		if (checkBox_Couscous.isSelected() == true) {
			if (!ClientHandler.listGrains.contains("Couscous")) {
				ClientHandler.listGrains.add("Couscous");
			}
		}

		if (checkBox_Couscous.isSelected() == false) {
			if (ClientHandler.listGrains.contains("Couscous")) {
				ClientHandler.listGrains.remove("Couscous");
			}
		}
		if (checkBox_Cracked_Wheat.isSelected() == true) {
			if (!ClientHandler.listGrains.contains("Cracked Wheat")) {
				ClientHandler.listGrains.add("Cracked Wheat");
			}
		}

		if (checkBox_Cracked_Wheat.isSelected() == false) {
			if (ClientHandler.listGrains.contains("Cracked Wheat")) {
				ClientHandler.listGrains.remove("Craked Wheat");
			}
		}
		if (checkBox_Bread.isSelected() == true) {
			if (!ClientHandler.listGrains.contains("Bread")&&!ClientHandler.listGrainsDB.contains("11")) {
				ClientHandler.listGrains.add("Bread");
				ClientHandler.listGrainsDB.add("11");
			}
		}

		if (checkBox_Bread.isSelected() == false) {
			if (ClientHandler.listGrains.contains("Bread")&&!ClientHandler.listGrainsDB.contains("11")) {
				ClientHandler.listGrains.remove("Bread");
				ClientHandler.listGrainsDB.remove("11");
			}
		}
		if (checkBox_Pasta.isSelected() == true) {
			if (ClientHandler.listGrains.contains("Pasta")) {
				ClientHandler.listGrains.add("Pasta");
			}
		}

		if (checkBox_Pasta.isSelected() == false) {
			if (ClientHandler.listGrains.contains("Pasta")) {
				ClientHandler.listGrains.remove("Pasta");
			}
		}

	}

	@FXML
	private void handleCheckBoxActionDairy(ActionEvent event) throws IOException {
		if (checkBox_Milk.isSelected() == true) {
			if (!ClientHandler.listDairy.contains("Milk")) {
				ClientHandler.listDairy.add("Milk");
			}
		}
		if (checkBox_Milk.isSelected() == false) {
			if (ClientHandler.listDairy.contains("Milk")) {
				ClientHandler.listDairy.remove("Milk");
			}
		}
		if (checkBox_Cream.isSelected() == true) {
			if (!ClientHandler.listDairy.contains("Cream")) {
				ClientHandler.listDairy.add("Cream");
			}
		}
		if (checkBox_Milk.isSelected() == false) {
			if (ClientHandler.listDairy.contains("Cream")) {
				ClientHandler.listDairy.remove("Cream");
			}
		}
		if (checkBox_Sour_Cream.isSelected() == true) {
			if (!ClientHandler.listDairy.contains("Sour Cream")) {
				ClientHandler.listDairy.add("Sour Cream");
			}
		}

		if (checkBox_Sour_Cream.isSelected() == false) {
			if (ClientHandler.listDairy.contains("Sour Cream")) {
				ClientHandler.listDairy.remove("Sour Cream");
			}
		}
		if (checkBox_Creme_Fraiche.isSelected() == true) {
			if (!ClientHandler.listDairy.contains("Creme Fraiche")&&!ClientHandler.listDairyDB.contains("14")) {
				ClientHandler.listDairy.add("Creme Fraiche");
				ClientHandler.listDairyDB.add("14");
			}
		}

		if (checkBox_Creme_Fraiche.isSelected() == false) {
			if (ClientHandler.listDairy.contains("Creme Fraiche")&&!ClientHandler.listDairyDB.contains("14")) {
				ClientHandler.listDairy.remove("Creme Fraiche");
				ClientHandler.listDairyDB.remove("14");
			}
		}
		if (checkBox_Yogurt.isSelected() == true) {
			if (!ClientHandler.listDairy.contains("Yogurt")) {
				ClientHandler.listDairy.add("Yogurt");
			}
		}

		if (checkBox_Yogurt.isSelected() == false) {
			if (ClientHandler.listDairy.contains("Yogurt")) {
				ClientHandler.listDairy.remove("Yogurt");
			}
		}
		if (checkBox_Hard_Cheese.isSelected() == true) {
			if (!ClientHandler.listDairy.contains("Hard Cheese")) {
				ClientHandler.listDairy.add("Hard Cheese");
				ClientHandler.listDairyDB.remove("10");
			}
		}

		if (checkBox_Hard_Cheese.isSelected() == false) {
			if (ClientHandler.listDairy.contains("Hard Cheese")) {
				ClientHandler.listDairy.remove("Hard Cheese");
				ClientHandler.listDairyDB.remove("10");
			}
		}
		if (checkBox_Soft_Cheese.isSelected() == true) {
			if (!ClientHandler.listDairy.contains("Soft Cheese")) {
				ClientHandler.listDairy.add("Soft Cheese");
			}
		}

		if (checkBox_Soft_Cheese.isSelected() == false) {
			if (ClientHandler.listDairy.contains("Soft Cheese")) {
				ClientHandler.listDairy.remove("Soft Cheese");
			}
		}
		if (checkBox_Cottage_Cheese.isSelected() == true) {
			if (!ClientHandler.listDairy.contains("Cottage Cheese")) {
				ClientHandler.listDairy.add("Cottage Cheese");
			}
		}

		if (checkBox_Cottage_Cheese.isSelected() == false) {
			if (ClientHandler.listDairy.contains("Cottage Cheese")) {
				ClientHandler.listDairy.remove("Cottage Cheese");
			}
		}
		if (checkBox_Blue_Cheese.isSelected() == true) {
			if (!ClientHandler.listDairy.contains("Blue Cheese")) {
				ClientHandler.listDairy.add("Blue Cheese");
			}
		}

		if (checkBox_Blue_Cheese.isSelected() == false) {
			if (ClientHandler.listDairy.contains("Blue Cheese")) {
				ClientHandler.listDairy.remove("Blue Cheese");
			}
		}
		if (checkBox_Parmesan.isSelected() == true) {
			if (!ClientHandler.listDairy.contains("Parmesan")) {
				ClientHandler.listDairy.add("Parmesan");
			}
		}

		if (checkBox_Parmesan.isSelected() == false) {
			if (ClientHandler.listDairy.contains("Parmesan")) {
				ClientHandler.listDairy.remove("Parmesan");
			}
		}
		if (checkBox_Butter.isSelected() == true) {
			if (!ClientHandler.listDairy.contains("Butter")) {
				ClientHandler.listDairy.add("Butter");
			}
		}

		if (checkBox_Butter.isSelected() == false) {
			if (ClientHandler.listDairy.contains("Butter")) {
				ClientHandler.listDairy.remove("Butter");
			}
		}

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
