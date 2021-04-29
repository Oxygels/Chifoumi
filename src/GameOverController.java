import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class GameOverController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	@FXML public void newGame(ActionEvent e)
	{
		System.out.println("Nouvelle partie");
	}
	
	@FXML public void optionsMenu(ActionEvent e)
	{
		System.out.println("Options Menu");
	}

	
	@FXML public void contactesMenu(ActionEvent e)
	{
		System.out.println("Contactes Menu");
	}

	@FXML public void quitter(ActionEvent e)
	{
		System.exit(0);
	}
	
}
