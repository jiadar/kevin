import java.util.*;

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
	public int getCoefficient(int power) {
		int desiredCoefficient = 0;
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
	public void changeCoefficient(int newCoefficient, int power) {
		for (int i = 0; i < termList.size(); i++) {
			if (power == termList.get(i).getDegree()) {
				termList.get(i).changeCoefficient(newCoefficient);
			}
		}
	}

	@Override
	public String toString() {
		// reorganizing the array (doesn't work)
		ArrayList<term> newTermList = new ArrayList<term>();
		for (int i = 0; i < termList.size(); i++) {
				if (termList.get(i).getDegree() == getDegreeOfPolynomial()) {
					newTermList.add(termList.get(i));
				} else if (termList.get(i).getDegree() < getDegreeOfPolynomial()) {
					newTermList.add(termList.get(i));
				} else {
					term zero = new term(0,i);
					newTermList.add(zero);
				}
		}
		String s = "";
		for (int i = 0; i < newTermList.size(); i++) {
			if (i == (newTermList.size() - 1)) {
				s = s + newTermList.get(i).toString();
			} else {
				s = s + newTermList.get(i).toString() + " + ";
			}
		}
		return s;
	}

	@Override
	public void addPolynomials(Polynomial p2) {
		// make an array list of the new polynomial

	}

}
