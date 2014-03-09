
public class Date {
	private int Jour;
	private int Mois;
	private int Annee;
	
	/**
	 * Cree une Date a partir d'un jour,un mois et une annee
	 * @param jour
	 * 			Jour de la date
	 * @param mois
	 * 			Mois de la date
	 * @param annee
	 * 			Annee de la date
	 */
	public Date (int jour,int mois,int annee) 
	throws DateException
	{
		if (jour <= this.nbJoursMois(mois,annee) && mois >= 1 && mois <= 12 && annee >= 1583 && annee <= 9999)
		{
			this.Jour = jour;
			this.Mois = mois;
			this.Annee = annee;
		}
		else
			throw new DateException();
	}
	
	/**
	 * Retourne le numero du jour d'une date
	 * @return int
	 */
	public int nJour()
	{
		return this.Jour;
	}
	
	/**
	 * Retourne le numero du mois d'une date
	 * @return int
	 */
	public int nMois()
	{
		return this.Mois;
	}
	
	/**
	 * Retourne le numero de l'annee d'une date
	 * @return int
	 */
	public int nAnnee()
	{
		return this.Annee;
	}
	
	/**
	 * Verifie si une annee est bissextile
	 * @param a
	 * 			Annee a verifier
	 * @return boolean
	 * 			Vrai si l'annee est bissextile sinon faux
	 */
	public boolean bissextile(int a)
	{
		return ((a % 400 == 0) || (a % 4 == 0 && a % 100 != 0));
	}
	
	/**
	 * Retourne le nombre de jour dans un certain mois m de l'annee a
	 * @param m
	 * 			Mois
	 * @param a
	 * 			Annee
	 * @return int
	 * @throws DateException
	 */
	public int nbJoursMois(int m,int a) throws DateException
	{
		switch (m)
		{    
		case 1: case 3: case 5: 
		case 7: case 8: case 10: 
		case 12:
			return 31;
       
		case 4: case 6: 
		case 9: case 11:
			return 30;
	
		case 2 :  
			if (this.bissextile(a))
				return 29;
			else
				return 28;
    	
		default:
			throw new DateException();
		}		
	}
	
	/**
	 * Retourne la date du lendemain
	 * @return Date
	 * 			Date d'origine
	 * @throws DateException
	 */
	public Date lendemain() 
	throws DateException
	{
		if (this.Jour < this.nbJoursMois(this.Mois,this.Annee))
			return new Date(this.Jour + 1,this.Mois,this.Annee);
		else if (this.Mois < 12)
			return new Date(1,this.Mois + 1,this.Annee); 
		else
			return new Date(1,1,this.Annee + 1);
	}
	
	/**
	 * Verifie si deux dates sont equivalentes
	 * @param a
	 * @return boolean
	 * 			Vrai si equivalente sinon faux
	 */
	public boolean equals(Date a)
	{
		return(this.Jour == a.Jour && this.Mois == a.Mois && this.Annee == a.Annee);
	}
	
	/**
	 * Retourne le jour d'une date sous forme d'une chaine de caractère
	 * @return String
	 * 			Jour sous forme de chaine de charactère
	 */
	public String jourSemaine()
	{
		int c = (14 - this.nMois())/12;
		int a = this.nAnnee() - c;
		int m = this.nMois()*c - 2;
		int j = (this.nJour() + a + a/4 - a/100 + a/400 + 31*m/12) % 7;
		switch (j) 
		{
		case 0:
        	return("Dimanche");
		case 1:
        	return("Lundi");
		case 2:
        	return("Mardi");
		case 3:
        	return("Mercredi");
		case 4:
        	return("Jeudi");
		case 5:
        	return("Vendredi");
		case 6:
        	return("Samedi");
		default:
            return("Date incorecte");
		}
	}
	
	/**
	 Retourne le Mois d'une date sous forme d'une chaine de caractère
	 * @return String
	 * 			Mois sous forme de chaine de charactère
	 */
	public String moisLettres()
	{
		switch (this.nMois()) 
		{
		case 1:
        	return("Janvier");
		case 2:
        	return("Fevrier");
		case 3:
        	return("Mars");
		case 4:
        	return("Avril");
		case 5:
        	return("Mai");
		case 6:
        	return("Juin");
		case 7:
        	return("Juillet");
		case 8:
        	return("Août");
		case 9:
        	return("Septembre");
		case 10:
        	return("Octobre");
		case 11:
        	return("Novembre");
		case 12:
        	return("Decembre");	
		default:
            return("Date incorecte");
		}
	}
	
	/**
	 * Ecrit la date sous forme de chaine de charactère
	 * @return String 
	 */
	public String toString()
	{
		return ("" + this.jourSemaine() + " " + this.Jour + " " + this.moisLettres() + " " + this.Annee);
	}
}