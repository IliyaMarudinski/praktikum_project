import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int userCount = 0;
		int userRate  = 0;
		Scanner scan = new Scanner(System.in);
		CustomerList custList = new CustomerList();
		System.out.println(" ---------------------- This is the start point of the main class ---------------------- ");
		while(userCount < 1 || userCount > 5000) {
			System.out.print("TASK 1: Input user count beetwen 1 and 5000: ");
			if(scan.hasNextInt()) {
				userCount = scan.nextInt();
			}
			scan.nextLine();
		}

		for(int i = 0; i < userCount; i++) {
			custList.addCustomer(UserGenerator.genUser());			
		}
		
		System.out.println("\n\n---------------------- List all users ---------------------- ");	
		custList.printAll();
		System.out.println("\n\nTASK 2: Sort by name and print");
		custList.sortByNamePrint(false, 0);
		System.out.println("\n\nTASK 3: Filter ** users sort by Money Spent and print");
		custList.sortByNamePrint(true, 2);
		System.out.println("\n\n");
		
		while(userRate < 1 || userRate > 5 ){
			System.out.print("TASK 4: Show register users per year, select rating(1-5):");
			if(scan.hasNextInt()) {
				userRate = scan.nextInt();
			}
			scan.nextLine();
		}
		scan.close();		
		
		custList.showCustCountPerYearByRate(2);
	}
}
