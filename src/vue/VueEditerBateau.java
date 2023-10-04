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

public class VueEditerBateau extends Vue
{
	public ControleurFlotte controleur;
	
	protected static VueEditerBateau instance;
	public static VueEditerBateau getInstance() {if(null == instance) instance = new VueEditerBateau(); return instance;};
	private VueEditerBateau() {
		super("editer-bateau.fxml", VueEditerBateau.class,995,617);
	}
	
	public void activerControles()
	{
		super.activerControles();
		Button actionEnregistrer = (Button)lookup("#action-enregistrer-bateau");
		actionEnregistrer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Logger.logMsg(Logger.INFO, "Clic sur enregistrer bateau");
				controleur.reagirClicEnregistrerEditerBateau();
			}});
	}	
	
	public Bateau lireBateau() 
	{
		Logger.logMsg(Logger.INFO, "VueAjouterBateau.lireBateau()");
		Bateau bateau = new Bateau();
		
		TextField champsNom = (TextField)lookup("#nom-bateau");
		bateau.setNom(champsNom.getText());
		
		TextField champsValeur = (TextField)lookup("#valeur-bateau");
		double valeur = Double.parseDouble(champsValeur.getText()); // TODO : ajouter robustesse
		bateau.setValeur(valeur);
		
		TextField champsNoeuds = (TextField)lookup("#noeuds-bateau"); // TODO : ajouter robustesse
		int noeuds = Integer.parseInt(champsNoeuds.getText());
		bateau.setNoeud(noeuds);
		
		return bateau;
	}
	
	public void afficherBateau(Bateau bateau)
	{
		Logger.logMsg(Logger.INFO, "VueEditerBateau.afficherBateau()");
		TextField champsNom = (TextField)lookup("#nom-bateau");		
		TextField champsValeur = (TextField)lookup("#valeur-bateau");		
		TextField champsNoeuds = (TextField)lookup("#noeuds-bateau"); 
		champsNom.setText(bateau.getNom());
		champsValeur.setText(bateau.getValeur() + "");
		champsNoeuds.setText(bateau.getNoeud() + "");
	}
	
	public void afficherFlotte(Flotte flotte)
	{
		Logger.logMsg(Logger.INFO, "VueEditerBateau.afficherFlotte()");
		Label vueNomFlotte = (Label)lookup("#nom-flotte");
		vueNomFlotte.setText(flotte.getNom());
	}

}
