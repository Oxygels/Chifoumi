package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.GestionJeu;
import utils.ApplicationOption;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/vueMenu.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setHeight(appOption.getResolutionH());
			primaryStage.setWidth(appOption.getResolutionW());
			primaryStage.setTitle("Pierre Feuille Ciseaux");
			primaryStage.setResizable(false); // Modifier via la résolution
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ApplicationOption appOption = new ApplicationOption();
	public static GestionJeu jeu = new GestionJeu();
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
