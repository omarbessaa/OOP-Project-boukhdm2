package bss.inr.poo.prjct;

public class BonusSms extends Bonus {
	//Attributs
		int nbrSms;

		//Méthodes
		//constructeur

		public BonusSms(Date dateConsommation, int nbrSms) {
			super(dateConsommation);
			this.nbrSms = nbrSms;
		}
		
	//getter and setter nbr sms
		public int getNbrSms() {
			return nbrSms;
		}

		public void setNbrSms(int nbrSms) {
			this.nbrSms = nbrSms;
		}
			
	
}
