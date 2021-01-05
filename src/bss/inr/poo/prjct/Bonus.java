package bss.inr.poo.prjct;

public class Bonus {
	//Attributs
	protected Date dateConsommation;

	
	//Méthodes
	//constructeur ave paramères
	public Bonus(Date dateConsommation) {
		super();
		this.dateConsommation = dateConsommation;
	}

	//getter date
	public Date getDateConsommation() {
		return dateConsommation;
	}

	//setter date
	public void setDateConsommation(Date dateConsommation) {
		this.dateConsommation = dateConsommation;
	}
	
	
	
}
