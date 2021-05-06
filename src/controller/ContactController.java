package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ContactController {
	@FXML
	private Label _lContact;
	@FXML
	private Label _lSupp;
	@FXML
	private Label _lNum;

	@FXML
	private void initalize() {

	}

	public void setStyle() {
		switch (Main.appOption.getFontSize()) {
		case Grand: {
			_lContact.setStyle("-fx-font-size: 70px;");
			_lSupp.setStyle("-fx-font-size: 50px;");
			_lNum.setStyle("-fx-font-size: 50px;");
			break;
		}
		case Moyen: {
			_lContact.setStyle("-fx-font-size: 50px;");
			_lSupp.setStyle("-fx-font-size: 40px;");
			_lNum.setStyle("-fx-font-size: 40px;");
			break;
		}
		case Petit: {
			_lContact.setStyle("-fx-font-size: 40px;");
			_lSupp.setStyle("-fx-font-size: 30px;");
			_lNum.setStyle("-fx-font-size: 30px;");
			break;
		}
		default: {
			_lContact.setStyle("-fx-font-size: 40px;");
			_lSupp.setStyle("-fx-font-size: 30px;");
			_lNum.setStyle("-fx-font-size: 30px;");
			break;
		}

		}
	}
}