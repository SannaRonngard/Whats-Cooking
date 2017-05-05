package gui;
import java.io.IOException;

import client.MainClient;
import database.DBConnection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.StageStyle;
/**
 * Controller
 * @author Sofia Larsson
 */
public class GUIController implements EventHandler<ActionEvent>{
		
		@FXML private Button btnAdmin;
		@FXML private Button btnLogin; 
		@FXML private Button btnUser;
		@FXML private Label lblLogIn;
		@FXML private Label lblStatus;
		@FXML private Hyperlink hlContactSupport;
		@FXML private Pane pane;
		@FXML private PasswordField txtPassword;
		@FXML private TextField txtUsername; 
		
		private MainClient clientGUI;
		private DBConnection db;
		
		public GUIController(){
			this.btnLogin = new Button();
			this.btnUser = new Button();
			this.btnAdmin = new Button();
		}
		/**
		 * @param event
		 * @throws Exception
		 */
		public void handle(ActionEvent event) {
			db = new DBConnection();
			
			if(event.getSource() == btnUser) {
				((Node)(event.getSource())).getScene().getWindow().hide(); 
				//db.initiate();<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			}
			
			if(event.getSource() == btnAdmin) {  

				((Node)(event.getSource())).getScene().getWindow().hide(); 
				Stage stageLogin = new Stage();
				Parent rootLogin = null;
				try {
					rootLogin = FXMLLoader.load( getClass().getResource("/gui/Login.fxml") );
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene sceneLogin = new Scene(rootLogin, Color.TRANSPARENT);
				stageLogin.initStyle(StageStyle.TRANSPARENT);
				stageLogin.setScene(sceneLogin);
				stageLogin.show();
				
			} else if(event.getSource() == btnLogin){
				
					if(txtUsername.getText().equals(db.getUsername()) && txtPassword.getText().equals(db.getPassword()) ){
						lblStatus.setTextFill(Color.web("#43af43"));
						lblStatus.setText("Log in successful!");
						
						((Node)(event.getSource())).getScene().getWindow().hide();
						Stage stageMenu = new Stage();
						Parent rootMenu = null;
						try {
							rootMenu = FXMLLoader.load( getClass().getResource("/gui/Menu.fxml") );
						} catch (IOException e) {
							e.printStackTrace();
						}
						Scene sceneMenu = new Scene(rootMenu,Color.TRANSPARENT);
						stageMenu.initStyle(StageStyle.TRANSPARENT);
						stageMenu.setScene(sceneMenu);
						stageMenu.show();
						db.initiate();
					} else {
					txtUsername.clear();
					txtPassword.clear();
					lblStatus.setTextFill(Color.web("#ff6347"));
					lblStatus.setText("Ooops! Try again!");
					}
				
				}
				
			}
		}
		
	