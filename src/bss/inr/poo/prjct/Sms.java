package bss.inr.poo.prjct;

public class Sms {
	//Attributs
	protected String numDest;
	protected String numExp; //numero de l'expediteur
	protected Date date;
	protected Duree heure;
	protected String texte;

	//Méthodes
	//constructeur avec paramètres
	
	public Sms(String numDest, String numExp, Date date, Duree heure,
			String texte) {
		
		this.numDest = numDest;
		this.numExp = numExp;
		this.date = date;
		this.heure = heure;
		this.texte = texte;
	}
	
}
