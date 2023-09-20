
import architecture.Controleur;
import architecture.Fenetre;
import donnee.BateauDAO;
import donnee.FlotteDAO;
import modele.Flotte;
import vue.VueAjouterBateau;
import vue.VueFlotte;
import vue.VueMarina;

public class App {

	public static void main(String[] parametres) {
		
		FlotteDAO flotteDAO = new FlotteDAO();
		Flotte flotte3 = flotteDAO.detaillerFlotte(3);
		System.out.println("Flotte : " + flotte3.getNom());
		
		//BateauDAO bateauDAO = new BateauDAO();
		//bateauDAO.listerBateauxParFlotte(1);
		//flotteDAO.detaillerFlotte(1);
		//Controleur.choisirVuePrincipale(VueAjouterBateau.class);
		//Controleur.choisirVuePrincipale(VueFlotte.class);
		//Controleur.choisirVuePrincipale(VueMarina.class);
		//Fenetre.launch(Fenetre.class, parametres);	
	}

}
