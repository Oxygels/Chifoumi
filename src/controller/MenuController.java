package controller;

import java.io.IOException;
import java.util.Optional;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import utils.IStylizable;

public class MenuController implements IStylizable {

	private boolean resizable = true;

	public MenuController() {

	}

	public MenuController(boolean resize) {
		resizable = resize;
	}

	@FXML
	public void newGame(ActionEvent e) {
		Scene scene = ((Node) (e.getSource())).getScene();

		try {
			Dialog<Boolean> dialog = new Dialog<>();
			dialog.setTitle("Nouvelle Partie");

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/vueNouvellePartie.fxml"));
			GridPane grille;
			NouvellePartieController nvp = new NouvellePartieController();
			loader.setController(nvp);
			grille = loader.load();
			dialog.getDialogPane().setContent(grille);
			ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
			ButtonType buttonTypeAnnuler = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
			dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, buttonTypeAnnuler);

			dialog.setResultConverter(new Callback<ButtonType, Boolean>() {

				@Override
				public Boolean call(ButtonType b) {
					if (b == buttonTypeOk) {
						return nvp.buttonOK();
					}
					return nvp.buttonCancel();
				}
			});

			Optional<Boolean> result = dialog.showAndWait();

			if (result.get() == true) {
				try {
					// JeuController Jeu=new JeuController();
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vueJeu.fxml"));
					JeuController controll = new JeuController();
					fxmlLoader.setController(controll);
					GridPane root = fxmlLoader.load();
					scene.setRoot(root);
					controll.updateStyle();
					if (resizable && !Main.appOption.isFullscreen()) {
						((Stage) scene.getWindow()).setHeight(Main.appOption.getResolutionH());
						((Stage) scene.getWindow()).setWidth(Main.appOption.getResolutionW());
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	private void optionsMenu(ActionEvent e) {
		optionsMenuWithUpdate(e, this);
	}

	public void optionsMenuWithUpdate(ActionEvent e, IStylizable style) {
		GridPane grille;
		try {
			Dialog<Boolean> dialog = new Dialog<>();
			dialog.setTitle("Options");

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/vueOptions.fxml"));
			OptionsController ctrl = new OptionsController();
			loader.setController(ctrl);
			grille = loader.load();
			dialog.getDialogPane().setContent(grille);
			ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
			ButtonType buttonTypeAnnuler = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
			dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, buttonTypeAnnuler);

			dialog.setResultConverter(new Callback<ButtonType, Boolean>() {

				@Override
				public Boolean call(ButtonType b) {
					if (b == buttonTypeOk) {
						return ctrl.buttonOk();
					}
					return ctrl.buttonCancel();
				}
			});
			Optional<Boolean> result = dialog.showAndWait();

			if (result.get() == true) {
				try {
					ctrl.actionbuttonOk();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else
				ctrl.actionbuttonCancel();

		} catch (IOException e1)

		{
			e1.printStackTrace();
		}
		style.updateStyle();
	}

	@FXML
	public void contactsMenu(ActionEvent e) {
		GridPane grille;
		try {
			Dialog<ButtonType> dialog = new Dialog<>();
			dialog.setTitle("Contacts");

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/vueContact.fxml"));
			ContactController ctrl = new ContactController();
			loader.setController(ctrl);
			grille = loader.load();
			ctrl.updateStyle();
			dialog.getDialogPane().setContent(grille);
			ButtonType buttonTypeOkAnnuler = new ButtonType("OK", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(buttonTypeOkAnnuler);

			dialog.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	public void quitter(ActionEvent e) {
		Alert dialog = new Alert(AlertType.CONFIRMATION);
		dialog.setHeaderText("Quitter le jeu");
		dialog.setContentText("Voulez-vous vraiment quitter le jeu ?\nToute progression ne sera pas sauvegardée");
		ButtonType cancelButton = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
		dialog.showAndWait().filter(button -> button == ButtonType.OK).ifPresent(response -> System.exit(0));
	}

	@Override
	public void updateStyle() {

	}
}
