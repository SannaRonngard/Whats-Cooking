package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

public class RecipeWindowHandler extends Application implements Initializable {

	private static Pane root = new Pane(); 
	
	@FXML
	private Scene scene;
	
	@FXML
	private VBox box;

	@FXML
	private static ListView<String> list = new ListView<String>();

	@FXML
	private ObservableList<String> data = FXCollections.observableArrayList("chocolate", "salmon", "gold", "coral",
			"darkorchid", "darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue", "blueviolet", "brown");
	@FXML
	final Label label = new Label();
	
	public void start(Stage primaryStage) throws IOException {
		Pane fxmlWindow = FXMLLoader.load(getClass().getResource("/gui/Show_Recipe_Window.fxml"));
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        fxmlWindow.getChildren().add(box);
        Scene scene = new Scene(fxmlWindow, 1200, 700);
        primaryStage.setScene(scene);
        box.getChildren().addAll(list, label);
        VBox.setVgrow(list, Priority.ALWAYS);    
		
     
        
        label.setLayoutX(10);
        label.setLayoutY(115);
        label.setFont(Font.font("Verdana", 20));    
        
		list.setItems(data);
		    
		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> list) {
				return new ColorRectCell();
			}
		});

		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
				label.setText(new_val);
				label.setTextFill(Color.web(new_val));
			}
		});
	
		primaryStage.show();
		
	
	}
	
	
	
	
	
	
//	@FXML
//	public void start(Stage stage) throws IOException {
		
		
		// Scene scene =
		//FXMLLoader.load(getClass().getResource("/gui/Show_Recipe_Window.fxml"));
//        Parent fxmlWindow = FXMLLoader.load(getClass().getResource("/gui/Show_Recipe_Window.fxml"));        
//        Scene scene = new Scene(fxmlWindow, 1200,750);
//        stage.setScene(scene);
//        stage.show();
		
        //stage.setScene(new Scene(fxmlWindow, 1200,750));
		
		//fxmlWindow.getChildren().add(vbox);
		//		VBox box = new VBox();
//		box.getChildren().addAll(list, label);
//		VBox.setVgrow(list, Priority.ALWAYS);
//		Scene scene = new Scene(box);
//		scene.getStylesheets().add("/gui/Show_Recipe_Window.fxml");
//		stage.setScene(scene);
//
//		list.setItems(data);
//
//		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
//			@Override
//			public ListCell<String> call(ListView<String> list) {
//				return new ColorRectCell();
//			}
//		});
//
//		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//			public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
//				label.setText(new_val);
//				label.setTextFill(Color.web(new_val));
//			}
//		});
//		stage.show();

	//}

	static class ColorRectCell extends ListCell<String> {
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			Rectangle rect = new Rectangle(100, 20);
			if (item != null) {
				rect.setFill(Color.web(item));
				setGraphic(rect);
			}
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	// public static void main(String[] args) {
	// launch(args);
	// }
}
