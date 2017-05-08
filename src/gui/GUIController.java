package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.DBConnection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Controller class for GUI. 
 * @author Sofia Larsson
 */
public class GUIController implements Initializable {
		
		@FXML private Button btnAdmin;
		@FXML private Button btnUser;
		
		@FXML private Button btnLogin; 
		@FXML private Label lblLogIn;
		@FXML private Label lblStatus;
		@FXML private Button btnContact;

		@FXML private PasswordField txtPassword;
		@FXML private TextField txtUsername; 
		private DBConnection db;
		@FXML public Button btnCloseLogin;
		private Stage window;
		
		public GUIController(){
			this.btnLogin = new Button();
			this.btnUser = new Button();
			this.btnAdmin = new Button();
			this.btnContact = new Button();
			this.btnCloseLogin = new Button();
			this.db = new DBConnection();
		}
		/**
		 * Method that is called whenever an event occurs. 
		 * @param event
		 * @throws Exception
		 */
		@FXML
		private void handleButtonAction(ActionEvent event) throws IOException {
			
			btnContact.setOnAction(e -> {
				AlertBox.blueprint("Contact", "Email support at: support@whatscooking.com", "Return to login", 100, 300);
			});
			
			if(event.getSource() == btnAdmin) {
				Parent parentLogin = FXMLLoader.load( getClass().getResource("/gui/Login.fxml"));//Instantiate a parent
				Scene sceneLogin = new Scene(parentLogin);
				Stage window = (Stage)((Node)event.getSource() ).getScene().getWindow();
				this.window = window;
				window.setOnCloseRequest(e -> { 
					e.consume();
					closeAppConfirm();
					});
				window.setHeight(350);
				window.setWidth(424);
				window.setScene(sceneLogin);
				window.show();
			}
			if(event.getSource() == btnUser) {
				System.out.println("på G");
//				Parent parentClient = FXMLLoader.load( getClass().getResource("/gui/Client.fxml"));//Instantiate a parent
//				Scene sceneClient = new Scene(parentClient);
//				Stage window = (Stage)((Node)event.getSource() ).getScene().getWindow();
//				this.window = window;
//				closeButton = new Button("");
//				closeButton.setOnAction( e -> closeApp() );
//				window.setScene(sceneClient);
//				window.show();
			}
					if(event.getSource() == btnLogin) {
				
						if(txtUsername.getText().equals(db.getUsername()) && txtPassword.getText().equals(db.getPassword()) ){
							lblStatus.setTextFill(Color.web("#43af43"));
							lblStatus.setText("Log in successful!");
						
							((Node)(event.getSource())).getScene().getWindow().hide();
							Stage window = new Stage();
							Parent rootMenu = null;
							try {
							rootMenu = FXMLLoader.load( getClass().getResource("/gui/AdminMenu.fxml") );
							} catch (IOException e) {
							e.printStackTrace();
								}
							Scene sceneMenu = new Scene(rootMenu,Color.TRANSPARENT);
							sceneMenu.getStylesheets().add(getClass().getResource("/gui/wc_styleSheet.css").toExternalForm());
							window.initStyle(StageStyle.TRANSPARENT);
							window.setHeight(500);
							window.setWidth(650);
							window.setScene(sceneMenu);
							window.show();
							db.initiate();
						} else {

							txtUsername.clear();
							txtPassword.clear();
							lblStatus.setTextFill(Color.web("#ff6347"));
							lblStatus.setText("Ooops! Try again!");
						}
					}
				}
		
		private void closeAppConfirm(){
			Boolean answer = ConfirmBox.blueprint("", "Are you sure you want to exit?");
			if(answer)
			window.close();
		}
//		 btnMinimize.setOnAction(new EventHandler<ActionEvent>() {
//
//		        public void handle(ActionEvent event) {
//		            Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
//		            // is stage minimizable into task bar. (true | false)
//		            stage.setIconified(true);
//		        }
//		    });
		
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {}	
			
	}
		
	