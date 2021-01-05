package bss.inr.poo.prjct;

public class PointVente {
	//attributs
	private String nomAgence;
	private EnumTypePointVente type;
	private Adresse adresse; 
	private String numTele;
	
	//Méthodes 
	//constructeur avec paramètres
	public PointVente(String nomAgence,int type,Adresse adresse,String numTele) {
		this.nomAgence=nomAgence;
		this.adresse=adresse;
		this.numTele=numTele;
		if (type==1) this.type=EnumTypePointVente.principal;
		else this.type=EnumTypePointVente.secondaire;
	}

	
	//getter and setter nomAgence
	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}
	
	//setter numTele
	public void setNumTele(String numTele) {
		this.numTele = numTele;
	}
	//setter type redéfinition
	public void setType(int type) {
		if (type==1) this.type=EnumTypePointVente.principal;
		else this.type=EnumTypePointVente.secondaire;
	}
	
	//getter adresse
	public Adresse getAdresse() {
		return adresse;
	}
	
	//toString : affichage des information de l'agence 

	@Override
	public String toString() {
		return "NomAgence : " + nomAgence + "\nAdresse : " + adresse
				+ "\nType de point de vente : "+ type +"\nNumTele : " + numTele + "\n\n";
	}


	

}
