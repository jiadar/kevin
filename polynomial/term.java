
public class term {

	private int coefficient;
	private int degree;

	public term(int coefficient, int degree) {
		this.coefficient = coefficient;
		this.degree = degree;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public int getDegree() {
		return degree;
	}

	public void changeCoefficient(int newCoefficient) {
		this.coefficient = newCoefficient;
	}

	@Override
	public String toString() {
		if (coefficient == 0) {
			return "";
		} else if (coefficient == 1) {
			if (degree == 0) {
				return 1 + "";
			} else if (degree == 1) {
				return "x";
			} else {
				return "x^" + degree;
			}
		} else if (coefficient > 1) {
			if (degree == 0) {
				return coefficient + "";
			} else if (degree ==1) {
				return coefficient + "x";
			} else return coefficient + "x^" + degree;
		} else {
			return coefficient + "x^" + degree;
		}
	}
}
