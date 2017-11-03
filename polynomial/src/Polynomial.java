
/**
 * @termList is an ArrayList that will hold all of the terms entered by the user.
 * Constructor takes in a ArrayList of terms as parameter.
 */

import java.util.*;
import java.util.Collections;
import java.util.Optional;

public class Polynomial implements PolynomialADTList {
	private ArrayList<term> termList = new ArrayList<term>();

	public Polynomial(ArrayList<term> list) {
		this.termList = list;
	}

	/**
	 * @highestDegree serves as a way to keep track of the highest degree until we
	 *                reach the end of the forloop. I use a forloop to loop through
	 *                the ArrayList to find the highest degree of the polynomial.
	 *                Then, return highestDegree
	 */
	@Override
	public int getDegreeOfPolynomial() {

		int highestDegree = 0;

		for (int i = 0; i < termList.size(); i++) {
			if (termList.get(i).getDegree() > highestDegree) {
				highestDegree = termList.get(i).getDegree();
			}
		}
		return highestDegree;
	}

	/**
	 * @power is user input which tells us which coefficient to get.
	 * @desiredCoefficient is a variable that will hold coefficient that the user
	 *                     wants us to find. return this value if the power is
	 *                     negative, throw the exception ending the program with a
	 *                     "Invalid Power" message. Otherwise, if power is positive,
	 *                     loop through termList and find the coefficient of the
	 *                     power that the user entered.
	 */
	@Override
	public int getCoefficient(int power) throws InvalidPowerException {
		int desiredCoefficient = 0;

		if (power >= 0) {
			for (int i = 0; i < termList.size(); i++) {
				if (power == termList.get(i).getDegree()) {
					desiredCoefficient = termList.get(i).getCoefficient();
				}
			}
		} else {
			throw new InvalidPowerException("Invalid Power.");
		}

		return desiredCoefficient;
	}

	@Override
	public void changeCoefficient(int newCoefficient, int power) throws InvalidPowerException {
		if (power >= 0) {
			for (int i = 0; i < termList.size(); i++) {
				if (power == termList.get(i).getDegree()) {
					termList.get(i).changeCoefficient(newCoefficient);
				}
			}
		} else {
			throw new InvalidPowerException("Invalid Power.");
		}
	}

	@Override
	public String toString() {

		Collections.sort(termList);

		String s = "";

		for (int i = 0; i < termList.size(); i++) {
			if (i == (termList.size() - 1)) {
				s = s + termList.get(i).toString();
			} else if (termList.get(i).getCoefficient() != 0) {
				s = s + termList.get(i).toString() + " + ";
			}
		}
		return s;
	}

	private Optional<term> getTermForExponent(ArrayList<term> t) {
		// search for term with the exponent wanted by loopin throug array list
		// return that term
		for (int i = 0; i < t.size(); i++) {
			if (t.get(i).getDegree() == i) {
				return Optional.of(t.get(i));
			}
		}
		return Optional.empty();

	}

   // Get the coefficient by expoent 
   private Optional<Integer> gcbe(int x) {
		for (int i = 0; i < termList.size(); i++) {
			if (termList.get(i).getDegree() == x) {
				return Optional.of(termList.get(i).getCoefficient());
			}
		}
		return Optional.empty();
	}

	@Override
   public Polynomial addPolynomials(Polynomial p2) {
      // create an arraylist to hold the result set
      ArrayList<term> s = new ArrayList<term>();

      // Get the highest degree in hd
      int hd = this.getDegreeOfPolynomial() > p2.getDegreeOfPolynomial() ?
         this.getDegreeOfPolynomial() : p2.getDegreeOfPolynomial();

      // Loop through to highest degree
      for (int i=1; i<= hd; i++) {
         // get the coefficients of this & p2
         Optional coef1 = this.gcbe(i);
         Optional coef2 = p2.gcbe(i);

         // If only one coefficient is present, add that to the
         // resultant polynomial. If both coeff's are present,
         // add the sum to the result polynomial.
         if (! coef1.isPresent() && coef2.isPresent()) 
            s.add(new term((int)coef2.get(), i));
         if (coef1.isPresent() && ! coef2.isPresent())
            s.add(new term((int)coef1.get(), i));
         if (coef1.isPresent() && coef2.isPresent()) 
            s.add(new term((int)coef1.get() + (int)coef2.get(), i));
      }

      // return a new polynomial from the term list
      return new Polynomial(s);
   }
}
