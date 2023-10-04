package controleur;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import architecture.Navigateur;
import donnee.BateauDAO;
import donnee.FlotteDAO;
import modele.Bateau;
import modele.Flotte;
import vue.VueAjouterBateau;
import vue.VueEditerBateau;
import vue.VueFlotte;
import vue.VueMarina;

public class ControleurFlotte extends Controleur
{
	protected FlotteDAO flotteDAO = new FlotteDAO();
	protected BateauDAO bateauDAO = new BateauDAO();
	
	protected Flotte flotte = null;
	protected List<Bateau> bateaux = null;
	
	public ControleurFlotte()
	{
		Logger.logMsg(Logger.INFO, "new ControleurFlotte()");
	}
	
	public void initialiser()
	{
	}

	// NOTIFICATION = ACTION UTILISATEUR
	
	protected int flotteActuelle = 0;
	public void reagirClicFlotte(int id)
	{		
		Logger.logMsg(Logger.INFO, "ControleurFlotte.reagirClicFlotte("+id+")");	
		this.flotteActuelle = id; // IMPORTANT = pour se souvenir de la flotte affichee dans laquelle on va ajouter
		FlotteDAO flotteDAO = new FlotteDAO();
		Flotte flotte = flotteDAO.detaillerFlotte(id);
		System.out.println("Flotte : " + flotte.getNom());	
		VueFlotte.getInstance().afficherFlotte(flotte);
		
		BateauDAO bateauDAO = new BateauDAO();
		List<Bateau> bateaux = bateauDAO.listerBateauxParFlotte(id);
		
		for(Bateau bateau:bateaux)
		{
			System.out.println("Bateau : " + bateau.getNom());
		}
		VueFlotte.getInstance().afficherBateaux(bateaux);
	}	
	
	public void reagirClicAjouterBateau()
	{
		Logger.logMsg(Logger.INFO, "ControleurFlotte.reagirClicAjouterBateau()");
		VueAjouterBateau vue = VueAjouterBateau.getInstance();
		Navigateur.getInstance().afficherVue(vue);
	}
	
	public void reagirClicEnregistrerAjoutBateau()
	{
		Logger.logMsg(Logger.INFO, "ControleurFlotte.reagirClicEnregistrerAjoutBateau()");
		Bateau bateau = VueAjouterBateau.getInstance().lireBateau();
		bateau.setIdFlotte(flotteActuelle); // pour ajouter le bateau dans la bonne flotte contextuelle
		System.out.println("Le bateau lu est " + bateau.getNom() + " avec " + bateau.getNoeud() + " noeuds");
		BateauDAO bateauDAO = new BateauDAO();
		bateauDAO.ajouterBateau(bateau);
		Navigateur.getInstance().afficherVue(VueFlotte.getInstance()); // TODO ajouter le nouveau bateau dans la vue // pas dans devoir
	}
	
	protected Bateau bateau;
	protected int idBateauEnEdition = 0;
	public void reagirClicEditerBateau(int id)
	{
		Logger.logMsg(Logger.INFO, "ControleurFlotte.reagirClicEditerBateau()");

		this.idBateauEnEdition = id; // memoriser le bon bateau pour sauver
		BateauDAO bateauDAO = new BateauDAO();
		Bateau bateau = bateauDAO.detaillerBateau(id);
		VueEditerBateau.getInstance().afficherBateau(bateau);
		Navigateur.getInstance().afficherVue(VueEditerBateau.getInstance());
	}
	public void reagirClicEnregistrerEditerBateau()
	{
		Logger.logMsg(Logger.INFO, "ControleurFlotte.reagirClicEnregistrerEditerBateau()");
		Bateau bateau = VueEditerBateau.getInstance().lireBateau();
		bateau.setId(idBateauEnEdition); // bien sauvegarder dans le bon bateau
		System.out.println("Nouveau bateau " + bateau.getNom());
		BateauDAO bateauDAO = new BateauDAO();
		bateauDAO.editerBateau(bateau);
	}
}
