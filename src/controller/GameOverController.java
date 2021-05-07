package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utils.ApplicationOption;
import utils.IStylizable;

public class GameOverController implements IStylizable {

	@FXML
	private Label _lGameOver;
	MenuController menuC = new MenuController();

	@FXML
	private void initialize() {

	}

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
			_lGameOver.setStyle("-fx-font-size: 100px");
			break;
		case Moyen:
			_lGameOver.setStyle("-fx-font-size: 120px");
			break;
		default:
			_lGameOver.setStyle("-fx-font-size: 150px");
			break;
		}
		Stage stage = ((Stage) _lGameOver.getScene().getWindow());
		boolean isFull = options.isFullscreen();
		stage.setFullScreen(isFull);
		if (!isFull) {
			stage.setHeight(options.getResolutionH());
			stage.setWidth(options.getResolutionW());
		}
	}
}
