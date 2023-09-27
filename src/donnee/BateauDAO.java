package donnee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import modele.Bateau;

public class BateauDAO {
	
	public Bateau detaillerBateau(int id)
	{
		return null;
	}
	
	public List<Bateau> listerBateauxParFlotte(int idFlotte)
	{
		Logger.logMsg(Logger.INFO, "BateauDAO.listerBateauxParFlotte()");
		List<Bateau> bateaux = new ArrayList<Bateau>();

		Bateau bateau1 = new Bateau();
		bateau1.setNom("Le bleu ciel");
		Bateau bateau2 = new Bateau();
		bateau2.setNom("Vintage");
		Bateau bateau3 = new Bateau();
		bateau3.setNom("Blanche-neige");
		Bateau bateau4 = new Bateau();
		bateau4.setNom("Pirate du nord");
		
		bateaux.add(bateau1);
		bateaux.add(bateau2);
		bateaux.add(bateau3);
		bateaux.add(bateau4);
		
		return bateaux;
	}
	
	public void ajouterBateau(Bateau bateau)
	{
		Logger.logMsg(Logger.INFO, "BateauDAO.ajouterBateau()");
	}

	public void editerBateau(Bateau bateau) {
		Logger.logMsg(Logger.INFO, "BateauDAO.editerBateau()");
	}

}
