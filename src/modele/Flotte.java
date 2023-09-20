package modele;

public class Flotte {
	
	protected int id;
	protected String nom;

	public Flotte() {
		super();
	}

	public Flotte(String nom) {
		super();
		this.nom = nom;
	}
	public Flotte(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
