package bss.inr.poo.prjct;

import java.util.Scanner;





public class AdresseMail {
	//attribus
		private String nomUser;
		private EnumSite nomSite;
		private String extension;
	//Methodes
		//constructeur sans paramètres
		public AdresseMail() {
			super();
		}
		//costructeur avec paramètres
		public AdresseMail(String nomUser,String nomSite,String extension) {
			this.nomUser=nomUser;
			this.nomSite=EnumSite.valueOf(nomSite);
			this.extension=extension;
		}
		
		//toString
		public String toString() {
			return this.nomUser+"@"+this.nomSite.toString()+"."+this.extension;
		}
		
		//afficher
		public void afficher() {
			System.out.println(this.nomUser+"@"+this.nomSite.toString()+"."+this.extension);
		}
		
		//memeSite
		public boolean memeSite(AdresseMail a) {
			if (this.nomSite.compareTo(a.nomSite)==0) return true;
			return false;
		}
		
		
		//egale instnace
		public boolean egale(AdresseMail a) {
			return (this.memeSite(a) && this.nomUser.equals(a.nomUser) && this.extension.equals(a.extension) );
		}
		
		
		//compare instance
		public int comparerA(AdresseMail b) {
			
			if (this.memeSite(b) && this.nomUser.equals(b.nomUser)) return 0;
			if (this.nomUser.compareTo(b.nomUser) < 0) return 1;
			if (this.nomUser.compareTo(b.nomUser) > 0) return -1;
			else if ( this.nomSite.toString().compareTo(b.nomSite.toString()) < 0 ) return 1;
				else return -1; 
		}
		
		//Saisir
		public void saisir(Scanner sc) {
		
			String nomSite;
			
			boolean corect=false;
			
			System.out.println("Saisir l'adresse email : ");
			System.out.print("Saisir le nom d'utilisateur : ");
			this.nomUser=sc.next();  
	        do
	        {
	        	System.out.print("Saisir le site : ");
	        	nomSite=sc.next();     
	        	//verif de nom de site
	        	for (EnumSite i : EnumSite.values())
	        	{
	        		if ( nomSite.equals(i.toString()) ) {corect=true; break;}; //nom site saisi correct
	        	}
	        	if (corect) break;
	        	else System.out.println("nom de site erroné ! veillez resaisir !");
	        }while(!corect);
	        
	        System.out.print("Saisir l'extension : ");
			this.extension=sc.next(); 
			
		}
		
		//***************************************************
		
}
