
public class term implements Comparable {

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

   public int compareTo(Object o) {
      // returns a negative integer, zero, or a positive integer as
      // this object is less than, equal to, or greater than the
      // specified object.

      term t = (term)o;
      
      // Compare if this term exponent equals t exponent, return 0
      if(t.degree == this.degree) {
         return 0;
      } else if (this.degree < t.degree) {
         return -1;
      } else return 1;

      // if (t.degree == this.degree)
      //    return 0;
      // if (t.degree < this.degree)
      //    return -1;
      // return 1;
      
      // Compare if this term exponent is less than t exponent, return -1

      // Return 1 (because this term exponent is greater than t exponent)
      
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
