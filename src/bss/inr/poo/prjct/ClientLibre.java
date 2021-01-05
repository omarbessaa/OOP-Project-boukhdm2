package bss.inr.poo.prjct;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientLibre extends Client {
	//attributs en plus
	int montantFactureCourant;
	Date datePaiement; //paiement de facture (chaque 2 mois) et doit paier avant 30 jours sinon on bloque le client
	
	
	
	
	//remplissage auto
	public ClientLibre(String numTele, String numContrat, Date dateContrat,
			String nom, String prenom, Adresse adresse, AdresseMail email,
			boolean active, int montantFactureCourant, Date datePaiement) {
		super(numTele, numContrat, dateContrat, nom, prenom, adresse, email,
				active);
		this.montantFactureCourant = montantFactureCourant;
		this.datePaiement = datePaiement;
		this.listAppel=new ArrayList<Appel> ();
		this.listSms=new ArrayList<Sms>  ();
	}


	//constructeur sans paramètres
		public ClientLibre() {
			super();
			this.listAppel=new ArrayList<Appel> ();
			this.listSms=new ArrayList<Sms>  ();
			this.active=true;
			this.montantFactureCourant=500; //forfait fixe de la facture
		}
	
	
	public ClientLibre(String NumTele,String numCon) {
		super(NumTele,numCon);
		this.montantFactureCourant=500; //forfait fixe de la facture
	}


	@Override
	public String toString() {
		return "Type D'abonnement : Libre \nNuuméro Telephone de client : " + numTele
				+ "\numéro de contrat : " + numContrat + " DateContrat=" + dateContrat
				+ "\nNom de client : " + nom + "\nPrenom de client : " + prenom + "\nAdresse de client : "
				+ adresse + "\nemail de client " + email + "\nmontant de Facture Courant : " + montantFactureCourant
						+ "\n La facture doit etre payée le  : " + this.datePaiement ;
	}
    
	//redéfinition de méthode saisir pour saisir la date de paiment de facture
		public void saisir(Scanner sc) {
			super.saisir(sc);
			System.out.println();
			System.out.println("Veillez saisir la date programmée pour le paiment de facture pour ce numéro (2mois): ");
			this.datePaiement=new Date();
			this.datePaiement.saisir(sc);
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
			if (d.comparerA(this.datePaiement)==1) System.out.println("vous pouvez pas effectuer l'appel avant de payer la facture \n");
			else {
				Duree dr;
				System.out.println("donner la durée de cet appel : heures,minutes ensuite secondes :");
				dr=new Duree(sc.nextInt(), sc.nextInt(), sc.nextInt());
				int montant=4*(dr.getMin())+4*60*(dr.getHeure());
				
				 this.montantFactureCourant+=montant;
				this.listAppel.add(new AppelEmis(numDest, this.numTele, d, new Duree(), dr, montant));
			}
			}
}
