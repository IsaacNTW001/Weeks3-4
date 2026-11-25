import java.util.Scanner;

public class A3 {

	public static void readData(Scanner data, int[] birthYear, int[] phoneNumber, double[] salary, int numDataPoints) {
		String currLine = data.nextLine();
		int secondDelimPos = currLine.indexOf(" ", currLine.indexOf(" ") + 1) + 1;
		int firstDelimPos = currLine.indexOf(" ") + 1;

		for (int i = 0; i < numDataPoints; i++) {
			birthYear[i] = Integer.parseInt(currLine.substring(0, currLine.indexOf("-")));
			phoneNumber[i] = Integer.parseInt(currLine.substring(firstDelimPos, secondDelimPos - 1));
			salary[i] = Double.parseDouble(currLine.substring(secondDelimPos, currLine.length()));

			if (data.hasNextLine())
				currLine = data.nextLine();
		}
		data.close();
	}

	public static int nrOfSamePhoneNr(String[] phoneNumber) {
		int sameNr = 0;

		for(int i=0;i<phoneNumber.length-1;i++){
			if(phoneNumber[i].equals(phoneNumber[i+1])){
				sameNr+=1;
			}
		}
		
		// Go through every phone number in the array
			// Compare each element to all other elements in the array
			// Use the .equals() method for String and, if two elements
			// are the same, increase sameNr by one

		return sameNr;
	}

	public static void main(String[] args) {
		Scanner data = new Scanner(System.in);
		int numDataPoints = Integer.parseInt(data.nextLine());
		int[] birthYear = new int[numDataPoints];
		int[] phoneNumber = new int[numDataPoints];
		double[] salary = new double[numDataPoints];

		// For this to work, you need to edit NumericalArrays.java

		readData(data, birthYear, phoneNumber, salary, numDataPoints);
		int mode = NumericalArrays.mode(birthYear);
		int samePhoneNr = NumericalArrays.numEqualElements(phoneNumber);

		System.out.println("The year " + mode + " is the most frequent birth year");
		System.out.println(samePhoneNr +"telephone numbers appear more than once");
		System.out.println("Maximum salary is " + NumericalArrays.max(salary) + " and minimum salary is " + NumericalArrays.min(salary));
		System.out.println("The mean salary is " + NumericalArrays.average(salary) + " with a standard deviation of " + NumericalArrays.standardDeviation(salary));
		System.out.println("Half of the sample has a salary lower than " + NumericalArrays.median(salary));

	}
}
