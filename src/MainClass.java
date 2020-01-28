import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int UserCount = 0;
		Scanner scan = new Scanner(System.in);
		CustomerList custList = new CustomerList();
		System.out.println(" ---------------------- This is the start point of the main class ---------------------- ");
		while(UserCount < 1 || UserCount > 5000) {
			System.out.print("TASK 1: Input user count beetwen 1 and 5000: ");
			if(scan.hasNextInt()) {
				UserCount = scan.nextInt();
			}
			scan.nextLine();
		}
		scan.close();

		for(int i = 0; i < UserCount; i++) {
			custList.addCustomer(UserGenerator.genUser());			
		}
		
		System.out.println("\n\n---------------------- List all users ---------------------- ");	
		custList.printAll();
		System.out.println("\n\nTASK 2: Sort by name and print");
		custList.sortByNamePrint(false, 0);
		System.out.println("\n\nTASK 3: Filter ** users sort by Money Spent and print");
		custList.sortByNamePrint(true, 2);
		System.out.println("\n\nTASK 4: Show register users per year");
		custList.showCustCountPerYearByRate(2);
	}
}
