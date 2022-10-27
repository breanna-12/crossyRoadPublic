
public class RunnerArrayLecture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		///System.out.println("Array Lecture");
		
		int x = 3;
		int y= 4;
		String str = "Hello World";
		
		//a group of 10 ints 

		int [] myArray = new int [10];
		myArray[0] = 30; //assign 30 to first int
		myArray[1] = 30;
		//...
		myArray[9] = -13;
		myArray[myArray.length - 1] = -13; //no ()
		
		double [] myDouble = {1.5, 2.4, 3.6};
		
	//	System.out.println(myArray[0]);
		
		//create an array to contain 31 doubles
		double [] arrayTwo = new double [31]; 
		
		//new int [how many numbers, count from 1]
		//myArray[0] index value
		
		//for(int i = 0; i < arrayTwo.length; i++)
		for (int i = 0; i < 31; i++) {
			arrayTwo[i] = Math.random();
			//visit each index and assign random number
		}
		
		String a = "banana";
		System.out.println(a);
		while (a.indexOf("a") > 0) {
				a = a.substring(0, a.indexOf("a")) + a.substring(a.indexOf("a")+1);
				System.out.println(a);
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 1; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		for (int j = 1; j <= 5; j++) {
			for (int i = j; i <= 5; i++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		}
		

}
