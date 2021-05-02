package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

public class NouvellePartieController {

	@FXML private RadioButton _button;
	
	@FXML private boolean estSelect=false;
	
	@FXML public void selection(ActionEvent e)
	{
		if(_button.isSelected())
		{
			estSelect = true;
			
		}
		else {
			estSelect=false;
			
		}
	}
	
	public Boolean buttonOK()
	{
		
		return estSelect;
	}
	
	public Boolean buttonCancel()
	{
		return false;
	}
	
}