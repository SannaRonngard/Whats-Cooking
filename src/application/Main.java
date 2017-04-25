package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

/**
 * Class for running the application, eventhandling and connecting logic with FXML file
 * Extends Application for Java FX and implements EventHandler for eventhandling
 * @author Linus Forsberg
 *
 */
public class Main extends Application implements EventHandler<ActionEvent> {

	Stage window;
	FlowPane fp1, fp2;
	Scene sceneMain, sceneRecipe;
	@FXML
	private Button btnSearchRecipes;
	@FXML
	private Button btnClearIngredients;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			btnSearchRecipes = new Button();
			btnClearIngredients = new Button();
			btnSearchRecipes.setOnAction(this);
			btnClearIngredients.setOnAction(this);
			Parent root = FXMLLoader.load(getClass().getResource("/application/GUI.fxml"));
			Scene scene = new Scene(root,642,508);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method for eventhandling
	 */
	@FXML
	public void handle(ActionEvent event) {
		if(event.getSource() == btnSearchRecipes) {
			System.out.println("Tar fram ny scene med förslag på recept");
			window.setScene(sceneRecipe);
		}
		if(event.getSource() == btnClearIngredients) {
			System.out.println("Rensar ingredienserna");
		}
	}
	
	/**
	 * Launches application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
