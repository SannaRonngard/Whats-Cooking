package client;

import java.util.HashMap;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/***
 * Client class that displays the main Window of the application
 * @author OlleOlsson
 *
 */

public class MainClient extends Application {
	
	public static final String IMAGE_SOURCE_DIRECTORY = "";
	
	private MealType currentMealType = MealType.ALL;
	
	private boolean transitioning = false;
	
	private int wheelHeight = 580;
	private int wheelWidth = 464;
	private int layoutX = 368;
	private int layoutY = 104;
	
	private HashMap<MealType, String> mealTypes = new HashMap<>();
	private Scene scene;
	private Pane root = new Pane();
	private Pane mainWheelPane = new Pane();
	private Pane dairyPane = new Pane();
	private Pane meatPane = new Pane(); 
	private Pane fruitPane = new Pane(); 
	private Pane spannPane = new Pane(); 
	private Pane vegetablePane = new Pane();
	
	private ImageView wheel = new ImageView();
	private ImageView backgroundImage;
	
	/***
	 * Startmethod that starts the application and opens a window
	 */
	
	@Override
	public void start(Stage primaryStage) {
		try {
			scene = new Scene(root,1200,750);
			
			backgroundImage = new ImageView(new Image(loadResource("Whats-Cooking-Background.png")));
			
			backgroundImage.setPreserveRatio(false);
			
			backgroundImage.fitWidthProperty().bind(root.widthProperty());
			backgroundImage.fitHeightProperty().bind(root.heightProperty());
			
			root.getChildren().addAll(backgroundImage,mainWheelPane);
			mainWheelPane.getChildren().add(wheel);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			mealTypes.put(MealType.ALL, "WhatsCooking_All_Grey.png");
			mealTypes.put(MealType.DAIRY, "WhatsCooking_Dairy.png");
			mealTypes.put(MealType.FRUITS, "WhatsCooking_Fruit.png");
			mealTypes.put(MealType.MEAT, "WhatsCooking_Meat.png");
			mealTypes.put(MealType.SPANN, "WhatsCooking_Spann.png");
			mealTypes.put(MealType.VEGETABLES, "WhatsCooking_Vegetables.png");
			
			this.addWheel(wheel);
			
			this.createBoundingBoxes(MealType.MEAT, mainWheelPane, 400, 103, 163, 180);
			this.createBoundingBoxes(MealType.VEGETABLES, mainWheelPane, 623, 103, 163, 180);
			this.createBoundingBoxes(MealType.FRUITS, mainWheelPane, 685, 300, 170, 150);
			this.createBoundingBoxes(MealType.DAIRY, mainWheelPane, 335, 300, 170, 150);
			this.createBoundingBoxes(MealType.SPANN,mainWheelPane, 500, 457, 185, 140);
			
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void createFruitPane(){
		
	}
	
	/***
	 * Method that takes an image of the 'FoodWheel' and puts it in given position.  
	 * @param wheelImage - image of the wheel.
	 */
	
	public void addWheel(ImageView wheelImage){
		wheelImage.setImage(new Image(mealTypes.get(currentMealType)));
		wheelImage.setPreserveRatio(true);
		wheelImage.setFitHeight(this.wheelHeight);
		wheelImage.setFitWidth(this.wheelWidth);
		wheelImage.setLayoutX(this.layoutX);
		wheelImage.setLayoutY(this.layoutY);

	}
	
	/***
	 * Method that creates BoundingBoxes over the categories to allow a specific category to be selected
	 * @param mealType - takes an Enum type (given mealcategory) 
	 * @param pane - Base class for layout panes which need to expose the children list as public so that users of the subclass can freely add/remove children
	 * @param x - position on x-axis 
	 * @param y - position on y-axis
	 * @param width - width of boundingbox
	 * @param height - height of boundingbox 
	 * (To see Bounding boxes, add "boundingBox.setStroke(Color.BLACK);"
	 */
	
	public void createBoundingBoxes(MealType mealType, Pane pane, int x, int y, int width, int height){
		Rectangle boundingBox = new Rectangle(x,y,width,height);
		boundingBox.setFill(Color.TRANSPARENT);
		pane.getChildren().add(boundingBox);
		addHoverAction(boundingBox,mealType);
	}
	
	/***
	 * Method that lights up the category that the mouse is hovering over. When no categori is being hovered over, the wheel
	 * is in it's standard color (when mouse exits the box).
	 * @param box - 
	 * @param mealType -
	 */
	
	private void addHoverAction(Rectangle box, MealType mealType){
		box.setOnMouseClicked(e -> {
			changeScene(mealType); 
		});
		box.setOnMouseEntered(e -> {
			switch(mealType){
			case ALL:
				break;
			case DAIRY:
				changeWheelImage(MealType.DAIRY);
				break;
			case FRUITS:
				changeWheelImage(MealType.FRUITS);
				break;
			case MEAT:
				changeWheelImage(MealType.MEAT);
				break;
			case SPANN:
				changeWheelImage(MealType.SPANN);
				break;
			case VEGETABLES:
				changeWheelImage(MealType.VEGETABLES);
				break;
			default:
				break;
			
			}
		});
		box.setOnMouseExited(e -> {
			changeWheelImage(MealType.ALL);
		});
	}
	
	/**
	 * Method that changes the different categories color 
	 * @param mealType - Enum
	 */
	
	public void changeWheelImage(MealType mealType){
		currentMealType = mealType;
		wheel.setImage(new Image(mealTypes.get(mealType)));
	}
	
	/**
	 * Method that switches scene when one category is pressed. 
	 * Run-methods (x5) for changing the scenes with given time-interval.
	 * @param type - switches between the Enum types 
	 */
	
	public void changeScene(MealType type){
		
		switch(type){
		case DAIRY:
			if(transitioning)
				return;
			
		    createTransition(1000,new Runnable(){
				@Override
				public void run() {
					Button goBackBtn = new Button("Go back");
					dairyPane.getChildren().addAll(goBackBtn);
					root.getChildren().remove(mainWheelPane);
					root.getChildren().add(dairyPane);
					
					goBackBtn.setOnMouseClicked(e -> {
						root.getChildren().remove(dairyPane);
						root.getChildren().add(mainWheelPane);
						transitionToHome(1000);
						
					});
				}
		    	
		    });
		    
			break;
		case FRUITS:
			if(transitioning)
				return;
			
			  createTransition(1000,new Runnable(){
					@Override
					public void run() {
						Button goBackBtn = new Button("Go back");
						fruitPane.getChildren().addAll(goBackBtn);
						root.getChildren().remove(mainWheelPane);
						root.getChildren().add(fruitPane);
						
						goBackBtn.setOnMouseClicked(e -> {
							root.getChildren().remove(fruitPane);
							root.getChildren().add(mainWheelPane);
							transitionToHome(1000);
						});
					}
			    	
			    });
			  
			break;
		case MEAT:
			if(transitioning)
				return;
			
			createTransition(1000,new Runnable(){
				@Override
				public void run() {
					Button goBackBtn = new Button("Go back");
					meatPane.getChildren().addAll(goBackBtn);
					root.getChildren().remove(mainWheelPane);
					root.getChildren().add(meatPane);
					
					goBackBtn.setOnMouseClicked(e -> {
						root.getChildren().remove(meatPane);
						root.getChildren().add(mainWheelPane);
						transitionToHome(1000);
					});
				}
				
			});
						
			break;
		case SPANN:
			if(transitioning)
				return;
			
			createTransition(1000,new Runnable(){
				@Override
				public void run() {
					Button goBackBtn = new Button("Go back");
					spannPane.getChildren().addAll(goBackBtn);
					root.getChildren().remove(mainWheelPane);
					root.getChildren().add(spannPane);
					
					goBackBtn.setOnMouseClicked(e -> {
						root.getChildren().remove(spannPane);
						root.getChildren().add(mainWheelPane);
						transitionToHome(1000);
					});
				}
				
			});
			
			
			break;
		case VEGETABLES:
			if(transitioning)
				return;
			
			createTransition(1000,new Runnable(){
				@Override
				public void run() {
					Button goBackBtn = new Button("Go back");
					vegetablePane.getChildren().addAll(goBackBtn);
					root.getChildren().remove(mainWheelPane);
					root.getChildren().add(vegetablePane);
					
					goBackBtn.setOnMouseClicked(e -> {
						root.getChildren().remove(vegetablePane);
						root.getChildren().add(mainWheelPane);
						transitionToHome(1000);
					});
				}
				
			});
			
			break;
		default:
			break;
		
		}
	}
	
	/**
	 * Method that creates a transition between the scenes
	 * @param duration - duration of the transition 
	 * @param script - if the script is not null the transition runs. 
	 */
	
	private void createTransition(int duration, Runnable script){
		transitioning = true;
		
		FadeTransition fade = new FadeTransition();
		fade.setDuration(Duration.millis(duration));
		fade.setNode(wheel);
		fade.setFromValue(1);
		fade.setToValue(0);
		fade.setOnFinished(e -> {
			if(script!=null){
				script.run();
			}
			transitioning = false;
		});
		fade.play();
	}
	
	/**
	 * Creates a transition to the original startup view. 
	 * @param duration - duration of the transition
	 */
	
	private void transitionToHome(int duration){
		FadeTransition fade = new FadeTransition();
		fade.setDuration(Duration.millis(duration));
		fade.setNode(wheel);
		fade.setFromValue(0);
		fade.setToValue(1);
		fade.play();
	}
	
	/**
	 * Method that loads the different images form the source folder
	 * @param image - images from the source directory 
	 * @return - returns the url for the images 
	 */
	
	public static String loadResource(String image) {
		String url = IMAGE_SOURCE_DIRECTORY + image;
		return url;
	}
	
	/**
	 * Main-method that launches the application. 
	 * @param args
	 */
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Enum types (a special data type that enables for a variable to be a set of predefined constants)
	 * @author OlleOlsson
	 *
	 */
	
	public enum MealType{
		MEAT,VEGETABLES,FRUITS,SPANN,DAIRY,ALL;
	}
}


