package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import utils.IStylizable;

public class VictoireController implements IStylizable {

	public void initialize() {

	}

	MenuController menuC = new MenuController(false);

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
		
	}

}
