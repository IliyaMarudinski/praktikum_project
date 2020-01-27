import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.lang.Double;

public class CustomerList {
	
	ArrayList<Customer> list = new ArrayList<Customer>();
	Comparator<Customer> byName = (Customer c1, Customer c2) -> c1.getName().compareTo(c2.getName());
	Comparator<Customer> bySum = (Customer c2, Customer c1) ->  Double.compare(c1.getTotalSumSpent(), c2.getTotalSumSpent());
	
	public void printAll() {
		for(Customer i:list) {
			i.print();
		}
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
		String  year       = "";
		Integer totalCount = 0;
		for(Customer i: list) {
			year = i.getRegDate().substring(6);
			totalCount = tMap.get(year);
			totalCount++;
			tMap.put(year, totalCount);
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
}
