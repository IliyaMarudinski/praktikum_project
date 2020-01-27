import java.util.HashMap;
import java.util.Random;

public class UserGenerator {
	
	private final HashMap<Integer, String> hNamesMale = new HashMap<Integer, String>(){
		put(0, "Ivan");
		put(1, "Petyr");
		put(2, "Georgi");
		put(3, "Petko");
		put(4, "Nasko");
		put(5, "Aleksandyr");
  }
	private final HashMap<Integer, String> hFamiliesMale = new HashMap<Integer, String>(){
	    put(0, "Georgiev");
	    put(1, "Petrov");
	    put(2, "Vasilev");
	    put(3, "Domitrov");
	    put(4, "Ivanov");
	    put(5, "Atanasov");
  }
	private final HashMap<Integer, String> hNamesFemale = new HashMap<Integer, String>(){
		put(0, "Ivana");
		put(1, "Petya");
		put(2, "Gergana");
		put(3, "Mariq");
		put(4, "Naska");
		put(5, "Aleksandra");
  }
private final HashMap<Integer, String> hFamiliesFemale = new HashMap<Integer, String>(){
	    put(0, "Georgieva");
	    put(1, "Petrova");
	    put(2, "Vasileva");
	    put(3, "Domitrova");
	    put(4, "Ivanova");
	    put(5, "Atanasova");
 }
	
	public final Customer genUser(){
		Random rand = new Random();
		String name = new String();
		if(rand.nextBoolean()) {//Male
			String = hNamesMale.(rand.nextInt(hNamesMale.size()));
		}
		else {                  //Female
			
		}
		
		
	}
}
