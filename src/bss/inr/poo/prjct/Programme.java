package bss.inr.poo.prjct;

import java.util.ArrayList;
import java.util.Scanner;


public class Programme {
	
	
	
	static ArrayList<Operateur> oprCol=new ArrayList<Operateur>(); //collection pour sauvgarder les opérateurs téléphonique
	static ArrayList<Client> clnCol=new ArrayList<Client>(); //pour sauvgarder les clients
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws ExcpSolde {
		
		
		oprCol.add(new Operateur("ooredoo"));
		
		menu();
	
	}
	
	//menu principal
	public static void menu() throws ExcpSolde {
	
		
		boolean quitter=false;	
	do
  	  {
		System.out.println();
		System.out.println("***********  Bienvenu au programme *****************\n\n");
		System.out.println("1-Remplissage automatique de données");
		System.out.println("2-Gestion de l'opérateur");
		System.out.println("3-Gestion des clients");
		System.out.println("4-Gestion des facture");
		System.out.println("5-Gestion des bonus");
		System.out.println("6-Quitter\n");
		int rep;
		System.out.print("votre choix : ");
		//controle de choix
		do
		{
			rep=sc.nextInt();
			if(rep >0 && rep <7) break;
			System.out.println();
			System.out.print("choix invalide ! réessayer : ");
		}while(true);
		
		switch(rep) {
		case 1:
			remplir();
			break;
		case 2:
			menu2();
			break;
		case 3:
			menu3();
			break;
		case 4:
			break;
		case 5:
			break;
		case 6: quitter=true;
			break;
		}
		
  	  }while(quitter==false);
	
  }
	
	
	//gestion de l'opérateur
	public static void menu2() {
		
		
		int rep;
		boolean quitter=false;
		
		do
	  	  {
			
			System.out.println();
			System.out.println("1-Informations sur l'opérateur");
			System.out.println("2-Ajouter point de vente");
			System.out.println("3-Ajouter une wilaya");
			System.out.println("4-Modifier point de vente");
			System.out.println("5-Modifier le pourcentage de réseau pour une wilaya");
			System.out.println("6-Supprimer un point de vente");
			System.out.println("7-Quitter\n");
			
			System.out.print("votre choix : ");
			//controle de choix
			do
			{
				rep=sc.nextInt();
				if(rep >0 && rep <8) break;
				System.out.println();
				System.out.print("choix invalide ! réessayer : ");
			}while(true);
			
			String nomA;
			
			switch(rep) {
			case 1:
				oprCol.get(0).infosOperateur();
				break;
			case 2:
				oprCol.get(0).ajouterPointV(sc);
				break;
			case 3:
				oprCol.get(0).ajouterWilaya(sc);
				break;
			case 4:
				System.out.println("Donner le nom d'agence : ");
				sc.nextLine();
				nomA=sc.nextLine();
				oprCol.get(0).modifierpointV(nomA,sc);
				break;
			case 5:
				oprCol.get(0).modifierCouverture(sc);
				break;
			case 6:System.out.println("Donner le nom d'agence : ");
			sc.nextLine();
			nomA=sc.nextLine();
				oprCol.get(0).suppPointV(nomA);
				break;
			case 7: quitter=true;
				break;
			}
			
	  	  }while(quitter==false);
		
	}
	
	
	//gestion des factures
	public static void menu4() {
		
		int rep;
		
		boolean quitter=false;	
	do
  	  {
		
		System.out.println();
		System.out.println("1-Etablir facture pour un numéro donné");
		System.out.println("2-Afficher tous les numéros arrivés à échéance de paiment");
		System.out.println("3-Toutes les factures en instance de paiement");
		System.out.println("4-Relancer les numéros pour les rechargements / paiements");
		System.out.println("5-Quitter\n");
		
		System.out.print("votre choix : ");
		//controle de choix
		do
		{
			rep=sc.nextInt();
			if(rep >0 && rep <6) break;
			System.out.println();
			System.out.print("choix invalide ! réessayer : ");
		}while(true);
		
		switch(rep) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5: quitter=true;
			break;
		}
		
  	  }while(quitter==false);
	
  }
	
	
	//gestion des bonus
	public static void menu5() {
		
		int rep;
		
		boolean quitter=false;	
	do
  	  {
		System.out.println();
		System.out.println("1-Affecter bonus à des clients");
		System.out.println("2-Afficher les clients ayant bénéficié de bonus");
		System.out.println("3-Quitter\n");
		
		System.out.print("votre choix : ");
		//controle de choix
		do
		{
			rep=sc.nextInt();
			if(rep >0 && rep <4) break;
			System.out.println();
			System.out.print("choix invalide ! réessayer : ");
		}while(true);
		
		switch(rep) {
		case 1:
			break;
		case 2:
			break;
		case 3: quitter=true;
			break;
		}
		
  	  }while(quitter==false);
	
  }
		
	
	//MENU 	CLIENT	 menu3
public static void menu3() throws ExcpSolde {
		
		int rep;
		int rang;
		String numTele;
		
		boolean quitter=false;	
	do
  	  {
		
		System.out.println();
		System.out.println("1-Ajouter un client");
		System.out.println("2-Modifier client");
		System.out.println("3-Supprimer client ");
		System.out.println("4-Afficher les informations sur un numéro");
		System.out.println("5-Liste des clients par type d'abonnement");
		System.out.println("6-Liste des clients par wilaya");
		System.out.println("7-Liste des numéro bloqués");
		System.out.println("8-Afficher tous les appels pour un numéro");
		System.out.println("9-Effectuer un appel");
		System.out.println("10-Quitter\n");
		
		System.out.print("votre choix : ");
		//controle de choix
		do
		{
			rep=sc.nextInt();
			if(rep >0 && rep <11) break;
			System.out.println();
			System.out.print("choix invalide ! réessayer : ");
		}while(true);
		
		switch(rep) {
		case 1:
			ajouterClient();
			break;
		case 2:
			modifierClient();
			break;
		case 3:
			supprimerClient();
			break;
		case 4:
			
			System.out.println();
			System.out.print("Donner le numéro de client que vous désirez : ");
			//control de numéro
			do
			{
				sc.nextLine();
			numTele=sc.nextLine();
			System.out.println();
			if (numTele.charAt(0)=='0' & numTele.length()==10) break;
			System.out.print("numéro inccorect ! veillez resaisir : ");
			}while(true);
			
			//on vérifie si ce numéro de client existe
			rang=existClient(numTele);
			if (rang == -1) System.out.println("Ce numéro ne correnspand a accun client ! \n\n");
		else {
			System.out.println(clnCol.get(rang).toString());
		}
			
			break;
		case 5: 
			System.out.println();
			System.out.println("1-Abonement prépayé");
			System.out.println("2-Abonement forfaitaire");
			System.out.println("3-Abonement libre");
			
			System.out.print("votre choix : ");
			//controle de choix
			do
			{
				rep=sc.nextInt();
				if(rep >0 && rep <4) break;
				System.out.println();
				System.out.print("choix invalide ! réessayer : ");
			}while(true);
			
			switch(rep) {
			case 1:
				for (Client c : clnCol) {if (c instanceof ClientPrepaye) System.out.println(c.getNom()+"  "+c.getPrenom());}
				break;
			case 2:
				for (Client c : clnCol) {if (c instanceof ClientForfaitaire) System.out.println(c.getNom()+"  "+c.getPrenom());}
				break;
			case 3: 
				for (Client c : clnCol) {if (c instanceof ClientLibre) System.out.println(c.getNom()+"  "+c.getPrenom());}
				break;
			}
		break;
		
		case 6: 
			EnumWilaya wilaya;
			System.out.print("Donner le numéro de wilaya : ");
			do
			{
			rep=sc.nextInt();
			System.out.println();
			wilaya=Adresse.saisieWilaya(rep);
			if (wilaya!=null) break;
			System.out.print("numéro wilaya incorrect ! reéssayer : ");
			}while(true);
			
			for (Client c : clnCol) {if (c.getAdresse().getWilaya().equals(wilaya)) System.out.println(c.getNom()+"  "+c.getPrenom());}
		break;
		case 7: 
			for (Client c : clnCol) {if (c.active==false) System.out.println(c.getNom()+"  "+c.getPrenom());}
		break;
		case 8:
			
			System.out.println();
			System.out.print("Donner le numéro de client que vous désirez : ");
			//control de numéro
			do
			{
			sc.nextLine();
			numTele=sc.nextLine();
			System.out.println();
			if (numTele.charAt(0)=='0' & numTele.length()==10) break;
			System.out.print("numéro inccorect ! veillez resaisir : ");
			}while(true);
			
			//on vérifie si ce numéro de client existe
			rang=existClient(numTele);
			if (rang == -1) System.out.println("Ce numéro ne correnspand a accun client ! \n\n");
		else {
			for (Appel a : clnCol.get(rang).getListAppel()) {System.out.println(a.toString());}
		}
			
			break;
		case 9: 
			System.out.println();
			System.out.print("Donner le numéro de client avec le quel vous voulez faire l'appel : ");
			//control de numéro
			do
			{
				sc.nextLine();
			numTele=sc.nextLine();
			System.out.println();
			if (numTele.charAt(0)=='0' & numTele.length()==10) break;
			System.out.print("numéro inccorect ! veillez resaisir : ");
			}while(true);
			
			//on vérifie si ce numéro de client existe
			rang=existClient(numTele);
			if (rang == -1) System.out.println("Ce numéro ne correnspand a accun client ! \n\n");
		else {
		clnCol.get(rang).appeler(sc);
		}
		break;
		case 10: quitter=true;
			break;
		}
		
  	  }while(quitter==false);
	
  }


	//ajouter client 
	static void ajouterClient() {
		
		int rep;
		Client c;
		
		System.out.println();
		System.out.println("Choisir le type d'abonnement pour ce client : ");
		System.out.println("1-Abonnement libre");
		System.out.println("2-Abonnement forfaitaire");
		System.out.println("3-Abonnement prépayé");
		
		System.out.print("votre choix : ");
		//controle de choix
		do
		{
			rep=sc.nextInt();
			if(rep >0 && rep <4) break;
			System.out.println();
			System.out.print("choix invalide ! réessayer : ");
		}while(true);
		
		switch(rep) {
		case 1:
			c=new ClientLibre();
			c.saisir(sc);
			clnCol.add(c);
			break;
		case 2:
			c=new ClientForfaitaire();
			c.saisir(sc);
			clnCol.add(c);
			break;
		case 3: 
			c=new ClientPrepaye();
			c.saisir(sc);
			clnCol.add(c);
			break;
		}
	}
	
	static void modifierClient() {
		int rang,rep;
		String numTele;
		
		
		
		System.out.println();
		System.out.print("Donner le numéro de client a modifier : ");
		//control de numéro
		do
		{
			sc.nextLine();
		numTele=sc.nextLine();
		System.out.println();
		if (numTele.charAt(0)=='0' & numTele.length()==10) break;
		System.out.print("numéro inccorect ! veillez resaisir : ");
		}while(true);
		
		//on vérifie si ce numéro de client existe
		rang=existClient(numTele);
		if (rang == -1) System.out.println("Ce numéro ne correnspand a accun client ! \n\n");
	else {
		
		System.out.println("1-Modifier Adresse de client");
		System.out.println("2-Modifier l'etat de client");
		
		
		System.out.print("votre choix : ");
		//controle de choix
		do
		{
			rep=sc.nextInt();
			if(rep >0 && rep <3) break;
			System.out.println();
			System.out.print("choix invalide ! réessayer : ");
		}while(true);
		
		switch(rep) {
		case 1:
			Adresse ad;
			
			System.out.println();
			System.out.println("Veillez saisir la nouvelle adresse de ce client : ");
			System.out.print("Numéro de rue : ");
			int numRue=sc.nextInt();
			sc.nextLine();
			System.out.println();
			System.out.print("Nom de rue : ");
			String nomRue=sc.nextLine();
			System.out.println();
			System.out.print("Numéro de wilaya : ");
			
			EnumWilaya w;
			do
			{
			rep=sc.nextInt();
			System.out.println();
			w=Adresse.saisieWilaya(rep);
			if (w!=null) break;
			System.out.print("numéro wilaya incorrect ! reéssayer : ");
			}while(true);
			
			ad=new Adresse(numRue, nomRue, w);
			clnCol.get(rang).setAdresse(ad); //on modifier l'adresse
			
		case 2:
			 
			
			System.out.println();
			System.out.println("1-Bloquer le client");
			System.out.println("2-Débloquer le client");
			
			System.out.print("votre choix : ");
			//controle de choix
			do
			{
				rep=sc.nextInt();
				if(rep >0 && rep <3) break;
				System.out.println();
				System.out.print("choix invalide ! réessayer : ");
			}while(true);
			
			switch(rep) {
			case 1:
				clnCol.get(rang).active=false;
				break;
			case 2:
				clnCol.get(rang).active=true;
				break;
			
			}
			
			
		
		}
	}
	}
	
	//envoie le rang de client dans la collection si num existe
	//-1 sinon
	static int existClient(String numTele) { 
		
		for (int i=0;i<clnCol.size();i++) {if ( clnCol.get(i).getNumTele().equals(numTele) ) return i;  }
		return -1;
	}
	
	//supprimer un client
	static void supprimerClient() {
		int rang;
		String numTele;
		
		
		
		System.out.println();
		System.out.print("Donner le numéro de client a modifier : ");
		//control de numéro
		do
		{
			sc.nextLine();
		numTele=sc.nextLine();
		System.out.println();
		if (numTele.charAt(0)=='0' & numTele.length()==10) break;
		System.out.print("numéro inccorect ! veillez resaisir : ");
		}while(true);
		
		//on vérifie si ce numéro de client existe
		rang=existClient(numTele);
		if (rang == -1) System.out.println("Ce numéro ne correnspand a accun client ! \n\n");
	else {	
		clnCol.remove(rang);
	}
	}
	
	
	//remplissage automatique des données
	static void remplir() {
		//********************* OPERATEUR *****************************
		//7 point de vente 5 wilaya
		
		//wilaya
		ArrayList<CouvertureReseau> colCvrt=new ArrayList<CouvertureReseau> ();
		colCvrt.add(new CouvertureReseau(Adresse.saisieWilaya(16), 100)); //alger
		colCvrt.add(new CouvertureReseau(Adresse.saisieWilaya(35), 50));
		colCvrt.add(new CouvertureReseau(Adresse.saisieWilaya(15), 84));
		colCvrt.add(new CouvertureReseau(Adresse.saisieWilaya(12), 100));
		colCvrt.add(new CouvertureReseau(Adresse.saisieWilaya(9), 20));
		colCvrt.add(new CouvertureReseau(Adresse.saisieWilaya(1), 60));
		colCvrt.add(new CouvertureReseau(Adresse.saisieWilaya(48), 76));
		
		//modfication de la collection des couvertures dans l'opérateur
		oprCol.get(0).setCouverture(colCvrt);
		
		//point de vente
		ArrayList<PointVente> colP=new ArrayList<PointVente> ();
		Adresse adrss;
		
		adrss=new Adresse(17, "1er novelbre", Adresse.saisieWilaya(35));
		colP.add(new PointVente("omarVente", 1, adrss, "0123456789"));
		
		adrss=new Adresse(4, "Didouche", Adresse.saisieWilaya(16));
		colP.add(new PointVente("OoredooAgc", 1, adrss, "0258741369"));
		
		adrss=new Adresse(2, "zighod youcef", Adresse.saisieWilaya(48));
		colP.add(new PointVente("hettUl", 1, adrss, "0874521369"));
		
		adrss=new Adresse(10, "rue 02", Adresse.saisieWilaya(15));
		colP.add(new PointVente("KabylieVente", 2, adrss, "0564789213"));
		
		adrss=new Adresse(12, "zyama mansouria", Adresse.saisieWilaya(12));
		colP.add(new PointVente("abdou", 1, adrss, "0789654123"));
		
		adrss=new Adresse(8, "el emir", Adresse.saisieWilaya(16));
		colP.add(new PointVente("Ness", 2, adrss, "0523456789"));
		
		adrss=new Adresse(35, "krim belkacem", Adresse.saisieWilaya(31));
		colP.add(new PointVente("Paris", 2, adrss, "0665891478"));
		
		//modificatio dans l'opérateur
		oprCol.get(0).setPointV(colP);
		
		//********************************* CLIENTS ****************************
		
		ArrayList<Appel> colAppl=new ArrayList<Appel> ();
		Date date=new Date();
		AdresseMail email=new AdresseMail("ProjetPoo", "gmail", "fr");
		
		
		//client 1
		//ajout
		//l'adresse de client
				adrss=new Adresse(17, "1er novelbre", Adresse.saisieWilaya(35));
		//par type  de client
		clnCol.add(new ClientForfaitaire("0580064123", "u78965412", date, "omar", "bessaa", adrss, email, true, 2350, new Date(15,"juin",2018)));
		
		//les appels 
		//appel entré
		colAppl.add(new Appel(clnCol.get(0).getNumTele(),"0147852369", date, new Duree(5,34, 10), new Duree(0,1, 0)));
		//appel sorti
		colAppl.add(new AppelEmis("0147852369",clnCol.get(0).getNumTele(), date, new Duree(5,34, 10), new Duree(0,1, 0),4));
		
		//affectation des appels
		clnCol.get(0).setListAppel(colAppl);
		
		//*******************
		//client 2
		//ajout
		
		//l'adresse de client
				adrss=new Adresse(17, "1er novelbre", Adresse.saisieWilaya(19));
		//par type  de client
				clnCol.add(new ClientForfaitaire("0789654123", "u78965412", date, "omar", "bessaa", adrss, email, true, 2350, new Date(15,"juin",2018)));
		//les appels 
		//appel entré
		colAppl.add(new Appel(clnCol.get(1).getNumTele(),"0147852369", date, new Duree(5,34, 10), new Duree(0,1, 0)));
		//appel sorti
		colAppl.add(new AppelEmis("0147852369",clnCol.get(1).getNumTele(), date, new Duree(5,34, 10), new Duree(0,1, 0),4));
		
		
		
		//affectation des appels
		clnCol.get(1).setListAppel(colAppl);
		
		//*******************
		//client 3

		//l'adresse de client
		adrss=new Adresse(17, "1er novelbre", Adresse.saisieWilaya(16));
		
		//ajout
		//par type  de client
		clnCol.add(new ClientPrepaye("0587964123", "u78965412", date, "hicham", "inourar", adrss, email, true, 2350, new Date(15,"juin",2018)));
		//les appels 
		//appel entré
		colAppl.add(new Appel(clnCol.get(2).getNumTele(),"0147852369", date, new Duree(5,34, 10), new Duree(0,1, 0)));
		//appel sorti
		colAppl.add(new AppelEmis("0147852369",clnCol.get(2).getNumTele(), date, new Duree(5,34, 10), new Duree(0,1, 0),4));
		
		//affectation des appels
		clnCol.get(2).setListAppel(colAppl);
		
		//*******************
		//client 4
		//l'adresse de client
				adrss=new Adresse(17, "1er novelbre", Adresse.saisieWilaya(5));
				
				//ajout
				//par type  de client
				clnCol.add(new ClientForfaitaire("0654789321", "o741", date, "pilo", "alkk", adrss, email, true, 2350, new Date(15,"juin",2018)));
		//les appels 
		//appel entré
		colAppl.add(new Appel(clnCol.get(3).getNumTele(),"0147852369", date, new Duree(5,34, 10), new Duree(0,1, 0)));
		//appel sorti
		colAppl.add(new AppelEmis("0147852369",clnCol.get(3).getNumTele(), date, new Duree(5,34, 10), new Duree(0,1, 0),4));
		
		//affectation des appels
		clnCol.get(3).setListAppel(colAppl);
		
		//*******************
		//client 5

		//l'adresse de client
		adrss=new Adresse(17, "1er novelbre", Adresse.saisieWilaya(16));
		
		//ajout
		//par type  de client
		clnCol.add(new ClientForfaitaire("0741587963", "p789", date, "akli", "nuio", adrss, email, false, 2350, new Date(15,"juin",2018)));
		//les appels 
		//appel entré
		colAppl.add(new Appel(clnCol.get(4).getNumTele(),"0147852369", date, new Duree(5,34, 10), new Duree(0,1, 0)));
		//appel sorti
		colAppl.add(new AppelEmis("0147852369",clnCol.get(4).getNumTele(), date, new Duree(5,34, 10), new Duree(0,1, 0),4));
		
		//affectation des appels
		clnCol.get(4).setListAppel(colAppl);
		
		//*******************
		//client 6

		//l'adresse de client
		adrss=new Adresse(17, "1er novelbre", Adresse.saisieWilaya(16));
		
		//ajout
		//par type  de client
		clnCol.add(new ClientPrepaye("0897456321", "m47852", date, "kiko", "chinwi", adrss, email, true, 2350, new Date(15,"juin",2018)));
		//les appels 
		//appel entré
		colAppl.add(new Appel(clnCol.get(5).getNumTele(),"0147852369", date, new Duree(5,34, 10), new Duree(0,1, 0)));
		//appel sorti
		colAppl.add(new AppelEmis("0147852369",clnCol.get(5).getNumTele(), date, new Duree(5,34, 10), new Duree(0,1, 0),4));
		
		//affectation des appels
		clnCol.get(5).setListAppel(colAppl);
		
		//*******************
		//client 7

		//l'adresse de client
		adrss=new Adresse(17, "1er novelbre", Adresse.saisieWilaya(9));
		
		//ajout
		//par type  de client
		clnCol.add(new ClientLibre("0478965123", "p48", date, "kjhs", "nerr", adrss, email, true, 2350, new Date(15,"juin",2018)));
		//les appels 
		//appel entré
		colAppl.add(new Appel(clnCol.get(6).getNumTele(),"0147852369", date, new Duree(5,34, 10), new Duree(0,1, 0)));
		//appel sorti
		colAppl.add(new AppelEmis("0147852369",clnCol.get(6).getNumTele(), date, new Duree(5,34, 10), new Duree(0,1, 0),4));
		
		//affectation des appels
		clnCol.get(6).setListAppel(colAppl);
		
		//*******************
		//client 8

		//l'adresse de client
		adrss=new Adresse(17, "1er novelbre", Adresse.saisieWilaya(35));
		
		//ajout
		//par type  de client
		clnCol.add(new ClientLibre("0147258369", "5412", date, "omar", "bessaa", adrss, email, true, 2350, new Date(15,"juin",2018)));
		//les appels 
		//appel entré
		colAppl.add(new Appel(clnCol.get(7).getNumTele(),"0147852369", date, new Duree(5,34, 10), new Duree(0,1, 0)));
		//appel sorti
		colAppl.add(new AppelEmis("0147852369",clnCol.get(7).getNumTele(), date, new Duree(5,34, 10), new Duree(0,1, 0),4));
		
		//affectation des appels
		clnCol.get(7).setListAppel(colAppl);
		
		//*******************
		//client 9

		//l'adresse de client
		adrss=new Adresse(17, "1er novelbre", Adresse.saisieWilaya(15));
		
		//ajout
		//par type  de client
		clnCol.add(new ClientPrepaye("0321456987", "965412", date, "omar", "bessaa", adrss, email, true, 2350, new Date(15,"juin",2018)));
		//les appels 
		//appel entré
		colAppl.add(new Appel(clnCol.get(8).getNumTele(),"0147852369", date, new Duree(5,34, 10), new Duree(0,1, 0)));
		//appel sorti
		colAppl.add(new AppelEmis("0147852369",clnCol.get(8).getNumTele(), date, new Duree(5,34, 10), new Duree(0,1, 0),4));
		
		//affectation des appels
		clnCol.get(8).setListAppel(colAppl);
		
		//*******************
		//client 10

		//l'adresse de client
		adrss=new Adresse(17, "1er novelbre", Adresse.saisieWilaya(19));
		
		//ajout
		//par type  de client
		clnCol.add(new ClientForfaitaire("066932541", "u78965412", date, "omar", "bessaa", adrss, email, true, 2350, new Date(15,"juin",2018)));
		//les appels 
		//appel entré
		colAppl.add(new Appel(clnCol.get(9).getNumTele(),"0147852369", date, new Duree(5,34, 10), new Duree(0,1, 0)));
		//appel sorti
		colAppl.add(new AppelEmis("0147852369",clnCol.get(9).getNumTele(), date, new Duree(5,34, 10), new Duree(0,1, 0),4));
		
		//affectation des appels
		clnCol.get(9).setListAppel(colAppl);
		
		//*******************
	}
	
	
}
