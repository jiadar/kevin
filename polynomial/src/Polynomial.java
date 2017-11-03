
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

		// update interface to include method/return type
		// make new polynominal for return value (rval)
		// sort this (Collections.sort(termList)) (p1)
		// sort p2
		// find the highest exponent of p1 & p2 (max)
		// loop: i [1-max]
		// .. if p1 exponent i == p2 exponent i, add p1 & p2 coeff
		// .... add to rval
		// .. else if p1 exponent i exists OR p2 exponent i exists
		// .... add the one that exists to the rval
		// return rval
		/**
		 * for (int i = 0; i < highestDegree; i++) { if (termList.get(i).getDegree() ==
		 * p2.termList.get(i).getDegree()) { term t = new
		 * term((termList.get(i).getCoefficient() +
		 * p2.termList.get(i).getCoefficient()), i); sumPTermList.add(t); } else if
		 * (termList.contains(termList.get(i))) { sumPTermList.add(termList.get(i)); }
		 * else if (p2.termList.contains(termList.get(i))) {
		 * sumPTermList.add(p2.termList.get(i)); } }
		 */


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
