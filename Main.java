package dbms;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] keys = {"id","name", "job", "age", "sex", "salary"};
		Cursor cursor = new Cursor(keys);
		boolean isRunning = true;
		
		for ( ; isRunning; ) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("DataBase managment system:");
			System.out.println("Select all rows - 1");
			System.out.println("Insert row - 2");
			System.out.println("Update row - 3");
			System.out.println("Delete row - 4");
			System.out.println("Exit - 0");
			
			int res = sc.nextInt();
			
			switch (res) {
            	case Definitions.SELECT_CASE:
            		cursor.select();
            		
            		
            		
            	case Definitions.EXIT_CASE:
            		isRunning = false;
			}
		
		

		} //for
	}  //main()
}   //class
	
