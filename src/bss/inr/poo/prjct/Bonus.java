package bss.inr.poo.prjct;

public class Bonus {
	//Attributs
	protected Date dateConsommation;

	
	//M�thodes
	//constructeur ave param�res
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
