package bss.inr.poo.prjct;

public class AppelEmis extends Appel {
	
	//attributs +
	int montant;



	public AppelEmis(String numDest, String numAppel, Date date, Duree heure,
		Duree duree, int montant) {
	super(numDest, numAppel, date, heure, duree);
	this.montant = montant;
}



	@Override
	public String toString() {
		return "Appel émi a : " + numDest
				+ "\nA la date : " + date + "  heure : " + heure + "\nLa duree de cet appel : " + duree;
	}

	
}
