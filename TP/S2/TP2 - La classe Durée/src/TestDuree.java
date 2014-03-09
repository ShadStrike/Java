import java.util.*;

public class TestDuree {
	
	/**
	 * Demande une duree
	 * @return duree
	 * @throws DureeExeption
	 */
	private static Duree entrerDuree(Scanner entree) throws DureeException
	{
		int h;
		int m;
		int s;		
		System.out.println("Entrer une duree");
		System.out.println("Heures ?");
		h = entree.nextInt();
		System.out.println("Minutes ?");
		m = entree.nextInt();
		System.out.println("Secondes ?");
		s = entree.nextInt();
		Duree time = new Duree(h,m,s) ;
		return time;		
	}
	
	/**
	 * Calcule la difference de deux duree
	 * @param time1
	 * 		duree
	 * @param time2
	 * 		duree
	 * @return duree
	 * 		Duree issue de la difference de time1 et time2
	 * @throws DureeExeption
	 */
	private static Duree differenceDuree(Duree time1,Duree time2) throws DureeException
	{
		Duree timeR = new Duree (0,0,0);
		if (time2.egal(time1))
			System.out.println("0");
		else if (time2.inf(time1))
		{
			while (! time2.egal(time1))
			{
				time2.plusUneSeconde();
				timeR.plusUneSeconde();
			}
		}	
			else 
			{
				while (! time1.egal(time2))
				{
				time1.plusUneSeconde();
				timeR.plusUneSeconde();
				}
			}
		return timeR;
	}
	
	/**
	 * Application principal :
	 *		 Demande deux duree et affiche leur difference
	 * @param args
	 * @throws DureeExeption
	 */
	public static void main(String[] args) throws DureeException 
	{		
		Duree time1;
		Duree time2;
		Duree time3 = new Duree (0,0,0);		
		Scanner entree = new Scanner(System.in);
	
		time1 = TestDuree.entrerDuree(entree);
		time2 = TestDuree.entrerDuree(entree);	
		time3 = TestDuree.differenceDuree(time1,time2);
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("--   Il y a " + time3 + " de difference entre les deux durees.   --");
		System.out.println("-------------------------------------------------------------");
		entree.close();
	}
}
