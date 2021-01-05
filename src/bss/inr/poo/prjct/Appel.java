package bss.inr.poo.prjct;

public class Appel {
	//attributs
	protected String numDest;
	protected String numAppel;
	protected Date date;
	protected Duree heure;
	protected Duree duree;
	
	
	
	public Appel(String numDest, String numAppel, Date date, Duree heure,
			Duree duree) {
		
		this.numDest = numDest;
		this.numAppel = numAppel;
		this.date = date;
		this.heure = heure;
		this.duree = duree;
	}



	@Override
	public String toString() {
		return "Appel reçu de : " + numAppel
				+ "\nA la date : " + date + "  heure : " + heure + "\nLa duree de cet appel : " + duree;
	}
	
	
	
	
}
