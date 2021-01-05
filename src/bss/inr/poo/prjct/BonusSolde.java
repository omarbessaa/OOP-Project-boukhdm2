package bss.inr.poo.prjct;

public class BonusSolde extends Bonus {
	//Attributs
			int montantAdd;

			//Méthodes
			//constructeur
			public BonusSolde(Date dateConsommation, int montantAdd) {
				super(dateConsommation);
				this.montantAdd = montantAdd;
			}
//getter and setter
			public int getMontantAdd() {
				return montantAdd;
			}

			public void setMontantAdd(int montantAdd) {
				this.montantAdd = montantAdd;
			}

				
}
