package controller;

import java.io.File;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.GestionJeu;
import utils.ApplicationOption;
import utils.BackgroundStyle;
import utils.IStylizable;

public class JeuController implements IStylizable {
	private MenuController _menuC;
	private GestionJeu _jeu;

	// ================ Gridpane
	@FXML
	private GridPane _gridRoot;

	// ================ Button
	@FXML
	private Button _bPierre;
	@FXML
	private Button _bCiseaux;
	@FXML
	private Button _bFeuille;

	// ================ ImageView
	@FXML
	private ImageView _imgvJoueur;
	@FXML
	private ImageView _imgvOrdi;

	// ================ Label
	@FXML
	private Label _lResultat;
	@FXML
	private Label _lScoreJ;
	@FXML
	private Label _lScoreO;
	@FXML
	private Label _lPseudo;
	@FXML
	private Label _lOrdi;

	// ================ Image
	@FXML
	private Image _imgCiseaux;
	@FXML
	private Image _imgPierreJ;
	@FXML
	private Image _imgFeuilleJ;

	@FXML
	private Image _imgPierreO;
	@FXML
	private Image _imgFeuilleO;

	private BackgroundStyle _bgStyle;

	public JeuController() {
		ApplicationOption options = Main.appOption;
		_menuC = new MenuController(false);
		_jeu = new GestionJeu();
		_jeu.set_maxPointsGagnants(options.getMaxWRound());

		_imgCiseaux = new Image("file:img/icon/ciseaux.png", true);
		_imgPierreJ = new Image("file:img/icon/pierreJ.png", true);
		_imgPierreO = new Image("file:img/icon/pierreO.png", true);
		_imgFeuilleJ = new Image("file:img/icon/feuilleJ.png", true);
		_imgFeuilleO = new Image("file:img/icon/feuilleO.png", true);

		
		_bgStyle = options.getBgStyle();
	}
	
	@FXML private void initialize() {
		ApplicationOption options = Main.appOption;
		int roll = _jeu.get_alea().nextInt(3);
		switch (options.getBgStyle()) {
		case Asiatique:
			_gridRoot.setStyle("-fx-background-image: url(\"file:img/background/as" + roll + ".jpg\");");
			break;
		case Solitude:
			_gridRoot.setStyle("-fx-background-image: url(\"file:img/background/sol" + roll + ".jpg\");");
			break;
		default:
			_gridRoot.setStyle("-fx-background-image: url(\"file:img/background/zen" + roll + ".jpg\");");
			break;
		}
	}

	@FXML
	private void choixBouton(ActionEvent e) {
		Button receiver = (Button) e.getSource();
		if (receiver == _bPierre) {
			_imgvJoueur.setImage(_imgPierreJ);
			_jeu.set_nombreJoueur(0);
		} else if (receiver == _bCiseaux) {
			_imgvJoueur.setImage(_imgCiseaux);
			_jeu.set_nombreJoueur(1);
		} else {
			_imgvJoueur.setImage(_imgFeuilleJ);
			_jeu.set_nombreJoueur(2);
		}

		_jeu.ChoixOrdinateur();

		switch (_jeu.get_nombreOrdi()) {
		case 0:
			_imgvOrdi.setImage(_imgPierreO);
			break;
		case 1:
			_imgvOrdi.setImage(_imgCiseaux);
			break;
		case 2:
			_imgvOrdi.setImage(_imgFeuilleO);
			break;
		}

		int res = _jeu.CaculerPoints();
		updateLabel(res);

		_lScoreJ.setText(String.valueOf(_jeu.get_pointsJoueur()));
		_lScoreO.setText(String.valueOf(_jeu.get_pointsOrdi()));
		verifGagnant(e);

	}

	private void updateLabel(int res) {
		switch (res) {
		case -1:
			BackgroundFill colorCpu = new BackgroundFill(Color.rgb(65, 114, 196), null, null);
			_lResultat.setBackground(new Background(colorCpu));
			_lResultat.setText("L'ordinateur   gagne   la   manche,   tenez   bon   !");
			break;
		case 0:
			BackgroundFill colorEq = new BackgroundFill(Color.BLUEVIOLET, null, null);
			_lResultat.setBackground(new Background(colorEq));
			_lResultat.setText("Egalite   ! La   tension   est   a   son   comble   !");
			break;
		case 1:
			BackgroundFill colorJ = new BackgroundFill(Color.RED, null, null);
			_lResultat.setBackground(new Background(colorJ));
			_lResultat.setText("Vous   gagnez   la   manche   !   La   chance   vous   sourit");
			break;
		}
	}

	private void verifGagnant(ActionEvent e) {
		if (_jeu.Gagnant()) {
			Scene scene = (Scene) ((Button) e.getSource()).getScene();
			try {
				Parent root;

				if (_jeu.JoueurGagne()) {
					root = FXMLLoader.load(getClass().getResource("/view/vueVictoire.fxml"));

				} else {
					root = FXMLLoader.load(getClass().getResource("/view/vueGameOver.fxml"));
				}
				scene.setRoot(root);
			} catch (Exception except) {
				except.printStackTrace();
			}

		}
	}

	// ================ Menu
	@FXML
	private void nouvPartieHandler(ActionEvent e) {
		_menuC.newGame(e);
	}

	@FXML
	private void optionsHandler(ActionEvent e) {
		_menuC.optionsMenuWithUpdate(e, this);
	}

	@FXML
	private void contactsHandler(ActionEvent e) {
		_menuC.contactsMenu(e);
	}

	@FXML
	private void exitHandler(ActionEvent e) {
		_menuC.quitter(e);
	}

	// ================ Exposed methods
	public void setPseudo(String pseudo) {
		_lPseudo.setText(pseudo);
	}

	public void setResolution(int height, int width, Stage stage) {
		stage.setHeight(height);
		stage.setWidth(width);
	}

	public void setFontSize(int size) {

	}

	public void setFullScreen(Stage stage, boolean set) {
		stage.setFullScreen(set);
	}

	public void setBackground(BackgroundStyle type) {
		_bgStyle = type;
	}

	@Override
	public void updateStyle() {
		ApplicationOption options = Main.appOption;
		_lPseudo.setText(options.getPseudo());
		// Care labels aren't visible anymore
		((Stage) _lPseudo.getScene().getWindow()).setFullScreen(options.isFullscreen());

		switch (options.getFontSize()) {
		case Moyen:
			_lPseudo.setStyle("-fx-font-size: 35px;");
			_lOrdi.setStyle("-fx-font-size: 35px;");
			_lResultat.setStyle("-fx-font-size: 35px;");
			_lScoreJ.setStyle("-fx-font-size: 80px;");
			_lScoreO.setStyle("-fx-font-size: 80px;");
			break;

		case Petit:
			_lPseudo.setStyle("-fx-font-size: 30px;");
			_lOrdi.setStyle("-fx-font-size: 30px;");
			_lResultat.setStyle("-fx-font-size: 30px;");
			_lScoreJ.setStyle("-fx-font-size: 60px;");
			_lScoreO.setStyle("-fx-font-size: 60px;");
			break;

		default:
			_lPseudo.setStyle("-fx-font-size: 40px;");
			_lOrdi.setStyle("-fx-font-size: 40px;");
			_lResultat.setStyle("-fx-font-size: 40px;");
			_lScoreJ.setStyle("-fx-font-size: 100px;");
			_lScoreO.setStyle("-fx-font-size: 100px;");
			break;

		}
		// TODO: Rajouter alert changement de nbre de manche
		if (_jeu.get_maxPointsGagnants() != options.getMaxWRound()) {
			Alert dialog = new Alert(AlertType.CONFIRMATION);
			dialog.setHeaderText("Changement important détecté");
			dialog.setContentText(
					"Le nombre de manches maximales a été modifié, le changement sera effectué à  la prochaine partie.\n"
							+ "Annuler ignorera uniquement ce changement, les autres modifications seront appliquées.");
			ButtonType cancelButton = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
			dialog.showAndWait().ifPresent(button -> {
				if (button == ButtonType.CANCEL)
					options.setMaxWRound(_jeu.get_maxPointsGagnants());
			});
		}

		if (options.getBgStyle() != _bgStyle) {
			int roll = _jeu.get_alea().nextInt(3);
			switch (options.getBgStyle()) {
			case Asiatique:
				_gridRoot.setStyle("-fx-background-image: url(\"file:img/background/as" + roll + ".jpg\");");
				break;
			case Solitude:
				_gridRoot.setStyle("-fx-background-image: url(\"file:img/background/sol" + roll + ".jpg\");");
				break;
			default:
				_gridRoot.setStyle("-fx-background-image: url(\"file:img/background/zen" + roll + ".jpg\");");
				break;
			}
		}

	}

}
