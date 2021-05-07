package controller;

import java.util.ArrayList;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import utils.ApplicationOption;
import utils.BackgroundStyle;
import utils.FontStyle;
import utils.IStylizable;

public class OptionsController implements IStylizable {

	@FXML
	private TextArea _taPseudo;
	@FXML
	private ChoiceBox<String> _cbResolution;
	@FXML
	private CheckBox _cbFullscreen;
	@FXML
	private ChoiceBox<BackgroundStyle> _cbBgStyle;
	@FXML
	private ChoiceBox<FontStyle> _cbTextSize;
	@FXML
	private ChoiceBox<Integer> _cbMaxWRound;

	@FXML
	private Label _lOptions;
	@FXML
	private Label _lPseudo;
	@FXML
	private Label _lResolution;
	@FXML
	private Label _lFullscreen;
	@FXML
	private Label _lBackground;
	@FXML
	private Label _lFontSize;
	@FXML
	private Label _lMaxWRound;

	@FXML
	private void initialize() {
		setContent();
		_cbTextSize.setOnAction(e -> {
			Main.appOption.setFontSize(_cbTextSize.getValue());
			updateStyle();
		});
	}

	public void setContent() {
		ApplicationOption options = Main.appOption;
		_cbResolution.getItems().addAll("1280 x 720", "1366 x 768", "1600 x 900");
		_cbResolution.setValue(options.getResolutionW() + " x " + options.getResolutionH());

		_cbBgStyle.getItems().addAll(BackgroundStyle.Zen, BackgroundStyle.Asiatique, BackgroundStyle.Solitude);
		_cbBgStyle.setValue(options.getBgStyle());

		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 5; i <= 20; i++) {
			arr.add(i);
		}
		_cbMaxWRound.getItems().addAll(arr);
		_cbMaxWRound.setValue(options.getMaxWRound());

		_taPseudo.setText(options.getPseudo());

		_cbFullscreen.setSelected(options.isFullscreen());

		_cbTextSize.getItems().addAll(FontStyle.Grand, FontStyle.Moyen, FontStyle.Petit);
		_cbTextSize.setValue(options.getFontSize());
	}

	public boolean buttonOk() {
		return true;
	}

	public boolean buttonCancel() {
		return false;
	}

	public void actionbuttonOk() {
		ApplicationOption options = Main.appOption;
		options.setBgStyle(_cbBgStyle.getValue());
		options.setMaxWRound(_cbMaxWRound.getValue());
		options.setFontSize(_cbTextSize.getValue());
		options.setFullscreen(_cbFullscreen.isSelected());
		options.setPseudo(_taPseudo.getText());
		String[] resolution = _cbResolution.getValue().split(" ");
		options.setResolutionH(Integer.parseInt(resolution[2]));
		options.setResolutionW(Integer.parseInt(resolution[0]));
	}

	public void actionbuttonCancel() {

	}

	@Override
	public void updateStyle() {
		ApplicationOption options = Main.appOption;
		switch (options.getFontSize()) {
		case Petit:
			_lOptions.setStyle("-fx-font-size: 55px;");
			_lFontSize.setStyle("-fx-font-size: 30px;");
			_lFullscreen.setStyle("-fx-font-size: 30px;");
			_lMaxWRound.setStyle("-fx-font-size: 30px;");
			_lBackground.setStyle("-fx-font-size: 30px;");
			_lPseudo.setStyle("-fx-font-size: 30px;");
			_lResolution.setStyle("-fx-font-size: 30px;");
			break;
		case Moyen:
			_lOptions.setStyle("-fx-font-size: 65px;");
			_lFontSize.setStyle("-fx-font-size: 35px;");
			_lFullscreen.setStyle("-fx-font-size: 35px;");
			_lMaxWRound.setStyle("-fx-font-size: 35px;");
			_lBackground.setStyle("-fx-font-size: 35px;");
			_lPseudo.setStyle("-fx-font-size: 35px;");
			_lResolution.setStyle("-fx-font-size: 35px;");
			break;
		default:
			_lOptions.setStyle("-fx-font-size: 75px;");
			_lFontSize.setStyle("-fx-font-size: 40px;");
			_lFullscreen.setStyle("-fx-font-size: 40px;");
			_lMaxWRound.setStyle("-fx-font-size: 40px;");
			_lBackground.setStyle("-fx-font-size: 40px;");
			_lPseudo.setStyle("-fx-font-size: 40px;");
			_lResolution.setStyle("-fx-font-size: 40px;");
			break;
		}
	}
}