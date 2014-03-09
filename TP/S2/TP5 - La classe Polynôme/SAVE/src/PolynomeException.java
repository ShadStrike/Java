public class PolynomeException extends Exception
{
	/**
	 * Exception en cas de calcul incorect
	 */
	private static final long serialVersionUID = 1L;

	public PolynomeException(int i)
	{
		switch (i) 
		{
		case 1:
			System.out.println("Calcul Impossible");
			break;
		case 2:
			System.out.println("Impossible d'ajouter ce monôme, un monôme du même degré est déja inclu dans ce polynôme");
			break;
		 default:
             System.out.println("Erreure inconue");
		}
	}  
}
