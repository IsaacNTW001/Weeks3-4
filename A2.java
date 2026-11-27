import java.util.Scanner;

public class A2 {
	public static int counter=0;

	public static void main(String[] args) {

		//System.out.println("test");
		// We setup a scanner to read the data
		Scanner data = new Scanner(System.in);
		//System.out.println("test");

		// Our first line tell us the size of the arrays we have to prepare
		int numDataPoints = Integer.parseInt(data.nextLine());
	
		// Modify this to declare the arrays correctly
		String[] yearAndPhone = new String[numDataPoints];
		int[] salary = new int[numDataPoints];	
		
		// Read data line by line
		String currLine = data.nextLine();
		// Analize: what does this line do?
		int cutPosition = currLine.indexOf(" ", currLine.indexOf(" ") + 1) + 1;

		//salary[counter] = Integer.valueOf(currLine.substring(cutPosition,currLine.length()));
		//yearAndPhone[counter] =currLine.substring(0,currLine.length());

		//counter++;
		//System.out.println(cutPosition);


		// TASK:
		// Go line by line and fill up the two arrays
		// For each iteration, put the data in the correct index for BOTH arrays
		//NumericalArrays numArray = new NumericalArrays();
		for(int i=0; i<numDataPoints;i++){

			int tempInt=0;
			tempInt = Integer.valueOf(currLine.substring(cutPosition,currLine.length()));
			salary[i] = tempInt;

			//Ändra till new string om strängen inte förändras efter varje iteration.
			String tempString = "";
			tempString = currLine.substring(0,cutPosition-1);

			yearAndPhone[i]= tempString;

			if(data.hasNextLine()){
				currLine = data.nextLine();	
				cutPosition = currLine.indexOf(" ", currLine.indexOf(" ") + 1) + 1;
			}

		}
		//yearAndPhone.add(currLine.substring(0,cutPosition));
		//salary.add(Integer.valueOf(currLine.substring(cutPosition,currLine.length())));

		// Close the Scanner
		data.close();
		//System.out.println("Outside of data.close");
		// Sorting value by value
		
		// 1: You will need variables to keep values temporarily, one for the
		//    salary and one for the date and telephone
		int swap = 0;

		String swapString = "";

		//Forsätt här! Jag vet fortfarande inte hur man betyder plats på element i en array.
		/*
		for(int j=0; j<yearAndPhone.length;j++){
			//System.out.println(swap+" "+salary[j]);
			for(int k=1; k<salary.length;k++){
				System.out.println(salary[k]+" Before if"+salary[j]);

				if(salary[j]>salary[k]){
					swap= salary[j];
					salary[j] = salary[k];
					salary[k] = swap;
					//System.out.println("The largest of the two values has been pushed back.");
					System.out.println(salary[k]+" "+salary[j]);

				}

			}
		}
		*/

		for(int m=0; m<salary.length;m++){
			for(int j=0,k=1; j<yearAndPhone.length;j++,k++){
			//System.out.println(swap+" "+salary[j]);
			
				if(k<salary.length){
					if(salary[j]>salary[k]){
						swap= salary[j];
						salary[j] = salary[k];
						salary[k] = swap;

						swapString = yearAndPhone[j];
						yearAndPhone[j] = yearAndPhone[k];
						yearAndPhone[k] = swapString;
					}
				}	
			

			}
		}
		

		// You will need to go through each value in the array (how do we traverse an array?)
			// For each value you go through, you go again through the array until you find a value
			// in salaries that is greater than the current one you are reading
			// If that value exists, you store it temporarily, update that index of the arrays
			// with the value that you have and then push back all the other values to higher indexes
			// For example, you are reading index 6 find that salary[5] > salary[6],
			// then you swap both values (salary[6] now has the old value of salary[5])
			// and execute the same process until all values are sorted.

		// Now, you have a set of sorted arrays

		// These lines print out the sorted arrays
		System.out.println(numDataPoints);
		for(int i = 0; i < numDataPoints; i++)
			System.out.println(yearAndPhone[i] +" " +salary[i]);
	}
}