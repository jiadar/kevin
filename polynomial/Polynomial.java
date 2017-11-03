// maybe want to just import arraylist
import java.util.*;
import java.util.Collections;

public class Polynomial implements PolynomialADTList {
	private ArrayList<term> termList = new ArrayList<term>();

	// constructor: takes in array of terms
	public Polynomial(ArrayList<term> list) {
		this.termList = list;
	}

	// get highest degree of polynomial
	@Override
	public int getDegreeOfPolynomial() {
		int highestDegree = 0;
		for (int i = 0; i < termList.size(); i++) {
			if (termList.get(i).getDegree() > highestDegree) {
				highestDegree = termList.get(i).getDegree();
			} else {
				// do nothing
			}
		}
		return highestDegree;
	}

	// get coefficient of the power the user entered
	@Override
	public int getCoefficient(int power) throws InvalidPowerException {
		int desiredCoefficient = 0;
      // add try / catch here and string with error
		for (int i = 0; i < termList.size(); i++) {
			if (power == termList.get(i).getDegree()) {
				desiredCoefficient = termList.get(i).getCoefficient();
			} else {

			}
		}
		return desiredCoefficient;
	}

	// change the coefficient of power that user entered
	@Override
	public void changeCoefficient(int newCoefficient, int power)
   throws InvalidPowerException {
      // add try / catch here and string with error
		for (int i = 0; i < termList.size(); i++) {
			if (power == termList.get(i).getDegree()) {
				termList.get(i).changeCoefficient(newCoefficient);
			}
		}
	}

	@Override
	public String toString() {
		// reorganizing the array (doesn't work)
      Collections.sort(termList);
      String s = "";
		for (int i = 0; i < termList.size(); i++) {
			if (i == (termList.size() - 1)) {
				s = s + termList.get(i).toString();
			} else {
				s = s + termList.get(i).toString() + " + ";
			}
		}
		return s;
	}

	@Override
	public Polynomial addPolynomials(Polynomial p2) {

      // update interface to include method/return type
      // make new polynominal for return value (rval)
      rval = new Polynomial();
      // sort this (Collections.sort(termList)) (p1)
      Collections.sort(termList);
      // sort p2
      // find the highest exponent of p1 & p2 (max)
      // loop: i [1-max]
      // .. if p1 exponent i == p2 exponent i, add p1 & p2 coeff
      // .... add to rval
      // .. else if p1 exponent i exists OR p2 exponent i exists
      // .... add the one that exists to the rval
      // return rval
      
	}

}
