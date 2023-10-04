
import architecture.Controleur;
import architecture.Fenetre;
import donnee.BateauDAO;
import donnee.FlotteDAO;
import modele.Bateau;
import modele.Flotte;
import vue.VueAjouterBateau;
import vue.VueFlotte;
import vue.VueMarina;

public class App {

	public static void main(String[] parametres) {
		
		
		BateauDAO bateauDAO = new BateauDAO();
		//bateauDAO.listerBateauxParFlotte(1);
		//flotteDAO.detaillerFlotte(1);
		Bateau fauxBateau = new Bateau();
		fauxBateau.setNom("faux");
		fauxBateau.setValeur(4);
		fauxBateau.setNoeud(25);
		fauxBateau.setIdFlotte(1);
		bateauDAO.ajouterBateau(fauxBateau);
		
		//Controleur.choisirVuePrincipale(VueAjouterBateau.class);
		//Controleur.choisirVuePrincipale(VueFlotte.class);
		
		
		//Controleur.choisirVuePrincipale(VueMarina.class);
		//Fenetre.launch(Fenetre.class, parametres);	
	}

}
