import java.util.*;

public class PolynomialDriver {

	public static void main(String[] args) {
      //		Scanner scan = new Scanner(System.in);
		//System.out.println("This is a polynomial maker");
		//System.out.println("Enter the coefficient, (press enter) then enter the degree.");
		int coefficient = 0;
		int degree = 0;
		ArrayList<term> listOfTerms = new ArrayList<term>();
      // Test 9x^3+2x^4+x^2+2x^7

      listOfTerms.add(new term(9, 3));
      listOfTerms.add(new term(2, 4));
      listOfTerms.add(new term(1, 2));
      listOfTerms.add(new term(2, 7));

      Polynomial p1 = new Polynomial(listOfTerms);

      System.out.println(p1.toString());

      ArrayList<term> listOfTerms2 = new ArrayList<term>();
      // Test 9x^3+2x^4+x^2+2x^7

      listOfTerms2.add(new term(3, 3));
      listOfTerms2.add(new term(4, 5));
      listOfTerms2.add(new term(2, 6));
      listOfTerms2.add(new term(3, 7));

      Polynomial p2 = new Polynomial(listOfTerms2);

      System.out.println(p2.toString());

      Polynomial p3 = p1.addPolynomials(p2);

      System.out.println("Added: " + p3.toString());
      
		// while (coefficient != -1 && degree != -1) {
		// 	coefficient = Integer.parseInt(scan.nextLine());
		// 	degree = Integer.parseInt(scan.nextLine());
		// 	term t = new term(coefficient, degree);
		// 	if (coefficient != -1 && degree != -1) {
		// 		listOfTerms.add(t);
		// 	}
		// 	System.out.println(t.toString());
		// }
		// Polynomial p1 = new Polynomial(listOfTerms);
		// System.out.println(p1.toString());

		// scan.close();
	}
}
