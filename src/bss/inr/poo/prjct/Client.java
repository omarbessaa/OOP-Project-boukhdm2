package bss.inr.poo.prjct;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Client  {
	//attributs
	protected String numTele;
	protected String numContrat;
	protected Date dateContrat;
	protected String nom;
	protected String prenom;
	protected Adresse adresse;
	protected AdresseMail email;
	protected ArrayList<Appel> listAppel ;
	protected ArrayList<Sms> listSms ;
	protected boolean active; //true au debut false si on le bloque
	

	//constructeur sans paramètres
	public Client() {
		super();
	}
	
	
	//pour le remplissage automatique
	public Client(String numTele, String numContrat, Date dateContrat,
			String nom, String prenom, Adresse adresse, AdresseMail email,
			boolean active) {
		super();
		this.numTele = numTele;
		this.numContrat = numContrat;
		this.dateContrat = dateContrat;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.active = active;
	}



	public Client(String numTele, String numContrat) {
		
		this.numTele = numTele;
		this.numContrat = numContrat;
	
		
	}
	//Getter and setter
	
	public String getNumTele() {
		return numTele;
	}
	public void setNumTele(String numTele) {
		this.numTele = numTele;
	}
	public String getNumContrat() {
		return numContrat;
	}
	public void setNumContrat(String numContrat) {
		this.numContrat = numContrat;
	}
	public Date getDateContrat() {
		return dateContrat;
	}
	public void setDateContrat(Date dateContrat) {
		this.dateContrat = dateContrat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public AdresseMail getEmail() {
		return email;
	}
	public void setEmail(AdresseMail email) {
		this.email = email;
	}
	public ArrayList<Appel> getListAppel() {
		return listAppel;
	}
	public void setListAppel(ArrayList<Appel> listAppel) {
		this.listAppel = listAppel;
	}
	public ArrayList<Sms> getListSms() {
		return listSms;
	}
	public void setListSms(ArrayList<Sms> listSms) {
		this.listSms = listSms;
	}
	@Override
	public String toString() {
		return " [numTele=" + numTele + ", numContrat=" + numContrat
				+ ", dateContrat=" + dateContrat + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + ", email=" + email
				+ ", active=" + active + "]";
	}
	
	//méthode pour la saisie des données pour faciliter l'ajout d'un client
	public void saisir(Scanner sc){
		
		sc.nextLine();
		System.out.println();
		System.out.print("Veillez saisir le numéro de téléphone de ce client : ");
		
		do
		{
		
		this.numTele=sc.nextLine();
		System.out.println();
		if (this.numTele.charAt(0)=='0' & this.numTele.length()==10) break;
		System.out.print("numéro inccorect ! veillez resaisir : ");
		}while(true);
	
		//numéro contrat
		System.out.println();
		System.out.print("Saisir le numéro de contrat : ");
		this.numContrat=sc.nextLine();
		
		//date contrat
		Date dateContrat=new Date();
		System.out.println("saisir la date de contrat : ");
		dateContrat.saisir(sc);
		this.dateContrat=dateContrat;
		
		//nom prenom
		sc.nextLine();
		System.out.print("saisir le nom de client : ");
		this.nom=sc.nextLine();
		System.out.println();
		System.out.print("saisir le prenom de client : ");
		this.prenom=sc.nextLine();
		
		//adresse objet
		EnumWilaya w;
		System.out.println();
		System.out.println("Veillez saisir l'adresse de client : ");
		System.out.print("Numéro de rue : ");
		int numRue=sc.nextInt();
		sc.nextLine();
		System.out.println();
		System.out.print("Nom de rue : ");
		String nomRue=sc.nextLine();
		System.out.println();
		System.out.print("Numéro de wilaya : ");
		
		do
		{
		int rep=sc.nextInt();
		sc.nextLine();
		System.out.println();
		w=Adresse.saisieWilaya(rep);
		if (w!=null) break;
		System.out.print("numéro wilaya incorrect ! reéssayer : ");
		}while(true);
	
		this.adresse=new Adresse(numRue,nomRue,w);
		
		//adresse mail
		AdresseMail a=new AdresseMail();
		a.saisir(sc);
		this.email=a;
	}
	
	public abstract void appeler(Scanner sc) throws ExcpSolde;
}
