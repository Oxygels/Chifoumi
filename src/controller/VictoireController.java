package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utils.ApplicationOption;
import utils.IStylizable;

public class VictoireController implements IStylizable {

	@FXML
	private Label _lVictoire;

	@FXML
	private void initialize() {

	}

	MenuController menuC = new MenuController();

	@FXML
	public void newGame(ActionEvent e) {
		menuC.newGame(e);

	}

	@FXML
	public void optionsMenu(ActionEvent e) {
		menuC.optionsMenuWithUpdate(e, this);
	}

	@FXML
	public void contactsMenu(ActionEvent e) {
		menuC.contactsMenu(e);

	}

	@FXML
	public void quitter(ActionEvent e) {
		menuC.quitter(e);
	}

	@Override
	public void updateStyle() {
		ApplicationOption options = Main.appOption;
		switch (options.getFontSize()) {
		case Petit:
			_lVictoire.setStyle("-fx-font-size: 100px");
			break;
		case Moyen:
			_lVictoire.setStyle("-fx-font-size: 120px");
			break;
		default:
			_lVictoire.setStyle("-fx-font-size: 150px");
			break;
		}
		Stage stage = ((Stage) _lVictoire.getScene().getWindow());
		boolean isFull = options.isFullscreen();
		stage.setFullScreen(isFull);
		if (!isFull) {
			stage.setHeight(options.getResolutionH());
			stage.setWidth(options.getResolutionW());
		}

	}

}
