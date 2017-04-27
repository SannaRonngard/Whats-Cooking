package serverGui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DBController {
	
		@FXML 
		private Label lblStatus;
		@FXML
		private TextField txtUsername; 
		@FXML
		private PasswordField txtPassword;
		
		public void Login(ActionEvent event) throws Exception {
			if(txtUsername.getText().equals("user") && txtPassword.getText().equals("password")){
				lblStatus.setTextFill(Color.web("#43af43"));
				lblStatus.setText("Log in successful!");
				/*
				 * Om villkoret stämmer öppnas nästa scen. 
				 */
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load( getClass().getResource("/serverGui/Menu.fxml"));
				Scene scene = new Scene(root,650,500);
				scene.getStylesheets().add(getClass().getResource("serverGui.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} else {
				lblStatus.setTextFill(Color.web("#b22222"));
				lblStatus.setText("Username or password wrong. Try again!");
			}
		}
	}


