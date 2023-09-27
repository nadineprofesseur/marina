package modele;

public class Bateau {
	
	protected int id;
	protected String nom;
	protected int noeud;
	protected int idFlotte; // a remplacer par reference vers l'objet de flotte
	protected double valeur;
	
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
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	public int getNoeud() {
		return noeud;
	}
	public void setNoeud(int noeud) {
		this.noeud = noeud;
	}
	public int getIdFlotte() {
		return idFlotte;
	}
	public void setIdFlotte(int idFlotte) {
		this.idFlotte = idFlotte;
	}

}
