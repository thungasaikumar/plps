package com.capg.validate;

public class BankValidate {
public boolean name(String str) {
		
		boolean name_val = str.matches("[A-Z][a-z]*");
		if(name_val)
			return true;
		return false;
		
	}

}
