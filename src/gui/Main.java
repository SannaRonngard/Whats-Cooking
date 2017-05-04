package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * Main class for server application.
 * @author Sofia Larsson
 */
public class Main extends Application implements EventHandler<ActionEvent> {
	
	@Override
	public void start(Stage primaryStage ) {
		setUserAgentStylesheet(STYLESHEET_CASPIAN);
		try{
			Parent root = FXMLLoader.load( getClass().getResource("/gui/StartWindow.fxml"));
			Scene scene = new Scene(root,Color.TRANSPARENT);
			primaryStage.setScene(scene);
			primaryStage.setWidth(400);
			primaryStage.setHeight(350);
			primaryStage.setResizable(false);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setTitle("What's Cooking");
			primaryStage.show();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
