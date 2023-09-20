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
