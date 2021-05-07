package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import utils.ApplicationOption;
import utils.IStylizable;

public class NouvellePartieController implements IStylizable {

	@FXML
	private RadioButton _button;

	@FXML
	private Label _lNouvelle;
	@FXML
	private Label _lPartie;
	@FXML
	private Label _lJoueur;
	@FXML
	private Label _lVS;
	@FXML
	private Label _lOrdi;

	public Boolean buttonOK() {

		return _button.isSelected();
	}

	public Boolean buttonCancel() {
		return false;
	}

	@Override
	public void updateStyle() {
		ApplicationOption options = Main.appOption;
		switch (options.getFontSize()) {
		case Petit:
			_lNouvelle.setStyle("-fx-font-size: 45px");
			_lPartie.setStyle("-fx-font-size: 45px");
			_lPartie.setStyle("-fx-font-size: 30px");
			_lPartie.setStyle("-fx-font-size: 30px");
			_lPartie.setStyle("-fx-font-size: 30px");
			break;
		case Moyen:
			_lNouvelle.setStyle("-fx-font-size: 50px");
			_lPartie.setStyle("-fx-font-size: 50px");
			_lPartie.setStyle("-fx-font-size: 35px");
			_lPartie.setStyle("-fx-font-size: 35px");
			_lPartie.setStyle("-fx-font-size: 35px");
			break;
		default:
			_lNouvelle.setStyle("-fx-font-size: 55px");
			_lPartie.setStyle("-fx-font-size: 55px");
			_lPartie.setStyle("-fx-font-size: 40px");
			_lPartie.setStyle("-fx-font-size: 40px");
			_lPartie.setStyle("-fx-font-size: 40px");
			break;
		}

	}

}