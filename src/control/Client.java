package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import database.DBController;
import database.Recipe;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * Client that shows the window when the 'Get Recipe' button in the
 * application is clicked.
 * @author Olle Olsson
 * @author Sofia Larsson
 * @author Sanna Rönngård
 * @author Linus Forsberg
 *
 */

public class Client {
	@FXML TextArea textArea;
	@FXML Label lblTitle, lblMeasures;
	
	private static MealType currentMealType = MealType.ALL;
	private static int wheelHeight = 580;
	private static int wheelWidth = 464;
	private static int wheelLayoutX = 368;
	private static int wheelLayoutY = 104;

	private static int questionMarkLayoutX = 1110;
	private static int questionMarkLayoutY = 12;
	private static int questionMarkHeight = 24;
	private static int questionMarkWidth = 24;
	
	private static int closeIconLayoutX = 1170;
	private static int closeIconLayoutY = 10;
	private static int closeIconHeight = 24;
	private static int closeIconWidth = 24;
	
	private static int minimizeIconLayoutX = 1140;
	private static int minimizeIconLayoutY = 10;
	private static int minimizeIconWidth = 24;
	private static int minimizeIconHeight = 24; 

	public static final String IMAGE_SOURCE_DIRECTORY = "";
	TextField tfSearchRecipe = new TextField("");
	private static Scene userLoginScene;
	
	private static HashMap<MealType, String> mealTypes = new HashMap<>();
	private static HashMap<MenuTools, String> menuTools = new HashMap<>();

	private static ImageView backgroundImage;
	private static ImageView tools = new ImageView();
	private static ImageView close = new ImageView(); 
	private static ImageView minimize = new ImageView(); 
	private static ImageView wheel = new ImageView();
	
	private static ListView<String> selectedIngredients = new ListView<String>(); 
	private static ListView<String> showRecipes = new ListView<String>();
	
	private static Pane questionMarkPane = new Pane();
	private static Pane closePane = new Pane(); 
	private static Pane minimizePane = new Pane(); 
	private static Pane root = new Pane();
	private static Pane mainWheelPane = new Pane();
	private Pane dairyPane = new Pane();
	private Pane meatPane = new Pane();
	private Pane fruitPane = new Pane();
	private Pane spannPane = new Pane();
	private Pane vegetablePane = new Pane(); 
	
	
	private static boolean transitioning = false;

	private ClientHandler clientHandler;
	private ApplicationInformation applicationInformation;
	private DBController dbc;
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
		root.getChildren().addAll(backgroundImage,mainWheelPane,questionMarkPane, closePane, minimizePane);
		mainWheelPane.getChildren().add(wheel);
		setMealTypes();
		addWheel(wheel);
		
		closePane.getChildren().add(close);
		minimizePane.getChildren().add(minimize);
		questionMarkPane.getChildren().add(tools);
		
		setToolIcons();
		addMenuTools(tools);
		addCloseButton(close);
		addMinimizeButton(minimize);
		
		createBoundingBoxesMeal(MealType.MEAT, mainWheelPane, 400, 103, 163, 180);
		createBoundingBoxesMeal(MealType.VEGETABLES, mainWheelPane, 623, 103, 163, 180);
		createBoundingBoxesMeal(MealType.FRUITS, mainWheelPane, 685, 300, 170, 150);
		createBoundingBoxesMeal(MealType.DAIRY, mainWheelPane, 335, 300, 170, 150);
		createBoundingBoxesMeal(MealType.SPANN, mainWheelPane, 500, 457, 185, 140);
		
		createBoundingBoxesQm(MenuTools.QUESTIONMARK, questionMarkPane, questionMarkLayoutX, questionMarkLayoutY, questionMarkWidth, questionMarkHeight);
		createBoundingBoxesClose(MenuTools.CLOSE, closePane, closeIconLayoutX, closeIconLayoutY, closeIconWidth, closeIconHeight);
		createBoundingBoxesMin(MenuTools.MINIMIZE, minimizePane, minimizeIconLayoutX, minimizeIconLayoutY, minimizeIconWidth, minimizeIconHeight); 

		window.initModality(Modality.APPLICATION_MODAL); 
		window.initStyle(StageStyle.TRANSPARENT);
		window.setTitle("What's Cooking");
		window.setResizable(false);
		window.setScene(userLoginScene);
		window.show();
		
		Label ingredients = new Label("Selected Ingredients");
		ingredients.setFont(Font.font("Impact", FontWeight.BOLD, 24));
		ingredients.setTextFill(Color.WHITE);
		ingredients.setLayoutX(900);
		ingredients.setLayoutY(120);
		addIngredientstList(selectedIngredients);
		root.getChildren().addAll(selectedIngredients, ingredients);
		
		Button clearAll = new Button("Clear All"); 
		clearAll.setLayoutX(1075);
		clearAll.setLayoutY(555);
		root.getChildren().addAll(clearAll); 
		clearAll.setOnAction(e -> clearList());
		
		Button generateRecipes = new Button("Generate Recipes"); 
		generateRecipes.setLayoutX(900);
		generateRecipes.setLayoutY(555);
		root.getChildren().addAll(generateRecipes); 
		generateRecipes.setOnAction(e -> generateRecipes());
		
		Button search = new Button("Search"); 
		search.setLayoutX(562);
		search.setLayoutY(620);
		tfSearchRecipe.setLayoutX(515);
		tfSearchRecipe.setLayoutY(590);
		root.getChildren().addAll(search, tfSearchRecipe); 
		search.setOnAction(e -> {	
		searchRecipesManually();
		
		});
		
	}

	/**
	 * Enum types of different menutools (a special data type that enables for a variable to be a set of predefined constants)
	 */
	
	public static enum MenuTools{
		QUESTIONMARK, CLOSE, MINIMIZE;
	}

	/**
	 * Enum types of different food categories (a special data type that enables for a variable to be a set of predefined constants)
	 */
	
	public static enum MealType{
		MEAT,VEGETABLES,FRUITS,SPANN,DAIRY,ALL;
	}
	
	/**
	 * Calls the given image from the sourcefolder
	 */

	public static void setToolIcons(){
		menuTools.put(MenuTools.QUESTIONMARK, "questionMark1.png");
		menuTools.put(MenuTools.CLOSE, "Close.png"); 
		menuTools.put(MenuTools.MINIMIZE, "Minimize.png");
	}
	
	/**
	 * Calls the given image from the sourcefolder 
	 */

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
	
	/**
	 * Method that clears the list from selected ingredients
	 */
	
	private void clearList() {
		ClientHandler.clearList(ClientHandler.bigList);
		selectedIngredients.getItems().clear();
		
	}
	
	public void searchRecipesManually() {
		dbc = new DBController();
		Recipe r = new Recipe();
		String name = tfSearchRecipe.getText();
		dbc.TitleSearch(name);
		
		String stringTitle = r.getTitle();
		Label title = new Label(stringTitle);
		title.setLayoutX(200);
		title.setLayoutY(150);
		title.setTextFill(Color.web("#FFFFFF"));
		title.setFont(Font.font("Impact", FontWeight.BOLD, 36));
		String stringTime = r.getPrepTime();
		Label time = new Label(stringTime);
		time.setLayoutX(400);
		time.setLayoutY(160);
		time.setTextFill(Color.web("#FFFFFF"));
		time.setFont(Font.font("Impact", FontWeight.BOLD, 24));
		Text textMeasures = new Text(r.getMeasure());
		textMeasures.setStyle("-fx-font-size: 18; -fx-fill: black;");
		TextFlow measures = new TextFlow(textMeasures);
		measures.setLayoutX(220);
		measures.setLayoutY(230);
		measures.setMaxWidth(Control.USE_PREF_SIZE);
	    measures.setMaxHeight(Control.USE_PREF_SIZE);
		Text textInstructions = new Text(r.getInstructions());
		textInstructions.setStyle("-fx-font-size: 18; -fx-fill: black;");
		TextFlow instructions = new TextFlow(textInstructions);
		instructions.setLayoutX(220);
		instructions.setLayoutY(500);
		instructions.setMaxWidth(Control.USE_PREF_SIZE);
	    instructions.setMaxHeight(Control.USE_PREF_SIZE);
		
		Button goBackBtn = new Button("Go back");;
//		dairyPane.getChildren().addAll(goBackBtn, title, time, measures, instructions);
		root.getChildren().remove(mainWheelPane);
		root.getChildren().add(dairyPane);
		
		try {
			
			Pane Recipe = FXMLLoader.load(getClass().getResource("/gui/Recipe.fxml"));
			dairyPane.getChildren().add(Recipe);
			Recipe.getChildren().addAll(goBackBtn, title, time, measures, instructions);
			
		} catch (IOException e) { e.printStackTrace(); }
		goBackBtn.setOnMouseClicked(e -> {
			root.getChildren().remove(dairyPane);
			root.getChildren().add(mainWheelPane);	});			
	}	
	public void generateRecipes() {
		Label recipes = new Label("Generated Recipes");
		recipes.setFont(Font.font("Impact", FontWeight.BOLD, 24));
		recipes.setTextFill(Color.WHITE);
		recipes.setLayoutX(50);
		recipes.setLayoutY(120);
		Button showRecipe = new Button("Show Recipe");
		showRecipe.setLayoutX(50);
		showRecipe.setLayoutY(555);
		
		getRecipeFromDatabase();
		
		showRecipeList(showRecipes);
		root.getChildren().addAll(showRecipes, recipes, showRecipe);
		
	}
	
	private void getRecipeFromDatabase() {
		dbc = new DBController();
		CheckBoxes.setbigListDairyDB();
		CheckBoxes.setbigListFruitDB();
		CheckBoxes.setbigListGrainsDB();
		CheckBoxes.setbigListMeatDB();
		CheckBoxes.setbigListVegDB();
		ClientHandler.setListToStringDB();
		String ingredientNumbers = ClientHandler.getStringListDB();
		
		dbc.getRecipeByIngredients(ingredientNumbers);
		showRecipes.getItems().addAll( Recipe.recipeNameList );
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
	 * Method that takes the selectedIngredients list and places it in given x and y position 
	 * @param selectedIngredients
	 */
	
	public void addIngredientstList(ListView<String> selectedIngredients) {
		selectedIngredients.setLayoutX(900);
		selectedIngredients.setLayoutY(150);
		selectedIngredients.setMaxSize(300, 650);
	
	}
	
	/**
	 * method that takes the recipes from the database and displays them in a list. 
	 * @param showRecipes
	 */
	
	public void showRecipeList(ListView<String> showRecipes) {
		showRecipes.setLayoutX(50);
		showRecipes.setLayoutY(150);
		showRecipes.setMaxSize(300, 650);
		
	}
	
	/**
	 * Method that takes an image of the 'MenuTools' and puts it in the given position. 
	 * @param menuToolImages
	 */

	public static void addMenuTools(ImageView menuToolImages){
		menuToolImages.setImage(new Image("questionMark1.png"));
		menuToolImages.setPreserveRatio(true);
		menuToolImages.setLayoutX(questionMarkLayoutX);
		menuToolImages.setLayoutY(questionMarkLayoutY);
		menuToolImages.setFitHeight(questionMarkHeight);
		menuToolImages.setFitWidth(questionMarkWidth);
	
	}
	
	/**
	 * Method that takes an image of the 'MenuTools' and puts it in the given position. 
	 * @param menuToolImages
	 */
	
	public static void addCloseButton(ImageView closeButtonImage){
		closeButtonImage.setImage(new Image("1494174280_Close.png"));
		closeButtonImage.setPreserveRatio(true);
		closeButtonImage.setLayoutX(closeIconLayoutX);
		closeButtonImage.setLayoutY(closeIconLayoutY);
		closeButtonImage.setFitHeight(closeIconHeight);
		closeButtonImage.setFitWidth(closeIconWidth);
	}
	
	/**
	 * Method that takes an image of the 'MenuTools' and puts it in the given position. 
	 * @param menuToolImages
	 */
	
	public static void addMinimizeButton(ImageView minimizeButtonImage){
		minimizeButtonImage.setImage(new Image("1494174365_minus.png"));
		minimizeButtonImage.setPreserveRatio(true);
		minimizeButtonImage.setLayoutX(minimizeIconLayoutX);
		minimizeButtonImage.setLayoutY(minimizeIconLayoutY);
		minimizeButtonImage.setFitWidth(minimizeIconWidth);
		minimizeButtonImage.setFitHeight(minimizeIconHeight);

	}

	/**
	 * Method that takes an image of the 'FoodWheel' and puts it in given position.
	 * @param wheelImage - image of the wheel.
	 */
	
	public static void addWheel(ImageView wheelImage){
		wheelImage.setImage(new Image(mealTypes.get(currentMealType)));
		wheelImage.setPreserveRatio(true);
		wheelImage.setFitHeight(wheelHeight);
		wheelImage.setFitWidth(wheelWidth);
		wheelImage.setLayoutX(wheelLayoutX);
		wheelImage.setLayoutY(wheelLayoutY);

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
	
	public void createBoundingBoxesMeal(MealType mealType, Pane pane, int x, int y, int width, int height){
		Rectangle boundingBox = new Rectangle(x,y,width,height);
		boundingBox.setFill(Color.TRANSPARENT);
		pane.getChildren().add(boundingBox);
		addHoverActionWheel(boundingBox,mealType); 

	}
	
	/**
	 * 
	 * @param pane - Base class for layout panes which need to expose the children list as public so that users of the subclass can freely add/remove children
	 * @param x - positiokn on x-axis 
	 * @param y - position on y-axis
	 * @param width - width of bar 
	 * @param height - height of bar 
	 */

	
	public void createWindowBar(Pane pane) {
		Rectangle windowBar = new Rectangle();
		windowBar.setX(0);
		windowBar.setY(0);
		windowBar.setWidth(1200);
		windowBar.setHeight(24);
		windowBar.setFill(Color.WHITE);
		windowBar.setOpacity(0.3);
		pane.getChildren().add(windowBar); 
		
	}
	
	/**
	 * Method that creates BoundingBoxes over the questionMarkIcon to allow the user to recieve information aobut the application
	 * @param menuTools - takes an Enum type (given MenuTool)
	 * @param pane - Base class for layout panes which need to expose the children list as public so that users of the subclass can freely add/remove children
	 * @param questionMarkLayoutX - position on x-axis 
	 * @param questionMarkLayoutY - position on y-axis 
	 * @param questionMarkWidth - width of boundingbox 
	 * @param questionMarkHeight - height of boundixbox
	 * (To see Bounding boxes, add "boundingBox.setStroke(Color.BLACK);" 
	 */

	public void createBoundingBoxesQm(MenuTools menuTools, Pane pane, int questionMarkLayoutX, int questionMarkLayoutY, int questionMarkWidth, int questionMarkHeight) {
		Rectangle boundingBox = new Rectangle(questionMarkLayoutX, questionMarkLayoutY, questionMarkWidth, questionMarkHeight);
		boundingBox.setFill(Color.TRANSPARENT);
//		boundingBox.setStroke(Color.BLACK);
		pane.getChildren().add(boundingBox);
		addHoverActionMenuTools(boundingBox, pane, menuTools);

	}
	
	/**
	 * Method that creates BoundingBoxes over the closeIcon to allow the user to Close the window 
	 * @param menutools - takes an Enum type (given menuTool) 
	 * @param pane - Base class for layout panes which need to expose the children list as public so that users of the subclass can freely add/remove children
	 * @param closeIconLayoutX - posotion on x-axis
	 * @param closeIconLayoutY - position on y-axis
	 * @param closeIconWidth - width of boundingBox
	 * @param closeIconHeight - height of boundingBox 
	 */
	
	public void createBoundingBoxesClose(MenuTools menuTools, Pane pane, int closeIconLayoutX, int closeIconLayoutY, int closeIconWidth, int closeIconHeight) { 
		Rectangle boundingBox = new Rectangle(closeIconLayoutX, closeIconLayoutY, closeIconWidth, closeIconHeight); 
		boundingBox.setFill(Color.TRANSPARENT);
		pane.getChildren().add(boundingBox);
		closeWindow(boundingBox, pane, menuTools); 
		
	}
	
	/**
	 * Method that creates BoundingBoxes over the minimizeIcon to allow the user to Close the window 
	 * @param menutools - takes an Enum type (given menuTool) 
	 * @param pane - Base class for layout panes which need to expose the children list as public so that users of the subclass can freely add/remove children
	 * @param minimizeIconLayoutX - posotion on x-axis
	 * @param minimizeIconLayoutY - position on y-axis
	 * @param minimizeIconWidth - width of boundingBox
	 * @param minimizeIconHeight - height of boundingBox 
	 */
	
	public void createBoundingBoxesMin(MenuTools menuTools, Pane pane, int minimizeIconLayoutX, int minimizeIconLayoutY, int minimizeIconWidth, int minimizeIconHeight) {
		Rectangle boundingBox = new Rectangle(minimizeIconLayoutX, minimizeIconLayoutY, minimizeIconWidth, minimizeIconHeight);
		boundingBox.setFill(Color.TRANSPARENT);
		pane.getChildren().add(boundingBox);
		minimizeWindow(boundingBox, pane, menuTools); 
	}
	
	/**
	 * Method that closes the window 
	 * @param box - boundingBox that reacts to a mouseEntered 
	 * @param menuTools - reference for the menutools 
	 */
	
	private void closeWindow(Rectangle box, Pane pane, MenuTools menuTools) {
		box.setOnMouseEntered(e -> {
			close.setScaleX(1.2);
			close.setScaleY(1.2);
		});
		
		box.setOnMouseExited(e -> {
			close.setScaleX(1);
			close.setScaleY(1);
		});
		
		box.setOnMouseClicked(e -> {
			window.close();
		});
	}
	
	/**
	 * method that minimizes the window 
	 * @param box - boundingBox that reacts to a mouseEntered 
	 * @param menuTools - reference for the menuTools 
	 */
	
	private void minimizeWindow(Rectangle box, Pane pane, MenuTools menuTools) {
		box.setOnMouseEntered(e -> {
			minimize.setScaleX(1.2);
			minimize.setScaleY(1.2);
		});
		
		box.setOnMouseExited(e -> {
			minimize.setScaleX(1);
			minimize.setScaleY(1);
		});
		
		box.setOnMouseClicked(e -> {
			window.setIconified(true);
		});
		
	}

	/**
	 * Method that makes the MenuTools interactive 
	 * @param box - area which triggers the menutools to size up 
	 * @param menuTools - reference for the menutools 
	 */

	private void addHoverActionMenuTools(Rectangle box, Pane pane, MenuTools menuTools) {
		box.setOnMouseEntered(e -> {
			tools.setScaleX(1.2);
			tools.setScaleY(1.2);
		});

		box.setOnMouseExited(e -> {
			tools.setScaleX(1);
			tools.setScaleY(1);
		});

		box.setOnMouseClicked(e -> {
			showHelpInformation(box, pane); 
		});
		
	}
	
	/**
	 * 
	 * @param box - information box where information about the program is supposed to be 
	 * @param pane
	 */
	
	private void showHelpInformation(Rectangle box, Pane pane) {
		
		StackPane stackPane = new StackPane();
		stackPane.setPrefSize(1200, 750);
		Rectangle infoBox = new Rectangle(500, 700);  
		infoBox.setFill(Color.BLACK);
		infoBox.setOpacity(0.5);
		stackPane.getChildren().addAll(infoBox);
		StackPane.setAlignment(infoBox, Pos.CENTER);
		
		pane.getChildren().add(stackPane);
	}

	/**
	 * Method that lights up the category that the mouse is hovering over. When no categori is being hovered over, the wheel
	 * is in it's standard color (when mouse exits the box).
	 * @param box -
	 * @param mealType -
	 */
	
	private void addHoverActionWheel(Rectangle box, MealType mealType){
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
	
	public void changeScene(MealType type) {

		switch(type){
		case DAIRY:
			if(transitioning)
				return;

			createTransition(1000,new Runnable(){
				@Override
				public void run() {
					Button goBackBtn = new Button("Go back");;
					dairyPane.getChildren().addAll(goBackBtn);
					root.getChildren().remove(mainWheelPane);
					root.getChildren().add(dairyPane);
					
					try {
						
						Pane fxmlDairyPane = FXMLLoader.load(getClass().getResource("/gui/Category_Dairy.fxml"));
						dairyPane.getChildren().add(fxmlDairyPane);
						fxmlDairyPane.getChildren().addAll(goBackBtn);
						
					} catch (IOException e) { e.printStackTrace(); }

					goBackBtn.setOnMouseClicked(e -> {
						root.getChildren().remove(dairyPane);
						root.getChildren().add(mainWheelPane);				
						
						CheckBoxes.setbigListDairy();
						selectedIngredients.getItems().clear();
						selectedIngredients.getItems().addAll(ClientHandler.bigList); 
						
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

					try {

						Pane fxmlFruitPane = FXMLLoader.load(getClass().getResource("/gui/Category_Fruit.fxml"));
						fruitPane.getChildren().add(fxmlFruitPane);
						fxmlFruitPane.getChildren().addAll(goBackBtn);
						

					} catch (IOException e) {
						e.printStackTrace();

					}

					goBackBtn.setOnMouseClicked(e -> {
						root.getChildren().remove(fruitPane);
						root.getChildren().add(mainWheelPane);
						
						CheckBoxes.setbigListFruit();
						selectedIngredients.getItems().clear();
						selectedIngredients.getItems().addAll(ClientHandler.bigList);
 	
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
					try {

						Pane fxmlMeatPane = FXMLLoader.load(getClass().getResource("/gui/Category_Meat.fxml"));
						meatPane.getChildren().add(fxmlMeatPane);
						fxmlMeatPane.getChildren().addAll(goBackBtn);

					} catch (IOException e) {
						e.printStackTrace();

					}

					goBackBtn.setOnMouseClicked(e -> {
						root.getChildren().remove(meatPane);
						root.getChildren().add(mainWheelPane);
						
						CheckBoxes.setbigListMeat();
						selectedIngredients.getItems().clear();
						selectedIngredients.getItems().addAll(ClientHandler.bigList);
						
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
					try {

						Pane fxmlGrainsPane = FXMLLoader.load(getClass().getResource("/gui/Category_Grains.fxml"));
						spannPane.getChildren().add(fxmlGrainsPane);
						fxmlGrainsPane.getChildren().addAll(goBackBtn);

					} catch (IOException e) {
						e.printStackTrace();

					}

					goBackBtn.setOnMouseClicked(e -> {
						root.getChildren().remove(spannPane);
						root.getChildren().add(mainWheelPane);
						
						CheckBoxes.setbigListGrains();
						selectedIngredients.getItems().clear();
						selectedIngredients.getItems().addAll(ClientHandler.bigList);
						
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
					
					try {

						Pane fxmlVegetablesPane = FXMLLoader.load(getClass().getResource("/gui/Category_Vegetables.fxml"));
						vegetablePane.getChildren().add(fxmlVegetablesPane);
						fxmlVegetablesPane.getChildren().addAll(goBackBtn);

					} catch (IOException e) {
						e.printStackTrace();

					}

					goBackBtn.setOnMouseClicked(e -> {
						root.getChildren().remove(vegetablePane);
						root.getChildren().add(mainWheelPane);
						
						CheckBoxes.setbigListVeg();
						selectedIngredients.getItems().clear();
						selectedIngredients.getItems().addAll(ClientHandler.bigList);

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
	 * Method that closes the program
	 */
	
	private void closeProgram(){
		System.out.println("Closed properly");
		window.close();
	}

}
