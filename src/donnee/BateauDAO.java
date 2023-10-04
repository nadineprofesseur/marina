package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		Bateau bateau = new Bateau();
		
		try {
			Connection connexion = BaseDeDonnees.getInstance().getConnexion();
			String SQL_DETAILLER_BATEAU = "SELECT * FROM bateau WHERE id = ?";
			PreparedStatement requete = connexion.prepareStatement(SQL_DETAILLER_BATEAU);
			requete.setInt(1, id);
			ResultSet curseur = requete.executeQuery();
			if(curseur.next())
			{
				//int id = curseur.getInt("id");
				String nom = curseur.getString("nom");
				int noeud = curseur.getInt("noeud");
				int idFlotte = curseur.getInt("flotte");
				
				bateau.setId(id);
				bateau.setNom(nom);
				bateau.setNoeud(noeud);
				bateau.setIdFlotte(idFlotte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bateau;
	}
	
	public List<Bateau> listerBateauxParFlotte(int idFlotte)
	{
		Logger.logMsg(Logger.INFO, "BateauDAO.listerBateauxParFlotte()");
		List<Bateau> bateaux = new ArrayList<Bateau>();

	/*
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
	*/	
		try {
			Connection connexion = BaseDeDonnees.getInstance().getConnexion();
			Statement requete = connexion.createStatement();
			ResultSet curseur = requete.executeQuery("SELECT * FROM bateau WHERE flotte = " + idFlotte);
			
			Bateau bateau;
			while(curseur.next())
			{
				int id = curseur.getInt("id");
				String nom = curseur.getString("nom");
				int noeud = curseur.getInt("noeud");
				
				bateau = new Bateau();
				bateau.setId(id);
				bateau.setNom(nom);
				bateau.setNoeud(noeud);
				bateau.setIdFlotte(idFlotte);
				bateaux.add(bateau);
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
		return bateaux;
	}
	
	public void ajouterBateau(Bateau bateau)
	{
		Logger.logMsg(Logger.INFO, "BateauDAO.ajouterBateau()");
		String SQL_AJOUTER_BATEAU = "INSERT into bateau(nom, noeud, flotte) VALUES(?,?,?)";
		try {
			Connection connexion = BaseDeDonnees.getInstance().getConnexion();
			PreparedStatement requete = connexion.prepareStatement(SQL_AJOUTER_BATEAU);
			requete.setString(1, bateau.getNom());
			requete.setInt(2, bateau.getNoeud());
			requete.setInt(3, bateau.getIdFlotte());			
			requete.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editerBateau(Bateau bateau) {
		Logger.logMsg(Logger.INFO, "BateauDAO.editerBateau()");
		String SQL_EDITER_BATEAU = "UPDATE bateau SET nom=? WHERE id = ?";
		try {
			Connection connexion = BaseDeDonnees.getInstance().getConnexion();
			PreparedStatement requete = connexion.prepareStatement(SQL_EDITER_BATEAU);
			requete.setString(1, bateau.getNom());
			//requete.setInt(2, bateau.getNoeud());
			//requete.setInt(3, bateau.getIdFlotte());			
			requete.setInt(2, bateau.getId());
			requete.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
