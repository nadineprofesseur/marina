package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDonnees {
	private Connection connexion = null;
	
	private BaseDeDonnees()
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/marina", "postgres", "testtest");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// SINGLETON - DEBUT
	private static BaseDeDonnees instance = null;
	public static BaseDeDonnees getInstance()
	{
		if(null == instance) instance = new BaseDeDonnees();
		return instance;
	}
	// SINGLETON - FIN

	public Connection getConnexion()
	{
		return this.connexion;
	}
	
}
