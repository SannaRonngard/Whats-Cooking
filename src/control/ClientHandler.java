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
 * @author Olle Olsson
 * @author Linus Forsberg
 */

public class ClientHandler implements Initializable {

	static List<String> bigList = new ArrayList<String>();
	static List<String> listVeggies = new ArrayList<String>();
	static List<String> listMeat = new ArrayList<String>();
	static List<String> listDairy = new ArrayList<String>();
	static List<String> listFruit = new ArrayList<String>();
	static List<String> listGrains = new ArrayList<String>();

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
	}

	

}
