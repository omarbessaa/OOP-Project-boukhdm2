package bss.inr.poo.prjct;

public class BonusHeures extends Bonus {
	//Attributs
	int nbrHeures;
	
	//Méthodes
	//constructeur
	public BonusHeures(Date dateConsommation,int nbrHeures) {
		super(dateConsommation);
		this.nbrHeures=nbrHeures;
	}

	//getter and setter nbHeures
	public int getNbrHeures() {
		return nbrHeures;
	}

	public void setNbrHeures(int nbrHeures) {
		this.nbrHeures = nbrHeures;
	}	
	
	
}
