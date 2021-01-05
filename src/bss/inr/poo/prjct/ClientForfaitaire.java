package bss.inr.poo.prjct;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientForfaitaire extends Client {
	//Attribus en plus 
	int montantForfait;
	Date dateFin; //la fin de forfait
	
	
	
	
	
	//remplissage auto
	public ClientForfaitaire(String numTele, String numContrat,
			Date dateContrat, String nom, String prenom, Adresse adresse,
			AdresseMail email, boolean active, int montantForfait, Date dateFin) {
		super(numTele, numContrat, dateContrat, nom, prenom, adresse, email,
				active);
		this.montantForfait = montantForfait;
		this.dateFin = dateFin;
		this.listAppel=new ArrayList<Appel> ();
		this.listSms=new ArrayList<Sms>  ();
	}

	//constructeur sans paramètres
		public ClientForfaitaire() {
			super();
			this.listAppel=new ArrayList<Appel> ();
			this.listSms=new ArrayList<Sms>  ();
			this.active=true;
		}
	
		//constructeur avec paramètres
	public ClientForfaitaire(String NumTele,String numCon,int mantantForfait) {
		super(NumTele,numCon);
		this.montantForfait=mantantForfait;
	}

	@Override
	public String toString() {
		return "Type D'abonnement : Forfaitaire \nNuuméro Telephone de client : " + numTele
				+ "\numéro de contrat : " + numContrat + " DateContrat=" + dateContrat
				+ "\nNom de client : " + nom + "\nPrenom de client : " + prenom + "\nAdresse de client : "
				+ adresse +  "\nmontant de forfait Courant : " + montantForfait
						+ "\n Valide jusqu'à : " + dateFin ;
	}
	
	
	//redéfinition de méthode saisir pour saisir le montant et la date de fin de forfait
	public void saisir(Scanner sc) {
		super.saisir(sc);
		System.out.println();
		
		System.out.print("Veillez saisir le montant de forfait : ");
		this.montantForfait=sc.nextInt();
		this.dateFin=new Date();
		System.out.println("saisir la date de fin de forfait : ");
		this.dateFin.saisir(sc);
	}
	
	public void appeler(Scanner sc) {
	System.out.println();
	System.out.print("Donner le numéro de client destinaitaire : ");
	//control de numéro
	String numDest;
	do
	{
		sc.nextLine();
	numDest=sc.nextLine();
	System.out.println();
	if (numDest.charAt(0)=='0' & numDest.length()==10) break;
	System.out.print("numéro inccorect ! veillez resaisir : ");
	}while(true);
	
	Date d=new Date();
	System.out.println("Saisir la date de l'appel : ");
	d.saisir(sc);
	if (d.comparerA(this.dateFin)==1) System.out.println("vous pouvez pas effectuer l'appel car la datede forfait est dépassée \n");
	else {
		Duree dr;
		System.out.println("donner la durée de cet appel : heures,minutes ensuite secondes :");
		dr=new Duree(sc.nextInt(), sc.nextInt(), sc.nextInt());
		int montant=4*(dr.getMin())+4*60*(dr.getHeure());
		if (montant > this.montantForfait) System.out.println("vous pouvez pas effectuer cet appel : solde insuffisant");
		else this.montantForfait-=montant;
		this.listAppel.add(new AppelEmis(numDest, this.numTele, d, new Duree(), dr, montant));
	}
	}
}
