
import architecture.Controleur;
import architecture.Fenetre;
import donnee.BateauDAO;
import donnee.FlotteDAO;
import vue.VueAjouterBateau;
import vue.VueFlotte;
import vue.VueMarina;

public class App {

	public static void main(String[] parametres) {
		//BateauDAO bateauDAO = new BateauDAO();
		//bateauDAO.listerBateauxParFlotte(1);
		//FlotteDAO flotteDAO = new FlotteDAO();
		//flotteDAO.detaillerFlotte(1);
		//Controleur.choisirVuePrincipale(VueAjouterBateau.class);
		//Controleur.choisirVuePrincipale(VueFlotte.class);
		Controleur.choisirVuePrincipale(VueMarina.class);
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
