package bss.inr.poo.prjct;

public class CouvertureReseau {
	//attributs
	private EnumWilaya wilaya;
	private int pourcentageReseau;

	//M�thodes
	//constructeur
	public CouvertureReseau(EnumWilaya wilaya,int pourcentage) {
		this.wilaya=wilaya;
		this.pourcentageReseau=pourcentage;
	}
	
	
	//modifier le pourcentage de couverture our une wilaya donn�e
	public void setPourcentage(int pourcentage) {
			this.pourcentageReseau=pourcentage;
	}
	
	//getter wilaya et pourcentage
	public EnumWilaya getWilaya() {
		return wilaya;
	}
	public int getPourcentageReseau() {
		return pourcentageReseau;
	}

//toString : affichage de wilaya avec son pourcentage r�seau
	@Override
	public String toString() {
		return "Wilaya : " + wilaya + "\nPourcentage de r�seau dans cette wilaya : "
				+ pourcentageReseau + "% \n\n";
	}
	
	
}

