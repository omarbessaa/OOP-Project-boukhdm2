package bss.inr.poo.prjct;

import java.util.ArrayList;
import java.util.Scanner;

public class Operateur {
      
		//attributs
		private String nom;
		private ArrayList<PointVente> pointV;
		private ArrayList<CouvertureReseau> couverture;

		//M�thodes
		//constructeurs
		//avec le nom seulment
		public Operateur(String nom) {
			this.nom = nom;
			this.pointV=new ArrayList<PointVente> ();
			this.couverture=new ArrayList<CouvertureReseau> ();
		}
		//avec les points de vente et les pourcentage r�seau par wilaya
		public Operateur(String nom, ArrayList<PointVente> pointV,
				ArrayList<CouvertureReseau> couverture) {
			this.nom = nom;
			this.pointV = pointV;
			this.couverture = couverture;
		}
		
		//getter and setter
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		//No setters for points de ventes et couvertures reseau
		public ArrayList<PointVente> getPointV() {
			return pointV;
		}
		public ArrayList<CouvertureReseau> getCouverture() {
			return couverture;
		}
		
		   public void setCouverture(ArrayList<CouvertureReseau> couverture) {
				this.couverture = couverture;
			}
		   
		   
		
		public void setPointV(ArrayList<PointVente> pointV) {
			this.pointV = pointV;
		}
		
		
		//redifinition de methode equals : si 2 operateur ont le meme le nom alors ils sont equivalent
		public boolean equals(Operateur o) {
			return this.nom.equals(o.nom); 
		}
		
		//on suppose que 2 agence difirentes ont des noms difirents
		private int existPointV(String nomAgence) { //retourner le rang de l'elemnt s'il existe -1 sinon
		for (int i=0;i<pointV.size();i++) {if (pointV.get(i).getNomAgence().equals(nomAgence)) return i;} //point de vente existe
		return -1;
		}
		
		//************************        **************************
		//M�thodes de points de ventes
		//ajout
		public void ajouterPointV(Scanner sc) {
			
			String nomAgence,numTele,nomRue;
			int numRue,rep,type;
			EnumWilaya w;
			
		//saisie des donn�es
			//******************************************************************************************
existe :  {
			System.out.print("Donner le nom d'agence : ");
			sc.nextLine();
			nomAgence=sc.nextLine();
			if (this.existPointV(nomAgence)!=-1) {System.out.println("cette agence existe d�j�"); break existe;}
			System.out.println("Selectioner le type de cette agence : ");
			
			do
			{
			System.out.println("1-Principale");
			System.out.println("2-Secondaire");
			System.out.print("Votre choix : ");
			type=sc.nextInt();
			if (type==1 || type==2) break;
			System.out.println("choix invalide ! re�ssayez ");
			}while(true);
			
			System.out.println();
			System.out.println("Veillez saisir l'adresse de cette agence ");
			System.out.print("Num�ro de rue : ");
			numRue=sc.nextInt();
			sc.nextLine();
			System.out.println();
			System.out.print("Nom de rue : ");
			nomRue=sc.nextLine();
			System.out.println();
			System.out.print("Num�ro de wilaya : ");
			
			do
			{
			rep=sc.nextInt();
			System.out.println();
			w=Adresse.saisieWilaya(rep);
			if (w!=null) break;
			System.out.print("num�ro wilaya incorrect ! re�ssayer : ");
			}while(true);
			
			sc.nextLine();
			System.out.println();
			System.out.print("Veillez saisir le num�ro de t�l�phone pour cette agence : ");
			
			do
			{
			numTele=sc.nextLine();
			System.out.println();
			if (numTele.charAt(0)=='0' & numTele.length()==10) break;
			System.out.print("num�ro inccorect ! veillez resaisir : ");
			}while(true);
			//****************************************************************************************
			
			//l'ajout
			Adresse adresse=new Adresse(numRue,nomRue,w);
			
			this.pointV.add(new PointVente(nomAgence,type,adresse,numTele));
			}//existe
		}
		
		//supprimer un point de vente : on donne juste le nom de l'agence a supprim�e
		public void suppPointV(String nomAgence) {
			
			int i=this.existPointV(nomAgence);
			if (i!=-1) {pointV.remove(i);}
		}
		
		//modification de point de vente
		public void modifierpointV(String nomAgence,Scanner sc) {
			int i=this.existPointV(nomAgence);
			notExist:{
				if (i==-1) {System.out.println("cette agence n'exsite pas ! \n\n"); break notExist;}
				
				int rep;
				String numTele;
				
				System.out.println();
				System.out.println("1-Modifier l'adresse de l'agence ");
				System.out.println("2-Modifier le num�ro de t�l�phone de l'agence ");
				System.out.println("3-Changer le type de l'agence ");
				rep=sc.nextInt();
				
				EnumWilaya w;
				switch(rep) 
				{
				case 1:
					System.out.println("Donner la nouvelle adresse :");
					System.out.print("Num�ro de rue : ");
					this.pointV.get(i).getAdresse().setNumRue(sc.nextInt());
					sc.nextLine();
					System.out.println();
					System.out.print("Nom de rue : ");
					this.pointV.get(i).getAdresse().setNomRue(sc.nextLine());
					System.out.println();
					System.out.print("Num�ro de wilaya : ");
					
					do
					{
					rep=sc.nextInt();
					System.out.println();
					w=Adresse.saisieWilaya(rep);
					if (w!=null) break;
					System.out.print("num�ro wilaya incorrect ! re�ssayer : ");
					}while(true);
					
					this.pointV.get(i).getAdresse().setWilaya(w);
					
					break;
				
				case 2:
					System.out.print("Donner le nouveau num�ro de t�l�phone : ");
					do
					{
					sc.nextLine();
					numTele = sc.nextLine();
					System.out.println();
					if (numTele.charAt(0)=='0' & numTele.length()==10) break;
					System.out.print("num�ro inccorect ! veillez resaisir : ");
					}while(true);
					this.pointV.get(i).setNumTele(numTele);
					
					break;
				
				case 3:
					System.out.println("Selectioner le type de l'agence : ");
					
					do
					{
					System.out.println("1-Principale");
					System.out.println("2-Secondaire");
					System.out.print("Votre choix : ");
					rep=sc.nextInt();
					if (rep==1 || rep==2) break;
					System.out.println("choix invalide ! re�ssayez : ");
					}while(true);
					
					this.pointV.get(i).setType(rep);
					break;
					
					default :
						break;
				}
				
			}
		}
		
		//m�thodes de la couverture r�seau
		//m�thode priv�e pour le traitement interne de la classe
				//on envoie le rang de l'element dans la collection por pouvoir le manipuler
		private int wilayaAssure(int wilaya)
		{
			for (int i=0;i<this.couverture.size();i++) 
			{
				if ((couverture.get(i).getWilaya().ordinal()+1)==wilaya) return i;
			}
			return -1;
		}
		//ajouter une wilaya a l'ensemble des wilaya assur�e
		public void ajouterWilaya(Scanner sc) {
			
			int rep;
			EnumWilaya wilaya;
			
			
			System.out.print("Donner le num de wilaya a ajouter : ");
			do
			{
			rep=sc.nextInt();
			System.out.println();
			wilaya=Adresse.saisieWilaya(rep);
			if (wilaya!=null) break;
			System.out.print("num�ro wilaya incorrect ! re�ssayer : ");
			}while(true);
			
			if (wilayaAssure(rep)!=-1) System.out.println("cette wilaya est d�j� assur�e par cet op�rateur \n\n");
			else 
			{
				System.out.println();
				System.out.print("donner le pourcentage de r�seau dans cette wilaya : ");
				 
				do 
				{
					System.out.println();
					rep=sc.nextInt();
					if (rep > 0 && rep <101) break;
					System.out.print("erreur ! re�ssayer : ");
				}while(true);
			
				couverture.add(new CouvertureReseau(wilaya, rep));
				System.out.println("wilaya ajout�e \n\n");
			}
			
		}
		
		//Modifier le pourcentage r�seau pour une wilaya donn�e
		public void modifierCouverture(Scanner sc) {
			
			int rang,rep;
			
			System.out.println();
			System.out.print("donner le num�ro de wilaya a modifier : ");
			
			do
			{
				rep=sc.nextInt();
				if (rep > 0 && rep < 49)  break;  //on controle le nombre direct sans utiliser wilayaSaisie
				System.out.print("erreur ! num�ro wilaya inccorect re�ssayer : ");
				System.out.println();
			}while(true);
			
			rang=wilayaAssure(rep);
			
			if (rang==-1) System.out.println("cette wilaya n'est meme pas assur�e par cet op�rateur ! \n\n");
			else 
			{
				System.out.print("Donner le nouveau pourcentage pour cette wilaya : ");
				do
				{
					rep=sc.nextInt();
					if (rep >0 && rep <101) break; //control de pourcentage
					System.out.print("erreur ! re�ssayer : ");
					System.out.println();
				}while(true);
				
				couverture.get(rang).setPourcentage(rep); //modification
				
				System.out.println("modification termin�e \n\n");
			}
			
		}
		
		
		//consultation des donn�es
		
		//affichage des informations concernant l'op�rateur
			public void infosOperateur() {
				System.out.println("***** Nom de l'operateur : "+this.nom + "*****");
				System.out.println("Liste des points de ventes : ");
				
				for (PointVente v : this.pointV) System.out.println(v.toString());
				
				System.out.println("Wilayas assur�e et le pourcentage de r�seau : ");
				
				for (CouvertureReseau c : this.couverture) System.out.println(c.toString());
				
				System.out.println("\n");
			}
}
