package gui;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
/**
 * Blueprint for pop-up widows
 * @author Sofia Larsson
 *
 */
public class AlertBox {
	
	/**
	 * A blueprint to asseble a pop-up or a new window/scene
	 * @param title
	 * @param message
	 * @param height
	 * @param width
	 */
	public static void blueprint(String title, String message, String buttonText, int height, int width) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL); // Block any user interraction  antil the alertbox is closed
		window.initStyle(StageStyle.TRANSPARENT);
		window.setTitle(title);
		window.setHeight(height);
		window.setWidth(width);
		window.setResizable(false);
		
		/*
		 * Example of buttons and labels that
		 * cloud be added to the alertbox. 
		 */
		
		Label label = new Label(); 
		label.setText(message);
		label.setId("bold-label");
		Button button = new Button(buttonText);
		button.setOnAction( e -> window.close() );
		
		/*
		 * Add button and label to layout 
		 */
		
		VBox layout = new VBox(20); 
		layout.getChildren().addAll(label, button);
		layout.setAlignment(Pos.CENTER);
		
		/*
		 * Make new scene, add window to the scene and show scene, 
		 * the scene needs to be closed before you can return to the previous one
		 */
		
		Scene scene = new Scene(layout);
		scene.getStylesheets().add("/gui/wc_styleSheet.css");
		window.setScene(scene);
		window.showAndWait();
		
	}
}
