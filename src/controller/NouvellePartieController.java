package controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

public class NouvellePartieController {

	@FXML
	private RadioButton _button;

	public Boolean buttonOK() {

		return _button.isSelected();
	}

	public Boolean buttonCancel() {
		return false;
	}

}