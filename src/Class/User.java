package Class;

import java.util.ArrayList;
import java.util.List;

public class User {
	private static List <User> userList = new ArrayList <User>();
	
	private static String userName;
	private static String userPassword;
	private static String userEmail;
	
	//User Constructor				
	public User(String userName, String userPassword, String userEmail){
		User.userName = userName;
		User.userPassword = userPassword;
		User.userEmail = userEmail;
		
		userList.add(this);
	}
	
	//userName Getter and Setter
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		User.userName = userName;
	}
	
	//userPassword Getter and Setter
	public static String getUserPassword() {
		return userPassword;
	}
	public static void setUserPassword(String userPassword) {
		User.userPassword = userPassword;
	}
	
	//userEmail Getter and Setter
	public static String getUserEmail() {
		return userEmail;
	}
	public static void setUserEmail(String userEmail) {
		User.userEmail = userEmail;
	}
	
	//Be Top Buyer
	public void beTopBuyer() {
		User.TopBuyers tB = User.TopBuyers.getTopBuyers();
		if(tB.getTopBuyer() != null && tB.getTopBuyer() != this) {
			System.out.println("Transfering the Top Buyer Title");
		}
		tB.setTopBuyer(this);
	}
	
	public boolean checkTopBuyer() {
		return (User.TopBuyers.getTopBuyers().getTopBuyer() == this);
	}
	
	//Login NormalUser
	public static boolean loginNormalUser(String name, String pass) {
		boolean login;
		
		if(name.equals(userName) && pass.equals(userPassword)) {
			login = true;
		}
		else {
			login = false;
		}
		return login;
	}
		
		//Inner Class TopBuyers
		public static class TopBuyers { //Singleton Class
			private static TopBuyers TOP_BUYER;
			private static User topBuyer;
			private TopBuyers() {
			}
			
			public static TopBuyers getTopBuyers() {
				if (TOP_BUYER == null) {
					TOP_BUYER = new TopBuyers();
				}
				return TOP_BUYER;
			}
			
			//topBuyer Getter and Setter
			public static void setTopBuyer(User topBuyer) {
				topBuyer = topBuyer;
			}
			
			public static User getTopBuyer() {
				return topBuyer;
			}
		}
}