
public interface PolynomialADTList {
	
	public int getDegreeOfPolynomial();	//return the highest degree of polynomial
	
	public int getCoefficient(int power);	//return the coefficient of power inputed
	
	public void changeCoefficient(int newCoefficient, int power);	//change coefficient of what power
																//user wants to change
	public Polynomial addPolynomials(Polynomial polynomial);	//add the polynomials together
	
}
