package gui;
import client.MainClient;
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
public class GUIController {
		@FXML
		private Button btnAdmin;
		@FXML
		private Button btnLogin; 
		@FXML
		private Button btnUser;
		private DBConnection db;
		@FXML 
		private Label lblLogIn;
		@FXML
		private Label lblStatus;
		private MainClient clientGUI;
		@FXML
		private Hyperlink hlContactSupport;
		@FXML
		private Pane pane;
		@FXML
		private PasswordField txtPassword;
		@FXML
		private TextField txtUsername; 
		
		public GUIController(){
			this.btnLogin = new Button();
			this.btnUser = new Button();
			this.btnAdmin = new Button();
		}
		/**
		 * @param event
		 * @throws Exception
		 */
		public void handle(ActionEvent event) throws Exception {
			db = new DBConnection();
			clientGUI = new MainClient();
			if(event.getSource() == btnUser){
				((Node)(event.getSource())).getScene().getWindow().hide(); //stäng fönster 
			//USER - Öppne userGUI	OCH anslut till server 
			} else { // ANNARS OM ADMIN 
				//Starta Log in ruta
				//OM LÖSEN OCH SÅNT ÄR RÄTT ANSLUT TILL SERVER 
				if(txtUsername.getText().equals(db.getUsername()) && txtPassword.getText().equals(db.getPassword())){
					lblStatus.setTextFill(Color.web("#43af43"));
					lblStatus.setText("Log in successful!");
					// Starta databas
					db.initiate();
					//Öppna nästa scen 
					((Node)(event.getSource())).getScene().getWindow().hide();
					Stage primaryStage = new Stage();
					Parent root = FXMLLoader.load( getClass().getResource("/serverGui/Menu.fxml"));
					Scene scene = new Scene(root,650,500);
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
		
	}