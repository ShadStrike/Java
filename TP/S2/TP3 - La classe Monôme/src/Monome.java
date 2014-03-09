import java.lang.*;

public class Monome 
{
	private float c;
	private int e;
	
	/**
	 * Cree un monome de coefficient c et d'exposant e
	 * @param c
	 * @param e
	 */
	public Monome (float c, int e)
	{
		this.c = c;
		this.e = e;
	}

	/**
	 * Retourne le coefficient d'un monome
	 * @return float
	 */
	public float coefficient()
	{
		return this.c;
	}
	
	/**
	 * Retourne l'exposant d'un monome
	 * @return int
	 */
	public int exposant()
	{
		return this.e;
	}
	
	/**
	 * Effectue la somme entre un monome et un autre monome a
	 * @param a
	 * @throws ArithmeticException
	 */
	public Monome somme(Monome a) 
	throws ArithmeticException
	{
		if (this.e == a.e)
			return new Monome(this.c + a.c,this.e);
		else
			throw new ArithmeticException();
	}
	
	/**
	 * Effectue le produit entre un monome et un autre monome a
	 * @param a
	 */
	public Monome produit(Monome a)
	{
		return new Monome(this.c * a.c,this.e + a.e);
	}
	
	/**
	 * 	Retourne la derivee d'un monome
	 */
	public Monome derivee()
	{
		if(this.e == 0)
			return new Monome (0,0);
		else
			return new Monome (this.c * this.e,this.e -1);
	}
	
	/**
	 * Dit si un monome est nul
	 * @return boolean
	 */
	public boolean estNul()
	{
		return (this.c == 0);
	}
	
	/**
	 * Ecrit le monome sous forme de chaine de caractères
	 * @return String
	 */
	public String toString()
	{
		return ("" + this.c + "xe" + this.e);
	}
}