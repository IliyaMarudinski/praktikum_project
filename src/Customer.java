
public class Customer {

	private String name;       //Name Family, 40 symbols
	private String regDate;    //ddMMyyy
	private int    orderCount; // 1:9999
	private double totalSumSpent; 
	private int    userRate;   // 1:5 stars(* ** *** **** *****)
	
	public Customer(String name, String regDate, int ordercount, double totalSumSpent) {
		super();
		this.name = name;
		this.regDate = regDate;
		this.orderCount = ordercount;
		this.totalSumSpent = totalSumSpent;
		this.userRate = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int ordercount) {
		this.orderCount = ordercount; 
		calcRating();
	}

	public double getTotalSumSpent() {
		return totalSumSpent;
	}

	public void setTotalSumSpent(double totalSumSpent) {
		this.totalSumSpent = totalSumSpent;
	}

	public int getUserRate() {
		return userRate;
	}
	
	private final boolean isBetween(int x, int lower, int upper) {
		  return lower <= x && x <= upper;
		}
	
	private void calcRating() {
		if(isBetween(this.orderCount, 1, 99))     this.userRate = 1; 
		if(isBetween(this.orderCount, 100, 299))  this.userRate = 2; 
		if(isBetween(this.orderCount, 300, 499))  this.userRate = 3; 
		if(isBetween(this.orderCount, 500, 999))  this.userRate = 4; 
		if(isBetween(this.orderCount, 1000,9999)) this.userRate = 5; 
	}
	
	
	
}
