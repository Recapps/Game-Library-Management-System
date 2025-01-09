package User;

import java.util.HashMap;
import Game.*;

public class Vault {
	
	private static HashMap<String,String> LOGINs = new HashMap<>();

	public void addUser(User user) {
		LOGINs.put(user.getName(), user.getMail());
	}

	public void listUsers() {

		if (LOGINs.size() == 0) {
			System.out.println("No user has been added to the database.");
		}
		else {
			int number = 1;
			for (String counter : LOGINs.keySet()) {
				System.out.println(number + " " + counter);
				number++;
			}
		}
	}

	public void clearUsers() {
		LOGINs.clear();
		System.out.println("All Logins have been cleared!");
	}
}