package controller;
import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MenuController  {

	
	private boolean resizable = true;
	
	
	 public MenuController() {
		// TODO Auto-generated constructor stub
	}
	
	public MenuController(boolean resize)
	{
		resizable=resize;
	}
	
	
	/*@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}*/
	
	@FXML public void newGame(ActionEvent e)
	{
		
		 Scene node = ((Node) (e.getSource())).getScene();
		 
		 // faire une boite de dialogue
		 
		 
		try {
			Dialog<Boolean> dialog = new Dialog<>();
			 dialog.setTitle("CONFIRMER JEU");
		
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/vueNouvellePartie.fxml"));
			 GridPane grille;
			 NouvellePartieController nvp = new NouvellePartieController();
			 loader.setController(nvp);
			grille = loader.load();
			dialog.getDialogPane().setContent(grille); // on lui dit que ce qu'il ya dedans c'est ta grille
			ButtonType buttonTypeOk = new ButtonType("OK",ButtonData.OK_DONE);
			ButtonType buttonTypeAnnuler = new ButtonType("Annuler",ButtonData.CANCEL_CLOSE);
			dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk,buttonTypeAnnuler);
			
			dialog.setResultConverter(new Callback<ButtonType,Boolean>() {  
				
				@Override
				public Boolean call(ButtonType b) {
					if (b == buttonTypeOk) {
						return nvp.buttonOK();
						}
					return nvp.buttonCancel();
				}
				
				
			});
			
			Optional<Boolean> result = dialog.showAndWait();
			
			if(result.get() == true)
			{
				 try {
			           // JeuController Jeu=new JeuController();
			            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../view/vueJeu.fxml"));
			            GridPane root = fxmlLoader.load();
			            node.setRoot(root);
			            if(resizable)
			            {
			            	((Stage)node.getWindow()).setHeight(720);
			            	((Stage)node.getWindow()).setWidth(1280);
			            }
			        } catch(Exception ex) {
			            ex.printStackTrace();
			        }
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		// try catch
	}
	
	
	
	
	@FXML public void optionsMenu(ActionEvent e)
	{
		

		GridPane grille;
		try {
			Dialog<String> dialog = new Dialog<>(); // Dialog<String> veut dire que ça renvoi un string quand ca se ferme
			dialog.setTitle("OPTIONS DE JEU");
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/vueOptions.fxml"));
			
			grille = loader.load();
			dialog.getDialogPane().setContent(grille); // on lui dit que ce qu'il ya dedans c'est ta grille
			ButtonType buttonTypeOk = new ButtonType("OK",ButtonData.OK_DONE);
			ButtonType buttonTypeAnnuler = new ButtonType("Annuler",ButtonData.CANCEL_CLOSE);
			dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk,buttonTypeAnnuler);
			dialog.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		
	}

	
	@FXML public void contactesMenu(ActionEvent e)
	{
		
		
		GridPane grille;
		try {
			Dialog<Integer> dialog = new Dialog<>(); // Dialog<String> veut dire que ça renvoi un int quand ca se ferme
			dialog.setTitle("CONACT DE SUPPORT");
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/vueContact.fxml"));
			
			grille = loader.load();
			dialog.getDialogPane().setContent(grille); // on lui dit que ce qu'il ya dedans c'est ta grille
			ButtonType buttonTypeOkAnnuler = new ButtonType("OK",ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(buttonTypeOkAnnuler);
			dialog.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		
	}

	@FXML public void quitter(ActionEvent e)
	{
		System.exit(0);
	}
}
