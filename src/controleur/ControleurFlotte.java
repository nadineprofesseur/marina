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
	}	
	
	public void reagirClicAjouterBateau()
	{
		Logger.logMsg(Logger.INFO, "ControleurFlotte.reagirClicAjouterBateau()");
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
