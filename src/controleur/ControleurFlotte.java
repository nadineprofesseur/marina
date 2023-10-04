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
	
	public void reagirClicFlotte(int id)
	{		
		Logger.logMsg(Logger.INFO, "ControleurFlotte.reagirClicFlotte("+id+")");	
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
	}
	
	protected Bateau bateau;
	public void reagirClicEditerBateau(int id)
	{
		Logger.logMsg(Logger.INFO, "ControleurFlotte.reagirClicEditerBateau()");
	}
	public void reagirClicEnregistrerEditerBateau()
	{
		Logger.logMsg(Logger.INFO, "ControleurFlotte.reagirClicEnregistrerEditerBateau()");
	}
}
