import java.util.Scanner;


public class TestMonome 
{
	/**
	 * affiche le menu de l'application
	 */
	public static void afficherMenu()
	{
		System.out.println("Quel est votre choix :");
        System.out.println("   1- Modifier le premier monome");
        System.out.println("   2- Modifier le deuxième monome");
        System.out.println("   3- Afficher le premier monome");
        System.out.println("   4- Afficher le deuxième monome");
        System.out.println("   5- Calculer la somme des 2 monomes");
        System.out.println("   6- Calculer le produit des 2 monomes");
        System.out.println("   7- Calculer la derivee du premier monome");
        System.out.println("   8- Calculer la derivee du deuxième monome");
        System.out.println("   9- Quitter l'application");
	}
	
	/**
	 * lit un monome sur l'entree standard (coefficient et exposant)
	 * @param entree 
	 * 			scanner associe au flot standard d'entree
	 */
	public static Monome lectureMonome(Scanner entree)
	{
		float c;
		int e;	
		System.out.println("Nouveau coefficient?");
    	c = entree.nextFloat();
    	System.out.println("Nouveaux exposant?");
    	e = entree.nextInt();
    	Monome a = new Monome(c,e);
		return a;
	}
	
	/**
	 * Propose un menu orientant sur differents traitements pour tester la classe Monome
	 * @param args
	 */
	public static void main(String[] args)
		{
		int choix;
        boolean fini = false;
		Monome a = new Monome(0.0f,0);
		Monome b = new Monome(0.0f,0);
        Scanner entree = new Scanner(System.in);

		do {
            TestMonome.afficherMenu();
            choix = entree.nextInt();
            switch (choix) 
            {
            case 1:
            	a = TestMonome.lectureMonome(entree);
                break;
                
            case 2:
            	b = TestMonome.lectureMonome(entree);
                break;
                
            case 3:
            	System.out.println(a);
                break;
            
            case 4:
            	System.out.println(b);
                break;
                
            case 5:
            	System.out.println(a.somme(b));    
                break;
                
            case 6:
            	System.out.println(a.produit(b)); 
                break;
                
            case 7:
            	System.out.println(a.derivee()); 
                break;
                
            case 8:
            	System.out.println(b.derivee());
                break;
                
            case 9:
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