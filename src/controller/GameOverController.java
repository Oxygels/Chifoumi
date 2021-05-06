package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import utils.IStylizable;

public class GameOverController implements IStylizable {

	MenuController menuC = new MenuController(false);

	public void initialize() {

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
		// TODO Auto-generated method stub
		
	}

}
