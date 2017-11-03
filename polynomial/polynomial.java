
/**
 * @termList is an ArrayList that will hold all of the terms entered by the user.
 * Constructor takes in a ArrayList of terms as parameter.
 */

import java.util.*;
import java.util.Collections;

public class polynomial implements polynomialADTList {
	private ArrayList<term> termList = new ArrayList<term>();

	public polynomial(ArrayList<term> list) {
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

	private term getTermForExponent(ArrayList<term> t) {
		// search for term with the exponent wanted by loopin throug array list
		// return that term
		for (int i = 0; i < t.size(); i++) {
			if (t.get(i).getDegree() == i) {
				return t.get(i);
			}
		}
		term noTerm = new term(0, 0);
		return noTerm;

	}

	@Override
	public polynomial addPolynomials(polynomial p2) {

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

		polynomial sumPolynomial;
		ArrayList<term> sumPTermList = new ArrayList<term>();
		Collections.sort(termList);
		Collections.sort(p2.termList);
		int highestDegree;
		if (this.getDegreeOfPolynomial() > p2.getDegreeOfPolynomial()) {
			highestDegree = termList.get(0).getDegree();
		} else
			highestDegree = p2.getDegreeOfPolynomial();
		for (int i = termList.size(); i > 0; i--) {
			if (this.getCoefficient(i) == 0) {
				term t = new term(0, (-i + termList.get(i).getDegree()));
				termList.add(i, t);
			}
			
		}
		for (int i = p2.termList.size(); i>0; i--) {
			if (p2.getCoefficient(i) == 0) {
				term t = new term(0, (-i + p2.termList.get(i).getDegree()));
				termList.add(i, t);
			}
		}
		System.out.println("P1: " + termList.toString() + "\nP2: " + p2.termList.toString());
		for (int i = 0; i < highestDegree; i++) {
			if (termList.get(i).getDegree() == p2.termList.get(i).getDegree()) {
				term t = new term((termList.get(i).getCoefficient() + p2.termList.get(i).getCoefficient()), i);
				sumPTermList.add(t);
			} else if (termList.contains(termList.get(i))) {
				sumPTermList.add(termList.get(i));
			} else if (p2.termList.contains(termList.get(i))) {
				sumPTermList.add(p2.termList.get(i));
			}
		}
		sumPolynomial = new polynomial(sumPTermList);
		return sumPolynomial;
	}

}
