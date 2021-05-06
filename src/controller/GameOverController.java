package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class GameOverController implements Initializable {

	MenuController menuC = new MenuController(false);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	public void newGame(ActionEvent e) {
		menuC.newGame(e);
	}

	@FXML
	public void optionsMenu(ActionEvent e) {
		menuC.optionsMenu(e);
	}

	@FXML
	public void contactsMenu(ActionEvent e) {
		menuC.contactsMenu(e);

	}

	@FXML
	public void quitter(ActionEvent e) {
		Scene node = ((Node) (e.getSource())).getScene();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vueMenu.fxml"));
			VBox root = fxmlLoader.load();
			node.setRoot(root);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
