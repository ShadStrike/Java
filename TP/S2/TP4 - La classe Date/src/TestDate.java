import java.util.Scanner;

public class TestDate 
{
	/**
	 * affiche le menu de l'application
	 */
	public static void afficherMenu()
	{
		System.out.println("########################################################");
		System.out.println("##                TP2 - La classe Date                ##");
		System.out.println("########################################################");
        System.out.println("#   1- Modifier la date                                #");
        System.out.println("#   2- Afficher la date                                #");
        System.out.println("#   3- Afficher le nombre de jour du mois courant      #");
        System.out.println("#   4- Calculer la date du lendemain                   #");
        System.out.println("#   5- Verifier si c'est une annee bisextile           #");
        System.out.println("#   6- Comparer a une autre date                       #");
        System.out.println("#   7- Quitter l'application                           #");
        System.out.println("########################################################");
        System.out.println("Quel est votre choix ?");
	}
	/**
	 * lit une Date sur l'entree standard (jour, mois et annee)
	 * @param entree 
	 * 			scanner associe au flot standard d'entree
	 * @throws DateException 
	 */
	public static Date lectureDate(Scanner entree) throws DateException
	{		
		int j;
		int m;
		int a;	
		System.out.println("Jour?");
    	j = entree.nextInt();
    	System.out.println("Mois?");
    	m = entree.nextInt();
    	System.out.println("Annee?");
    	a = entree.nextInt();
    	Date d = new Date(j,m,a);
		return d;
	}
	/**
	 * Propose un menu orientant sur differents traitements pour tester la classe Date
	 * @param args
	 * @throws DateException 
	 */
	public static void main(String[] args) throws DateException
		{
			int choix;
			boolean fini = false;
			Date d = new Date(1,1,1583);
			Date d2 = new Date(1,1,1583);
			Scanner entree = new Scanner(System.in);
			
			do {
				TestDate.afficherMenu();
				choix = entree.nextInt();
	            switch (choix) {
	            case 1:
	            	d = TestDate.lectureDate(entree);
	                break;
	                
	            case 2:
	            	System.out.println(d);
	                break;
	                
	            case 3:
	            	System.out.println(d.nbJoursMois(d.nMois(),d.nAnnee()));
	                break;
	            
	            case 4:
	            	System.out.println(d.lendemain());
	                break;
	                
	            case 5:
	            	if (d.bissextile(d.nAnnee()))
	            		System.out.println("" + d.nAnnee() + " est une annee bissextile");
	            	else
	            		System.out.println("" + d.nAnnee() + " n'est pas une annee bissextile");
	                break;
	                
	            case 6:
	            	System.out.println("Entrer la date a comparer");
	            	d2 = TestDate.lectureDate(entree);
	            	if (d.equals(d2))
	            		System.out.println("Les deux dates sont equivalentes");
	            	else
	            		System.out.println("Les deux dates sont differentes");
	                break;
	       	                
	            case 7:
	                fini = true;
	                break;
	            default:
	                System.out.println("choix errone");
	            }
	        } while (!fini);
	        System.out.println("le programme est termine");
	        entree.close();
	            }			
}