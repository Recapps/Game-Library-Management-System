package User;

import Game.*;

public class AdminUser extends User {
	
	private int pass;
	private boolean admin = false;
	private Vault vault;

	public AdminUser(String name, String email, int pass) {
		
		super(name, email);
		this.pass = pass;
		this.vault = new Vault();
		if (this.pass == 573104) {
			System.out.println("Admin Login Confirmed!");
			admin = true;
		}
		else {
			System.out.println("Admin Login Denied! You won't be able to access admin commands.");
		}
	
	}

	public void addUser(User user) {
		if (admin == true) {
			vault.addUser(user);
		}
		else {
			System.out.println("Can't Access Admin Command");
		}
	}

	public void listUsers() {
		if (admin == true) {
			vault.listUsers();
		}
		else {
			System.out.println("Can't Access Admin Command");
		}
	}

	public void clearUsers() {
		if (admin == true) {
			vault.clearUsers();
		}
		else {
			System.out.println("Can't Access Admin Command");
		}
	}

	public boolean getStatus() {
		return admin;
	}

}