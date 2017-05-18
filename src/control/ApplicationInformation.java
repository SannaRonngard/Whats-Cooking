package control;

import javafx.scene.control.Label;

public class ApplicationInformation {
	
	public static void addApplicationInformation(Label label) {
		Label applicationInformation = new Label(Words); 
		applicationInformation.setWrapText(true);
		
	}
	
	public static void words(String string) {
		String Words = 
				"Welome To Whats Cooking\n"
				+ "\n"
				+ "This application is supposed to help our users to be one step ahead\n"
				+ "when it comes to our daily rutines and make life a little bit simpler";
		
	}

}
