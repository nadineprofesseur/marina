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
		
		/*
		List<Flotte> flottes = new ArrayList<Flotte>();
		
		Flotte flotte1 = new Flotte("Les voiles du Nord");
		Flotte flotte2 = new Flotte("La course de St-Malo");
		Flotte flotte3 = new Flotte("Drakars rouges");

		flottes.add(flotte1);
		flottes.add(flotte2);
		flottes.add(flotte3);
		*/
		
		FlotteDAO flotteDAO = new FlotteDAO();
		List<Flotte> flottes = flotteDAO.listerFlottes();
		VueMarina.getInstance().afficherFlottes(flottes);
	}	

	// NOTIFICATION = ACTION UTILISATEUR
	
	public void reagirClicFlotte(int id)
	{		
		Logger.logMsg(Logger.INFO, "ControleurMarina.reagirClicFlotte("+id+")");
		
		FlotteDAO flotteDAO = new FlotteDAO();
		Flotte flotte = flotteDAO.detaillerFlotte(id);
		System.out.println("Flotte : " + flotte.getNom());
		
		VueFlotte.getInstance().getControleur().reagirClicFlotte(id);
		Navigateur.getInstance().afficherVue(VueFlotte.getInstance());
	}
}
