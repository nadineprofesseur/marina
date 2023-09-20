package vue;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurFlotte;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.Bateau;
import modele.Flotte;

public class VueAjouterBateau extends Vue
{
	public ControleurFlotte controleur;
	
	protected static VueAjouterBateau instance;
	public static VueAjouterBateau getInstance() {if(null == instance) instance = new VueAjouterBateau(); return instance;};
	private VueAjouterBateau() {
		super("ajouter-bateau.fxml", VueAjouterBateau.class,995,617);
	}
	
	public void activerControles()
	{
		super.activerControles();
		Button actionEnregistrer = (Button)lookup("#action-enregistrer-bateau");
		actionEnregistrer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Logger.logMsg(Logger.INFO, "Clic sur enregistrer bateau");
				controleur.reagirClicEnregistrerAjoutBateau();
			}});
	}	
	
	public Bateau lireBateau() 
	{
		Logger.logMsg(Logger.INFO, "VueAjouterBateau.lireBateau()");
		Bateau bateau = new Bateau();
		TextField champsNom = (TextField)lookup("#nom-bateau");
		bateau.setNom(champsNom.getText());
		
		return bateau;
	}
	
	public void afficherFlotte(Flotte flotte)
	{
		Logger.logMsg(Logger.INFO, "VueAjouterBateau.afficherFlotte()");
		Label vueNomFlotte = (Label)lookup("#nom-flotte");
		vueNomFlotte.setText(flotte.getNom());
	}
	

}
