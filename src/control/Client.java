package control;

import java.util.HashMap;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Client {
	private static MealType currentMealType = MealType.ALL;
	private static int wheelHeight = 580;
	private static int wheelWidth = 464;
	private static int layoutX = 368;
	private static int layoutY = 105;
	public static final String IMAGE_SOURCE_DIRECTORY = "";
	private static Scene userLoginScene;
	private static Pane root = new Pane();
	private static Pane mainWheelPane = new Pane();
	private static HashMap<MealType, String> mealTypes = new HashMap<>();
	private Pane dairyPane = new Pane();
	private Pane meatPane = new Pane(); 
	private Pane fruitPane = new Pane(); 
	private Pane spannPane = new Pane(); 
	private Pane vegetablePane = new Pane();
	private static boolean transitioning = false;
	private static ImageView wheel = new ImageView();
	private static ImageView backgroundImage;
	Stage window = new Stage();
/*
 * Making a new stage where scene and root components are placed. 
 */
	public void clientGui() {
		userLoginScene = new Scene(root,1200,750);
		backgroundImage = new ImageView(new Image(loadResource("Whats-Cooking-Background.png")));
		backgroundImage.setPreserveRatio(false);
		backgroundImage.fitWidthProperty().bind(root.widthProperty());
		backgroundImage.fitHeightProperty().bind(root.heightProperty());
		root.getChildren().addAll(backgroundImage,mainWheelPane);
		mainWheelPane.getChildren().add(wheel);
		setMealTypes();
		addWheel(wheel);
		createBoundingBoxes(MealType.MEAT, mainWheelPane, 400, 103, 163, 180);
		createBoundingBoxes(MealType.VEGETABLES, mainWheelPane, 623, 103, 163, 180);
		createBoundingBoxes(MealType.FRUITS, mainWheelPane, 685, 300, 170, 150);
		createBoundingBoxes(MealType.DAIRY, mainWheelPane, 335, 300, 170, 150);
		createBoundingBoxes(MealType.SPANN,mainWheelPane, 500, 457, 185, 140);
		
		Button closeBtn = new Button("X");
		closeBtn.setLayoutX(1160);
		closeBtn.setLayoutY(25);
		closeBtn.setOnAction( e -> window.close() );
		root.getChildren().add(closeBtn);
		
		window.initModality(Modality.APPLICATION_MODAL); // Block any user interraction until window is closed
		window.initStyle(StageStyle.TRANSPARENT);
		window.setTitle("What's Cooking");
		window.setResizable(false);
		window.setScene(userLoginScene);
		window.show();
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
	private static void transitionToHome(int duration){
		FadeTransition fade = new FadeTransition();
		fade.setDuration(Duration.millis(duration));
		fade.setNode(wheel);
		fade.setFromValue(0);
		fade.setToValue(1);
		fade.play();
	}
	/**
	 * Enum types (a special data type that enables for a variable to be a set of predefined constants)
	 */
	public static enum MealType{
		MEAT,VEGETABLES,FRUITS,SPANN,DAIRY,ALL;
	}
	public static void setMealTypes(){
		mealTypes.put(MealType.ALL, "WhatsCooking_All_Grey.png");
		mealTypes.put(MealType.DAIRY, "WhatsCooking_Dairy.png");
		mealTypes.put(MealType.FRUITS, "WhatsCooking_Fruit.png");
		mealTypes.put(MealType.MEAT, "WhatsCooking_Meat.png");
		mealTypes.put(MealType.SPANN, "WhatsCooking_Spann.png");
		mealTypes.put(MealType.VEGETABLES, "WhatsCooking_Vegetables.png");
		
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

	/***
	 * Method that takes an image of the 'FoodWheel' and puts it in given position.  
	 * @param wheelImage - image of the wheel.
	 */
	public static void addWheel(ImageView wheelImage){
		wheelImage.setImage(new Image(mealTypes.get(currentMealType)));
		wheelImage.setPreserveRatio(true);
		wheelImage.setFitHeight(wheelHeight);
		wheelImage.setFitWidth(wheelWidth);
		wheelImage.setLayoutX(layoutX);
		wheelImage.setLayoutY(layoutY);

	}
	
	/**
	 * Method that changes the different categories color 
	 * @param mealType - Enum
	 */
	public static void changeWheelImage(MealType mealType){
		currentMealType = mealType;
		wheel.setImage(new Image(mealTypes.get(mealType)));
	}
	
	/**
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
	
	/**
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
					Button goBackBtn = new Button("<---");
					goBackBtn.setLayoutY(500);
					goBackBtn.setLayoutX(10);
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
	private void closeProgram(){
		System.out.println("Closed properly");
		window.close();
	}

}
