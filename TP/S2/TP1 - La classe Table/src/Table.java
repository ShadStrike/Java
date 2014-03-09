import java.util.Scanner;

public class Table {
    /**
     * nombre maximum d'entiers contenus dans le tableau
     */
    public static final int TAILLE_MAX = 100;
    /**
     * tableau contenant les entiers
     */
    private int[] tabEntiers;
    /**
     * nombre d'entiers contenus dans le tableau
     */
    private int nbValeurs;

    /**
     * crée un tableau d'entiers vide
     */
    public Table() {
        this.tabEntiers = new int[Table.TAILLE_MAX];
        this.nbValeurs = 0;
    }

    /**
     * lit et range dans un tableau d'entiers une suite de valeurs terminée par
     * un marqueur de fin
     * 
     * @param entrée
     *            flot standard d'entrée
     */
    public void lireValeurs(Scanner entrée) {
        int marqueur; // valeur du marqueur de fin
        int valeur; // une valeur lue
        int i; // indice de parcours du tableau
        // lire la valeur du marqueur de fin
        System.out.print("Quelle est la valeur du marqueur de fin ? ");
        marqueur = entrée.nextInt();
        // lire les valeurs et les stocker dans le tableau
        System.out.print("Donner la liste des valeurs terminée par le marqueur ? ");
        valeur = entrée.nextInt();
        i = 0;
        while (valeur != marqueur) {
            this.tabEntiers[i] = valeur;
            i++;
            valeur = entrée.nextInt();
        }
        this.nbValeurs = i;
    }

    /**
     * écrit les valeurs du tableau d'entiers
     */
    public void écrireValeurs() {
        for (int i = 0; i < this.nbValeurs; i++) {
            System.out.print(this.tabEntiers[i] + "\t");
        }
        System.out.println();
    }

    /**
     * recherche le rang du minimum d'un tableau d'entiers
     * 
     * @return indice de la plus petite valeur
     */
    public int indiceMinimum() {
        int iMin; // rang du minimum
        iMin = 0;
        for (int i = 1; i < this.nbValeurs; i++) {
            if (this.tabEntiers[i] < this.tabEntiers[iMin]) {
                iMin = i;
            }
        }
        return iMin;
    }

    /**
     * recherche et renvoie le rang de la première occurrence d'une valeur d'un
     * tableau d'entiers
     * 
     * @param valeur
     *            valeur à rechercher
     * @return indice de la première occurrence de valeur si elle existe -1
     *         sinon
     */
    public int rang1èreOccurrenceValeur(int valeur) {
        int i;
        for (i = 0; i < this.nbValeurs && this.tabEntiers[i] != valeur; i++) {
        }
        if (i == this.nbValeurs) {
            return -1;
        } else {
            return i;
        }
    }

    /**
     * insère une valeur dans un tableau d'entiers supposé trié de l'indice 0 à
     * l'indice k-1
     * 
     * @param k
     *            nombre d'éléments triés
     * @param valeur
     *            valeur à insérer
     */
    private void insérerValeur(int k, int valeur) {
        int i;
        for (i=k;i>=0 && this.tabEntiers[i]>valeur;i--)
        	this.tabEntiers[i+1]=this.tabEntiers[i];
        this.tabEntiers[i+1]=valeur;
    }

    /**
     * tri par insertion d'un tableau d'entiers
     */
    public void trierParInsertion() {
        for(int i=1;i<this.nbValeurs;i++)
        	this.insérerValeur(i-1,this.tabEntiers[i]);
    }
    
    /**
     * calcul la moyenne des éléments stockés dans le tableau
     * @return moyenne 
     * */
    public int moyenneElementsStocke(){
    	int s = 0;
    	for(int i=0;i<nbValeurs;i++)
    		s = s +this.tabEntiers[i];
    	return s / this.nbValeurs ;
    }
}
