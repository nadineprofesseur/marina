package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import architecture.Navigateur;
import donnee.BateauDAO;
import donnee.FlotteDAO;
import modele.Flotte;
import vue.VueFlotte;
import vue.VueMarina;

public class ControleurMarina extends Controleur{

	public ControleurMarina()
	{
		Logger.logMsg(Logger.INFO, "new ControleurMarina()");
	}

	public void initialiser()
	{
		Logger.logMsg(Logger.INFO, "ControleurMarina.initialiser()");
		
		List<Flotte> flottes = new ArrayList<Flotte>();
		
		Flotte flotte;
		
		
	}	

	// NOTIFICATION = ACTION UTILISATEUR
	
	public void reagirClicFlotte(int id)
	{		
		Logger.logMsg(Logger.INFO, "ControleurMarina.reagirClicFlotte("+id+")");
		VueFlotte.getInstance().getControleur().reagirClicFlotte(id);
	}
}
