import java.util.*;
public class Polynome {

	private List<Monome> listeMonome;
	
	/**
	 * Construit un Polynome vide
	 */
	public Polynome()
	{
		this.listeMonome = new LinkedList<>();
	}
	
	/**
	 * Ajoute un monome a un Polynome
	 * @param monome
	 * 		Monome a ajouter au Polynome source
	 * @throws PolynomeException 
	 */
	public void ajouterMonome(Monome monome) throws PolynomeException
	{
		int i = 0;
		if (this.listeMonome.size() == 0)	
			
		while (i < (this.listeMonome.size()) && monome.exposant() > (this.listeMonome.get(i)).exposant())
				{
					if (monome.exposant() == (this.listeMonome.get(i)).exposant())
						throw new PolynomeException(2);
					i ++;
				}
				if (i==0)
					this.listeMonome.add(monome);
				else
					this.listeMonome.add(i,monome);
	}
	
	/**
	 * Somme de deux Polynomes
	 * @param p
	 * 		Polynome a additioner au Polynome source
	 * @return r
	 * 		Polynome issue de la somme du Polynome source et du Polynome p
	 */
	public Polynome somme(Polynome p)
	{
		Polynome r = new Polynome();
		int i1 = 0;
		int i2 = 0;
		Monome m;
		while (i1 < this.listeMonome.size() && i2 < p.listeMonome.size()){
			if ((this.listeMonome.get(i1)).exposant() == (r.listeMonome.get(i2)).exposant()){
				m = (this.listeMonome.get(i1)).somme(r.listeMonome.get(i2));
				if (!(m.estNul())){
					r.listeMonome.add(m);
				}
				i1 ++;
				i2 ++;
			}
			else if ((this.listeMonome.get(i1)).exposant() < (r.listeMonome.get(i2)).exposant()){
				r.listeMonome.add(this.listeMonome.get(i1));
				i1 ++;
			}
			else {
				r.listeMonome.add(this.listeMonome.get(i2));
				i2 ++;
			}
		}
		while (i1 < this.listeMonome.size()){
			r.listeMonome.add(this.listeMonome.get(i1));
			i1 ++;
		}
		while (i1 < p.listeMonome.size()){
			r.listeMonome.add(this.listeMonome.get(i2));
			i2 ++;
		}
		return r;
	}
	
	/**
	 * Produit d’un Polynome et d’un monome
	 * @param m
	 * 		Monome utiliser pour multiplier
	 * @return r
	 * 		Polynome resultat du Produit du Polynome source et du monome m
	 * @throws PolynomeException
	 */
	public Polynome produit(Monome m) throws PolynomeException
	{
		Polynome r = new Polynome();
		boolean trouve = false;
		int i2 = 0;
		for (int i = 0;i < this.listeMonome.size(); i++)
		{
			while (i2 < this.listeMonome.size()){
				if ((((this.listeMonome.get(i)).produit(m)).exposant()) == (this.listeMonome.get(i2)).exposant())
					trouve = true;
				i2++;
			}		
			if (trouve)
				r.ajouterMonome(((this.listeMonome.get(i)).produit(m)).somme(this.listeMonome.get(i)));
			else
				r.ajouterMonome((this.listeMonome.get(i)).produit(m));
			trouve = false;
		}
		return r;
	}
	
	/**
	 * Derivee d’un Polynome
	 * @return Polynome
	 * 		Polynome issue de la derivee du Polynome source 
	 * @throws PolynomeException
	 */
	public Polynome derivee() throws PolynomeException
	{
		Polynome r = new Polynome();
		for (int i = 0; i < this.listeMonome.size();i++)
			r.listeMonome.add((this.listeMonome.get(i)).derivee());
		return r; 
	}
	
	/**
	 * Verifie si un Polynome est equivalent a en autre
	 * @param p
	 * 		Polynome utiliser pour la comparaison
	 * @return r 
	 * 		boolean - Vrai si equivalent sinon faux
	 */
	public boolean equal(Polynome p){
		boolean r = true;
		if (this.listeMonome.size() != p.listeMonome.size())
			r = false;
		else
		{
			for (int i=0;i < this.listeMonome.size();i++)
			{
			if ((this.listeMonome.get(i)).coefficient() != (p.listeMonome.get(i)).coefficient())
				r = false;
			}
		}
		return r;
			
	}
	
	/**
	 * Retourne le degre d'un Polynome
	 * @return int
	 * 		Degre du Polynome
	 */
	public int degre()
	{
		return ((this.listeMonome.get(this.listeMonome.size()-1)).exposant());
	}
	
	/**
	 * Ecris le Polynome sous forme de chaine de caractères
	 */
	public String toString()
	{
		String res = "";
		if (this.listeMonome.size() == 0)
			res += "0";
		for  (int i=0;i < this.listeMonome.size();i++)
		{
				if((this.listeMonome.get(i)).coefficient() > 0)
				{
					if (i != 0)
						res += " + ";
					res += (this.listeMonome.get(i)).toString();
				}
				else
					res += (" - " + -((this.listeMonome.get(i)).coefficient()) + "ex" + this.listeMonome.get(i).exposant());
		}
		return res;
	}
}