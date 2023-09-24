package com.shopNest.customer;

import com.shopNest.dbHandler.DataFetcher;

public class Validator {
	public static boolean isValid(String uname,String pas) {
		String dbPass=DataFetcher.fetchPassword(uname);
		if(pas.equals(dbPass)) {
			return true;
		}
		else {
			return false;
		}
	}

}
