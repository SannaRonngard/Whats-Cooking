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

/**
 * Class for running the application, eventhandling and connecting logic with FXML file
 * Extends Application for Java FX and implements EventHandler for eventhandling
 * @author Linus Forsberg
 *
 */
public class Main extends Application implements EventHandler<ActionEvent> {

	@FXML
	private Button btnShowRecipes;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			btnShowRecipes = new Button();
			btnShowRecipes.setOnAction(this);
			Parent root = FXMLLoader.load(getClass().getResource("/application/GUI.fxml"));
			Scene scene = new Scene(root,642,508);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
		if(event.getSource() == btnShowRecipes) {
			System.out.println("FUNKA DÅÅÅÅÅÅÅÅÅ");
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
