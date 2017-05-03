package serverGui;
import database.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * Server controller.
 * @author Sofia Larsson
 */
public class DBController {
		@FXML 
		private Label lblLogIn;
		@FXML
		private Label lblStatus;
		@FXML
		private TextField txtUsername; 
		@FXML
		private PasswordField txtPassword;
		@FXML
		private Button btnLogin;
		
		@FXML
		private Hyperlink hlContactSupport;
		@FXML
		private Pane pane;
//		private DBConnection db = new DBConnection(); 
		/**
		 * Method performs the log in sequence. 
		 * If: login details are correct: Log in window is hidden, and next stage opens. 
		 * Else: log in details are wrong. Clear user and pw fields and display message. 
		 * @param event
		 * @throws Exception
		 */
		public void Login(ActionEvent event) throws Exception {

			if(txtUsername.getText().equals("user") && txtPassword.getText().equals("password")){
				lblStatus.setTextFill(Color.web("#43af43"));
				lblStatus.setText("Log in successful!");

				
				
				/*
				 * Om villkoret stämmer öppnas nästa scen. 
				 */

				((Node)(event.getSource())).getScene().getWindow().hide();
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load( getClass().getResource("/serverGui/Menu.fxml"));
				Scene scene = new Scene(root,650,500);
				scene.getStylesheets().add(getClass().getResource("serverGui.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} else {
				txtUsername.clear();
				txtPassword.clear();
				lblStatus.setTextFill(Color.web("#b22222"));
				lblStatus.setText("Username or password wrong. Try again!");
			}
		}
		
	}


