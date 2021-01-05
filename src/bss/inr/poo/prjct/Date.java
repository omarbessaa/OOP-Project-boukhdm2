package bss.inr.poo.prjct;

import java.util.Scanner;




public class Date {
	//attributs
		private int jour;
		private EnumMois mois;
		private int annee;

	//methodes
		//consturcteur sans parametres
		public Date() {
			this.jour=1;
			this.mois=EnumMois.janvier;
			this.annee=2018;
		}
		//consturcteur avec parametres
		public Date(int jour,String mois,int annee) {
			this.jour=jour;
			this.mois=EnumMois.valueOf(mois);
			this.annee=annee;
		}
		//****************************************************
		public boolean verif() { //annee > 1900 ?
			if (this.jour>0 ) {
				if ( this.mois.equals(EnumMois.fevrier) ) {
					if  (bissextile(this.annee))  return this.jour<30;//annee bissex ==> fervrier 29
					else return this.jour<29; //fevrier 28
				}//if*jours
				else { //mois n'est pas fevrier
					  if (this.mois.compareTo(EnumMois.aout) >= 0) {
								if ((this.mois.ordinal() % 2)==0) return (this.jour < 31); //le rang de mois est 8 ou 10 *ca commence a partir de zero*(sep ou nev) ==> 30jours
								else return (this.jour < 32); //aout oct dec ==> 31 jours
					 }else { //if*>aout ==> contraire
						      if ((this.mois.ordinal() % 2)==0) return (this.jour < 32); //jan mars mai juil ==> 31j
						      else return (this.jour < 31); //avril juin ==>30j
						   }
				}	
			}else return false; //jour < 0 ==> false
			
			
		}//fin verif
		
		//bissextile static ?
		public static boolean bissextile(int annee){
			if ( ((annee%4==0) && (annee%100!=0)) || (annee%400==0) ) return true;
			else return false;
			}
		
		//saisir static ?
		public void saisir(Scanner sc) {
			
			int jour,annee, m;
			EnumMois mois=null;
			boolean  exist=false;
			boolean loop=true;
			
			do
			{
				System.out.print("Saisir le jour : ");
				jour=sc.nextInt();  this.jour=jour;
				System.out.print("Saisir le numéro de mois : ");
				m=sc.nextInt();     
				System.out.print("Saisir l'année : ");
				annee=sc.nextInt();  this.annee=annee;
				
				//verification de mois 
				for (EnumMois i : EnumMois.values())
				{
					if (i.ordinal()==(m-1)) { mois=i; exist=true; break;} 
				}
				this.mois=mois;
				if (exist && this.verif()) loop=false;
				else System.out.println("Date erronée veillez resaisir !");
				
			}while(loop);
		
		}
		
		//compare
		public int comparerA(Date d) {
	   	  if (this.annee > d.annee) return 1;
	   	  else if (this.annee < d.annee) return -1;
	   	  else 
	   	  {
	   		  if ((this.mois.compareTo(d.mois))>0) return 1;
	       	  else if ((this.mois.compareTo(d.mois))<0) return -1;
	       	  else   
	       	  {
	       		  if (this.jour > d.jour) return 1;
	           	  else if (this.jour < d.jour) return -1;
	           	  else return 0;
	       	  }
	   	  }
	   	  
	     }
		
		public String toString() {
			 return this.jour +" "+ this.mois.toString() +" " + this.annee;
		}

}
