package bss.inr.poo.prjct;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientPrepaye extends Client {
	//Attribus en plus
	int montantSoldeCourant;
	Date validite;
	//array list carte de recharge 
	//la date de validit� de la derniere carte (la derniere case de tableau ) 
	//est la date de validit� de solde
	
	
	
	//pour le remplissage auto
	public ClientPrepaye(String numTele, String numContrat, Date dateContrat,
			String nom, String prenom, Adresse adresse, AdresseMail email,
			boolean active, int montantSoldeCourant, Date validite) {
		super(numTele, numContrat, dateContrat, nom, prenom, adresse, email,
				active);
		this.montantSoldeCourant = montantSoldeCourant;
		this.validite = validite;
		this.listAppel=new ArrayList<Appel> ();
		this.listSms=new ArrayList<Sms>  ();
	}
	
	//constructeur sans param�tres
		public ClientPrepaye() {
			super();
			this.listAppel=new ArrayList<Appel> ();
			this.listSms=new ArrayList<Sms>  ();
			this.active=true;
			this.montantSoldeCourant=0; //il faut recharger
		}
	
	

	public ClientPrepaye(String NumTele,String numCon) {
		super(NumTele,numCon);
		this.montantSoldeCourant=0; //il faut recharger
	}

	@Override
	

	//saisir sans acun ajout 
	public void saisir(Scanner sc) {
		super.saisir(sc);
		System.out.println();		
	}

	@Override
	public String toString() {
		return "Type D'abonnement : Pr�pay� \nNuum�ro Telephone de client : " + numTele
				+ "\num�ro de contrat : " + numContrat + " DateContrat=" + dateContrat
				+ "\nNom de client : " + nom + "\nPrenom de client : " + prenom + "\nAdresse de client : "
				+ adresse + "\nemail de client " + email + "\nmontant de Solde Courant : " + montantSoldeCourant
						+ "\n Valide jusqu'� : " + validite ;
	}
	
	public void appeler(Scanner sc) throws ExcpSolde {
	System.out.println();
	System.out.print("Donner le num�ro de client destinaitaire : ");
	//control de num�ro
	String numDest;
	sc.nextLine();
	System.out.println();
	do
	{
		
	numDest=sc.nextLine();
	if (numDest.charAt(0)=='0' & numDest.length()==10) break;
	System.out.print("num�ro inccorect ! veillez resaisir : ");
	System.out.println();
	}while(true);
	
	Date d=new Date();
	System.out.println("Saisir la date de l'appel : ");
	d.saisir(sc);
	if (d.comparerA(this.validite)==1) System.out.println("vous pouvez pas effectuer l'appel car la datede de validit� de votre cr�dit d�pass�e \n");
	else {
		Duree dr;
		System.out.println("donner la dur�e de cet appel : heures,minutes ensuite secondes :");
		dr=new Duree(sc.nextInt(), sc.nextInt(), sc.nextInt());
		int montant=4*(dr.getMin())+4*60*(dr.getHeure());
		if (montant > this.montantSoldeCourant) throw new ExcpSolde("Solde insuffisant"); 
			
		else this.montantSoldeCourant-=montant;
		this.listAppel.add(new AppelEmis(numDest, this.numTele, d, new Duree(), dr, montant));
	}
	}
}
