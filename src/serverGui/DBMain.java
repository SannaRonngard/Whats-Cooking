package serverGui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
/**
 * Main class for server application. Hej
 * @author Sofia Larsson
 */
public class DBMain extends Application implements EventHandler<ActionEvent> {
	@Override
	public void start(Stage primaryStage ) {
		try{
			Parent root = FXMLLoader.load( getClass().getResource("/serverGui/Login.fxml"));
			Scene scene = new Scene(root,500,450);
			primaryStage.setResizable(false);
			primaryStage.setTitle("What's Cooking Admin");
			primaryStage.setScene(scene);
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
