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
		int i = monome.exposant();
		if ( i<this.listeMonome.size() && (this.listeMonome.get(i)).estNul())  
		{
			this.listeMonome.set(i, monome);
		} 
		else if ( i<this.listeMonome.size() && !((this.listeMonome.get(i)).estNul()))
				throw new PolynomeException(2);
		else
		{
		 
		   while( this.listeMonome.size()<i ) 
		   {
			   this.listeMonome.add(new Monome(0, this.listeMonome.size()));
		   }
		 
		   this.listeMonome.add(monome);
		}
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
		Polynome p2 = p;
		Polynome this2 = this;
		Polynome r = new Polynome();
		while (this2.listeMonome.size() < p2.listeMonome.size())
			this2.listeMonome.add(new Monome(0, this.listeMonome.size()));
		while (this2.listeMonome.size() > p2.listeMonome.size())
			p2.listeMonome.add(new Monome(0, p.listeMonome.size()));
		r.listeMonome.add(0,new Monome(((this2.listeMonome.get(0)).coefficient() + (p2.listeMonome.get(0)).coefficient()),0));
		for(int i = 1;i < this2.listeMonome.size();i++)
			r.listeMonome.add(new Monome(((this2.listeMonome.get(i)).coefficient() + (p2.listeMonome.get(i)).coefficient()), i));
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
		for (int i = 0;i < this.listeMonome.size(); i++)
		{
			if ((((this.listeMonome.get(i)).produit(m)).exposant() < r.listeMonome.size()) && (this.listeMonome.get(i)).estNul())
				{
				r.listeMonome.set(((this.listeMonome.get(i)).produit(m)).exposant(),(this.listeMonome.get(i)).produit(m));
				if (((this.listeMonome.get(i)).produit(m)).exposant() != i)
					r.listeMonome.set(i,new Monome(0,0));
				}
			else if ((((this.listeMonome.get(i)).produit(m)).exposant() < r.listeMonome.size()) && !(this.listeMonome.get(((this.listeMonome.get(i)).produit(m)).exposant())).estNul())
				{
				r.listeMonome.set(((this.listeMonome.get(i)).produit(m)).exposant(),(this.listeMonome.get(((this.listeMonome.get(i)).produit(m)).exposant())).somme(((this.listeMonome.get(i)).produit(m))));
				if (((this.listeMonome.get(i)).produit(m)).exposant() != i)
					r.listeMonome.set(i,new Monome(0,0));
				}
			else if ((((this.listeMonome.get(i)).produit(m)).exposant() >= r.listeMonome.size()))
				r.ajouterMonome(((this.listeMonome.get(i)).produit(m)));
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
			r.ajouterMonome((this.listeMonome.get(i)).derivee());
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
		{
			r = false;
		}
		else if (this.listeMonome.size() == p.listeMonome.size())
		{
			for (int i=0;i < this.listeMonome.size();i++)
			{
			if ((this.listeMonome.get(i)).coefficient() != (p.listeMonome.get(i)).coefficient())
				{
				r = false;
				}
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
		return (this.listeMonome.size()-1);
	}
	
	/**
	 * Ecris le Polynome sous forme de chaine de caractères
	 */
	public String toString()
	{
		String res = "";
		int i = 0;
		if (this.equal(new Polynome()))
			return res;
		while ((this.listeMonome.get(i)).estNul())
		{
			i++;
		}
		res += (this.listeMonome.get(i)).toString();
		i++;
		while  (i < this.listeMonome.size())
		{
			if(!(this.listeMonome.get(i)).estNul())
			{
				if((this.listeMonome.get(i)).coefficient() >= 0)
				{
					res += " + ";
					res += (this.listeMonome.get(i)).toString();
				}
				else if ((this.listeMonome.get(i)).coefficient() < 0)
				{
					res += " - ";
					res += ((this.listeMonome.get(i)).coefficient() -2*(this.listeMonome.get(i)).coefficient());
					res += "ex";
					res += this.listeMonome.get(i).exposant();
				}
			}
			i ++;
		}
		return res;
	}
}