package bss.inr.poo.prjct;

public class Duree {
	//attributs
	private int heure;
	private int min;
	private int sec;

//methodes
	//consturcteur sans parametres
	public Duree() {
		this.heure=0;
		this.min=0;
		this.sec=0;
	}
	//consturcteur avec parametres
	public Duree(int heure,int min,int sec) {
		if (sec>59) {min=min+(sec/60); this.sec=sec%60;}
		if (min>59) {this.heure=heure+(min/60); this.min=min%60;}
	}
	//****************************************************
	
	//afficher
	public String toString() {
		return +this.heure+"h"+this.min+"min"+this.sec+"sec";
	}
	
	public int getHeure() {
		return heure;
	}
	public int getMin() {
		return min;
	}
	public int getSec() {
		return sec;
	}
	
	
	
}
