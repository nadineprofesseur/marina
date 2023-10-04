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
				Bateau bateau = lireBateau();
				System.out.println("Le bateau lu est " + bateau.getNom() + " avec " + bateau.getNoeud() + " noeuds");
				//controleur.reagirClicEnregistrerAjoutBateau();
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
		//System.out.println(noeuds);	
		bateau.setNoeud(noeuds);
		
		return bateau;
	}
	
	/*
                              <TextField id="nom-bateau" fx:id="nomBateau" GridPane.columnIndex="1" />
                              <TextField id="valeur-bateau" fx:id="valeurBateau" GridPane.columnIndex="1" GridPane.rowIndex="1" />
                              <TextField id="noeuds-bateau" fx:id="noeudsBateau" GridPane.columnIndex="1" GridPane.rowIndex="2" />
	 * */
	
	public void afficherFlotte(Flotte flotte)
	{
		Logger.logMsg(Logger.INFO, "VueAjouterBateau.afficherFlotte()");
		Label vueNomFlotte = (Label)lookup("#nom-flotte");
		vueNomFlotte.setText(flotte.getNom());
	}
	

}
