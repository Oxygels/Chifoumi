package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import utils.IStylizable;

public class ContactController implements IStylizable {
	@FXML
	private Label _lContact;
	@FXML
	private Label _lRegles;
	@FXML
	private Label _lPierre;
	@FXML
	private Label _lFeuille;
	@FXML
	private Label _lCiseaux;
	@FXML
	private Label _lSupp;
	@FXML
	private Label _lNum;

	@FXML
	private void initalize() {

	}

	public void updateStyle() {
		_lContact.getScene();
		switch (Main.appOption.getFontSize()) {
		case Moyen: {
			_lContact.setStyle("-fx-font-size: 50px;");
			_lRegles.setStyle("-fx-font-size: 50px;");
			_lSupp.setStyle("-fx-font-size: 40px;");
			_lNum.setStyle("-fx-font-size: 40px;");
			_lPierre.setStyle("-fx-font-size: 30px;");
			_lFeuille.setStyle("-fx-font-size: 30px;");
			_lCiseaux.setStyle("-fx-font-size: 30px;");
			break;
		}
		case Petit: {
			_lContact.setStyle("-fx-font-size: 40px;");
			_lRegles.setStyle("-fx-font-size: 40px;");
			_lSupp.setStyle("-fx-font-size: 30px;");
			_lNum.setStyle("-fx-font-size: 30px;");
			_lPierre.setStyle("-fx-font-size: 25px;");
			_lFeuille.setStyle("-fx-font-size: 25px;");
			_lCiseaux.setStyle("-fx-font-size: 25px;");
			break;
		}
		default: {
			_lContact.setStyle("-fx-font-size: 70px;");
			_lRegles.setStyle("-fx-font-size: 70px;");
			_lSupp.setStyle("-fx-font-size: 50px;");
			_lNum.setStyle("-fx-font-size: 50px;");
			_lPierre.setStyle("-fx-font-size: 35px;");
			_lFeuille.setStyle("-fx-font-size: 35px;");
			_lCiseaux.setStyle("-fx-font-size: 35px;");
			break;
		}

		}
	}
}