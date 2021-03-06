import java.util.Scanner;

public class TestTable {

    public static void main(String[] args) {
        Table tab = new Table();
        int v;
        int rang;
        int choix;
        Scanner entr�e = new Scanner(System.in);
        tab.lireValeurs(entr�e);
        boolean fini = false;
        do {
            System.out.println("Que voulez-vous faire ?");
            System.out.println("   1- rechercher le rang de la 1ere occurrence d'une valeur");
            System.out.println("   2- rechercher la valeur minimum");
            System.out.println("   3- trier le tableau par insertion");
            System.out.println("   4- Calculer moyenne");
            System.out.println("   5- terminer le programme");
            choix = entr�e.nextInt();
            switch (choix) {
            case 1:
                System.out.println("Valeur � rechercher : ");
                v = entr�e.nextInt();
                rang = tab.rang1�reOccurrenceValeur(v);
                if (rang != -1) {
                    System.out.println("valeur trouv�e au rang " + rang);
                } else {
                    System.out.println("valeur non trouv�e");
                }
                break;
            case 2:
                System.out.println("rang minimum " + tab.indiceMinimum());
                break;
            case 3:
                tab.trierParInsertion();
                System.out.println("tableau tri�");
                tab.�crireValeurs();
                break;
            case 4:
                System.out.println("moyenne");
                System.out.println(tab.moyenneElementsStocke());
            	break;
            case 5:
                fini = true;
                break;
            default:
                System.out.println("choix erron�");
            }
        } while (!fini);
        System.out.println("le programme est termin�");
        entr�e.close();
    }
}
