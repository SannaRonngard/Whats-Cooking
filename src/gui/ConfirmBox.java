package gui;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
/**
 * Blueprint for a simple confirmbox
 * @author Sofia Larsson
 */
public class ConfirmBox {
	
	static boolean answer;

	public static boolean blueprint(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); // Block any user interraction  antil the alertbox is closed
		window.initStyle(StageStyle.TRANSPARENT);
		window.setTitle(title);
		window.setMinHeight(100);
		window.setMinWidth(200);
		
		Label label = new Label(); 
		label.setText(message);
		label.setId("bold-label");
		
		//Create two buttons
		Button yesButton = new Button("Yes");
		Button cancelButton = new Button("Cancel");
		
		yesButton.setOnAction(e -> {
			answer = true;
			window.close();
		
		});
		
		cancelButton.setOnAction(e -> {
			answer = false;
			window.close();
			
		});
		
		VBox layout = new VBox(10); 
		layout.getChildren().addAll(label, yesButton, cancelButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		scene.getStylesheets().add("/gui/wc_styleSheet.css");
		window.setScene(scene);
		window.showAndWait();
		
		//When this pop-pup is closed, return the boolean answer 
		return answer;
	}
}

//IN other class:
//button.setOnAction(e -> {
//	boolean result = ConfirmBox.blueprint("Warning", "Are you sure you want to delete all data?");
//	System.out.println(result);
//});