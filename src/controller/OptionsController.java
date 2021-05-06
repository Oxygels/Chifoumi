package controller;

import java.util.ArrayList;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import utils.ApplicationOption;
import utils.BackgroundStyle;
import utils.FontStyle;

public class OptionsController {

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
	private void initialize() {
		setContent();
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
}