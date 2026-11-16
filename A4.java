public class A4{
	public static void main(String[] args) {
		Scanner data = new Scanner(System.in);
		int numDataPoints = Integer.parseInt(data.nextLine());
		int[] birthYear = new int[numDataPoints];
		int[] phoneNumber = new int[numDataPoints];
		double[] salary = new double[numDataPoints];
		
		System.out.println("begin: " + numDataPoints);
		readData(data, birthYear, phoneNumber, salary, numDataPoints);
		System.out.println("Done");
		drawHistogram(birthYear);
		drawScatterPlot(salary);
	}

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

	public static int[][] getBirthYearFreq(int[] birthYear){
		int[][] freq = new int[birthYear.length][2];
		
		// Your code here
				
		return freq;
	}
	
	public static void drawHistogram(int[] birthYear){
		StdDraw.setXscale(0,100);
    	StdDraw.setYscale(0,100);
		StdDraw.show();

		int[][] freq = getBirthYearFreq(birthYear);
		int x = 5;
		
		// Your code here

	}

	public static void drawScatterPlot(double [] salary){
		int min = (int) NumericalArrays.min(salary);
		int max = (int) NumericalArrays.max(salary);
		int padding = 10000;
		StdDraw.setXscale(min-padding,max+padding);
    	StdDraw.setYscale(min-padding,max+padding);
		StdDraw.show();
		
		// Your code here

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(min, NumericalArrays.average(salary), max, 100);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(min, NumericalArrays.median(salary), max, 100);

	}
}
