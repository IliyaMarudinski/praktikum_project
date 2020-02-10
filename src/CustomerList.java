import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.lang.Double;
import java.text.ParseException;

public class CustomerList {
	
	ArrayList<Customer> list = new ArrayList<Customer>();
	Comparator<Customer> byName = (Customer c1, Customer c2) -> c1.getName().compareTo(c2.getName());
	Comparator<Customer> bySum = (Customer c2, Customer c1) ->  Double.compare(c1.getTotalSumSpent(), c2.getTotalSumSpent());
	
	public void printAll() {
		for(Customer i:list) {
			i.print();
		}
	}	
	public void addCustomer(Customer addCust) {
		this.list.add(addCust);
	}
	
	public void addCustomerManual() {
		Scanner scanLn     = new Scanner(System.in);
		String  name       = new String();
		String  dataStr    = new String();
		int     orderC     = -1;
		double  totalSpend = -0.1;
		
		System.out.print("Please type the Name of the customer(between 5 and 40 symbols): ");
		name = scanLn.nextLine();
		while(name.length() > 40 || name.length() < 5) {
			System.out.print("ERROR in the length of the name please type it again(between 5 and 40 symbols): ");
			name = scanLn.nextLine();
		}	

		System.out.print("Please type the register date of the customer(format dd.MM.yyyy): ");
		dataStr = scanLn.nextLine();
			while(!checkDatePattern(dataStr)) {
				System.out.print("ERROR in the register date type it again(format dd.MM.yyyy): ");
				dataStr = scanLn.nextLine();
			}	
				
		System.out.print("Please type the order count of the customer (between 0 and 9999):  ");
		if(scanLn.hasNextInt()) orderC = scanLn.nextInt();
		scanLn.nextLine();
		while(orderC < 0 || orderC > 9999) {
			System.out.print("ERROR in the order count, please type it again(between 0 and 9999): ");
			if(scanLn.hasNextInt()) {
				orderC = scanLn.nextInt();
			}
			scanLn.nextLine();
		}
		
		System.out.print("Please type customer total spend amount (more than 0):  ");
		if(scanLn.hasNextDouble()) totalSpend = scanLn.nextDouble();
		scanLn.nextLine();
		while(totalSpend < 0.0 ) {
			System.out.print("ERROR in the order count, please type it again(between 0 and 9999): ");
			if(scanLn.hasNextDouble()) {
				totalSpend = scanLn.nextDouble();
			}
			scanLn.nextLine();
		}	
		this.list.add(new Customer(name, dataStr, orderC, totalSpend));
	}	
	
	public void sortByNamePrint(boolean filterRating, int Rating) {
		ArrayList<Customer> tmp_list = new ArrayList<Customer>();
		for(Customer i:list) {
			if(filterRating) {
				if(i.getUserRate() == Rating) {
					tmp_list.add(i);
				}
			}
			else {
				tmp_list.add(i);
			}
		}
		if(filterRating)tmp_list.sort(bySum.thenComparing(byName));
		else            tmp_list.sort(byName);
		printList(tmp_list);
	}	
	public final void printList(ArrayList<Customer> printList) {
		for(Customer i : printList) {
			i.print();
		}
	}	
	public void showCustCountPerYearByRate(int showRate) {
		TreeMap<String, Integer> tMap = new TreeMap<String, Integer>();
		for(Customer i: list) {
			if(i.getUserRate() == showRate) {
				String  year = i.getRegDate().substring(6);
				if(tMap.containsKey(year)) {
					Integer tmp_int = new Integer(tMap.get(year));
					tmp_int = tmp_int + 1;
					tMap.put(year, tmp_int);					
				}
				else {
					tMap.put(year, 1);
				}
			}
		}
		for(Map.Entry<String,Integer> entry : tMap.entrySet() ) {
			StringBuilder strBuild = new StringBuilder();
			String  key   = entry.getKey();
			Integer value = entry.getValue();
			strBuild.append(key);
			strBuild.append(" - ");
			strBuild.append(value);
			System.out.println(strBuild.toString());			
		}		
	}
	public static boolean checkDatePattern(String data) {
		if(!data.matches("\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d")) {
//			System.out.println("Checkoint 0");
			return false;
		}
		String[] sepStr = data.split("\\.");
		int      day    = Integer.parseInt(sepStr[0]);
		int      mount  = Integer.parseInt(sepStr[1]);
		int      year   = Integer.parseInt(sepStr[2]);
	    try {
	        Customer.dateFormat.parse(data);
	        if(day   < 1 || day > 31) {
//				System.out.println("Checkoint 1");
	        	return false;
	        }
	        if(mount < 1 || mount > 12) {
//				System.out.println("Checkoint 2");
	        	return false;
	        }
	        if(year  < 1900) {
//				System.out.println("Checkoint 3");
	        	return false;
	        }        
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}
}
