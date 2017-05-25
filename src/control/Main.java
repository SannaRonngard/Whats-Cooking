package control;

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
public class Main extends Application {
	Stage window;
	
	@Override
	public void start(Stage stage) throws Exception { setUserAgentStylesheet(STYLESHEET_CASPIAN);
			window = stage; //Making a reference to the primary stage. Needed for other methods. 
			final Parent rootStart = FXMLLoader.load( getClass().getResource("/gui/StartWindow.fxml"));
			final Scene scene = new Scene(rootStart, 350, 424);
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.setOnCloseRequest(e -> closeProgram());
			stage.setTitle("What's Cooking");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setHeight(350);
			stage.setWidth(424);
			stage.show();

	}
	private void closeProgram(){
		System.out.println("Closed properly");
		window.close();
	}
	
	public static void main(String[] args) { launch(args); }

}
