import java.util.Scanner;


public class TestPolynome 
{
	/**
	 * affiche le menu de l'application
	 */
	public static void afficherMenu()
	{
		System.out.println("-----------------------------------------------------------------");
		System.out.println("|                   TP5 - La classe Polynome                    |");
		System.out.println("-----------------------------------------------------------------");
        System.out.println("|   1- Aficher un polynome                                      |");
        System.out.println("|   2- Ajouter des monome a un polynome                         |");
        System.out.println("|   3- Calculer le degre d'un polynome                          |");
        System.out.println("|   4- Calculer la derivee d'un polynome                        |");
        System.out.println("|   5- Verifier l'egalite entre deux polynome                   |");
        System.out.println("|   6- Calculer la somme de deux polynome                       |");
        System.out.println("|   7- Calculer le produit d'un polynome avec un monome         |");
        System.out.println("|   8- Quitter l'application                                    |");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Quel est votre choix ?");
	}
	
	/**
	 * Lit un monome
	 * @param entree
	 * 		Scanner
	 * @return a
	 *		Monome
	 */
	public static Monome lectureMonome(Scanner entree)
	{
		float c;
		int e;	
		System.out.println("Nouveau monome :");
		System.out.println("Coefficient?");
    	c = entree.nextFloat();
    	System.out.println("Exposant?");
    	e = entree.nextInt();
    	Monome a = new Monome(c,e);
		return a;
	}
	
	/**
	 * Lit un polynome
	 * @param entree
	 * 		Scanner
	 * @return P
	 * 		Polynome
	 * @throws PolynomeException
	 */
	public static Polynome lecturePolynome(Scanner entree) throws PolynomeException
	{
		int c;
		boolean fin = false;
		Polynome p = new Polynome();
		System.out.println("Entrer le premier Monome :");
		p.ajouterMonome(TestPolynome.lectureMonome(entree));
		do {
			System.out.println("Ajouter un autre monome? (1 oui/2 non)");
			c = entree.nextInt();
			switch (c) 
			{
			case 1:                
			p.ajouterMonome(TestPolynome.lectureMonome(entree));
				break;
			case 2:
                fin = true;
                break;
			}
		} while (!fin);
		return p;	
	}
	

	public static void main(String[] args) throws PolynomeException
	{
		int choix;
		int c1;
		int c2;
		boolean fini = false;
		Polynome poly = new Polynome();
		Polynome poly2 = new Polynome();
		Scanner entree = new Scanner(System.in);
		
		do {
			TestPolynome.afficherMenu();
			choix = entree.nextInt();
            switch (choix) 
            {
            case 1:
            	System.out.println("Quel polynome voulez vous afficher? (1 ou 2)");
            	c1 = entree.nextInt();
            	if (c1 == 1){
            		System.out.println("");
            		System.out.println(""+"         P(x)= "+poly.toString()+"                         ");
            		System.out.println("");
            	}
            	else if (c1 == 2){
            		System.out.println("");
                	System.out.println(""+"         Q(x)= "+poly2.toString()+"                         ");
                	System.out.println("");
            	}
            	else 
            		System.out.println("Entrer incorecte");
            	
                break;
                
            case 2:
            	System.out.println("A quel polynome voulez vous ajouter un monome? (1 ou 2)");
            	c1 = entree.nextInt();
            	if (c1 == 1){
            		System.out.println("Combien de monome voulez vous ajouter?");
            		c2 = entree.nextInt();
            		for (int c3=1;c3<=c2;c3++){
            			poly.ajouterMonome(TestPolynome.lectureMonome(entree));
            		}
            	}
            	else if (c1 == 2){
            		System.out.println("Combien de monome voulez vous ajouter?");
            		c2 = entree.nextInt();
            		for (int c3=1;c3<=c2;c3++){
            			poly2.ajouterMonome(TestPolynome.lectureMonome(entree));
            		}
        		}
            	else
            		System.out.println("Entrer incorecte"); 
                break;
                
            case 3:
            	System.out.println("De quel polynome voulez vous le degre? (1 ou 2)");
            	c1 = entree.nextInt();
            	if (c1 == 1)
            		System.out.println("" + "         Le polynome est de degre " + poly.degre() + ".");
            	else if (c1 == 2)
            		System.out.println("" + "         Le polynome est de degre " + poly2.degre() + ".");
            	else
            		System.out.println("Entrer incorecte"); 
                break;
            
            case 4:
            	System.out.println("De quel polynome voulez vous la derive? (1 ou 2)");
            	c1 = entree.nextInt();
            	if (c1 == 1)
            		System.out.println("" + "         P'(x)= " + (poly.derivee()).toString() + ".");
            	else if (c1 == 2)
            		System.out.println("" + "         P'(x)= " + (poly2.derivee()).toString() + ".");
            	else
            		System.out.println("Entrer incorecte");
                break;
                
            case 5:
            	if (poly.equal(TestPolynome.lecturePolynome(entree)))
            		System.out.println("P(x) = Q(x)");
            	else
            		System.out.println("P(x) /= Q(x)");
                break;
                
            case 6:
            	System.out.println(""+"P(x) + Q(x) = "+(poly.somme(poly2)).toString());
                break;
            case 7:
            	System.out.println("De quel polynome voulez vous faire le produit? (1 ou 2)");
            	c1 = entree.nextInt();
            	Monome ent = TestPolynome.lectureMonome(entree);
            	if (c1 == 1)
            		System.out.println("" + "         P(x) * " + ent.toString() + " = " + poly.produit(ent) + ".");
            	else if (c1 == 2)
            		System.out.println("" + "         Q(x) * " + ent.toString() + " = " + poly2.produit(ent) + ".");
            	else
            		System.out.println("Entrer incorecte");
                break;
       	                
            case 8:
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
