package donnee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import modele.Flotte;

public class FlotteDAO {

	public List<Flotte> listerFlottes()
	{
		Logger.logMsg(Logger.INFO, "FlotteDAO.listerFlottes()");
		
		List<Flotte> flottes = new ArrayList<Flotte>();
		
		try {
			Connection connexion = BaseDeDonnees.getInstance().getConnexion();
			Statement requete = connexion.createStatement();
			ResultSet curseur = requete.executeQuery("SELECT * FROM flotte");
			
			while(curseur.next())
			{
				String nom = curseur.getString("nom");
				int id = curseur.getInt("id");
				Flotte flotte = new Flotte(id, nom);
				flottes.add(flotte);
				//System.out.println("Flotte BDD : " + nom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flottes;
	}
	
	public Flotte detaillerFlotte(int id)
	{
		Logger.logMsg(Logger.INFO, "FlotteDAO.detaillerFlotte()");
		Flotte flotte = new Flotte();
		
		return flotte;
	}
}