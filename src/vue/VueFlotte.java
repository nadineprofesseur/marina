package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurFlotte;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Bateau;
import modele.Flotte;

public class VueFlotte extends Vue
{
	protected static VueFlotte instance = null;
	public static VueFlotte getInstance() 
	{
		if(null == instance) instance = new VueFlotte();
		return instance;
	}
	
	public ControleurFlotte controleur = null;
	public ControleurFlotte getControleur() {return this.controleur;}
	
	private VueFlotte() {
		super("flotte.fxml", VueFlotte.class,995,617);
		super.controleur = this.controleur = new ControleurFlotte();
	}

	public void activerControles()
	{
		super.activerControles();
		Button actionAjouterBateau = (Button)lookup("#action-ajouter-bateau");
		
		actionAjouterBateau.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				controleur.reagirClicAjouterBateau();
			}});
	}	

	public void afficherFlotte(Flotte flotte)
	{
		Logger.logMsg(Logger.INFO, "VueFlotte.afficherFlotte()");
		Label vueTitreFlotte = (Label)lookup("#flotte-titre");
		vueTitreFlotte.setText(flotte.getNom());
	}
	
	public void afficherBateaux(List<Bateau> bateaux) 
	{
		Logger.logMsg(Logger.INFO, "VueFlotte.afficherBateau()");
		VBox vueBateaux = (VBox)lookup("#liste-bateaux");
		vueBateaux.getChildren().clear();
		Button action;
		
		for(Bateau bateau:bateaux)
		{			
			Logger.logMsg(Logger.INFO, "Bateau : " + bateau.getNom());
			HBox vueBateau = new HBox();
			vueBateau.getStyleClass().add("bateau");
			vueBateau.setPadding(new Insets(15, 12, 15, 12));
			vueBateau.setSpacing(10);
			
			Label vueTitre = new Label(bateau.getNom());
			vueTitre.getStyleClass().add("titre");
			vueTitre.setStyle("-fx-font: 24 arial;");
			vueBateau.getChildren().add(vueTitre);
			
			action = new Button("�diter");
			action.setId(bateau.getId()+"");
			action.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Button source = (Button)e.getSource();
					Logger.logMsg(Logger.INFO, "Clic sur le bateau " + source.getId());		
					controleur.reagirClicEditerBateau(Integer.parseInt(source.getId()));
				}});			
			vueBateau.getChildren().add(action);
			
			vueBateaux.getChildren().add(vueBateau);
		}
	}

	
	
}
