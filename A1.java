public class A1 {

	private static int nextLeapYear = 2028;	
	private static int lower_Percentile_Salary = 25700;
	private static int higher_Percentile_Salary = 66700;
	
	public static void main(String[] args) {
		int numDataPoints = Integer.parseInt(args[0]);
		
		// Print the number of data points
		System.out.println(numDataPoints);
		//PrintBirthDate(numDataPoints);
		// Generate and print all the data points
		// For each datapoint:
			// Print the birthdate and a space

			// On the same line, print the telephone number and a space

			// On the same line, print the random salary in SEK without öre and break the line
		//System.out.println("\nYear, Month, Day; Telephone number; salary");
		PrintPersonalInformation(numDataPoints);
		

	}

	public static void PrintPersonalInformation(int numDataPoints){
		//System.out.println();
		for(int i=0; i<numDataPoints;i++ ){
			PrintBirthDate();
			PrintTelephoneNumber();
			PrintRandomSalary();
		}
	}

	public static void PrintRandomSalary(){//Pröva med -1 och +1. Se vilken skillnad den gör.
		int randomSalary = (int)((Math.random()*(higher_Percentile_Salary-lower_Percentile_Salary-1))+25700);
		System.out.println(randomSalary);
	}

	//Formatera output texten som Oskar Molina har gjort --> ingen text rena siffror.
	public static void PrintTelephoneNumber(){
		String regionSweden = "07";
		int randomTelephoneNumber = (int)((Math.random()*99999999)+1);
		String randomTelephoneNumberInString =regionSweden+""+Integer.toString(randomTelephoneNumber);
		System.out.print(randomTelephoneNumberInString+" ");
	}
	public static void PrintBirthDate(){
		
		int randomYear = (int)((Math.random()*65)+1961);
		//2026-18=2008 2008-65 2000-57=1943
		int randomMonth = (int)((Math.random()*12)+1);
		int randomDay = 0;
		//Handles the case where the month has 28.
		if(randomMonth == 2){
			randomDay = (int)((Math.random()*28)+1);
		}
		//Handles the case where the month has 30 days.
		else if(randomMonth%2 == 0) {
			randomDay = (int)((Math.random()*30)+1);
		}
		//Handles the case where the month has 31 days.
		else{
			randomDay = (int)((Math.random()*31)+1);
		}



		System.out.print(randomYear+"-"+randomMonth +"-"+ randomDay+" ");
	}
}
