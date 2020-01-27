
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int UserCount = 30;
		CustomerList custList = new CustomerList();
		System.out.println("This is the star point of the main class");

		for(int i = 0; i < UserCount; i++) {
			custList.addCustomer(UserGenerator.genUser());			
		}
		System.out.println("22222222222");	
		custList.printAll();
		System.out.println("33333333333");
		custList.sortByNamePrint(false, 0);
		System.out.println("44444444444");
		custList.sortByNamePrint(true, 2);
		System.out.println("55555555555");
		custList.showCustCountPerYearByRate(2);
	}
}
