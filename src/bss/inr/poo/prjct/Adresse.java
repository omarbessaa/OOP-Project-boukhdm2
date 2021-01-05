package bss.inr.poo.prjct;

public class Adresse {
    private int numRue;
    private String nomRue;
    private EnumWilaya wilaya;
    
    //Déclaration du constructeur 
	public Adresse(int numRue, String nomRue, EnumWilaya wilaya) {
		
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.wilaya = wilaya;
	}
     //Déclaration des setteur and getteur 

	public int getNumRue() {
		return numRue;
	}

	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public EnumWilaya getWilaya() {
		return wilaya;
	}

	public void setWilaya(EnumWilaya wilaya) {
		this.wilaya = wilaya;
	}
	
  //toString : affichage de l'adresse
	@Override
	public String toString() {
		return "Adresse : " + numRue + ", " + nomRue + ", "
				+ wilaya ;
	}
	//

	//pour la verification de la saisie de wilaya dans toute les classe (Static)
       public static EnumWilaya saisieWilaya(int numWilaya) {
    	   
    	   for (EnumWilaya i : EnumWilaya.values())
			{
				if (i.ordinal()==(numWilaya-1)) return i; 
			}
    	   return null;
       }
    
}
