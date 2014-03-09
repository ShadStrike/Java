public class Duree {

	private int secondes;
		
	/**
	 * Constructeur 
	 * */
		public Duree(int heures,int minutes, int secondes)
		throws DureeException
		{
			if (!(heures >= 0 && minutes >= 0 && secondes >= 0 && secondes < 60 && minutes < 60))
				throw new DureeException();	
			this.secondes = heures*3600 + minutes*60 + secondes;
		}

		
	/**
	 * Donne le nombre d'heure d'une duree
	 * @return nbHeures 
	 * 			nombre d'heures
	 */
		public int nbHeures()
		{
			return (this.secondes/3600);
		}
		
	/**
	 * Donne le nombre de minutes d'une duree
	 * @return nbMinutes
	 * 		 	nombre de minutes
	 */
		public int nbMinutes()
		{
			return ((this.secondes - (this.nbHeures()*3600))/60);
		}
		
	/**
	 * Donne le nombre de secondes d'une duree
	 * @return nbSecondes
	 * 		 	nombre de secondes
	 */
		public int nbSecondes()
		{
			return (this.secondes - this.nbHeures()*3600 - this.nbMinutes()*60);
		}
		
	/**
	 * Dit si deux duree sont egale
	 * @param Duree
	 * 			La secondes duree que l'on compare
	 * @return boolean
	 */
		public boolean egal(Duree a)
		{
			if (this.secondes == a.secondes) 
				return true;
			else
				return false;	
		}
		
	/**
	 * Dit si une duree est inerieur à un autre
	 * @param Duree
	 * 			La secondes duree que l'on compare
	 * @return boolean
	 */
		public boolean inf(Duree a)
		{
			if (this.secondes < a.secondes)
				return true;
			else
				return false;
		}
	/**
	 * Ajoute une seconde à une duree
	 * @return Duree
	 * 			La duree avec une seconde de plus
	 */
		public void plusUneSeconde()
		{
			this.secondes += 1;
		}
				
	/**
	 * Ecrit la duree sous forme d'une chaine : "heures:minutes:secondes"
	 * @return string
	 * 		duree
	 */
		public String toString()
		{
			return ("" + this.nbHeures() + ":" + this.nbMinutes() + ":" + this.nbSecondes());
		}
}
