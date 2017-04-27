package serverGui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class DBController {
	
		@FXML 
		private Label lblStatus;
		@FXML
		private TextField txtUsername; 
		@FXML
		private PasswordField txtPassword;
		
		public void Login(ActionEvent event){
			if(txtUsername.getText().equals("user") && txtPassword.getText().equals("password")){
				lblStatus.setTextFill(Color.web("#43af43"));
				lblStatus.setText("Log in sucessful");
			} else {
				lblStatus.setTextFill(Color.web("#b22222"));
				lblStatus.setText("Username or password wrong. Try again!");
			}
		}
	}


