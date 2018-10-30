package lab5out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class DatabaseFile
{
	private ArrayList<Integer> Id = new ArrayList<Integer>();
	private HashMap<String,String> account;
	private HashMap<String,Integer> account_ID = new HashMap<String, Integer>();
	
	public DatabaseFile() {
		this.account = new HashMap<String, String>();
	}

	public void addtoDatabase(String username, String password) {
		 if (!account.containsKey(username)) {
			 account.put(username, password);
		 }
		 else {
			 System.out.println("account exists");
		 }
		 
	}
	 public boolean validateAccount(String username, String pass) {
			  Iterator it = account.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        if (pair.getKey() ==username && pair.getValue() == pass) {
			        	return true;
			        }
			    }

		 return false;
	 }
	  
	
	 
	 public boolean validateUsername(String username) {
		
		 Iterator it = account.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        if (pair.getKey() ==username) {
		        	return true;
		        }
		    }
		 
		 return false;
	 }
	 
	 
	public HashMap<String,String> getMap() {
		
		return account;
	}
	
	public int generateID(String username) {
		Random rand = new Random();
		int id  = rand.nextInt(20000);
		if (account_ID.containsKey(username) ) {
			while  (Id.contains(id)) {
				id  = rand.nextInt(20000);
			}
			Id.add(id);
			account_ID.put(username, id);
		 }
		 else {
			 System.out.println("account created");
		 }
		
		return id;
	}
	
}
