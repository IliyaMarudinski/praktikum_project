import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class UserGenerator {
	
	private final static HashMap<Integer, String> hNamesMale = new HashMap<Integer, String>(){{
		put(0, "Ivan");
		put(1, "Petyr");
		put(2, "Georgi");
		put(3, "Petko");
		put(4, "Nasko");
		put(5, "Aleksandyr");
  }};
	private final static HashMap<Integer, String> hFamiliesMale = new HashMap<Integer, String>(){{
	    put(0, "Georgiev");
	    put(1, "Petrov");
	    put(2, "Vasilev");
	    put(3, "Domitrov");
	    put(4, "Ivanov");
	    put(5, "Atanasov");
  }};
	private final static HashMap<Integer, String> hNamesFemale = new HashMap<Integer, String>(){{
		put(0, "Ivana");
		put(1, "Petya");
		put(2, "Gergana");
		put(3, "Mariq");
		put(4, "Naska");
		put(5, "Aleksandra");
  }};
private final static HashMap<Integer, String> hFamiliesFemale = new HashMap<Integer, String>(){{
	    put(0, "Georgieva");
	    put(1, "Petrova");
	    put(2, "Vasileva");
	    put(3, "Domitrova");
	    put(4, "Ivanova");
	    put(5, "Atanasova");
 }};
	
	public final static Customer genUser(){
		Random rand = new Random();
		String name = new String();
		if(rand.nextBoolean()) {//Male
			name = hNamesMale.get(rand.nextInt(hNamesMale.size()));
			name = name + " " + hFamiliesMale.get(rand.nextInt(hFamiliesMale.size()));
		}
		else {                  //Female
			name = hNamesFemale.get(rand.nextInt(hNamesFemale.size()));
			name = name + " " + hFamiliesFemale.get(rand.nextInt(hFamiliesFemale.size()));
		}
		int orderC = rand.nextInt(9999)+1;
		double totalSpend = rand.nextDouble()*1000;		
		Date date = null;
		try {
		    date = between(Customer.dateFormat.parse("31.12.2000"), Customer.dateFormat.parse("31.12.2019"));
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace(); 
		}
		String dataStr = Customer.dateFormat.format(date);
		return new Customer(name, dataStr, orderC, totalSpend);
	}
	  public static Date between(Date start, Date end) {
		  long startMillis = start.getTime();
		  long endMIllis   = end.getTime();
		  long randomMill = ThreadLocalRandom
			  .current()
			  .nextLong(startMillis, endMIllis);
		  return new Date(randomMill);	
	}
	
}
