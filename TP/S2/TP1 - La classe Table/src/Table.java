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
     * cr�e un tableau d'entiers vide
     */
    public Table() {
        this.tabEntiers = new int[Table.TAILLE_MAX];
        this.nbValeurs = 0;
    }

    /**
     * lit et range dans un tableau d'entiers une suite de valeurs termin�e par
     * un marqueur de fin
     * 
     * @param entr�e
     *            flot standard d'entr�e
     */
    public void lireValeurs(Scanner entr�e) {
        int marqueur; // valeur du marqueur de fin
        int valeur; // une valeur lue
        int i; // indice de parcours du tableau
        // lire la valeur du marqueur de fin
        System.out.print("Quelle est la valeur du marqueur de fin ? ");
        marqueur = entr�e.nextInt();
        // lire les valeurs et les stocker dans le tableau
        System.out.print("Donner la liste des valeurs termin�e par le marqueur ? ");
        valeur = entr�e.nextInt();
        i = 0;
        while (valeur != marqueur) {
            this.tabEntiers[i] = valeur;
            i++;
            valeur = entr�e.nextInt();
        }
        this.nbValeurs = i;
    }

    /**
     * �crit les valeurs du tableau d'entiers
     */
    public void �crireValeurs() {
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
     * recherche et renvoie le rang de la premi�re occurrence d'une valeur d'un
     * tableau d'entiers
     * 
     * @param valeur
     *            valeur � rechercher
     * @return indice de la premi�re occurrence de valeur si elle existe -1
     *         sinon
     */
    public int rang1�reOccurrenceValeur(int valeur) {
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
     * ins�re une valeur dans un tableau d'entiers suppos� tri� de l'indice 0 �
     * l'indice k-1
     * 
     * @param k
     *            nombre d'�l�ments tri�s
     * @param valeur
     *            valeur � ins�rer
     */
    private void ins�rerValeur(int k, int valeur) {
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
        	this.ins�rerValeur(i-1,this.tabEntiers[i]);
    }
    
    /**
     * calcul la moyenne des �l�ments stock�s dans le tableau
     * @return moyenne 
     * */
    public int moyenneElementsStocke(){
    	int s = 0;
    	for(int i=0;i<nbValeurs;i++)
    		s = s +this.tabEntiers[i];
    	return s / this.nbValeurs ;
    }
}
